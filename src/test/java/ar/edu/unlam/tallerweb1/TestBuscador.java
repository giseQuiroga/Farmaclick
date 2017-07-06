package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.modelo.Producto;

public class TestBuscador extends SpringTest
	{/*
	@Inject
	private ProductoDao ProductoDao;
	
	@Test 
	@Transactional
	@Rollback(true)
	public void buscarProducto()
		{
		//Preparacion
		String productoBuscado;
		productoBuscado="Curaplus";
		
		//Operacion
		List<Producto> productoObtenido = ProductoDao.buscarProducto(productoBuscado);
		
		//Verificacion
		//assertThat(productoObtenido).isNotNull();
		assertThat(productoObtenido.equals(productoBuscado));
		}
		
		*/
	
	}