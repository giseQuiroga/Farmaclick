package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

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
		
		/* Hardcodeo llenando datos en un array, simula la gente ya registrada */
		ArrayList <Usuario> misRegistros = new ArrayList<Usuario>();
		
		/* Agrego 5 usuarios para poder comparar con algo*/
		Usuario usuarioAIngresar1 = new Usuario();
		usuarioAIngresar1.setId(1);
		usuarioAIngresar1.setNombre("Rocio");
		usuarioAIngresar1.setApellido("Bareiro");
		usuarioAIngresar1.setEmail("bareiro@gmail.com");
		usuarioAIngresar1.setPassword("bareiro");		
		misRegistros.add(usuarioAIngresar1);
		
		Usuario usuarioAIngresar2 = new Usuario();
		usuarioAIngresar2.setId(2);
		usuarioAIngresar2.setNombre("Gisela");
		usuarioAIngresar2.setApellido("Quiroga");
		usuarioAIngresar2.setEmail("quiroga@gmail.com");
		usuarioAIngresar2.setPassword("quiroga");		
		misRegistros.add(usuarioAIngresar2);
		
		Usuario usuarioAIngresar3 = new Usuario();
		usuarioAIngresar3.setId(3);
		usuarioAIngresar3.setNombre("Pablo");
		usuarioAIngresar3.setApellido("Garcia");
		usuarioAIngresar3.setEmail("garcia@gmail.com");
		usuarioAIngresar3.setPassword("garcia");		
		misRegistros.add(usuarioAIngresar3);
		
		Usuario usuarioAIngresar4 = new Usuario();
		usuarioAIngresar4.setId(4);
		usuarioAIngresar4.setNombre("Matias");
		usuarioAIngresar4.setApellido("Martinez");
		usuarioAIngresar4.setEmail("martinez@gmail.com");
		usuarioAIngresar4.setPassword("martinez");		
		misRegistros.add(usuarioAIngresar4);
		
		Usuario usuarioAIngresar5 = new Usuario();
		usuarioAIngresar5.setId(1);
		usuarioAIngresar5.setNombre("Rocio");
		usuarioAIngresar5.setApellido("Casta�er");
		usuarioAIngresar5.setEmail("casta�er@gmail.com");
		usuarioAIngresar5.setPassword("casta�er");		
		misRegistros.add(usuarioAIngresar5);
		
		Boolean resultadoRegistroUsuario = null;
		
		
		/* Busco si el usuario ya esta registrado */
		for (Usuario usuarioComparado : misRegistros) {
			if (usuarioComparado.getEmail().equals(usuario.getEmail())) {
				resultadoRegistroUsuario = false;
		        return resultadoRegistroUsuario;
		    }
			else{
				/* Comparo a ver si mi usuario esta en la lista */
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setNombre(usuario.getNombre());
				nuevoUsuario.setApellido(usuario.getApellido());
				nuevoUsuario.setEmail(usuario.getEmail());
				nuevoUsuario.setPassword(usuario.getPassword());
				
				misRegistros.add(nuevoUsuario);
				
				return resultadoRegistroUsuario = true;
			}
		 }
		
		return resultadoRegistroUsuario;
	}	
	
}
