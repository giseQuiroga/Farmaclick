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
	public Farmacia ingresarFarmaciaNueva (Farmacia farmacia) {

		if (farmaciaDao.consultarFarmacia(farmacia) != null){
			return null;
		}
		farmaciaDao.guardarFarmaciaNueva(farmacia);
		Farmacia farmaciaObtenida = farmaciaDao.consultarFarmacia(farmacia);
		return farmaciaObtenida;			
	}

	@Override
	public Farmacia logear(Farmacia farmacia) {

		Farmacia farmaciaObtenida = farmaciaDao.consultarFarmacia(farmacia);
		if (farmaciaObtenida != null){
			if (farmaciaObtenida.getPassword().equals(farmacia.getPassword())){
				return farmaciaObtenida;
			}
		}
		return null;		
	}
}