package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.util.Date;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Hijo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 87702167043566000L;
	Padre padre;
	String id;
	String password;
	String nombre;
	String email;
	Date fechaAlta;
	Date fechaBaja;
	boolean nivel;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public boolean isNivel() {
		return nivel;
	}
	public void setNivel(boolean nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "Hijo [padre=" + padre + ", id=" + id + ", password=" + password + ", nombre=" + nombre + ", email="
				+ email + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nivel=" + nivel + "]";
	}

}
