package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contrato database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")})
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcontrato;

	@Temporal(TemporalType.DATE)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	//bi-directional one-to-one association to Condicionservicio
	@OneToOne(mappedBy="contrato")
	private Condicionservicio condicionservicio;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;

	public Contrato() {
	}

	public int getIdcontrato() {
		return this.idcontrato;
	}

	public void setIdcontrato(int idcontrato) {
		this.idcontrato = idcontrato;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Condicionservicio getCondicionservicio() {
		return this.condicionservicio;
	}

	public void setCondicionservicio(Condicionservicio condicionservicio) {
		this.condicionservicio = condicionservicio;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}