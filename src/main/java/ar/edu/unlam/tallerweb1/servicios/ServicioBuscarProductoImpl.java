package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Producto;


@Service("servicioBuscarProducto")
@Transactional
public class ServicioBuscarProductoImpl implements ServicioBuscarProducto 
	{
	public List<Producto> filtrarProducto(List<Producto> listaProductos, String artNombre)
		{	
		List<Producto> productosFiltrados = new LinkedList<Producto>();
	
		for(Producto cadaProducto:listaProductos)
			{
			if(cadaProducto.getNombre().equals(artNombre))
				{
				productosFiltrados.add(cadaProducto);
				}
			}
		
		return productosFiltrados;	
		}		
	}
