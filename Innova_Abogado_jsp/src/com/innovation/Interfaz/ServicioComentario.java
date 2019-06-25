package com.innovation.Interfaz;

import java.util.List;
import com.innovation.modelo.Comentario;
import com.innovation.modelo.Usuario;

public interface ServicioComentario {

	public List<Comentario> mostra();
	
	public void Insertar(Comentario comentario);
	
	public Comentario Buscar(int id_comentario);
	
	public void Actualizar(Comentario comentario);
	
	public void Eliminar(int id_comentario);
	
	public String GetMensaje();
	
	public List<Usuario> BuscarUsuario();
	
}
