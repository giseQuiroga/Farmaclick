package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Producto;

@Service("servicioProducto")
@Transactional
public class ServicioProductoImpl implements ServicioProducto {

	@Inject
	private ProductoDao productoDao;
	@Inject
	private FarmaciaDao farmaciaDao;
	
	@Override
	public Boolean verificarProducto(Producto producto, Integer idFarmacia) {
		List<Producto> productosExistentes= new LinkedList<Producto>();
		Boolean existeProducto=true;
		
		
		
		for(Producto unProducto : productosExistentes){
			if (unProducto.getCodigo()==producto.getCodigo()){
				existeProducto=false;
				break;
			}
			
		}
		Farmacia farmaciaID = farmaciaDao.consultarFarmaciaPorId(idFarmacia);
		producto.setFarmacia(farmaciaID);
		
		productoDao.guardarProducto(producto);
		return existeProducto;
	}

	public List<Producto> obtenerProductos(){
		List<Producto>productos=productoDao.obtenerProductos();
		return productos;
	}
	
	public Producto buscarProducto(long idProd){
		Producto producto=productoDao.buscarProducto(idProd);
		return producto;				
	}
}
