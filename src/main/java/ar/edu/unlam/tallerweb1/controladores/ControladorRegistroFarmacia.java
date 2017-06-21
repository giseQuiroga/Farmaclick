package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFarmacia;

@Controller
public class ControladorRegistroFarmacia {
	
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
			model.put("farmacia", farmacia);
			String mensajeConfirmacionRegistroFarmaciaNueva;
			
			if (servicioFarmacia.ingresarFarmaciaNueva(farmacia) == false){
				mensajeConfirmacionRegistroFarmaciaNueva = "El CUIT ingresado ya esta registrado.";
				model.put("mensajeConfirmacionRegistroFarmaciaNueva", mensajeConfirmacionRegistroFarmaciaNueva);
				return new ModelAndView("registroFarmacia", model);
			}
			
			mensajeConfirmacionRegistroFarmaciaNueva = "Se registro correctamente la Farmacia.";
			model.put("mensajeConfirmacionRegistroFarmaciaNueva", mensajeConfirmacionRegistroFarmaciaNueva);
			return new ModelAndView("home", model);
			
			
			
		}
}
