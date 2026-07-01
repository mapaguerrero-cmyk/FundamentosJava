package com.pguerrero.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//NO ES una entidad, ni va a generar tabla
//Objetivo: obtener la informacion y crear una instancia para poder compararla con un registro real)
public class LoginUsuario {
	
	@NotBlank(message="El email es obligatorio.")
	@Email(message="Ingrese un email válido.")
	private String correoLogin;
	
	@NotBlank(message="La contraseña es obligatoria.")
	private String passwordLogin;
	
	public LoginUsuario(){
	}

	public LoginUsuario(String correoLogin, String passwordLogin) {
		super();
		this.correoLogin = correoLogin;
		this.passwordLogin = passwordLogin;
	}

	public String getCorreoLogin() {
		return correoLogin;
	}

	public void setCorreoLogin(String correoLogin) {
		this.correoLogin = correoLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	@Override
	public String toString() {
		return "LoginUsuario [correoLogin=" + correoLogin + ", passwordLogin=" + passwordLogin + "]";
	}
	
	

}
