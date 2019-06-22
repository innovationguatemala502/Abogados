package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioTipoUsuario;
import com.innovation.modelo.Municipio;
import com.innovation.modelo.TipoUsuario;

public class TipoUsuarioDAO implements ServicioTipoUsuario {

	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<TipoUsuario> mostra() {
		
		List<TipoUsuario> lista = null;
		String sentencia = "select tipo_usuario, descripcion from tipo_usuario";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<TipoUsuario>();
				while (rs.next()) {
					TipoUsuario tipo_usuario = new TipoUsuario();
					tipo_usuario.setTipo_usuario(rs.getInt(1));
					tipo_usuario.setDescripcion(rs.getString(2));
					lista.add(tipo_usuario);
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
	public void Insertar(TipoUsuario tipo_usuario) {
		String sentencia = "Insert into tipo_usuario (descripcion) values (?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, tipo_usuario.getDescripcion());
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
	public TipoUsuario Buscar(int id) {
		TipoUsuario tipo_usuario = null;
		String sentencia = "select tipo_usuario, descripcion from tipo_usuario where tipo_usuario =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					tipo_usuario = new TipoUsuario();
					tipo_usuario.setTipo_usuario(rs.getInt(1));
					tipo_usuario.setDescripcion(rs.getString(2));
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
		return tipo_usuario;
	}

	@Override
	public void Actualizar(TipoUsuario tipo_usuario) {
		String sentencia = "update tipo_usuario set descripcion =? where tipo_usuario =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, tipo_usuario.getDescripcion());
				st.setInt(2, tipo_usuario.getTipo_usuario());
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
	public void Eliminar(int id) {
		String sentencia = "delete from tipo_usuario where tipo_usuario = ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				
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
