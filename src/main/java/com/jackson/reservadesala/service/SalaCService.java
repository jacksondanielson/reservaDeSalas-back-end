package com.jackson.reservadesala.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackson.reservadesala.domain.SalaC;
import com.jackson.reservadesala.repository.SalaCRepository;


@Service
public class SalaCService {
	
	@Autowired
	private SalaCRepository repo;
	
	public SalaC find(Integer id){
		Optional <SalaC> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.jackson.reservadesala.service.exception.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + "Tipo: " + SalaC.class.getName()));
	}
	
	public SalaC insert(SalaC obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public SalaC update(SalaC obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
}
