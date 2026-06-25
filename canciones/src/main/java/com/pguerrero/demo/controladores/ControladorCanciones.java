package com.pguerrero.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.pguerrero.demo.modelos.Cancion;
import com.pguerrero.demo.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	// Atributo de la clase 
	@Autowired
	private ServicioCanciones servicioCanciones;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		
		List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("listaCanciones", listaCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model modelo) {
		
		Cancion cancion = this.servicioCanciones.obtenerCancionPorId(id);
		modelo.addAttribute("cancion", cancion);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(Model modelo) {
		
		modelo.addAttribute("cancion", new Cancion());
		return "agregarCancion.jsp";
		
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones) {
		
		if (validaciones.hasErrors()) {
			return "agregarCancion.jsp";
			
		}
		this.servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable("idCancion") Long id, Model modelo ) {
		
		System.out.println("ID recibido en GET: " + id);
				
		modelo.addAttribute("cancion", this.servicioCanciones.obtenerCancionPorId(id));
		
		System.out.println("idCancion agregado al modelo: " + id);
		return "editarCancion.jsp";
	}
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones, @PathVariable("idCancion") Long idCancion) {
		
		cancion.setId(idCancion);
		System.out.println("ID de la canción PUT: " + cancion.getId());
	    System.out.println("Título: " + cancion.getTitulo());
		if (validaciones.hasErrors()) {
			return "editarCancion.jsp";
		}
		
		System.out.println("Actualizando canción...");
		this.servicioCanciones.actualizaCancion(cancion);
		return "redirect:/canciones";
	}
	
}
