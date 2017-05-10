package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the usuarioweb database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarioweb.findAll", query="SELECT u FROM Usuarioweb u")
public class Usuarioweb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuarioweb;

	private byte activo;

	private String clave;

	private int creado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreado;

	private String nombreusuario;

	private int tipousuarioid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultacceso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultcamioclave;

	private String usuario;

	//bi-directional many-to-one association to Permisorol
	@OneToMany(mappedBy="usuarioweb")
	private Set<Permisorol> permisorols;

	//bi-directional many-to-one association to Usuarioperfil
	@OneToMany(mappedBy="usuarioweb")
	private Set<Usuarioperfil> usuarioperfils;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="usuarioperfil"
		, joinColumns={
			@JoinColumn(name="idusuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idperfil")
			}
		)
	private Set<Perfil> perfils1;

	//bi-directional many-to-many association to Perfil
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="usuarioperfil"
		, joinColumns={
			@JoinColumn(name="idusuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idperfil")
			}
		)
	private Set<Perfil> perfils2;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="permisorol"
		, joinColumns={
			@JoinColumn(name="idusuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idrol")
			}
		)
	private Set<Rol> rols1;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="permisorol"
		, joinColumns={
			@JoinColumn(name="idusuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idrol")
			}
		)
	private Set<Rol> rols2;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="idusuarioweb")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario2;

	public Usuarioweb() {
	}

	public int getIdusuarioweb() {
		return this.idusuarioweb;
	}

	public void setIdusuarioweb(int idusuarioweb) {
		this.idusuarioweb = idusuarioweb;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getCreado() {
		return this.creado;
	}

	public void setCreado(int creado) {
		this.creado = creado;
	}

	public Date getFechacreado() {
		return this.fechacreado;
	}

	public void setFechacreado(Date fechacreado) {
		this.fechacreado = fechacreado;
	}

	public String getNombreusuario() {
		return this.nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public int getTipousuarioid() {
		return this.tipousuarioid;
	}

	public void setTipousuarioid(int tipousuarioid) {
		this.tipousuarioid = tipousuarioid;
	}

	public Date getUltacceso() {
		return this.ultacceso;
	}

	public void setUltacceso(Date ultacceso) {
		this.ultacceso = ultacceso;
	}

	public Date getUltcamioclave() {
		return this.ultcamioclave;
	}

	public void setUltcamioclave(Date ultcamioclave) {
		this.ultcamioclave = ultcamioclave;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Set<Permisorol> getPermisorols() {
		return this.permisorols;
	}

	public void setPermisorols(Set<Permisorol> permisorols) {
		this.permisorols = permisorols;
	}

	public Permisorol addPermisorol(Permisorol permisorol) {
		getPermisorols().add(permisorol);
		permisorol.setUsuarioweb(this);

		return permisorol;
	}

	public Permisorol removePermisorol(Permisorol permisorol) {
		getPermisorols().remove(permisorol);
		permisorol.setUsuarioweb(null);

		return permisorol;
	}

	public Set<Usuarioperfil> getUsuarioperfils() {
		return this.usuarioperfils;
	}

	public void setUsuarioperfils(Set<Usuarioperfil> usuarioperfils) {
		this.usuarioperfils = usuarioperfils;
	}

	public Usuarioperfil addUsuarioperfil(Usuarioperfil usuarioperfil) {
		getUsuarioperfils().add(usuarioperfil);
		usuarioperfil.setUsuarioweb(this);

		return usuarioperfil;
	}

	public Usuarioperfil removeUsuarioperfil(Usuarioperfil usuarioperfil) {
		getUsuarioperfils().remove(usuarioperfil);
		usuarioperfil.setUsuarioweb(null);

		return usuarioperfil;
	}

	public Set<Perfil> getPerfils1() {
		return this.perfils1;
	}

	public void setPerfils1(Set<Perfil> perfils1) {
		this.perfils1 = perfils1;
	}

	public Set<Perfil> getPerfils2() {
		return this.perfils2;
	}

	public void setPerfils2(Set<Perfil> perfils2) {
		this.perfils2 = perfils2;
	}

	public Set<Rol> getRols1() {
		return this.rols1;
	}

	public void setRols1(Set<Rol> rols1) {
		this.rols1 = rols1;
	}

	public Set<Rol> getRols2() {
		return this.rols2;
	}

	public void setRols2(Set<Rol> rols2) {
		this.rols2 = rols2;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}