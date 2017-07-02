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
		
		List<Producto> listaEncontrados = servicioBuscarProducto.buscarProductos(artNombre);
		
		Model.put("productoList", listaEncontrados);
		return new ModelAndView("productosTodos", Model);
		}
		
	}
