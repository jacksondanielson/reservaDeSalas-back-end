package com.jackson.reservadesala.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackson.reservadesala.domain.SalaC;
import com.jackson.reservadesala.domain.Usuario;
import com.jackson.reservadesala.repository.SalaCRepository;
import com.jackson.reservadesala.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private SalaCRepository salacRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	public void instantiateTestDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sdf.setTimeZone(TimeZone.getDefault());
		
		SalaC res1 = new SalaC(null, "aula de oftalmo", sdf.parse("18/09/2018 07:00"), sdf.parse("18/09/2018 09:00"), "alexandre", "84999885524", "jacksonalves31@gmail.com");
		SalaC res2 = new SalaC(null, "aula de ortopedia", sdf.parse("19/09/2018 13:00"), sdf.parse("19/09/2018 16:00"), "ricardo", "84999885524", "jacksonalves31@gmail.com");
		SalaC res3 = new SalaC(null, "aula de cirugia plastica", sdf.parse("20/09/2018 16:00"), sdf.parse("20/09/2018 18:00"), "kleber", "84999885524", "jacksonalves31@gmail.com");
		SalaC res4 = new SalaC(null, "aula de anestesio", sdf.parse("18/09/2018 13:00"), sdf.parse("18/09/2018 15:00"), "alexandre", "84999885524", "jacksonalves31@gmail.com");
		salacRepository.saveAll(Arrays.asList(res1,res2, res3,res4));
		
		Usuario user1 = new Usuario(null, "Jackson danielson", "84996000898", "jacksonalves@gmail.com");
		usuarioRepository.saveAll(Arrays.asList(user1));
	}
}
