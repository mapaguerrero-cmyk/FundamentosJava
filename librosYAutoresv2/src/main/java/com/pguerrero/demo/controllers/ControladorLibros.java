package com.pguerrero.demo.controllers;

import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pguerrero.demo.interfaces.NormalizarTexto;


@Controller
public class ControladorLibros implements NormalizarTexto{
	
	private static HashMap<String, String> listaLibros = new HashMap<String, String>();
	
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	}
	
		
	@GetMapping("/libros")
	public String obtenerTodosLosLibros(Model modelo) {
		// Obtener las llaves del HashMap (los nombres de los libros)
		Set<String> nombresLibros = listaLibros.keySet();
		modelo.addAttribute("libros", nombresLibros);
		return "libros.jsp";
	}
	
	@GetMapping("/libros/{nombre}")
	public String obtenerInformacionDeLibro(@PathVariable("nombre") String nombre, Model modelo) {
		String nombreNormalizado = normalizarTexto(nombre);
		for (String key : listaLibros.keySet()){
			String keyNormalizada = normalizarTexto(key);
			if (keyNormalizada.equals(nombreNormalizado)) {
				modelo.addAttribute("libro", key);
				modelo.addAttribute("autor", listaLibros.get(key));
				return "detalleLibro.jsp";
			}
		}
		modelo.addAttribute("mensajeError", "«El libro no se encuentra en nuestra lista.»");
		return "detalleLibro.jsp";
	}
	
	@GetMapping("/libros/formulario")
	public String formularioLibro() {
		
		return "formularioLibros.jsp";
	}
	
	@PostMapping("/procesa/libro")
	public String procesaLibro(@RequestParam String nombre, @RequestParam String autor) {
		
		listaLibros.put(nombre, autor);
		return "redirect:/libros";
	}

}
