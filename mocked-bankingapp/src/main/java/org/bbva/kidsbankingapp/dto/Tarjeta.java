package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Tarjeta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5924059111959224161L;
	Hijo hijo;
	String id;
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date fechaAlta;
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date fechaBaja;
	boolean activo;
	Cuenta cuenta;
	String tipoTarjeta;
	public Hijo getHijo() {
		return hijo;
	}
	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	@Override
	public String toString() {
		return "Tarjeta [hijo=" + hijo + ", id=" + id + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja
				+ ", activo=" + activo + ", cuenta=" + cuenta + ", tipoTarjeta=" + tipoTarjeta + "]";
	}
	
	

}
