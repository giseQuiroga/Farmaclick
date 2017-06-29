package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.dao.ProductoDao;

@Service("servicioBuscarProducto")
@Transactional
public class ServicioBuscarProductoImpl implements ServicioBuscarProducto 
	{
	@Inject 
	private ProductoDao ProductoDao;
	
	@Override
	public List<Producto> buscarProductos(String artNombre) 
		{
		// TODO Auto-generated method stub
		return ProductoDao.buscarProducto(artNombre);
		}
	
	}
