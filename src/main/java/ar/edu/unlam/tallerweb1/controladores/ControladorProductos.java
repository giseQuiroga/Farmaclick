package ar.edu.unlam.tallerweb1.controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroUsuario;

@Controller
@WebServlet("/ControladorProductos")
public class ControladorProductos {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioProducto servicioProducto;
	@Inject
	private ServicioRegistroUsuario servicioRegistroUsuario;

	@RequestMapping("/altaProductos")
	public ModelAndView altaProducto() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("altaProducto", modelo);
	}

	@RequestMapping(path = "/listadoProductos", method = RequestMethod.POST)
	protected ModelAndView validarRegistroProducto(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("producto") Producto producto)throws ServletException, IOException{
		ModelMap model = new ModelMap();
		model.put("producto", producto);
		String mensaje;
		
		Object attribute = request.getSession().getAttribute("idUsuario");
		Integer idSesionFarmacia = Integer.parseInt(String.valueOf(attribute));
		
		if (!servicioProducto.verificarProducto(producto, idSesionFarmacia)){
			mensaje= "El producto ingresado ya esta registrado.";
			model.put("mensaje", mensaje);
			return new ModelAndView("altaProducto", model);
		}
		else{	
			List<Producto> listaProductos=new LinkedList<Producto>();
			listaProductos.add(producto);
			model.put("listaProductos", listaProductos);
			return new ModelAndView("productosTodos", model);
		}
	}
	
	@RequestMapping(path = "Productos")
	public ModelAndView mostrarTodosProductos() {
		ModelMap model = new ModelMap();
		List<Producto> listaProductos = servicioProducto.obtenerProductos();
		model.put("listaProductos", listaProductos);
		return new ModelAndView("productosTodos", model);
	}
	
	@RequestMapping(path = "misProductos")
	public ModelAndView mostrarProductosPorFarmacia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		Integer idFarmacia = (Integer) sesion.getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		List<Producto> listaProductos = servicioProducto.obtenerProductosPorFarmacia(idFarmacia);
		model.put("listaProductos", listaProductos);
		return new ModelAndView("productosTodos", model);
	}

	@RequestMapping(path = "validarPedido", method = RequestMethod.GET)
	public ModelAndView mostrarDetalleDeCompra(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("producto") long idProd) throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		Pedido pedido = new Pedido();
		ModelMap model = new ModelMap();
		Producto producto = servicioProducto.buscarProductoPorId(idProd);
		producto.setStock(producto.getStock()-1);
		pedido.setProducto(producto);
		Integer idUsuario = (Integer) sesion.getAttribute("idUsuario");
		Usuario usuario = servicioRegistroUsuario.buscarUsuarioPorId(idUsuario);
		pedido.setUsuario(usuario);
		Date hoy = Calendar.getInstance().getTime();
		SimpleDateFormat fechaPedido = new SimpleDateFormat("dd/MM/yyyy");
		pedido.setFechaPedido(fechaPedido.format(hoy));
		servicioProducto.guardarCompra(pedido,producto);
		model.put("pedido", pedido);
		return new ModelAndView("validarPedido", model);
	}
	
	@RequestMapping(path = "misCompras", method = RequestMethod.GET)
	public ModelAndView mostrarComprasUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		Integer idUsuario = (Integer) sesion.getAttribute("idUsuario");
		
		ModelMap model = new ModelMap();
		List<Pedido> listaPedido = servicioProducto.obtenerPedidosPorUsuario(idUsuario);
		String mensaje;
		if (listaPedido==null){
			mensaje="Aun no se han realizado compras";
			model.put("mensaje", mensaje);
			return new ModelAndView("comprarProducto", model);
		}
		else{
			model.put("listaPedido", listaPedido);
			return new ModelAndView("comprarProducto", model);
		}
	}
	
	/*@RequestMapping(path="homeFarmacia")
	public ModelAndView mostrarProductosSinStock(){
		ModelMap model = new ModelMap();
		List<Producto> listaProductos = servicioProducto.obtenerProductosSinStock();
		model.put("listaProductos", listaProductos);
		return new ModelAndView("home", model);
	}*/
}
