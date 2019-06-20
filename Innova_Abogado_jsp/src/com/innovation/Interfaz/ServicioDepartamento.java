package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.Departamento;

public interface ServicioDepartamento {
	
	public List<Departamento> mostra();
	
	public void Insertar(Departamento depto);
	
	public Departamento Buscar(int id_departamento);
	
	public void Actualizar(Departamento depto);
	
	public void Eliminar(int id);
	
	public String GetMensaje();

}
