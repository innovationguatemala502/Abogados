package com.innovation.modelo;

import java.sql.Date;

public class Procesos_penales {

	private int id_proceso;
	private int id_cliente;
	private String no_caso_mp;
	private String no_caso_juzgado;
	private String estado_caso;
	private String descripcion;
	private Date fecha_audiencia;

	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_proceso() {
		return id_proceso;
	}
	public void setId_proceso(int id_proceso) {
		this.id_proceso = id_proceso;
	}
	public String getNo_caso_mp() {
		return no_caso_mp;
	}
	public void setNo_caso_mp(String no_caso_mp) {
		this.no_caso_mp = no_caso_mp;
	}
	public String getNo_caso_juzgado() {
		return no_caso_juzgado;
	}
	public void setNo_caso_juzgado(String no_caso_juzgado) {
		this.no_caso_juzgado = no_caso_juzgado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_audiencia() {
		return fecha_audiencia;
	}
	public void setFecha_audiencia(Date fecha_audiencia) {
		this.fecha_audiencia = fecha_audiencia;
	}
	public String getEstado_caso() {
		return estado_caso;
	}
	public void setEstado_caso(String estado_caso) {
		this.estado_caso = estado_caso;
	}
		
}
