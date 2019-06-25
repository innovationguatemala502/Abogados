package com.innovation.modelo;

import java.sql.Date;

public class Comentario {
	private int id_comentario;
	private int id_usuario;
	private int id_proceso;
	private Date fecha;
	private String comentario;
	
	public int getId_comentario() {
		return id_comentario;
	}
	
	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(int id_proceso) {
		this.id_proceso = id_proceso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
