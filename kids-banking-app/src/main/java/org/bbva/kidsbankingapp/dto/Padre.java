package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;
import java.util.Date;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Padre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2171209386088295368L;
	String id;
	String password;
	String mail;
	String nombre;
	Date fechaAlta;
	Date fechaBaja;
	boolean activo;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Padre [id=" + id + ", password=" + password + ", mail=" + mail + ", nombre=" + nombre + ", fechaAlta="
				+ fechaAlta + ", fechaBaja=" + fechaBaja + ", activo=" + activo + "]";
	}

}
