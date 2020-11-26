package org.bbva.kidsbankingapp.dto;

import java.io.Serializable;

import io.quarkus.runtime.annotations.RegisterForReflection;
@RegisterForReflection
public class Nivel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8682485671505877656L;
	String id;
	String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Nivel [id=" + id + ", description=" + description + "]";
	}
}
