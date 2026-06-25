package com.pguerrero.demo.modelos;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 5, max = 60, message = "Debe contener entre 5 y 60 caracteres.")
	private String titulo;
	
	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 3, max = 40, message = "Debe contener entre 3 y 40 caracteres.")
	private String artista;
	
	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 3, max = 20, message = "Debe contener entre 3 y 20 caracteres.")
	private String album;
	
	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String genero;
	
	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 3, max = 15, message = "Debe contener entre 3 y 15 caracteres.")
	private String idioma;
	
	@Column(name = "fecha_creacion", updatable = false)
	private Date fechaCreacion;
	
	
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;
	
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
		this.fechaActualizacion =new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();
	}
	
		
	public void setId(Long id) {
		this.id = id;
	}

	public Cancion() {
		}

		
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Long getId() {
		return id;
	}
		
	
	}
