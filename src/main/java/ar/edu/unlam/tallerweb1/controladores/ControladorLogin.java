package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	/*
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap model = new ModelMap();

		if (servicioLogin.consultarUsuario(usuario) != null) {
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	*/
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* login de farmaclick (hacer lo mismo que lo que dice el login de taller)*/
	
	@RequestMapping("/loginUsuario")
	public ModelAndView irAloginFarmaclick() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("loginUsuario", modelo);
	}
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap model = new ModelMap();
		//Logica de negocio en Servicio
		
		if (servicioLogin.consultarUsuario(usuario) == true){
			return new ModelAndView("home", model);
		}
		else{
			model.put("error", "Email o Contraseña Incorrecta.");
			return new ModelAndView("loginUsuario", model);
		}
	}	
		
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/loginUsuario");
	}
	
	@RequestMapping ("/home")
		public ModelAndView home(){
			ModelMap model = new ModelMap();
			return new ModelAndView("home", model);
		}
		
	@RequestMapping ("/nosotros")
		public ModelAndView nosotros(){
			ModelMap model = new ModelMap();
			return new ModelAndView("nosotros", model);
		}
		
	@RequestMapping ("/listaFarmacias")
		public ModelAndView listaFarmacias(){
			ModelMap model = new ModelMap();
			return new ModelAndView ("listaFarmacias", model);
		}
		
	}
	

