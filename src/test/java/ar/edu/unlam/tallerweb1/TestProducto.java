package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.modelo.Producto;;

public class TestProducto extends SpringTest {
	@Inject
	private ProductoDao productoDao;
	
	@Test
	@Transactional @Rollback(true)
	public void TestCrearNuevoProducto() {
		/* Preparacion */
		//long codigo=(long)12345;
		Producto productoPrueba = new Producto();
		productoPrueba.setCodigo(123452);
		
		/* Operacion */
		productoDao.guardarProducto(productoPrueba);
		
		/* Verifiacion */
		Producto productoObtenido = sessionFactory.getCurrentSession().get(Producto.class, productoPrueba.getCodigo());
		Assert.assertTrue(productoObtenido.getCodigo()==123452);
	}

}
