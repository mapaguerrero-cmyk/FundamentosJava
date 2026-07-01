package com.pguerrero.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pguerrero.modelos.LoginUsuario;
import com.pguerrero.modelos.Usuario;
import com.pguerrero.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	// Método que guarde el nuevo registro Siempre y cuando cumpla con todas las validaciones
	// incluyendo 2 validaciones manuales
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		//Comparar las contraseñas
		String password = nuevoUsuario.getPassword();
		String confirmarPassword = nuevoUsuario.getConfirmarPassword();
		
		if (!password.equals(confirmarPassword)) {
			//Si son diferentes password y confirmarpassword
			result.rejectValue("confirmarPassword","Matches","Las contraseñas NO coinciden.");//Crear un error
			//(Atributo, clave, mensaje)
		}
		
		//Revisar que el correo no esté ya registrado 
		String correo = nuevoUsuario.getCorreo();
		//Objeto Usuario (registro de mi db) o null
		Usuario existeUsuario = repositorioUsuarios.findByCorreo(correo);
		if(existeUsuario != null) {
			//Ese correo ya existe en BD
			result.rejectValue("correo", "Unique", "El correo ya está registrado en el sistema, elija otro.");
		}
		//Sino hay errores entonces guardamos el usuario
		if(result.hasErrors()) {
			return null;
		}else {
			//No hay errores
			//Hasheo la password
			String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt());
			nuevoUsuario.setPassword(passwordHasheado);//Establecer la password hasheada como pw
			
			return repositorioUsuarios.save(nuevoUsuario);
		}
	}
	//Método que haga las validaciones de inicio de sesión
	public Usuario login(LoginUsuario usuarioIniciaSesion, BindingResult result) {
		//Revisar que el email exista en mi BD
		String correo = usuarioIniciaSesion.getCorreoLogin();//Obtener correo con el que intenta iniciar sesion
		Usuario existeUsuario = repositorioUsuarios.findByCorreo(correo);//Objeto usuario (registro bd) o null
		if(existeUsuario == null) {
			//No existe usuario con ese correo en la bd
			result.rejectValue("correoLogin", "Unique","Correo electrónico no registrado.");
		} else if(! BCrypt.checkpw(usuarioIniciaSesion.getPasswordLogin(), existeUsuario.getPassword())) {
			//No coincide el password ingresado con el de la BD
			result.rejectValue("passwordLogin", "Matches", "Contraseña incorrecta.");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			return existeUsuario;
		}
		
		
	}

}
