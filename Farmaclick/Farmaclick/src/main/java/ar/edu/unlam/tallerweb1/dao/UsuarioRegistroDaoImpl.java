package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("registroUsuarioDao")
public class UsuarioRegistroDaoImpl implements UsuarioRegistroDao {
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario buscarUsuario(Usuario usuario) {

		final Session session = sessionFactory.openSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult();
	}

	
}
