package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.Testamento;
import com.innovation.modelo.Usuario;

public interface ServicioTestamento {

	public List<Testamento> mostra();
	
	public void Insertar(Testamento testamento);
	
	public Testamento Buscar(int id_testamento);
	
	public void Actualizar(Testamento testamento);
	
	public void Eliminar(int id);
	
	public String GetMensaje();	

	public List<Usuario> BuscarUsuario();
	
}
