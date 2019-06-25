package com.innovation.Controlador;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.innovation.Interfaz.ServicioComentario;
import com.innovation.Interfaz.ServicioJuzgado;
import com.innovation.daoModelo.ComentarioDAO;
import com.innovation.daoModelo.JuzgadoDAO;
import com.innovation.modelo.Comentario;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Juzgado;
import com.innovation.modelo.Municipio;
import com.innovation.modelo.Usuario;

@WebServlet("/Comentario")
public class ServletComentario extends HttpServlet {

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
		
		ServicioComentario servicio = new ComentarioDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Comentario> listacomentario = servicio.mostra();
			if (listacomentario != null) {
				request.setAttribute("lista", listacomentario);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "Comentario.jsp";
			break;
			
		case "INS":
			Comentario comen = new Comentario();
			String id_usuario = request.getParameter("id_usuario");
			String id_proceso = request.getParameter("id_proceso");
			String fecha = request.getParameter("fecha");
			String comentario = request.getParameter("comentario");
			comen.setId_usuario(Integer.parseInt(id_usuario));
			comen.setId_proceso(Integer.parseInt(id_proceso));
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			try {
				
				String dat=fecha;
				long date=new SimpleDateFormat("dd/MM/yyyy").parse(dat,new ParsePosition(0)).getTime();
				java.sql.Date dbDate=new java.sql.Date(date);
				comen.setFecha(dbDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comen.setComentario(comentario);
			servicio.Insertar(comen);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				direccion ="ComentarioCrear.jsp?accion=SPA";
			} else {
				direccion ="ComentarioCrear.jsp?accion=SPA";
				msjCreado = "Comentario Creado exitosamente!!!";
			}
			break;
		
		case "SPA":
			List<Usuario> listusuarios = servicio.BuscarUsuario();
			if (listusuarios != null) {
				request.setAttribute("listusuarios", listusuarios);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "ComentarioCrear.jsp?accion=SPA";
			break;				
			
		case "ACT":
			 Comentario comenact = new Comentario();
			 comenact.setId_comentario(Integer.parseInt(request.getParameter("id_comentario")));
			 comenact.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
			 comenact.setComentario(request.getParameter("comentario"));
			 servicio.Actualizar(comenact);
			 mensaje = servicio.GetMensaje();
			 if (mensaje != null) {
					request.setAttribute("Comentario",comenact);
					direccion ="ComentarioCrear.jsp?accion=QRY";
				} else {
					direccion ="ComentarioCrear.jsp?accion=QRY";
					msjCreado = "Comentario Modificado exitosamente!!!";
				}
			break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id_comentario"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				msjCreado = "Comentario Eliminado exitosamente!!!";
				
			} else {
				direccion ="ComentarioCrear.jsp?accion=QRY";
			}
			direccion ="ComentarioCrear.jsp?accion=QRY";
			break;
		
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
