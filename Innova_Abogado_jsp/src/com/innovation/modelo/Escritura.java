package com.innovation.modelo;

import java.sql.Date;

public class Escritura {

	private int id_escritura;	
	private String finca;
	private String folio;
	private String libro;
	private String partida;
	private String Hoja_protocolo;
	private int id_cliente;
	private String descripcion;
	private Date fecha;
	
	public int getId_escritura() {
		return id_escritura;
	}
	public void setId_escritura(int id_escritura) {
		this.id_escritura = id_escritura;
	}
	public String getFinca() {
		return finca;
	}
	public void setFinca(String finca) {
		this.finca = finca;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	public String getHoja_protocolo() {
		return Hoja_protocolo;
	}
	public void setHoja_protocolo(String hoja_protocolo) {
		Hoja_protocolo = hoja_protocolo;
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
	
}
