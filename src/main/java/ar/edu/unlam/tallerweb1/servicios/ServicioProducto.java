package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface ServicioProducto {

	Boolean verificarProducto(Producto producto, Integer idFarmacia);
	List<Producto> obtenerProductos();
}
