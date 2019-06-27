package com.innovation.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.innovation.Interfaz.ServicioUsuario;
import com.innovation.daoModelo.UsuarioDAO;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Municipio;
import com.innovation.modelo.TipoUsuario;
import com.innovation.modelo.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/Usuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		String mensaje = null;
		String msjCreado = null;
		String direccion = null;
		
		ServicioUsuario servicio = new UsuarioDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Usuario> listausuario = servicio.mostra();
			if (listausuario != null) {
				request.setAttribute("lista", listausuario);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "UsuarioModificar.jsp";
			break;
			
		case "INS":
			Usuario usuario = new Usuario();
			String dpi = request.getParameter("dpi");
			System.out.println("Numero de dpi " + request.getParameter("dpi"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String direccion1 = request.getParameter("direccion");
			String departamento = request.getParameter("id_departamento");
			String municipio = request.getParameter("id_municipio");
			String telefono = request.getParameter("telefono");
			String correo = request.getParameter("correo");
			String password = request.getParameter("passwd");
			String tipo_usuario	= request.getParameter("tipo_usuario");
			usuario.setDpi(dpi);
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setDireccion(direccion1);
			usuario.setDepartamento(Integer.parseInt(departamento));
			usuario.setMunicipio(Integer.parseInt(municipio));
			usuario.setTelefono(telefono);
			usuario.setCorreo(correo);
			usuario.setPassword(password);
			usuario.setTipo_usuario(Integer.parseInt(tipo_usuario));
			servicio.Insertar(usuario);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				direccion ="UsuarioCrear.jsp?accion=SPA";
			} else {
				direccion ="UsuarioCrear.jsp?accion=SPA";
				msjCreado = "Usuario Creado exitosamente!!!";
			}
			break;
		
		case "SPA":
			List<Departamento> listadepartamento = servicio.BuscarDepartamento();
			List<Municipio> listamunicipio = servicio.BuscarMunicipio();
			List<TipoUsuario> listaTipoUsuario = servicio.BuscarTipoUsuario();
			if (listadepartamento != null) {
				request.setAttribute("listadepartamento", listadepartamento);
			} else {
				mensaje = servicio.GetMensaje();
			}
			if (listamunicipio != null) {
				request.setAttribute("listamunicipio", listamunicipio);
			} else {
				mensaje = servicio.GetMensaje();
			}
			if (listaTipoUsuario != null) {
				request.setAttribute("listaTipoUsuario", listaTipoUsuario);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "UsuarioCrear.jsp";
			break;	
			
		case "ACT":
			 Usuario usuarioact = new Usuario();
			 usuarioact.setId(Integer.parseInt(request.getParameter("id")));
			 usuarioact.setDpi(request.getParameter("dpi"));
			 usuarioact.setNombre(request.getParameter("nombre"));
			 usuarioact.setApellido(request.getParameter("apellido"));
			 usuarioact.setDireccion(request.getParameter("direccion"));
			 usuarioact.setTelefono(request.getParameter("telefono"));
			 usuarioact.setCorreo(request.getParameter("correo"));
			 //usuarioact.setPassword(request.getParameter("passwordusu"));
			 usuarioact.setTipo_usuario(Integer.parseInt(request.getParameter("puesto")));
			 servicio.Actualizar(usuarioact);
			 mensaje = servicio.GetMensaje();
			 if (mensaje != null) {
					request.setAttribute("Usuario",usuarioact);
					direccion ="Usuario?accion=QRY";
				} else {
					direccion ="Usuario?accion=QRY";
					msjCreado = "Usuario Modificado exitosamente!!!";
				}
			break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				msjCreado = "Usuario Eliminado exitosamente!!!";
				
			} else {
				direccion ="Usuario?accion=QRY";
			}
			direccion ="Usuario?accion=QRY";
			break;
			
			
		case "VLD":
			String user = request.getParameter("nombre");
			String pass = request.getParameter("password");
			int validacion = servicio.Validar(user, pass);
			if (validacion != 0) {
				direccion = "index.jsp";
		
			} else {
                mensaje = "Credenciales incorrectas.";
                direccion = "login.jsp";
            }
			break;
			
		default:
			mensaje = "No se reconoce la accion";
		
		}
		
		if (mensaje != null) {
			String msg = "<div class=\"col-md-5 col-md-offset-3\" style=\"width: 200px; height: 100px;\">";
			msg += "<div class=\"alert alert-danger\">";
			msg += "<button class=\"close\" data-dismiss=\"alert\"><span>&times;</span></button>";
			msg += "<strong>Alerta!!</strong><br/>";
			msg += mensaje;
			msg += "</div></div>";
			request.setAttribute("mensaje", msg);
		}
		
		if (msjCreado != null) {
			String msg = "<div class=\"col-lg-6\">";
			msg += "<label for=\"success\"></label>";
			msg += "<div class=\"alert alert-success\" role=\"alert\">";
			msg += msjCreado;
			msg += "</div></div>";
			request.setAttribute("mensaje", msg);
		}
		
		RequestDispatcher despachador = request.getRequestDispatcher(direccion);
		despachador.forward(request, response);
	}

}
