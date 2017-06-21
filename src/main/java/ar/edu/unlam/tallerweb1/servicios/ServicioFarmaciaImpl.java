package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Service("ServicioFarmacia")
@Transactional
public class ServicioFarmaciaImpl implements ServicioFarmacia{

	@Inject
	private FarmaciaDao farmaciaDao;
	
	@Override
	public Boolean ingresarFarmaciaNueva (Farmacia farmacia) {

		Boolean resultadoRegistroFarmacia = true;
		
		if (farmaciaDao.consultarFarmacia(farmacia) != null){
			resultadoRegistroFarmacia = false;
			return resultadoRegistroFarmacia;
		}
		
		farmaciaDao.guardarFarmaciaNueva(farmacia);
		return resultadoRegistroFarmacia;	
		
	}


	@Override
	public Boolean logear(Farmacia farmacia) {

		Boolean resultadoRegistroFarmacia = false;
		Farmacia farmaciaPrueba = farmaciaDao.consultarFarmacia(farmacia);
		if (farmaciaPrueba != null){
			if (farmaciaPrueba.getPassword() == farmacia.getPassword()){
				resultadoRegistroFarmacia = true;
				return resultadoRegistroFarmacia;
			}
		}
		return resultadoRegistroFarmacia;	
		
	}
	
}






	

