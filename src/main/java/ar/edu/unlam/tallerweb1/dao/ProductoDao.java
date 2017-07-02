package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;;

public interface ProductoDao {

	Producto validarProducto (Producto producto);
	
	void guardarProducto(Producto producto);
	
	List<Producto> obtenerProductos();

	List<Producto> buscarProducto(String artNombre);
	
	Producto buscarProducto(long idProd);
}
