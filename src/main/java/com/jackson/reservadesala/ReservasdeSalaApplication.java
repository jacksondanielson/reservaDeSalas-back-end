package com.jackson.reservadesala;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jackson.reservadesala.domain.SalaC;
import com.jackson.reservadesala.repository.SalaCRepository;

@SpringBootApplication
public class ReservasdeSalaApplication implements CommandLineRunner{
	
	@Autowired
	private SalaCRepository salacRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReservasdeSalaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		SalaC res1 = new SalaC(null, "aula de oftalmo", sdf.parse("18/09/2018 07:00"), sdf.parse("18/09/2018 09:00"), "alexandre", "84999885524", "jacksonalves31@gmail.com");
		SalaC res2 = new SalaC(null, "aula de ortopedia", sdf.parse("19/09/2018 13:00"), sdf.parse("19/09/2018 16:00"), "ricardo", "84999885524", "jacksonalves31@gmail.com");
		SalaC res3 = new SalaC(null, "aula de cirugia plastica", sdf.parse("20/09/2018 16:00"), sdf.parse("20/09/2018 18:00"), "kleber", "84999885524", "jacksonalves31@gmail.com");
		SalaC res4 = new SalaC(null, "aula de anestesio", sdf.parse("18/09/2018 13:00"), sdf.parse("18/09/2018 15:00"), "alexandre", "84999885524", "jacksonalves31@gmail.com");
		salacRepository.saveAll(Arrays.asList(res1,res2, res3,res4));
		
	}
}
