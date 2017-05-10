package com.dromedicas.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the condicionservicio database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name="Condicionservicio.findAll", query="SELECT c FROM Condicionservicio c")})
public class Condicionservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcondicioneservicio;

	private int basegravable;

	private byte envioemail;

	private byte enviosms;

	private int factorpuntos;

	private byte redensionsucursales;

	//bi-directional one-to-one association to Contrato
	@OneToOne
	@JoinColumn(name="idcontrato")
	private Contrato contrato;

	public Condicionservicio() {
	}

	public int getIdcondicioneservicio() {
		return this.idcondicioneservicio;
	}

	public void setIdcondicioneservicio(int idcondicioneservicio) {
		this.idcondicioneservicio = idcondicioneservicio;
	}

	public int getBasegravable() {
		return this.basegravable;
	}

	public void setBasegravable(int basegravable) {
		this.basegravable = basegravable;
	}

	public byte getEnvioemail() {
		return this.envioemail;
	}

	public void setEnvioemail(byte envioemail) {
		this.envioemail = envioemail;
	}

	public byte getEnviosms() {
		return this.enviosms;
	}

	public void setEnviosms(byte enviosms) {
		this.enviosms = enviosms;
	}

	public int getFactorpuntos() {
		return this.factorpuntos;
	}

	public void setFactorpuntos(int factorpuntos) {
		this.factorpuntos = factorpuntos;
	}

	public byte getRedensionsucursales() {
		return this.redensionsucursales;
	}

	public void setRedensionsucursales(byte redensionsucursales) {
		this.redensionsucursales = redensionsucursales;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}