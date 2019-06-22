package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.Municipio;

public interface ServicioMunicipio {

	public List<Municipio> mostra();
	
	public void Insertar(Municipio muni);
	
	public Municipio Buscar(int id_municipio);
	
	public void Actualizar(Municipio muni);
	
	public void Eliminar(int id);
	
	public String GetMensaje();

}