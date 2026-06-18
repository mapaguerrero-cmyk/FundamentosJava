package cl.pguerrero.demo.controladores;
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
		
	//http://localhost:8080/peliculas
	@GetMapping("")
	public String obtenerTodasLasPeliculas() {
		String resultado = "<< Lista de películas disponibles:<br>";
		for (String pelicula : listaPeliculas.keySet()) {
			resultado += pelicula + "<br>";
		}
		return resultado;
	}
	
	//http://localhost:8080/peliculas/oliver
	@GetMapping("/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		String nombreNormalizado = normalizar(nombre);
		
		for (String pelicula : listaPeliculas.keySet()){
			String peliculaNormalizada = normalizar(pelicula);
			if (peliculaNormalizada.equals(nombreNormalizado)) {
				return "<< La pelicula : " + pelicula + " y su director es: " + listaPeliculas.get(pelicula);
			}
		}
		return " «La película no se encuentra en nuestra lista.»";
	}
	
	//http://localhost:8080/peliculas/director/don%20hall
	@GetMapping("/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre) {
		String nombreNormalizado = normalizar(nombre);
		String directorOriginal = "";
		String resultado ="";
		
		for (String pelicula : listaPeliculas.keySet()) {
			String director = listaPeliculas.get(pelicula);
			String directorNormalizado = normalizar(director);
			
			if (directorNormalizado.equals(nombreNormalizado)) {
				directorOriginal = listaPeliculas.get(pelicula);
				resultado += pelicula + "<br>";// Agrega la película y un salto de línea
			}
		}
		if (resultado.isEmpty()) {
			return "<< No contamos con películas con ese director en nuestra lista.>>";
		}else {
			return "<< Peliculas del director: " + directorOriginal + "<br>" + resultado;
		}
		
		
	}
	
}
