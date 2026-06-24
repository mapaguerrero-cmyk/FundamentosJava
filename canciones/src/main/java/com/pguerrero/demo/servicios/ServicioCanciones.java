package com.pguerrero.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pguerrero.demo.modelos.Cancion;
import com.pguerrero.demo.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	
	// Atributo de la clase ServicioCanciones
	@Autowired
	private RepositorioCanciones repositorioCanciones;
	
	// Constructor de la clase ServicioCanciones
	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	
	//OPERACIONES LECTURA --> SELECT
	public List<Cancion> obtenerTodasLasCanciones(){
		return  this.repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long id) {
		return this.repositorioCanciones.findById(id).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancion) {
		return this.repositorioCanciones.save(cancion);
	}
}
