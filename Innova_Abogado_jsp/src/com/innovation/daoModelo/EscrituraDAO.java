package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioEscritura;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Escritura;
import com.innovation.modelo.Juzgado;
import com.innovation.modelo.Municipio;
import com.innovation.modelo.Usuario;

public class EscrituraDAO implements ServicioEscritura{

	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<Escritura> mostra() {
		
		List<Escritura> lista = null;
		String sentencia = "select id_escritura, finca, folio, libro, partida, Hoja_protocolo, id_cliente,descripcion,fecha from escritura";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Escritura>();
				while (rs.next()) {
					Escritura escritura = new Escritura();
					escritura.setId_escritura(rs.getInt(1));
					escritura.setFinca(rs.getString(2));
					escritura.setFolio(rs.getString(3));
					escritura.setLibro(rs.getString(4));
					escritura.setPartida(rs.getString(5));
					escritura.setHoja_protocolo(rs.getString(6));
					escritura.setId_cliente(rs.getInt(7));
					escritura.setDescripcion(rs.getString(8));
					escritura.setFecha(rs.getDate(9));
					lista.add(escritura);
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
	public void Insertar(Escritura escritura) {
		String sentencia = "Insert into escritura (finca,folio,libro,partida,Hoja_protocolo,id_cliente,descripcion,fecha) values (?,?,?,?,?,?,?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, escritura.getFinca());
				st.setString(2, escritura.getFolio());
				st.setString(3, escritura.getLibro());
				st.setString(4, escritura.getPartida());
				st.setString(5, escritura.getHoja_protocolo());
				st.setInt(6, escritura.getId_cliente());
				st.setString(7, escritura.getDescripcion());
				st.setDate(8, escritura.getFecha());
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
	public Escritura Buscar(int id) {
		Escritura escritura = null;
		String sentencia = "select finca, folio, libro, partida, Hoja_protocolo, id_cliente,descripcion,fecha from escritura where id_escritura =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					escritura = new Escritura();
					escritura.setFinca(rs.getString(1));
					escritura.setFolio(rs.getString(2));
					escritura.setLibro(rs.getString(3));
					escritura.setPartida(rs.getString(4));
					escritura.setHoja_protocolo(rs.getString(5));
					escritura.setId_cliente(rs.getInt(6));
					escritura.setDescripcion(rs.getString(7));
					escritura.setFecha(rs.getDate(8));
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
		return escritura;
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
	public void Actualizar(Escritura escritura) {
		String sentencia = "update escritura set finca=?,folio=?,libro=?,partida=?,Hoja_protocolo=?,id_cliente=?,descripcion=? where id_escritura =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setString(1, escritura.getFinca());
				st.setString(2, escritura.getFolio());
				st.setString(3, escritura.getLibro());
				st.setString(4, escritura.getPartida());
				st.setString(5, escritura.getHoja_protocolo());
				st.setInt(6, escritura.getId_cliente());
				st.setString(7, escritura.getDescripcion());
				st.setDate(8, escritura.getFecha());
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
		String sentencia = "delete from escritura where id_escritura = ?";
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
