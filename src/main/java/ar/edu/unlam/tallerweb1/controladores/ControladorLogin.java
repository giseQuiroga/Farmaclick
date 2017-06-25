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
		Usuario usuarioObtenido = servicioLogin.logearUsuario(usuario);
		if (usuarioObtenido != null){
			model.put("usuario", usuarioObtenido);
			return new ModelAndView("home", model);
		}
		model.put("error", "Email o contraseña incorrecta.");
		return new ModelAndView("loginUsuario", model);
		
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
	

