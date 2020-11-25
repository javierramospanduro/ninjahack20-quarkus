package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6609061019563587876L;
	String id;
	String descripcion;
	Nivel nivel;
	BigDecimal precio;
	Date fechaAlta;
	Date fechaBaja;
	boolean activo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
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
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", nivel=" + nivel + ", activo=" + activo + "]";
	}
	

}
