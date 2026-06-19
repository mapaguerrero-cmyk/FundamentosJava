package cl.pguerrero.demo.controladores;
import java.text.Normalizer;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/peliculas")
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
	
	// Metodo para normalizar con ReGex (Expresiones Regulares)
	private String normalizarRegEx(String texto) {
		String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
		return normalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();
        
    }
		
	// http://localhost:8080/peliculas
	// 1. lista de todas las películas disponibles
	@GetMapping("")
	public String obtenerTodasLasPeliculas() {
		String resultado = "<< Lista de películas disponibles:<br>";
		for (String pelicula : listaPeliculas.keySet()) {
			resultado += pelicula + "<br>";
		}
		return resultado;
	}
	
	// http://localhost:8080/peliculas/oliver
	// 2. Devuelve el nombre de la película y su director
	@GetMapping("/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		String nombreNormalizado = normalizarRegEx(nombre);
		
		for (String pelicula : listaPeliculas.keySet()){
			String peliculaNormalizada = normalizarRegEx(pelicula);
			if (peliculaNormalizada.equals(nombreNormalizado)) {
				return "<< La pelicula : " + pelicula + " y su director es: " + listaPeliculas.get(pelicula);
			}
		}
		return " «La película no se encuentra en nuestra lista.»";
	}
	
	// http://localhost:8080/peliculas/director/don%20hall
	// 3. lista de todas las películas que tienen ese director
	@GetMapping("/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre) {
		String nombreNormalizado = normalizarRegEx(nombre);
		String directorOriginal = "";
		String resultado ="";
		
		for (String pelicula : listaPeliculas.keySet()) {
			String director = listaPeliculas.get(pelicula);
			String directorNormalizado = normalizarRegEx(director);
			
			if (directorNormalizado.equals(nombreNormalizado)) {
				directorOriginal = listaPeliculas.get(pelicula);
				resultado += pelicula + "<br>";// Agrega la película y un salto de línea
			}
		}
		return resultado.isEmpty() ? "<< No contamos con películas con ese director en nuestra lista.>>" : "<< Peliculas del director: " + directorOriginal + "<br>" + resultado;
		}
}
	

