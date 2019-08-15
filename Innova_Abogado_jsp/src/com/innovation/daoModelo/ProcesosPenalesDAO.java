package com.innovation.daoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.innovation.DAO.Conexion;
import com.innovation.Interfaz.ServicioProcesos_penales;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Procesos_penales;
import com.innovation.modelo.Usuario;

public class ProcesosPenalesDAO implements ServicioProcesos_penales{


	private final Conexion db = new Conexion();
	private String mensaje;
	
	@Override
	public List<Procesos_penales> mostra() {
		
		List<Procesos_penales> lista = null;
		String sentencia = "select id_proceso, id_cliente,no_caso_mp,no_caso_juzgado,estado_caso,descripcion,fecha_audiencia from procesos_penales";
		Connection cn = db.Conectar();
		
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				ResultSet rs = st.executeQuery();
				lista = new LinkedList<Procesos_penales>();
				while (rs.next()) {
					Procesos_penales proceso = new Procesos_penales();
					proceso.setId_proceso(rs.getInt(1));
					proceso.setId_cliente(rs.getInt(2));
					proceso.setNo_caso_mp(rs.getString(3));
					proceso.setNo_caso_juzgado(rs.getString(4));
					proceso.setEstado_caso(rs.getString(5));
					proceso.setDescripcion(rs.getString(6));
					proceso.setFecha_audiencia(rs.getDate(7));
				
					lista.add(proceso);
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
	public void Insertar(Procesos_penales proce) {
		String sentencia = "Insert into procesos_penales (id_cliente,no_caso_mp,no_caso_juzgado,estado_caso,descripcion,fecha_audiencia) values (?,?,?,?,?,?)";
		Connection cn = db.Conectar();
		if (cn != null) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, proce.getId_cliente());
				st.setString(2, proce.getNo_caso_mp());
				st.setString(3, proce.getNo_caso_juzgado());
				st.setString(4, proce.getEstado_caso());
				st.setString(5, proce.getDescripcion());
				st.setDate(6, proce.getFecha_audiencia());
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
	public Procesos_penales Buscar(int id) {
		Procesos_penales proce1 = null;
		String sentencia = "select id_proceso, id_cliente,no_caso_mp,no_caso_juzgado,estado_caso,descripcion,fecha_audiencia from procesos_penales where id_proceso =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					proce1.setId_proceso(rs.getInt(1));
					proce1.setId_cliente(rs.getInt(2));
					proce1.setNo_caso_mp(rs.getString(3));
					proce1.setNo_caso_juzgado(rs.getString(4));
					proce1.setEstado_caso(rs.getString(5));
					proce1.setDescripcion(rs.getString(6));
					proce1.setFecha_audiencia(rs.getDate(7));
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
		return proce1;
	}

	@Override
	public void Actualizar(Procesos_penales proceso) {
		String sentencia = "update procesos_penales set id_cliente=?,no_caso_mp=?,no_caso_juzgado=?,estado_caso=?,descripcion=?,fecha_audiencia=? where id_proceso =  ?";
		Connection cn = db.Conectar();
		if (cn != null ) {
			try {
				PreparedStatement st = cn.prepareStatement(sentencia);
				st.setInt(1, proceso.getId_cliente());
				st.setString(2, proceso.getNo_caso_mp());
				st.setString(3, proceso.getNo_caso_juzgado());
				st.setString(4, proceso.getEstado_caso());
				st.setString(5, proceso.getDescripcion());
				st.setDate(6, proceso.getFecha_audiencia());
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
		String sentencia = "delete from proceso where id_proceso = ?";
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
