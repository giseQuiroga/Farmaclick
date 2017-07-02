package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioRegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service ("servicioRegistroUsuario")
@Transactional

public class ServicioRegistroUsuarioImpl implements ServicioRegistroUsuario {

	@Inject
	private UsuarioRegistroDao servicioUsuarioRegistroDao;

	@Override
	public Usuario buscarUsuario (Usuario usuario) {	//registra usuario también			

		Usuario UsuarioObtenido = servicioUsuarioRegistroDao.buscarUsuario(usuario);
		
		if(UsuarioObtenido == null){
				servicioUsuarioRegistroDao.guardarUsuario(usuario);
				Usuario UsuarioObtenidoCompleto = servicioUsuarioRegistroDao.buscarUsuario(usuario);
				return UsuarioObtenidoCompleto;
			}
		return null;
	}
	
	public void setUsuarioDao (UsuarioRegistroDao usuarioRegistroDao){
		this.servicioUsuarioRegistroDao = usuarioRegistroDao;
	}

	public Usuario buscarUsuarioPorId(Integer idUsuario){
		Usuario UsuarioObtenido = servicioUsuarioRegistroDao.buscarUsuarioPorId(idUsuario);
		return UsuarioObtenido;
	}
}