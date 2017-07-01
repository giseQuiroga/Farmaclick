package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegistroUsuario {
	
	Usuario buscarUsuario(Usuario Usuario);
	Usuario buscarUsuarioPorId(Integer idUsuario);
}