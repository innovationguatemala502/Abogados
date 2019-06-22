package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.TipoUsuario;

public interface ServicioTipoUsuario {

public List<TipoUsuario> mostra();
	
	public void Insertar(TipoUsuario tipo_usuario);
	
	public TipoUsuario Buscar(int tipo_usuario);
	
	public void Actualizar(TipoUsuario tipo_usuario);
	
	public void Eliminar(int id);
	
	public String GetMensaje();
	
}
