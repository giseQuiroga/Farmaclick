package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroUsuario;

@Controller
public class ControladorRegistroUsuario {
	
	@Inject
	private ServicioRegistroUsuario servicioRegistroUsuario;
	

/* Me manda a la vista del Registro de Usuario */
		@RequestMapping("/registroUsuario")
		public ModelAndView irARegistroUsuario() {

			ModelMap modelo = new ModelMap();
			return new ModelAndView("registroUsuario", modelo);
		}

		
/* Se valida el Registro del Usuario */
		@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
		public ModelAndView validarRegistroUsuario(@ModelAttribute("usuario") Usuario usuario){
			ModelMap model = new ModelMap();
			//Logica de negocio en Servicio
			model.put("usuarioIngresado", usuario);
			Usuario usuarioObtenido = servicioRegistroUsuario.buscarUsuario(usuario);
			if (usuarioObtenido == null){
				model.put("error", "Usuario registrado, Intente con otro Email.");
				return new ModelAndView("registroUsuario", model);
			}
			
				model.put("Usuario", usuarioObtenido);
				return new ModelAndView("home", model);
			
			
		}	
}