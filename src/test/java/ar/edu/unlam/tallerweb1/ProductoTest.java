package ar.edu.unlam.tallerweb1;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Producto;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
//import static org.hamcrest.*;
import javax.inject.Inject;

public class ProductoTest extends SpringTest {

	@Inject
	public ProductoDao productoDao;
	
	/*@Test @Transactional @Rollback(true)
	public void testObtenerProductos(){
		Producto producto1 = new Producto();
		producto1.setNombre("prueba1");
		Producto producto2 = new Producto();
		producto1.setNombre("prueba2");
		
		productoDao.guardarProducto(producto1);
		productoDao.guardarProducto(producto2);
		
		List<Producto> listaProductos = (List<Producto>) sessionFactory.getCurrentSession().get(Producto.class, producto1.getId());
		 assertThat(listaProductos, containsInAnyOrder(producto1, producto2));
	}*/
	
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
