package com.pguerrero.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pguerrero.demo.modelos.Cancion;
import com.pguerrero.demo.servicios.ServicioCanciones;

@Controller
@RequestMapping("/canciones")
public class ControladorCanciones {
	
	// Atributo de la clase 
	@Autowired
	private ServicioCanciones servicioCanciones;
	
	// Constructor de la clase
	public ControladorCanciones(ServicioCanciones servicioCanciones) {
		this.servicioCanciones = servicioCanciones;
	}
	
	@GetMapping("")
	public String desplegarCanciones(Model modelo) {
		
		List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("listaCanciones", listaCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model modelo) {
		
		Cancion cancion = this.servicioCanciones.obtenerCancionPorId(id);
		modelo.addAttribute("cancion", cancion);
		return "detalleCancion.jsp";
	}
	

}
