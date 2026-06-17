package cl.pguerrero.demo.controladores;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Set;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");	
	}
	
		
	//http://localhost:8080/peliculas
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		String resultado = "<< Lista de películas disponibles:<br>";
		for (String pelicula : listaPeliculas.keySet()) {
			resultado += pelicula + "<br>";
		}
		return resultado;
	}
	
	//http://localhost:8080/peliculas/oliver
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		
		for (String pelicula : listaPeliculas.keySet()){
			if (pelicula.equalsIgnoreCase(nombre)) {
				return "<< La pelicula : " + pelicula + " y su director es: " + listaPeliculas.get(pelicula);
			}
		}
		return " «La película no se encuentra en nuestra lista.»";
	}
	
	//http://localhost:8080/peliculas/director/don%20hall
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre) {
		String resultado ="";
		for (String pelicula : listaPeliculas.keySet()) {
			String directorDepeliculas = listaPeliculas.get(pelicula);
			if (directorDepeliculas.equalsIgnoreCase(nombre)) {
				resultado += pelicula + "<br>";// Agrega la película y un salto de línea
			}
		}
		if (resultado.isEmpty()) {
			return "<< No contamos con películas con ese director en nuestra lista.>>";
		}else {
			return "<< Peliculas del director: " + nombre + "<br>" + resultado;
		}
		
		
	}
	
}
