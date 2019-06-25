package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioComentario;
import com.innovation.modelo.Comentario;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Usuario;

public class ComentarioDAO implements ServicioComentario{

	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<Comentario> mostra() {
		
		List<Comentario> lista = null;
		String sentencia = "select id_comentario, id_usuario,id_proceso,fecha,comentario from comentarios";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Comentario>();
				while (rs.next()) {
					Comentario comentario = new Comentario();
					comentario.setId_proceso(rs.getInt(1));
					comentario.setId_usuario(rs.getInt(2));
					comentario.setId_proceso(rs.getInt(3));
					comentario.setFecha(rs.getDate(4));
					comentario.setComentario(rs.getString(5));
					lista.add(comentario);
				}
				st.close();
			} catch (SQLException e) {
				SetMensaje("Problema con mostrar: " + e.getMessage());
			} finally {
				try {
					cn.close();
				}catch (SQLException ex) {
					 SetMensaje(ex.getMessage());
				}
			}
		} else {
			SetMensaje("Error de conexion: " + db.GetMessage());
		}
		
		return lista;
	}

	@Override
	public void Insertar(Comentario comentario) {
		String sentencia = "Insert into comentarios (id_usuario,id_proceso,fecha,comentario) values (?,?,?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, comentario.getId_usuario());
				st.setInt(2, comentario.getId_proceso());
				st.setDate(3, comentario.getFecha());
				st.setString(4, comentario.getComentario());
				int exec = st.executeUpdate();
				if (exec == 0) {
					throw new SQLException();
				}
				st.close();
			} catch (SQLException e) {
				SetMensaje("Problema con insertar: " + e.getMessage());
			} finally {
				try {
					cn.close();
				}catch (SQLException ex) {
					 SetMensaje(ex.getMessage());
				}
			}
		} else {
			SetMensaje("Error de conexion: " + db.GetMessage());
		}
		
	}

	@Override
	public Comentario Buscar(int id_comentario) {
		Comentario comentario = null;
		String sentencia = "select id_comentario, id_usuario,id_proceso,fecha,comentario from comentarios where id_comentario =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id_comentario);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					comentario = new Comentario();
					comentario.setId_comentario(rs.getInt(1));
					comentario.setId_usuario(rs.getInt(2));
					comentario.setId_proceso(rs.getInt(3));
					comentario.setFecha(rs.getDate(4));
					comentario.setComentario(rs.getString(5));
				}
				st.close();
			} catch (SQLException e) {
				SetMensaje("Problema con Consultar: " + e.getMessage());
			} finally {
				try {
					cn.close();
				}catch (SQLException ex) {
					 SetMensaje(ex.getMessage());
				}
			}
		} else {
			SetMensaje("Error de conexion: " + db.GetMessage());
		}
		return comentario;
	}

	public List<Usuario> BuscarUsuario() {
		List<Usuario> lista = null;
		String sentencia = "select id_usuario,CONCAT(Nombre, ' ', Apellido) As Nombre from usuario";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Usuario>();
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt(1));
					usuario.setNombre(rs.getString(2));
					lista.add(usuario);
				}
				st.close();
			} catch (SQLException e) {
				SetMensaje("Problema con Consultar: " + e.getMessage());
			} finally {
				try {
					cn.close();
				}catch (SQLException ex) {
					 SetMensaje(ex.getMessage());
				}
			}
		} else {
			SetMensaje("Error de conexion: " + db.GetMessage());
		}
		return lista;
	}
	
	
	@Override
	public void Actualizar(Comentario comentario) {
		String sentencia = "update comentarios set id_usuario =?,id_proceso=?,fecha=?,comentario=? where id_comentario =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, comentario.getId_usuario());
				st.setInt(2, comentario.getId_proceso());
				st.setDate(3, comentario.getFecha());
				st.setString(4, comentario.getComentario());
				int exec = st.executeUpdate();
				if (exec == 0) {
					throw new SQLException();
				}
				st.close();
			} catch (SQLException e) {
				SetMensaje("Problema con Actualizar: " + e.getMessage());
			} finally {
				try {
					cn.close();
				}catch (SQLException ex) {
					 SetMensaje(ex.getMessage());
				}
			}
		} else {
			SetMensaje("Error de conexion: " + db.GetMessage());
		}
		
	}

	@Override
	public void Eliminar(int id_comentario) {
		String sentencia = "delete from comentarios where id_comentario = ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id_comentario);
				
				int exec = st.executeUpdate();
				if (exec == 0) {
					throw new SQLException();
				}
				st.close();
			} catch (SQLException e) {
				SetMensaje("Problema con Eliminar: " + e.getMessage());
			} finally {
				try {
					cn.close();
				}catch (SQLException ex) {
					 SetMensaje(ex.getMessage());
				}
			}
		} else {
			SetMensaje("Error de conexion: " + db.GetMessage());
		}
		
	}

	@Override
	public String GetMensaje() {
		return mensaje;
	}
	
	public void SetMensaje (String msj) {
		this.mensaje = msj;
	}


	
}
