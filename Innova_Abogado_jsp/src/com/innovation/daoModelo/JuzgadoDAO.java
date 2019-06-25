package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioJuzgado;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Juzgado;
import com.innovation.modelo.Municipio;

public class JuzgadoDAO implements ServicioJuzgado {
	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<Juzgado> mostra() {
		
		List<Juzgado> lista = null;
		String sentencia = "select id_juzgado, nombre_juzgado, direccion, id_departamento, id_municipio, nombre_encargado, telefono from juzgado";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Juzgado>();
				while (rs.next()) {
					Juzgado juzgado = new Juzgado();
					juzgado.setId_juzgado(rs.getInt(1));
					juzgado.setNombre_juzgado(rs.getString(2));
					juzgado.setDireccion(rs.getString(3));
					juzgado.setId_departamento(rs.getInt(4));
					juzgado.setId_municipio(rs.getInt(5));
					juzgado.setNombre_encargado(rs.getString(6));
					juzgado.setTelefono(rs.getString(7));
					lista.add(juzgado);
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
	public void Insertar(Juzgado juzgado) {
		String sentencia = "Insert into juzgado (nombre_juzgado,direccion,id_departamento,id_municipio,nombre_encargado,telefono) values (?,?,?,?,?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, juzgado.getNombre_juzgado());
				st.setString(2, juzgado.getDireccion());
				st.setInt(3, juzgado.getId_departamento());
				st.setInt(4, juzgado.getId_municipio());
				st.setString(5, juzgado.getNombre_encargado());
				st.setString(6, juzgado.getTelefono());
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
	public Juzgado Buscar(int id) {
		Juzgado juzgado = null;
		String sentencia = "select nombre_juzgado,direccion,id_departamento,id_municipio,nombre_encargado,telefono from juzgado where id_juzgado =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					juzgado = new Juzgado();
					juzgado.setNombre_juzgado(rs.getString(1));
					juzgado.setDireccion(rs.getString(2));
					juzgado.setId_departamento(rs.getInt(3));
					juzgado.setId_municipio(rs.getInt(4));
					juzgado.setNombre_encargado(rs.getString(5));
					juzgado.setTelefono(rs.getString(6));
					juzgado.setId_juzgado(rs.getInt(7));
					
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
		return juzgado;
	}

	public List<Departamento> BuscarDepartamento() {
		List<Departamento> lista = null;
		String sentencia = "select id_departamento, descripcion from departamento";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Departamento>();
				while (rs.next()) {
					Departamento dep = new Departamento();
					dep.setId_departamento(rs.getInt(1));
					dep.setDescripcion(rs.getString(2));
					lista.add(dep);
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
	
	public List<Municipio> BuscarMunicipio() {
		List<Municipio> lista = null;
		String sentencia = "select id_Municipio, descripcion,id_departamento from municipio";
		Connection cn = db.Conectar();
		if (cn != null ) {
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
	public void Actualizar(Juzgado juzgado) {
		String sentencia = "update juzgado set nombre_juzgado=?,direccion =?,id_departamento=?,id_municipio=?,nombre_encargado=?,telefono=? where id_id_juzgado =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, juzgado.getNombre_juzgado());
				st.setString(2, juzgado.getDireccion());
				st.setInt(3, juzgado.getId_departamento());
				st.setInt(4, juzgado.getId_municipio());
				st.setString(5, juzgado.getNombre_encargado());
				st.setString(6, juzgado.getTelefono());
				st.setInt(7, juzgado.getId_juzgado());
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
