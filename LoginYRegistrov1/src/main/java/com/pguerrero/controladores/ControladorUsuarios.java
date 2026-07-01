package com.pguerrero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pguerrero.modelos.LoginUsuario;
import com.pguerrero.modelos.Usuario;
import com.pguerrero.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	//Mostrar vista para registro y para login
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, @ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
		
		return"index.jsp";
		
	}
	
	//Accion procesar el registro
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, BindingResult result, Model model, HttpSession sesion) {
		
		servicioUsuarios.registrar(nuevoUsuario, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUsuario", new LoginUsuario());//manda vacio form de inicio sesion
			return "index.jsp";
		}else {
			//Si no hay errores guardar el nuevo usuario en sesion
			sesion.setAttribute("usuarioEnSesion", nuevoUsuario);//Guardo el objeto usuario
			return "redirect:/dashboard";
		}
		
	}
	
	//Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession sesion) {
		if(sesion.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesion
			return "redirect:/"; //Redirijir al inicio sesion
			
		}
		return "dashboard.jsp";
	}
	
	//Accion procesar el inicio de sesion
	@PostMapping("/login")
	public String login (@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult result, Model model, HttpSession sesion) {
		Usuario usuarioIntentaLogin = servicioUsuarios.login(loginUsuario, result);
		if(result.hasErrors()) {
			model.addAttribute("nuevoUsuario", new Usuario());
			return "index.jsp";
		}else {
			sesion.setAttribute("usuarioEnSesion", usuarioIntentaLogin);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuarioEnSesion"); //Elimina un atributo de la sesión
		session.invalidate(); //Elimina la sesión completa
		return "redirect:/";
	}
	
	
}
