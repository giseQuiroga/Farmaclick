package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class TestFarmacia extends SpringTest {
	
	@Inject
	private FarmaciaDao farmaciaDao;
	
	@Test
	@Transactional @Rollback(true)
	public void PruebaInsertarUnaFarmacia() {
		
		/* Preparacion */
		Farmacia farmaciaPrueba = new Farmacia();
		farmaciaPrueba.setRazonSocial("RSfarmaciaPrueba");
		
		/* Operacion */
		farmaciaDao.guardarFarmaciaNueva(farmaciaPrueba);
		
		/* Verifiacion */
		Farmacia farmaciaObtenida = sessionFactory.getCurrentSession().get(Farmacia.class, farmaciaPrueba.getId());
		Assert.assertTrue(farmaciaObtenida.getRazonSocial().equals("RSfarmaciaPrueba"));
	}
}
