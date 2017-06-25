package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	@Inject
	private UsuarioDao servicioLoginDao; 

	@Override		
	public Usuario logearUsuario (Usuario usuario) {
		
		Usuario usuarioObtenido = servicioLoginDao.consultaUsuario(usuario);

		if(usuarioObtenido != null){
			return usuarioObtenido;
			}
		return null;
	}
}
