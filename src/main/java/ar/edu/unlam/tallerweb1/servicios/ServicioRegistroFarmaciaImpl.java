package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Service("ServicioRegistroFarmacia")
@Transactional
public class ServicioRegistroFarmaciaImpl implements ServicioRegistroFarmacia{

	@Inject
	private FarmaciaDao farmaciaDao;
	
	public Boolean verificarFarmaciaExistente (Farmacia farmacia) {
		
		/* Hardcodeo Farmacias ya registradas */
		ArrayList <Farmacia> farmaciasRegistradas = new ArrayList<Farmacia>();
		
		Farmacia f1 = new Farmacia();
		f1.setCuit("20355823866");
		f1.setRazonSocial("ffff");
		f1.setTelefono(12345678);
		f1.setEmail("f1@gmail.com");
		f1.setPassword("farmacia1");		
		farmaciasRegistradas.add(f1);
		
		Farmacia f2 = new Farmacia();
		f2.setCuit("21355823866");
		f2.setRazonSocial("aaaa");
		f2.setTelefono(12345678);
		f2.setEmail("f2@gmail.com");
		f2.setPassword("farmacia2");		
		farmaciasRegistradas.add(f2);
		Boolean resultadoRegistroFarmacia = true;
		
		for(Farmacia cadaFarmacia : farmaciasRegistradas){
			if (cadaFarmacia.getCuit().equals(farmacia.getCuit())){
				resultadoRegistroFarmacia = false;
				return resultadoRegistroFarmacia;
			}
		}
		farmaciaDao.guardarFarmaciaNueva(farmacia);
		return resultadoRegistroFarmacia;	
		
	}
	
}






	


