package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Controller
public class ControladorRegistroFarmacia {
	/*ArrayList <Usuario> registroUsuario = new ArrayList<Usuario>();*/
	
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
			
			/*aca se debe registrar*/
			Farmacia nuevaFarmacia = new Farmacia();
			nuevaFarmacia.setCuit(farmacia.getCuit());
			nuevaFarmacia.setRazonSocial(farmacia.getRazonSocial());
			nuevaFarmacia.setTelefono(farmacia.getTelefono());
			nuevaFarmacia.setEmail(farmacia.getEmail());
			nuevaFarmacia.setPassword(farmacia.getPassword());
			
			model.put("nuevaFarmacia", nuevaFarmacia);
			
			return new ModelAndView("confirmarRegistroFarmacia", model);
		}
}
