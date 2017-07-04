package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;

@Service("productoDao")
public class ProductoDaoImpl implements ProductoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Producto validarProducto(Producto producto) {

		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class)
				.add(Restrictions.eq("nombre", producto.getNombre()))
				.add(Restrictions.eq("codigo", producto.getCodigo()))
				.add(Restrictions.eq("laboratorio", producto.getLaboratorio()))
				.add(Restrictions.eq("accion", producto.getAccion()))
				.add(Restrictions.eq("farmacia", producto.getFarmacia()))
				.add(Restrictions.eq("precio", producto.getPrecio()))
				.uniqueResult();
	}
	
	public void guardarProducto(Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		session.save(producto);
	}
	
	public List<Producto> obtenerProductos(){
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>)session.createCriteria(Producto.class)
		.add(Restrictions.not(Restrictions.eq("stock", 0))).list();
		return productos;
	}

	@Override
	public List<Producto> buscarProducto(String artNombre) 
		{
		final Session session = sessionFactory.getCurrentSession();
		//return session.getCurrentSession().createCriteria(Producto.class)
		//return session.createCriteria(Producto.class).add(Restrictions.eq("nombre",artNombre)).list();
		@SuppressWarnings("unchecked")
		List<Producto> ListaP = (List<Producto>)session.createCriteria(Producto.class)
								.add(Restrictions.eq("nombre",artNombre))
								.add(Restrictions.not(Restrictions.eq("stock", 0)))
								.list(); 
		return ListaP;
		}
	
	public Producto buscarProductoPorId(long idProd){
		final Session session = sessionFactory.getCurrentSession();
		Producto producto = (Producto)session.createCriteria(Producto.class)
								.add(Restrictions.eq("id",idProd)).uniqueResult();
		return producto;
	}
	
	public void guardarCompra(Pedido pedido, Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		session.save(pedido);
		session.update(producto);
	}
	
	public List<Pedido>obtenerPedidosPorUsuario(Integer idUsuario){
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidosRealizados=(List<Pedido>)session.createCriteria(Pedido.class)
				.add(Restrictions.eq("usuario.id",idUsuario))
				.list(); 
		return pedidosRealizados;
	}
	
	public	List<Producto> obtenerProductosPorFarmacia(Integer idFarmacia){
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>)session.createCriteria(Producto.class)
								.add(Restrictions.eq("farmacia.id",idFarmacia))
								.list();
		return productos;
	}

	public List<Producto> obtenerProductosSinStock(Integer idFarmacia){
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>)session.createCriteria(Producto.class)
		.add(Restrictions.eq("stock", 0))
		.add(Restrictions.eq("farmacia.id", idFarmacia))
		.list();
		return productos;
	}
}
