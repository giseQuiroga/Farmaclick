package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Service("FarmaciaDao")
public class FarmaciaDaoImpl implements FarmaciaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void guardarFarmaciaNueva(Farmacia farmacia) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(farmacia);
	}
}
