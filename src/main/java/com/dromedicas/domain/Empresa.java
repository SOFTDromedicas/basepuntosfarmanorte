package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")})
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idempresa;

	private String direccion;

	private String email;

	@Column(name="email_notificaciones")
	private String emailNotificaciones;

	private String nit;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	private String telefono;

	//bi-directional many-to-one association to Afiliado
	@OneToMany(mappedBy="empresa", cascade={CascadeType.ALL})
	private Set<Afiliado> afiliados;

	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="empresa")
	private Set<Contrato> contratos;

	//bi-directional many-to-one association to Sucursal
	@OneToMany(mappedBy="empresa")
	private Set<Sucursal> sucursals;

	//bi-directional many-to-one association to Vendedor
	@OneToMany(mappedBy="empresa")
	private Set<Vendedor> vendedors;

	public Empresa() {
	}

	public int getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
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

	public String getEmailNotificaciones() {
		return this.emailNotificaciones;
	}

	public void setEmailNotificaciones(String emailNotificaciones) {
		this.emailNotificaciones = emailNotificaciones;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Afiliado> getAfiliados() {
		return this.afiliados;
	}

	public void setAfiliados(Set<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}

	public Afiliado addAfiliado(Afiliado afiliado) {
		getAfiliados().add(afiliado);
		afiliado.setEmpresa(this);

		return afiliado;
	}

	public Afiliado removeAfiliado(Afiliado afiliado) {
		getAfiliados().remove(afiliado);
		afiliado.setEmpresa(null);

		return afiliado;
	}

	public Set<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setEmpresa(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setEmpresa(null);

		return contrato;
	}

	public Set<Sucursal> getSucursals() {
		return this.sucursals;
	}

	public void setSucursals(Set<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	public Sucursal addSucursal(Sucursal sucursal) {
		getSucursals().add(sucursal);
		sucursal.setEmpresa(this);

		return sucursal;
	}

	public Sucursal removeSucursal(Sucursal sucursal) {
		getSucursals().remove(sucursal);
		sucursal.setEmpresa(null);

		return sucursal;
	}

	public Set<Vendedor> getVendedors() {
		return this.vendedors;
	}

	public void setVendedors(Set<Vendedor> vendedors) {
		this.vendedors = vendedors;
	}

	public Vendedor addVendedor(Vendedor vendedor) {
		getVendedors().add(vendedor);
		vendedor.setEmpresa(this);

		return vendedor;
	}

	public Vendedor removeVendedor(Vendedor vendedor) {
		getVendedors().remove(vendedor);
		vendedor.setEmpresa(null);

		return vendedor;
	}

}