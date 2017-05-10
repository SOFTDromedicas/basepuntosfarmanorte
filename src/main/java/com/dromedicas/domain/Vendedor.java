package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Vendedor.findAll", query="SELECT v FROM Vendedor v")})
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String docuvendedor;

	private byte actvo;

	private String apellidos;

	private String nombres;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;

	public Vendedor() {
	}

	public String getDocuvendedor() {
		return this.docuvendedor;
	}

	public void setDocuvendedor(String docuvendedor) {
		this.docuvendedor = docuvendedor;
	}

	public byte getActvo() {
		return this.actvo;
	}

	public void setActvo(byte actvo) {
		this.actvo = actvo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}