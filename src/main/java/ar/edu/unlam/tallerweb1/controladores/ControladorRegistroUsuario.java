package ar.edu.unlam.tallerweb1.controladores;


import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroUsuario;

@Controller
@WebServlet("/ControladorRegistroUsuario")
public class ControladorRegistroUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
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
		public ModelAndView validarRegistroUsuario(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("usuario") Usuario usuario) throws ServletException, IOException{
			
			ModelMap model = new ModelMap();
			
			Usuario usuarioObtenido = servicioRegistroUsuario.buscarUsuario(usuario);
			
			if (usuarioObtenido == null){
				model.put("usuarioIngresado", usuario);
				model.put("error", "Usuario registrado, Intente con otro Email.");
				
				return new ModelAndView("registroUsuario", model);
			}
				model.put("mainObject", usuarioObtenido);
				/*Creo una variable sesion*/
				HttpSession sesion = request.getSession();
				
				/*las seteo con los datos que vienen del usuario encontrado en la bd*/
				sesion.setAttribute("nombre", usuarioObtenido.getNombre());
				sesion.setAttribute("idUsuario", usuarioObtenido.getId());
				sesion.setAttribute("tipoUsuario", "usuario");
				
				return new ModelAndView("home", model);
			
			
		}


		public void setServicioUsuario(ServicioRegistroUsuario usuarioFake) {
			this.servicioRegistroUsuario = usuarioFake;				
		}

}
