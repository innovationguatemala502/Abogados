package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioTestamento;
import com.innovation.modelo.Testamento;
import com.innovation.modelo.Usuario;

public class TestamentoDAO implements ServicioTestamento {

	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<Testamento> mostra() {
		
		List<Testamento> lista = null;
		String sentencia = "select id_testamento, no_testamento, id_cliente, descripcion, fecha from testamento";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Testamento>();
				while (rs.next()) {
					Testamento testamento = new Testamento();
					testamento.setId_testamento(rs.getInt(1));
					testamento.setNo_testamento(rs.getString(2));
					testamento.setId_cliente(rs.getInt(3));
					testamento.setDescripcion(rs.getString(4));
					testamento.setFecha(rs.getDate(5));
					lista.add(testamento);
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
	public void Insertar(Testamento testamento) {
		String sentencia = "Insert into testamento (no_testamento,id_cliente,descripcion,fecha) values (?,?,?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, testamento.getNo_testamento());
				st.setInt(2, testamento.getId_cliente());
				st.setString(3, testamento.getDescripcion());
				st.setDate(4, testamento.getFecha());
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
	public Testamento Buscar(int id) {
		Testamento testamento= null;
		String sentencia = "select no_testamento, id_cliente, descripcion, fecha from testamento where id_testamento =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					testamento = new Testamento();
					testamento.setNo_testamento(rs.getString(1));
					testamento.setId_cliente(rs.getInt(2));
					testamento.setDescripcion(rs.getString(3));
					testamento.setFecha(rs.getDate(4));
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
		return testamento;
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
	public void Actualizar(Testamento testamento) {
		String sentencia = "update testamento set no_testamento=?,id_cliente=?,descripcion=? where testamento =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, testamento.getNo_testamento());
				st.setInt(2, testamento.getId_cliente());
				st.setString(3, testamento.getDescripcion());
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
		String sentencia = "delete from testamento where id_testamento = ?";
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
