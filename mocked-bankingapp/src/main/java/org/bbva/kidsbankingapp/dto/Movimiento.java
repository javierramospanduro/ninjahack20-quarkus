package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Movimiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4682999169608332513L;
	String id;
	Cuenta cuenta;
	Tarjeta tarjeta;
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date fechaMovimiento;
	BigDecimal importe;
	BigDecimal saldoResultante;
	String descripcion;
	Producto producto;
	Hijo hijo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public BigDecimal getSaldoResultante() {
		return saldoResultante;
	}
	public void setSaldoResultante(BigDecimal saldoResultante) {
		this.saldoResultante = saldoResultante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Hijo getHijo() {
		return hijo;
	}
	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}
	@Override
	public String toString() {
		return "Movimiento [cuenta=" + cuenta + ", tarjeta=" + tarjeta + ", fechaMovimiento=" + fechaMovimiento
				+ ", importe=" + importe + ", saldoResultante=" + saldoResultante + ", descripcion=" + descripcion
				+ ", producto=" + producto + "]";
	}

}
