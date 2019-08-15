package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.Procesos_penales;
import com.innovation.modelo.Usuario;


public interface ServicioProcesos_penales {

	public List<Procesos_penales> mostra();
	
	public void Insertar(Procesos_penales proceso);
	
	public Procesos_penales Buscar(int id_proceso);
	
	public void Actualizar(Procesos_penales proceso);
	
	public void Eliminar(int id);
	
	public String GetMensaje();
	
	public List<Usuario> BuscarUsuario();
	
}
