package com.innovation.Interfaz;

import java.util.List;

import com.innovation.modelo.Escritura;
import com.innovation.modelo.Usuario;


public interface ServicioEscritura {

	public List<Escritura> mostra();
	
	public void Insertar(Escritura escri);
	
	public Escritura Buscar(int id_escritura);
	
	public void Actualizar(Escritura escri);
	
	public void Eliminar(int id);
	
	public String GetMensaje();	

	public List<Usuario> BuscarUsuario();
	
}
