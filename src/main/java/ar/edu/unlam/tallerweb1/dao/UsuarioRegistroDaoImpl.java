package ar.edu.unlam.tallerweb1.dao;



import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("usuarioRegistroDao")
public class UsuarioRegistroDaoImpl implements UsuarioRegistroDao {
	@Inject
    private SessionFactory sessionFactory;
	
	/*Para buscar usuario OPCION 2*/
	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult();
	}

	/*Para registrar el usuario*/
	@Override
	public void guardarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}
	
}
