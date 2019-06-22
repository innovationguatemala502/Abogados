package com.innovation.modelo;

public class Juzgado {

	private int id_juzgado;
	private String nombre_juzgado;
	private String direccion;
	private int id_departamento;
	private int id_municipio;
	private String nombre_encargado;
	private String telefono;
	
	public int getId_juzgado() {
		return id_juzgado;
	}
	
	public void setId_juzgado(int id_juzgado) {
		this.id_juzgado = id_juzgado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNombre_encargado() {
		return nombre_encargado;
	}

	public void setNombre_encargado(String nombre_encargado) {
		this.nombre_encargado = nombre_encargado;
	}

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre_juzgado() {
		return nombre_juzgado;
	}

	public void setNombre_juzgado(String nombre_juzgado) {
		this.nombre_juzgado = nombre_juzgado;
	}
	
}
