package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface ServicioProducto {

	Boolean verificarProducto(Producto producto, Integer idFarmacia);
	List<Producto> obtenerProductos();
	Producto buscarProductoPorId(long idProd);
	void guardarCompra(Pedido pedido);
	List<Pedido>obtenerPedidosPorUsuario(Integer idUsuario);
}
