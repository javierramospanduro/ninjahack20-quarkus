package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Compra implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2592785030223781191L;
	Tarjeta tarjeta;
	Producto producto;
	@JsonbDateFormat(JsonbDateFormat.TIME_IN_MILLIS)
	Date fechaCompra;
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	@Override
	public String toString() {
		return "Compra [tarjeta=" + tarjeta + ", producto=" + producto + ", fechaCompra=" + fechaCompra + "]";
	}
}
