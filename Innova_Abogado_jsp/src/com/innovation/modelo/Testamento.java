package com.innovation.modelo;

import java.sql.Date;

public class Testamento {

	private int id_testamento;
	private String no_testamento;
	private int id_cliente;
	private String descripcion;
	private Date fecha;
	private String nombre_cliente;

	public int getId_testamento() {
		return id_testamento;
	}

	public void setId_testamento(int id_testamento) {
		this.id_testamento = id_testamento;
	}

	public String getNo_testamento() {
		return no_testamento;
	}

	public void setNo_testamento(String no_testamento) {
		this.no_testamento = no_testamento;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre) {
		this.nombre_cliente = nombre;
	}

}
