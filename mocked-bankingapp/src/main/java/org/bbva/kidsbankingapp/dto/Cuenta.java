package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5726268946360311573L;
	Hijo hijo;
	Padre padre;
	String id;
	BigDecimal saldo;
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date fechaAlta;
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date fechaBaja;
	BigDecimal ingresoMensual;
	boolean activo;
	public Hijo getHijo() {
		return hijo;
	}
	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}
	public Padre getPadre() {
		return padre;
	}
	public void setPadre(Padre padre) {
		this.padre = padre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public BigDecimal getIngresoMensual() {
		return ingresoMensual;
	}
	public void setIngresoMensual(BigDecimal ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Cuenta [hijo=" + hijo + ", id=" + id + ", saldo=" + saldo + ", fechaAlta=" + fechaAlta + ", fechaBaja="
				+ fechaBaja + ", ingresoMensual=" + ingresoMensual + ", activo=" + activo + "]";
	}

}
