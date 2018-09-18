package com.jackson.reservadesala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jackson.reservadesala.domain.SalaC;



@Repository
public interface SalaCRepository extends JpaRepository<SalaC, Integer>{

}
