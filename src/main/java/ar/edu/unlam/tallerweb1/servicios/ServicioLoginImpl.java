package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
/*import ar.edu.unlam.tallerweb1.dao.UsuarioDao;*/
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

/*	@Inject
	private UsuarioDao servicioLoginDao; */

	@Override		
	public Boolean consultarUsuario (Usuario usuario) {
/*	public Usuario consultarUsuario (Usuario usuario) { */	
		
		
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
		usuarioAIngresar5.setApellido("Castañer");
		usuarioAIngresar5.setEmail("castaner@gmail.com");
		usuarioAIngresar5.setPassword("castaner");		
		misRegistros.add(usuarioAIngresar5);
		
		
		/*FARMACIAS*/
		ArrayList <Farmacia> farmaciasRegistradas = new ArrayList<Farmacia>();
		
		Farmacia f1 = new Farmacia();
		f1.setCuit("20355823866");
		f1.setRazonSocial("ffff");
		f1.setTelefono(12345678);
		f1.setEmail("f1@gmail.com");
		f1.setPassword("farmacia1");		
		farmaciasRegistradas.add(f1);
		
		Farmacia f2 = new Farmacia();
		f2.setCuit("21355823866");
		f2.setRazonSocial("aaaa");
		f2.setTelefono(12345678);
		f2.setEmail("f2@gmail.com");
		f2.setPassword("farmacia2");		
		farmaciasRegistradas.add(f2);
		
		Boolean resultadoLogin = null;
		
		
		/* Busco si el usuario ya esta registrado */
		for (Usuario usuarioComparado : misRegistros) {
			if ((usuarioComparado.getEmail().equals(usuario.getEmail())) && (usuarioComparado.getPassword().equals(usuario.getPassword()))) {
				resultadoLogin = true;
		        return resultadoLogin;
		    }
			else{
				
				for (Farmacia farmaciaComparada : farmaciasRegistradas) {
					if ((farmaciaComparada.getEmail().equals(usuario.getEmail())) && (farmaciaComparada.getPassword().equals(usuario.getPassword()))) {
						resultadoLogin = true;
				        return resultadoLogin;
				    }
					else{
						/*Else de farmacia */
						}	
				}
				/*Else de usuario */
			}
			resultadoLogin = false;
		 }
		
		return resultadoLogin;
		
		/*return servicioLoginDao.consultarUsuario(usuario);*/
	}

}
