package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Producto;;

@Service("productoDao")
public class ProductoDaoImpl implements ProductoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Producto validarProducto(Producto producto) {

		final Session session = sessionFactory.openSession();
		return (Producto) session.createCriteria(Producto.class)
				.add(Restrictions.eq("nombre", producto.getNombre()))
				.add(Restrictions.eq("codigo", producto.getCodigo()))
				.add(Restrictions.eq("laboratorio", producto.getLaboratorio()))
				.add(Restrictions.eq("accion", producto.getAccion()))
				.add(Restrictions.eq("farmacia", producto.getFarmacia()))
				.add(Restrictions.eq("precio", producto.getPrecio()))
				.uniqueResult();
	}
}
