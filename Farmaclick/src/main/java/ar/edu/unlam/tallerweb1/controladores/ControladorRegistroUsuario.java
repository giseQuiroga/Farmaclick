package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

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
public class ControladorRegistroUsuario {
	ArrayList <Usuario> registroUsuario = new ArrayList<Usuario>();
	
		@Inject
		private ServicioLogin servicioLogin; 

/* Me manda a la vista del Registro de Usuario */
		@RequestMapping("/registroUsuario")
		public ModelAndView irARegistroUsuario() {

			ModelMap modelo = new ModelMap();
			return new ModelAndView("registroUsuario", modelo);
		}
		
/* Se valida el Registro del Usuario */
		@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
		public ModelAndView validarRegistro(@ModelAttribute("usuario") Usuario usuario){
			ModelMap model = new ModelMap();
			
			if(servicioLogin.consultarUsuario(usuario) != null){	
				model.put("error", "Usuario ya registrado");
			} else {
				/*aca se debe registrar*/
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setNombre(usuario.getNombre());
				nuevoUsuario.setApellido(usuario.getApellido());
				nuevoUsuario.setEmail(usuario.getEmail());
				nuevoUsuario.setPassword(usuario.getPassword());
				
				model.put("nuevoUsuario", nuevoUsuario);
			}
			return new ModelAndView("holaMundo", model);
		}
		
}
