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
	public Boolean buscarUsuario (Usuario usuario) {				
		/*Valida que no sea un usuario repetido y lo registra*/
		Boolean resultadoRegistroUsuario = null;
		Usuario resultado = servicioUsuarioRegistroDao.buscarUsuario(usuario);
		
		if(resultado == null){
				servicioUsuarioRegistroDao.guardarUsuario(usuario);
				resultadoRegistroUsuario = false;
			}
			else{
				 resultadoRegistroUsuario = true;
				}
		return resultadoRegistroUsuario;
	}

	
}