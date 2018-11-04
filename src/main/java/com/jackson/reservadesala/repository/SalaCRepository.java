package com.jackson.reservadesala.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jackson.reservadesala.domain.SalaC;



@Repository
public interface SalaCRepository extends JpaRepository<SalaC, Integer>{
	
	@Query("SELECT obj FROM SalaC obj WHERE obj.dataDaReserva = :dataDaReserva")
	SalaC findByDataDaReserva(@Param("dataDaReserva") Date dataDaReserva);
}
