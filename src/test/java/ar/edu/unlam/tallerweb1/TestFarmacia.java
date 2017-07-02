package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;
import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.*;

import java.io.IOException;

import ar.edu.unlam.tallerweb1.controladores.ControladorRegistroFarmacia;
import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.servicios.ServicioFarmacia;

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
		Farmacia farmaciaPrueba = new Farmacia();
		farmaciaPrueba.setCuit("20355823866");
			
		farmaciaDao.guardarFarmaciaNueva(farmaciaPrueba);
		Farmacia farmaciaBuscada = farmaciaDao.consultarFarmacia(farmaciaPrueba);
		
		Farmacia farmaciaObtenida = sessionFactory.getCurrentSession().get(Farmacia.class, farmaciaBuscada.getId()); 
		Assert.assertTrue(farmaciaObtenida.getCuit().equals(farmaciaBuscada.getCuit()));
	}
	
	@Test
	@Transactional @Rollback(true)
	public void PruebaConsultarFarmaciaPorId(){		
		Farmacia farmaciaPrueba = new Farmacia();
		
		farmaciaDao.guardarFarmaciaNueva(farmaciaPrueba);
		Farmacia farmaciaBuscada = farmaciaDao.consultarFarmaciaPorId(1);
		
		Farmacia farmaciaObtenida = sessionFactory.getCurrentSession().get(Farmacia.class, farmaciaBuscada.getId());
		Assert.assertTrue(farmaciaObtenida.getId().equals(farmaciaBuscada.getId()));
	}
	
	@Test
	public void TestQuePruebaFarmaciaCorrecta(){
		ControladorRegistroFarmacia farmaciaControlador = new ControladorRegistroFarmacia();
		ServicioFarmacia farmaFake = mock(ServicioFarmacia.class);
		farmaciaControlador.setServicioFarmacia(farmaFake);
		
		Farmacia miFarmacia = new Farmacia();
		Farmacia farmaciaObtenida = new Farmacia();
		when(farmaFake.logear(miFarmacia)).thenReturn(farmaciaObtenida);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		ModelAndView mav = farmaciaControlador.validarLoginFarmacia(request, response, miFarmacia);
		
		Assert.assertEquals("home", mav.getViewName());	
	}
	
	@Test
	public void TestQuePruebaElRegistroDeFarmacia() throws ServletException, IOException{
		ControladorRegistroFarmacia farmaciaControlador = new ControladorRegistroFarmacia();
		ServicioFarmacia farmaFake = mock(ServicioFarmacia.class);
		farmaciaControlador.setServicioFarmacia(farmaFake);
		
		Farmacia miFarmacia = new Farmacia();
		Farmacia farmaciaObtenida = new Farmacia();
		when(farmaFake.ingresarFarmaciaNueva(miFarmacia)).thenReturn(farmaciaObtenida);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		ModelAndView mav = farmaciaControlador.validarRegistroFarmacia(request, response, miFarmacia);
		Assert.assertEquals("home", mav.getViewName());
	}
}
