package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Producto;

@Controller
public class ControladorProductos {

	@RequestMapping("/alta")
	public ModelAndView altaProducto(){
		ModelMap modelo = new ModelMap();
		return new ModelAndView("altaProducto",modelo);
	}
	
	@RequestMapping(path = "/listadoProductos", method = RequestMethod.POST)
	public ModelAndView validarRegistroFarmacia(@ModelAttribute("producto") Producto producto){
		ModelMap model = new ModelMap();
		
		/*aca se debe registrar*/
		Producto nuevoProducto = new Producto();
		nuevoProducto.setCodigo(producto.getCodigo());
		nuevoProducto.setNombre(producto.getNombre());
		nuevoProducto.setLaboratorio(producto.getLaboratorio());
		nuevoProducto.setPrecio(producto.getPrecio());
		nuevoProducto.setAccion(producto.getAccion());
		
		model.put("nuevoProducto", nuevoProducto);
		
		return new ModelAndView("productosTodos", model);
	}
}
