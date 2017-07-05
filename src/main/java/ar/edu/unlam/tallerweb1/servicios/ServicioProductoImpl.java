package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FarmaciaDao;
import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
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
	
	public void guardarProductoEditado(Producto producto){
		productoDao.guardarProducto(producto);
	}

	public List<Producto> obtenerProductos(){
		List<Producto>productos=productoDao.obtenerProductos();
		return productos;
	}
	
	public Producto buscarProductoPorId(long idProd){
		Producto producto=productoDao.buscarProductoPorId(idProd);
		return producto;				
	}
	
	public void guardarCompra(Pedido pedido, Producto producto){
		
		productoDao.guardarCompra(pedido, producto);
	}
	
	public List<Pedido>obtenerPedidosPorUsuario(Integer idUsuario){
		List<Pedido> pedidos=productoDao.obtenerPedidosPorUsuario(idUsuario);
		return pedidos;
	}
	
	public List<Producto> obtenerProductosPorFarmacia(Integer idFarmacia){
		List<Producto>productos=productoDao.obtenerProductosPorFarmacia(idFarmacia);
		return productos;
	}
	
	public List<Producto> obtenerProductosSinStock(Integer idFarmacia){
		List<Producto> productos= productoDao.obtenerProductosSinStock(idFarmacia);
		return productos;
	}
	
	public void ocultarProducto(long idProducto){
		productoDao.ocultarProducto(idProducto);
		
	}
	
	public Producto buscarProductoPorCodigo(int codigo){
		Producto producto=productoDao.buscarProductoPorCodigo(codigo);
		return producto;				
	}
}
