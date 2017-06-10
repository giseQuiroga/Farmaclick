package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarProducto;

@Controller
public class ControladorBuscarProducto 
	{
	@Inject
	private ServicioBuscarProducto servicioBuscarProducto;
	
	@RequestMapping("/buscarProducto")
	public ModelAndView busqueda()
		{
		ModelMap Modelo = new ModelMap();
		Producto productoBuscado = new Producto();
		Modelo.put("productoBuscado", productoBuscado);
		return new ModelAndView("buscarProducto", Modelo);
		}
	
	@RequestMapping(path = "/procesarBusqueda", method = RequestMethod.POST)
	public ModelAndView procesarBusqueda(@ModelAttribute("productoBuscado") Producto productoBuscado) 
		{
		ModelMap Model = new ModelMap();
		
		String artNombre = productoBuscado.getNombre();
		List<Producto> listaProductos = new LinkedList<Producto>();
		List<Producto> listaEncontrados = new LinkedList<Producto>();
		
		Producto producto1 = new Producto(); 
		producto1.setNombre("Aspirinas");
		//producto1.setCodigo("ABC123JK");
		producto1.setAccion("Alivian el dolor de cabeza");
		
		Producto producto2 = new Producto();	
		producto2.setNombre("Curitas");
		//producto2.setCodigo("XYZ987OP");
		producto2.setAccion("Te curan las lastimaduras");
		
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		
		listaEncontrados.addAll(servicioBuscarProducto.filtrarProducto(listaProductos, artNombre));
		
		Model.put("productoList", listaEncontrados);
		return new ModelAndView("home", Model);
		}
		
	}
