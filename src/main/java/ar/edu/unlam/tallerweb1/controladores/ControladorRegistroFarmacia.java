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

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFarmacia;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;

@Controller
@WebServlet("/ControladorRegistroFarmacia")
public class ControladorRegistroFarmacia extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioProducto servicioProducto;
	@Inject
	private ServicioFarmacia servicioFarmacia;
	
	/* Login Farmacia */
	@RequestMapping("/loginFarmacia")
	public ModelAndView irAloginFarmaclick() {
		ModelMap modelo = new ModelMap();
		Farmacia farmacia = new Farmacia();
		modelo.put("farmacia", farmacia);
		return new ModelAndView("loginFarmacia", modelo);
	}
	
	// Login de Farmacias
	@RequestMapping(path = "/validar-loginFarmacia", method = RequestMethod.POST)
	public ModelAndView validarLoginFarmacia(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("farmacia") Farmacia farmacia) throws ServletException, IOException {
		ModelMap model = new ModelMap();
		
		Farmacia farmaciaObtenida = servicioFarmacia.logear(farmacia);
		
		if (farmaciaObtenida != null){
			model.put("mainObject", farmaciaObtenida);
			HttpSession sesion = request.getSession();
			
			/*las seteo con los datos que vienen del usuario encontrado en la bd*/
			sesion.setAttribute("nombre", farmaciaObtenida.getCuit());
			sesion.setAttribute("idUsuario", farmaciaObtenida.getId());
			sesion.setAttribute("tipoUsuario", "farmacia");
			sesion.setAttribute("razonSocial", farmaciaObtenida.getRazonSocial());
			
			Integer idFarmacia = (Integer) sesion.getAttribute("idUsuario");
			
			List<Producto> listaProductos = servicioProducto.obtenerProductosSinStock(idFarmacia);
			
			model.put("listaProductos", listaProductos);
			return new ModelAndView("home", model);
		}
		else{
			model.put("error", "CUIT o Contraseña incorrecta.");
			return new ModelAndView("loginFarmacia", model);
		}
	}	
/* Me manda a la vista del Registro de Farmacia */
		@RequestMapping("/registroFarmacia")
		public ModelAndView irARegistroFarmacia() {
			ModelMap modelo = new ModelMap();
			return new ModelAndView("registroFarmacia", modelo);
		}
		
/* Se valida el Registro de Farmacia */
		@RequestMapping(path = "/confirmarRegistroFarmacia", method = RequestMethod.POST)
		public ModelAndView validarRegistroFarmacia(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("farmacia") Farmacia farmacia) throws ServletException, IOException{
			
			ModelMap model = new ModelMap();
			
			String mensajeConfirmacionRegistroFarmaciaNueva;
			Farmacia farmaciaNueva = servicioFarmacia.ingresarFarmaciaNueva(farmacia); 
			if (farmaciaNueva == null){
				mensajeConfirmacionRegistroFarmaciaNueva = "El CUIT ingresado ya esta registrado.";
				model.put("farmacia", farmacia);
				model.put("mensajeConfirmacionRegistroFarmaciaNueva", mensajeConfirmacionRegistroFarmaciaNueva);
				return new ModelAndView("registroFarmacia", model);
			}
			
			
			model.put("mainObject", farmaciaNueva);
			HttpSession sesion = request.getSession();
			
			/*las seteo con los datos que vienen del usuario encontrado en la bd*/
			sesion.setAttribute("nombre", farmaciaNueva.getCuit());
			sesion.setAttribute("idUsuario", farmaciaNueva.getId());
			sesion.setAttribute("tipoUsuario", "farmacia");
			sesion.setAttribute("razonSocial", farmaciaNueva.getRazonSocial());
			return new ModelAndView("home", model);
		}

		public void setServicioFarmacia(ServicioFarmacia servicioFarmacia) {
			this.servicioFarmacia = servicioFarmacia;
		}
		
		@RequestMapping(path = "misPedidos", method = RequestMethod.GET)
		public ModelAndView mostrarComprasUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession sesion = request.getSession();
			
			Integer idFarmacia = (Integer) sesion.getAttribute("idUsuario");
			
			ModelMap model = new ModelMap();
			List<Pedido> listaPedido = servicioFarmacia.obtenerPedidosPorFarmacia(idFarmacia);
			String mensaje;
			if (listaPedido==null){
				mensaje="Aun no se han recibido pedidos";
				model.put("mensaje", mensaje);
				return new ModelAndView("pedidosFarmacia", model);
			}
			else{
				model.put("listaPedido", listaPedido);
				return new ModelAndView("pedidosFarmacia", model);
			}
		}
		
}
