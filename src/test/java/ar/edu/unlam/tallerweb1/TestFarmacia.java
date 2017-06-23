package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorRegistroFarmacia;
import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.servicios.ServicioFarmacia;
import ar.edu.unlam.tallerweb1.servicios.ServicioFarmaciaImpl;

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
	
	@Test
	@Transactional @Rollback(true)
	public void PruebaConsultarFarmacia() {
		
		/* Preparacion */
		Farmacia farmaciaPrueba = new Farmacia();
		farmaciaPrueba.setCuit("20355823866");
		
		/* Operacion */
		farmaciaDao.guardarFarmaciaNueva(farmaciaPrueba);
		Farmacia farmaciaBuscada = farmaciaDao.consultarFarmacia(farmaciaPrueba);
		
		/* Verifiacion */
		Farmacia farmaciaObtenida = sessionFactory.getCurrentSession().get(Farmacia.class, farmaciaBuscada.getId()); 
		Assert.assertTrue(farmaciaObtenida.getCuit().equals("20355823866"));
	}
	
	@Test
	public void TestQuePruebaFarmaciaCorrecta(){
		ControladorRegistroFarmacia farmaciaControlador = new ControladorRegistroFarmacia();
		ServicioFarmacia farmaFake=mock(ServicioFarmacia.class);
		farmaciaControlador.setServicioFarmacia(farmaFake);
		
		Farmacia miFarmacia=new Farmacia();
		Farmacia farmaciaObtenida=new Farmacia();
		when(farmaFake.logear(miFarmacia)).thenReturn(farmaciaObtenida);
		
		ModelAndView mav = farmaciaControlador.validarLoginFarmacia(miFarmacia);
		
		assertThat(mav.getViewName()).isEqualTo("home");
		
	}
}
