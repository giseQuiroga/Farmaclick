package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;;

public interface ProductoDao {

	Producto validarProducto (Producto producto);
	void guardarProducto(Producto producto);
	List<Producto> obtenerProductos();
	//Buscar producto por nombre.
	List<Producto> buscarProducto(String artNombre);
}
