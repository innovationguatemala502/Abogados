package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.Departamento;
import com.innovation.modelo.Juzgado;
import com.innovation.modelo.Municipio;

public interface ServicioJuzgado {

	public List<Juzgado> mostra();
	
	public void Insertar(Juzgado juzgado);
	
	public Juzgado Buscar(int id_juzgado);
	
	public void Actualizar(Juzgado juzgado);
	
	public void Eliminar(int id);
	
	public String GetMensaje();

	public List<Departamento> BuscarDepartamento();
	
	public List<Municipio> BuscarMunicipio();
	
}
