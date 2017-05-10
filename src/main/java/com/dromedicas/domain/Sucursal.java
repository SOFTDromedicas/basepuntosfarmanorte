package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")})
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsucursal;

	private String apikey;

	private String codigointerno;

	private String direccion;

	private String email;

	@Column(name="nombre_sucursal")
	private String nombreSucursal;

	//bi-directional many-to-one association to Audiwebservice
	@OneToMany(mappedBy="sucursal")
	private Set<Audiwebservice> audiwebservices;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="sucursal")
	private Set<Transaccion> transaccions;

	public Sucursal() {
	}

	public int getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getApikey() {
		return this.apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getCodigointerno() {
		return this.codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreSucursal() {
		return this.nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public Set<Audiwebservice> getAudiwebservices() {
		return this.audiwebservices;
	}

	public void setAudiwebservices(Set<Audiwebservice> audiwebservices) {
		this.audiwebservices = audiwebservices;
	}

	public Audiwebservice addAudiwebservice(Audiwebservice audiwebservice) {
		getAudiwebservices().add(audiwebservice);
		audiwebservice.setSucursal(this);

		return audiwebservice;
	}

	public Audiwebservice removeAudiwebservice(Audiwebservice audiwebservice) {
		getAudiwebservices().remove(audiwebservice);
		audiwebservice.setSucursal(null);

		return audiwebservice;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setSucursal(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setSucursal(null);

		return transaccion;
	}

}