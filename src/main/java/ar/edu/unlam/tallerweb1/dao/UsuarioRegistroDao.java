package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioRegistroDao {

	Usuario buscarUsuario (Usuario usuario);
	void guardarUsuario (Usuario usuario);
	Usuario buscarUsuarioPorId(Integer idUsuario);
}
