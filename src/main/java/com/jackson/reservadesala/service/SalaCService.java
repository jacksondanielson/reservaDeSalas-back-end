package com.jackson.reservadesala.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jackson.reservadesala.domain.SalaC;
import com.jackson.reservadesala.dto.SalaCDTO;
import com.jackson.reservadesala.repository.SalaCRepository;
import com.jackson.reservadesala.service.exception.ObjectNotFoudException;


@Service
public class SalaCService {
	
	@Autowired
	private SalaCRepository repo;
	
	@Autowired
	private EmailService emailService;
	
	public SalaC find(Integer id){
		Optional <SalaC> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.jackson.reservadesala.service.exception.ObjectNotFoudException(
				"Objeto não encontrado! id: " + id + "Tipo: " + SalaC.class.getName()));
	}
	
	public SalaC findByData(Date dataDaReserva) {
		SalaC obj = repo.findByDataDaReserva(dataDaReserva);
		if(obj == null) {
			throw new ObjectNotFoudException(
					"Objeto não encontrado! data: " + dataDaReserva + "Tipo: " + SalaC.class.getName());
			
		}
		return obj;
	}


	
	public SalaC insert(SalaC obj) {
		obj.setId(null);
		obj = repo.save(obj);
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
	
	public SalaC update(SalaC obj) {
		SalaC newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<SalaC> findAll(){
		return repo.findAll();
	}
	
	public SalaC fromDto(SalaCDTO objDto) {
		return new SalaC(objDto.getId(), objDto.getDescricao(), objDto.getDataDaReserva(), objDto.getDataFinalDaReserva(), objDto.getNomeDoSolicitante(), objDto.getContatoSolicitante(), objDto.getEmailSolicitante());
	}
	
	private void updateData(SalaC newObj, SalaC obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setDataDaReserva(obj.getDataDaReserva());
		newObj.setDataFinalDaReserva(obj.getDataFinalDaReserva());
	}
	
	public Page<SalaC> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
