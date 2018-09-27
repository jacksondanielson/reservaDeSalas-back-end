package com.jackson.reservadesala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jackson.reservadesala.domain.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
