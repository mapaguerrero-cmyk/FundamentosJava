package com.pguerrero.demo.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recetas")
public class ControladorRecetas {
	
	private static String[] listaRecetas = {"Pizza", "Espagueti","Lasaña"};
	private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();
	
	public ControladorRecetas() {
		String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
		recetasConIngredientes.put("Pizza", pizza);
		String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
		recetasConIngredientes.put("Espagueti", espagueti);
		String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
		recetasConIngredientes.put("Lasaña", lasaña);
	}
	
	// Metodo para normalizar (elimina acentos y mayusculas)
			private String normalizar(String texto) {
		        if (texto == null) return "";
		        return texto
		            .toLowerCase()
		            .replace("á", "a")
		            .replace("é", "e")
		            .replace("í", "i")
		            .replace("ó", "o")
		            .replace("ú", "u")
		            .replace("ü", "u")
		            .replace("ñ", "n");
		    }
	
	@GetMapping("")
	public String obtenerTodasLasRecetas(Model modelo) {
		modelo.addAttribute("recetas", listaRecetas);
		return "recetas.jsp";
			
	}
	
	@GetMapping("/{nombre}")
	public String obtenerRecetaPorNombre(@PathVariable("nombre") String nombre, Model modelo) {
		String nombreNormalizado = normalizar(nombre);
		
		for (int i=0; i < listaRecetas.length; i++ ) {
			String recetaOriginal = listaRecetas[i];
			String recetaNormalizada = normalizar(listaRecetas[i]);
			if (nombreNormalizado.equals(recetaNormalizada)) {
				String[] ingredientes = recetasConIngredientes.get(recetaOriginal);
				modelo.addAttribute("receta", recetaOriginal);
				modelo.addAttribute("ingredientes", ingredientes);
				return "detalleReceta.jsp";
			}
		
		}
		 modelo.addAttribute("mensajeError", "<<< La receta no se encuentra en nuestra lista.>>>");
		 return "detalleReceta.jsp";		
	}

}
