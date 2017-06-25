package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ProductoDao;
import ar.edu.unlam.tallerweb1.modelo.Producto;

@Service("servicioProducto")
@Transactional
public class ServicioProductoImpl implements ServicioProducto {

	@Inject
	private ProductoDao productoDao;
	
	@Override
	public Boolean verificarProducto(Producto producto) {
		List<Producto> productosExistentes= new LinkedList<Producto>();
		Boolean existeProducto=true;
		
		Producto p1=new Producto();
		p1.setCodigo(1234);
		p1.setAccion("Accion1");
		p1.setLaboratorio("Lab1");
		p1.setNombre("Medicamento1");
		p1.setPrecio(12);
		productosExistentes.add(p1);
		
		Producto p2=new Producto();
		p2.setCodigo(1235);
		p2.setAccion("Accion1");
		p2.setLaboratorio("Lab1");
		p2.setNombre("Medicamento1");
		p2.setPrecio(12);
		productosExistentes.add(p2);
		
		for(Producto unProducto : productosExistentes){
			if (unProducto.getCodigo()==producto.getCodigo()){
				existeProducto=false;
				break;
			}
			
		}
		productoDao.guardarProducto(producto);
		return existeProducto;
	}


}
