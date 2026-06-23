package com.pguerrero.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pguerrero.demo.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{
	
	// Método para obtener todas las canciones
		List<Cancion> findAll();

}
