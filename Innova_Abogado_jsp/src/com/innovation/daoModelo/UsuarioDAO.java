package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioUsuario;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Municipio;
import com.innovation.modelo.TipoUsuario;
import com.innovation.modelo.Usuario;

public class UsuarioDAO implements ServicioUsuario {


	private final Conexion db = new Conexion();
	private String mensaje;
	
	public List<Usuario> mostra() {
		
		List<Usuario> lista = null;
		String sentencia = "select id_usuario,DPI,Nombre,Apellido,Direccion,id_departamento,id_municipio,"
				+ "Telefono,Correo,passwd,tipo_usuario from usuario";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Usuario>();
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt(1));
					usuario.setDpi(rs.getString(2));
					usuario.setNombre(rs.getString(3));
					usuario.setApellido(rs.getString(4));
					usuario.setDireccion(rs.getString(5));
					usuario.setDepartamento(rs.getInt(6));
					usuario.setMunicipio(rs.getInt(7));
					usuario.setTelefono(rs.getString(8));
					usuario.setCorreo(rs.getString(9));
					usuario.setPassword(rs.getString(10));
					usuario.setTipo_usuario(rs.getInt(11));
					lista.add(usuario);
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
	
	public List<TipoUsuario> BuscarTipoUsuario() {
		List<TipoUsuario> lista = null;
		String sentencia = "select tipo_usuario, descripcion from tipo_usuario";
		Connection cn = db.Conectar();
		if (cn != null ) {
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
	public void Insertar(Usuario usuario) {
		String sentencia = "Insert into usuario (DPI,Nombre,Apellido,Direccion,id_departamento,id_municipio,Telefono,Correo,passwd,tipo_usuario) values (?,?,?,?,?,?,?,?,?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, usuario.getDpi());
				st.setString(2, usuario.getNombre());
				st.setString(3, usuario.getApellido());
				st.setString(4, usuario.getDireccion());
				st.setInt(5, usuario.getDepartamento());
				st.setInt(6, usuario.getMunicipio());
				st.setString(7, usuario.getTelefono());
				st.setString(8, usuario.getCorreo());
				st.setString(9, usuario.getPassword());
				st.setInt(10, usuario.getTipo_usuario());
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
	public void Actualizar(Usuario usuario) {
		String sentencia = "update login set DPI = ?,Nombre = ?,Apellido = ?,Direccion = ?,id_departamento = ?,id_municipio = ?,Telefono = ?,Correo = ?,passwd = ?,tipo_usuario = ? where id_usuario = ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, usuario.getDpi());
				st.setString(2, usuario.getNombre());
				st.setString(3, usuario.getApellido());
				st.setString(4, usuario.getDireccion());
				st.setInt(5, usuario.getDepartamento());
				st.setInt(6, usuario.getMunicipio());
				st.setString(7, usuario.getTelefono());
				st.setString(8, usuario.getCorreo());
				st.setString(9, usuario.getPassword());
				st.setInt(10, usuario.getTipo_usuario());
				st.setInt(11, usuario.getId());
				
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
		String sentencia = "delete from usuario where id_usuario = ?";
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
	public int Validar(String usuario, String pass) {
		int retorno = 0;
		Usuario validar = null;
		String sentencia = "select Nombre, passwd from usuario where nombre = ? and passwd = ?;";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, usuario);
				st.setString(2, pass);
				ResultSet rs = st.executeQuery();
				if(rs.absolute(1)) {
					retorno = 1;
					while (rs.next()) {
						validar = new Usuario();
						validar.setNombre(rs.getString(1));
						validar.setPassword(rs.getString(2));
					}
				}
				else {
					retorno = 0;
					SetMensaje("Usuario o Password es incorrecto");
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
		return retorno;
	}

	public String GetMensaje() {
		return mensaje;
	}
	
	public void SetMensaje (String msj) {
		this.mensaje = msj;
	}


}
