package ar.edu.unlam.tallerweb1;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Producto;

import static org.assertj.core.api.Assertions.*;

public class ProductoTest extends SpringTest {

	@Test @Transactional @Rollback(true)
	public void testCrearProducto(){
		Farmacia farmaciaPrueba = new Farmacia();
		farmaciaPrueba.setRazonSocial("RSfarmaciaPrueba");
		getSession().save(farmaciaPrueba);
		
		Producto p = new Producto();
		p.setNombre("buscapina");
		p.setFarmacia(farmaciaPrueba);
		
		// ejecucion
		getSession().save(p);
		
		Producto productoBuscado = getSession().get(Producto.class, p.getId());
		assertThat(productoBuscado.getFarmacia()).isNotNull();
		assertThat(productoBuscado.getFarmacia().getRazonSocial()).isEqualTo(farmaciaPrueba.getRazonSocial());
	}
	
	
}
