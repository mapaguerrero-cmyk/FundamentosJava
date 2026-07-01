package com.pguerrero.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pguerrero.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long>{
	
	Usuario findByCorreo(String correo);//SELECT * FROM usuarios WHERE correo =<correo>
}
