package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioRegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service ("servicioRegistroUsuario")
@Transactional

public class ServicioRegistroUsuarioImpl implements ServicioRegistroUsuario {

	@Inject
	private UsuarioRegistroDao servicioUsuarioRegistroDao;

	@Override
	public Usuario buscarUsuario (Usuario usuario) {
		return servicioUsuarioRegistroDao.buscarUsuario(usuario);
	}
}
