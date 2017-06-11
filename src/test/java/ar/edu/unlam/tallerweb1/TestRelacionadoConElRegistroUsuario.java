package ar.edu.unlam.tallerweb1;


import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioRegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class TestRelacionadoConElRegistroUsuario extends SpringTest {

	@Inject
	private UsuarioRegistroDao usuarioRegistroDao;

/*TEST REGISTRA USUARIO*/	
	@Test
	@Transactional @Rollback(false)
	public void PruebaRegistrarUnUsuario() {
		
/* 1) Preparacion - Preparo un usuario --------------------------------------------------------------------------------------- */
		Usuario usuarioRegistroTestAInsertar = new Usuario();
		usuarioRegistroTestAInsertar.setNombre("Rocío");
		usuarioRegistroTestAInsertar.setApellido("Bareiro");
		usuarioRegistroTestAInsertar.setEmail("bareiro@gmail.com");
		usuarioRegistroTestAInsertar.setPassword("bareiro");
		
/* 2) Operacion - Registro al usuario ----------------------------------------------------------------------------------------- */
		usuarioRegistroDao.guardarUsuario(usuarioRegistroTestAInsertar);
		
/* 3) Verifiacion - Usuario registrado es igual al usuario que quiero buscar por medio del email ------------------------------ */
		Usuario usuarioObtenido = sessionFactory.getCurrentSession().get(Usuario.class, usuarioRegistroTestAInsertar.getId());
		Assert.assertTrue(usuarioObtenido.getEmail().equals("bareiro@gmail.com"));
	}
	
	
/*TEST BUSCA USUARIO*/	
	@Test
	@Transactional @Rollback(false)
	public void PruebaBuscarUnRegistroDeUsuario(){
		
/* 1) Preparacion - Ingreso varios usuarios y repito el ultimo -----------------------------------------------------------------*/
		Usuario usuarioRegistroTestABuscar1 = new Usuario();
		usuarioRegistroTestABuscar1.setNombre("Rocío");
		usuarioRegistroTestABuscar1.setApellido("Castañer");
		usuarioRegistroTestABuscar1.setEmail("castaner@gmail.com");
		usuarioRegistroTestABuscar1.setPassword("castaner");
		
		Usuario usuarioRegistroTestABuscar2 = new Usuario();
		usuarioRegistroTestABuscar2.setNombre("Gisela");
		usuarioRegistroTestABuscar2.setApellido("Quiroga");
		usuarioRegistroTestABuscar2.setEmail("quiroga@gmail.com");
		usuarioRegistroTestABuscar2.setPassword("quiroga");
		
		Usuario usuarioRegistroTestABuscar3 = new Usuario();
		usuarioRegistroTestABuscar3.setNombre("Pablo");
		usuarioRegistroTestABuscar3.setApellido("Garcia");
		usuarioRegistroTestABuscar3.setEmail("garcia@gmail.com");
		usuarioRegistroTestABuscar3.setPassword("garcia");
		
/*Nota al margen: Ingresa repetidos, ver esto.*/
		Usuario usuarioRegistroTestABuscar4 = new Usuario();
		usuarioRegistroTestABuscar4.setNombre("Pablo");
		usuarioRegistroTestABuscar4.setApellido("Garcia");
		usuarioRegistroTestABuscar4.setEmail("garcia@gmail.com");
		usuarioRegistroTestABuscar4.setPassword("garcia");
		
		Usuario usuarioRegistroTestABuscar5 = new Usuario();
		usuarioRegistroTestABuscar5.setNombre("Matias");
		usuarioRegistroTestABuscar5.setApellido("Martinez");
		usuarioRegistroTestABuscar5.setEmail("martinez@gmail.com");
		usuarioRegistroTestABuscar5.setPassword("martinez");		

/* 2) Operacion - Busco el usuario que quiero --------------------------------------------------------------------------------------- */
		/*Guardo los usuarios*/
		usuarioRegistroDao.guardarUsuario(usuarioRegistroTestABuscar1);
		usuarioRegistroDao.guardarUsuario(usuarioRegistroTestABuscar2);
		usuarioRegistroDao.guardarUsuario(usuarioRegistroTestABuscar3);
		usuarioRegistroDao.guardarUsuario(usuarioRegistroTestABuscar4);
		usuarioRegistroDao.guardarUsuario(usuarioRegistroTestABuscar5);
		
		/*busco el usuario que quiero*/
		Usuario miUsuarioBuscado = usuarioRegistroDao.buscarUsuario(usuarioRegistroTestABuscar5);
		
/* 3) Verificacion - El usuario con el email X se encuentra en la tabla ------------------------------------------------------------- */
		Usuario usuarioObtenido = sessionFactory.getCurrentSession().get(Usuario.class, miUsuarioBuscado.getId()); 
		Assert.assertTrue(usuarioObtenido.getEmail().equals("martinez@gmail.com"));

	}
	
}
