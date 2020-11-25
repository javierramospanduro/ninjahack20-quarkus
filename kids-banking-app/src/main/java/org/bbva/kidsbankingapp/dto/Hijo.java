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
	String mail;
	Date fechaAlta;
	Date fechaBaja;
	Nivel nivel;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Hijo [padre=" + padre + ", id=" + id + ", password=" + password + ", nombre=" + nombre + ", mail="
				+ mail + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nivel=" + nivel + "]";
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

}
