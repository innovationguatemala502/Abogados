package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioMunicipio;
import com.innovation.modelo.Municipio;

public class MunicipioDAO implements ServicioMunicipio {

	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<Municipio> mostra() {
		
		List<Municipio> lista = null;
		String sentencia = "select id_Municipio, descripcion,id_departamento from municipio";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Municipio>();
				while (rs.next()) {
					Municipio muni = new Municipio();
					muni.setId_municipio(rs.getInt(1));
					muni.setDescripcion(rs.getString(2));
					muni.setId_departamento(rs.getInt(3));
					lista.add(muni);
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
	public void Insertar(Municipio muni1) {
		String sentencia = "Insert into municipio (descripcion,id_departamento) values (?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, muni1.getDescripcion());
				st.setInt(2, muni1.getId_departamento());
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
	public Municipio Buscar(int id) {
		Municipio muni1 = null;
		String sentencia = "select id_Municipio, descripcion,id_departamento from municipio where id_departamento =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					muni1 = new Municipio();
					muni1.setId_municipio(rs.getInt(1));
					muni1.setDescripcion(rs.getString(2));
					muni1.setId_departamento(rs.getInt(3));
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
		return muni1;
	}

	@Override
	public void Actualizar(Municipio muni) {
		String sentencia = "update municipio set descripcion =?,id_departamento=? where id_Municipio =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, muni.getDescripcion());
				st.setInt(2, muni.getId_departamento());
				st.setInt(3, muni.getId_municipio());
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
		String sentencia = "delete from municipio where id_Municipio = ?";
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
