package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipousuario database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Tipousuario.findAll", query="SELECT t FROM Tipousuario t")})
public class Tipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipousuario;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipousuario")
	private Set<Usuario> usuarios;

	public Tipousuario() {
	}

	public int getIdtipousuario() {
		return this.idtipousuario;
	}

	public void setIdtipousuario(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipousuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipousuario(null);

		return usuario;
	}

}