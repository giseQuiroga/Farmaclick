package ar.edu.unlam.tallerweb1.controladores;

import java.io.IOException;
import java.util.LinkedList;
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
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;

@Controller
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioProducto servicioProducto;

	@RequestMapping("/altaProductos")
	public ModelAndView altaProducto(){
		ModelMap modelo = new ModelMap();
		return new ModelAndView("altaProducto",modelo);
	}
	
	@RequestMapping(path = "/listadoProductos", method = RequestMethod.POST)
	protected ModelAndView validarRegistroProducto(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("producto") Producto producto)throws ServletException, IOException{
		ModelMap model = new ModelMap();
		//resultadoRegistroFarmacia
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
	
	@RequestMapping(path="Productos")
	public ModelAndView mostrarTodosProductos(){
		ModelMap model=new ModelMap();
		List<Producto> listaProductos=servicioProducto.obtenerProductos();
		model.put("listaProductos", listaProductos);
		return new ModelAndView("productosTodos", model);
	}
}
