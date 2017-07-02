package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Service("FarmaciaDao")
public class FarmaciaDaoImpl implements FarmaciaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void guardarFarmaciaNueva(Farmacia farmacia) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(farmacia);
	}

	@Override
	public Farmacia consultarFarmacia(Farmacia farmacia) {

		final Session session = sessionFactory.getCurrentSession();
		return (Farmacia) session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("cuit", farmacia.getCuit()))
				.uniqueResult();
	}
	
	@Override
	public Farmacia consultarFarmaciaPorId(Integer idFarmacia) {

		final Session session = sessionFactory.getCurrentSession();
		return (Farmacia) session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("id", idFarmacia))
				.uniqueResult();
	}
	
	@Override
	public List<Pedido>obtenerPedidosPorFarmacia(Integer idFarmacia){
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidosRealizados=(List<Pedido>)session.createCriteria(Pedido.class)
				.createAlias("producto.farmacia", "farmacia")
				.add(Restrictions.eq("farmacia.id",idFarmacia))
				.list(); 
		return pedidosRealizados;
	}
}
