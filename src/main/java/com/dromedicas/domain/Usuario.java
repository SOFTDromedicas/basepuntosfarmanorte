package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuario;

	private String descripcion;

	//bi-directional many-to-one association to Afiliado
	@OneToMany(mappedBy="usuario")
	private Set<Afiliado> afiliados;

	//bi-directional many-to-one association to Sucursal
	@OneToMany(mappedBy="usuario")
	private Set<Sucursal> sucursals;

	//bi-directional many-to-one association to Tipousuario
	@ManyToOne
	@JoinColumn(name="idtipousuario")
	private Tipousuario tipousuario;

	//bi-directional one-to-one association to Usuarioweb
	@OneToOne(mappedBy="usuario1")
	private Usuarioweb usuarioweb;

	//bi-directional many-to-one association to Usuarioweb
	@OneToMany(mappedBy="usuario2")
	private Set<Usuarioweb> usuariowebs;

	public Usuario() {
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Afiliado> getAfiliados() {
		return this.afiliados;
	}

	public void setAfiliados(Set<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}

	public Afiliado addAfiliado(Afiliado afiliado) {
		getAfiliados().add(afiliado);
		afiliado.setUsuario(this);

		return afiliado;
	}

	public Afiliado removeAfiliado(Afiliado afiliado) {
		getAfiliados().remove(afiliado);
		afiliado.setUsuario(null);

		return afiliado;
	}

	public Set<Sucursal> getSucursals() {
		return this.sucursals;
	}

	public void setSucursals(Set<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	public Sucursal addSucursal(Sucursal sucursal) {
		getSucursals().add(sucursal);
		sucursal.setUsuario(this);

		return sucursal;
	}

	public Sucursal removeSucursal(Sucursal sucursal) {
		getSucursals().remove(sucursal);
		sucursal.setUsuario(null);

		return sucursal;
	}

	public Tipousuario getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Tipousuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public Usuarioweb getUsuarioweb() {
		return this.usuarioweb;
	}

	public void setUsuarioweb(Usuarioweb usuarioweb) {
		this.usuarioweb = usuarioweb;
	}

	public Set<Usuarioweb> getUsuariowebs() {
		return this.usuariowebs;
	}

	public void setUsuariowebs(Set<Usuarioweb> usuariowebs) {
		this.usuariowebs = usuariowebs;
	}

	public Usuarioweb addUsuarioweb(Usuarioweb usuarioweb) {
		getUsuariowebs().add(usuarioweb);
		usuarioweb.setUsuario2(this);

		return usuarioweb;
	}

	public Usuarioweb removeUsuarioweb(Usuarioweb usuarioweb) {
		getUsuariowebs().remove(usuarioweb);
		usuarioweb.setUsuario2(null);

		return usuarioweb;
	}

}