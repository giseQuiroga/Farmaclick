package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroFarmacia;

@Controller
public class ControladorRegistroFarmacia {
	
	@Inject
	private ServicioRegistroFarmacia servicioRegistroFarmacia;
	
/* Me manda a la vista del Registro de Farmacia */
		@RequestMapping("/registroFarmacia")
		public ModelAndView irARegistroFarmacia() {
			ModelMap modelo = new ModelMap();
			return new ModelAndView("registroFarmacia", modelo);
		}
		
/* Se valida el Registro de Farmacia */
		@RequestMapping(path = "/confirmarRegistroFarmacia", method = RequestMethod.POST)
		public ModelAndView validarRegistroFarmacia(@ModelAttribute("farmacia") Farmacia farmacia){
			ModelMap model = new ModelMap();
			//resultadoRegistroFarmacia
			model.put("farmacia", farmacia);
			String mensaje;
			if (servicioRegistroFarmacia.verificarFarmaciaExistente(farmacia) == false){
				mensaje = "El CUIT ingresado ya esta registrado.";
				model.put("mensaje", mensaje);
				return new ModelAndView("registroFarmacia", model);
			}
			if (servicioRegistroFarmacia.verificarFarmaciaExistente(farmacia) == true){
				mensaje = "Se registro correctamente la Farmacia.";
				model.put("mensaje", mensaje);
			}
			
			
			return new ModelAndView("confirmarRegistroFarmacia", model);
		}
}
