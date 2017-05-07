package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorRegistroUsuario {
	ArrayList <Usuario> registroUsuario = new ArrayList<Usuario>();

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
			
			/* Hardcodeo llenando datos en un array, simula la gente ya registrada */
			ArrayList <Usuario> misRegistros = new ArrayList<Usuario>();
			
			/* Agrego 5 usuarios para poder comparar con algo*/
			Usuario usuarioAIngresar1 = new Usuario();
			usuarioAIngresar1.setId(1);
			usuarioAIngresar1.setNombre("Rocio");
			usuarioAIngresar1.setApellido("Bareiro");
			usuarioAIngresar1.setEmail("bareiro@gmail.com");
			usuarioAIngresar1.setPassword("bareiro");		
			misRegistros.add(usuarioAIngresar1);
			
			Usuario usuarioAIngresar2 = new Usuario();
			usuarioAIngresar2.setId(2);
			usuarioAIngresar2.setNombre("Gisela");
			usuarioAIngresar2.setApellido("Quiroga");
			usuarioAIngresar2.setEmail("quiroga@gmail.com");
			usuarioAIngresar2.setPassword("quiroga");		
			misRegistros.add(usuarioAIngresar2);
			
			Usuario usuarioAIngresar3 = new Usuario();
			usuarioAIngresar3.setId(3);
			usuarioAIngresar3.setNombre("Pablo");
			usuarioAIngresar3.setApellido("Garcia");
			usuarioAIngresar3.setEmail("garcia@gmail.com");
			usuarioAIngresar3.setPassword("garcia");		
			misRegistros.add(usuarioAIngresar3);
			
			Usuario usuarioAIngresar4 = new Usuario();
			usuarioAIngresar4.setId(4);
			usuarioAIngresar4.setNombre("Matias");
			usuarioAIngresar4.setApellido("Martinez");
			usuarioAIngresar4.setEmail("martinez@gmail.com");
			usuarioAIngresar4.setPassword("martinez");		
			misRegistros.add(usuarioAIngresar4);
			
			Usuario usuarioAIngresar5 = new Usuario();
			usuarioAIngresar5.setId(1);
			usuarioAIngresar5.setNombre("Rocio");
			usuarioAIngresar5.setApellido("Castañer");
			usuarioAIngresar5.setEmail("castañer@gmail.com");
			usuarioAIngresar5.setPassword("castañer");		
			misRegistros.add(usuarioAIngresar5);
			
			/* guardo la lista en mi modelo */
			model.put("usuarios", misRegistros);
			
			
			/* Comparo a ver si mi usuario esta en la lista */
			Usuario nuevoUsuario = new Usuario();
			nuevoUsuario.setNombre(usuario.getNombre());
			nuevoUsuario.setApellido(usuario.getApellido());
			nuevoUsuario.setEmail(usuario.getEmail());
			nuevoUsuario.setPassword(usuario.getPassword());
			
			/* Busco si el usuario ya esta registrado */
			int encontro = 0;
			for (Usuario usuarioComparado : misRegistros) {
				if (usuarioComparado.getEmail().equals(nuevoUsuario.getEmail())) {
			            	encontro = 1;
			      }
			 }
			
			/* Si lo encuentro me lleva otra vez al registro, si no me lleva a un jsp OK */
			if(encontro == 1){
				model.put("error", "Usuario ya registrado.");
				return new ModelAndView("registroUsuario", model);
			} else {
				misRegistros.add(nuevoUsuario);
				model.put("usuarioNuevoRegistrado", nuevoUsuario);
				return new ModelAndView("holaMundo", model); 
			}
	
		}
}
