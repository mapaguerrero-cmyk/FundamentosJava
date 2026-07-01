package com.pguerrero.modelos;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {// Tablas: plural; Clases, Atributos, Columnas: Singular
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//AI
	private Long id;
	
	@NotBlank(message = "Ingresa tu nombre.")
	@Size(min = 3, max=40, message = "El nombre debe tener al menos 3 caracteres")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", 
	         message = "El nombre no debe contener números.")
	private String nombre;
	
	@NotBlank(message = "Ingresa tu apellido.")
	@Size(min = 3, max=60, message = "El apellido debe tener al menos 3 caracteres")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", 
	         message = "El apellido no debe contener números.")
	private String apellido;
	
	@NotBlank(message = "Ingresa tu correo.")
	@Email(message= "Ingresa un correo válido.")// Valida que el correo este bien ingresado con @
	private String correo;
	
	@NotBlank(message = "Ingresa tu contraseña.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message ="La contraseña debe incluir al menos una mayúscula, una minúscula y un número.")
	private String password;
	
	@Transient //No guarda esa columna en mi BD
	private String confirmarPassword;
	
	@NotNull(message = "Ingresa fecha de nacimiento.")
	@Past(message = "La fecha de nacimiento debe ser una fecha en el pasado.")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaDeNacimiento;
	
	@Column(name = "fecha_creacion", updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
		
	@Column(name="fecha_actualizacion")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaActualizacion;
	
	public Usuario() {}

	public Usuario(Long id, String nombre, String apellido, String correo, String password,
			String confirmarPassword, LocalDate fechaDeNacimiento, Date fechaCreacion, Date fechaActualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", password=" + password + ", confirmarPassword="
				+ confirmarPassword + ", fechaDeNacimiento=" + fechaDeNacimiento + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	//Antes de crear un nuevo usuario
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
		this.fechaActualizacion = this.fechaCreacion;
	}
		
	//Antes de que actualice un registro
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();//fechaActualizacion = CURRENT_TIMESTAMP
	}
	

}
