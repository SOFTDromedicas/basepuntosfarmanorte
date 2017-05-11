package com.dromedicas.eis;

import java.util.List;

import com.dromedicas.domain.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> findAllUsuarios();

	public Usuario obtenerUsuarioById(Usuario instance);

	public void insertUsuario(Usuario instance);

	public void updateUsuario(Usuario instance);

	public void deleteUsuario(Usuario instance);

}
