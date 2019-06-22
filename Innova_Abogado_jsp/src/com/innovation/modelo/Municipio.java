package com.innovation.modelo;

public class Municipio {
	private int id_municipio;
	private String descripcion;
	private int id_departamento;
	
	public int getId_municipio() {
		return id_municipio;
	}
	
	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
		
}
