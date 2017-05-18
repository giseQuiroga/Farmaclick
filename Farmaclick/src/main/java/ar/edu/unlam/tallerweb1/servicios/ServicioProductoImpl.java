package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Producto;

@Service("servicioProducto")
@Transactional
public class ServicioProductoImpl implements ServicioProducto {

	@Inject
	private ProductoDao servicioProductoDao;
	
	@Override
	public Producto verificarProducto(Producto producto) {
		
		return servicioProductoDao.validarProducto(producto);
	}


}
