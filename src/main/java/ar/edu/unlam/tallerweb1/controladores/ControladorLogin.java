package ar.edu.unlam.tallerweb1.controladores;

import java.io.IOException;
import java.util.List;

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

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;

@Controller
@WebServlet("/ControladorLogin")	/*AGREGADO*/
public class ControladorLogin extends HttpServlet{ /*AGREGO EXTENDS para que funcione lo de sesiones*/
	
/*PARA SERVLET - SE AGREGA AUTOMATICAMENTE*/
	private static final long serialVersionUID = 1L;
/*PARA SERVLET - SE AGREGA AUTOMATICAMENTE*/
	
	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioProducto servicioProducto;
	
	@RequestMapping("/loginUsuario")
	public ModelAndView irAloginFarmaclick() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("loginUsuario", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("usuario") Usuario usuario) throws ServletException, IOException{
		ModelMap model = new ModelMap();
		Usuario usuarioObtenido = servicioLogin.logearUsuario(usuario);
		
		if (usuarioObtenido != null){
			model.put("mainObject", usuarioObtenido);
			
			/*Creo una variable sesion*/
			HttpSession sesion = request.getSession();
			
			/*las seteo con los datos que vienen del usuario encontrado en la bd*/
			sesion.setAttribute("nombre", usuarioObtenido.getNombre());
			sesion.setAttribute("idUsuario", usuarioObtenido.getId());
			sesion.setAttribute("tipoUsuario", "usuario");
			return new ModelAndView("home", model);
		}
		else{
			model.put("error", "Email o contraseña incorrecta.");
			return new ModelAndView("loginUsuario", model);
		}
	}

//metodo encargado de la gestion GET
//Cierro la sesion
		@RequestMapping("/cerrarSesion")
		protected ModelAndView cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			HttpSession sesion = request.getSession();
			ModelMap modelo = new ModelMap();
		
			modelo.put("usuarioNombre", sesion.getAttribute("nombre"));
			sesion.invalidate(); /*CIERRA LA SESION QUE ESTA ABIERTA EN ESE MOMENTO*/
			return new ModelAndView("cerrarSesion", modelo);
		}
	
 /*----------------------------------------------------------------------------------------------------------------------------------*/
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/loginUsuario");
	}
	
	@RequestMapping("/home")
	protected ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ModelMap model = new ModelMap();
		List<Producto> listaProductos = servicioProducto.obtenerProductosSinStock();
		model.put("listaProductos", listaProductos);
		return new ModelAndView("home", model);
	}
		
	@RequestMapping ("/listaFarmacias")
		public ModelAndView listaFarmacias(){
			ModelMap model = new ModelMap();
			return new ModelAndView ("listaFarmacias", model);
		}

	public void setServicioUsuario(ServicioLogin servicioUsuario) {
		this.servicioLogin = servicioUsuario;		
	}
		
}