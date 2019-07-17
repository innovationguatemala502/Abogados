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

import com.innovation.Interfaz.ServicioEscritura;
import com.innovation.daoModelo.EscrituraDAO;
import com.innovation.modelo.Escritura;
import com.innovation.modelo.Usuario;


/**
 * Servlet implementation class ServletDepartamento
 */
@WebServlet("/Escritura")
public class ServletEscritura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String mensaje = null;
		String direccion = null;
		String msjCreado = null;
		
		ServicioEscritura servicio = new EscrituraDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Escritura> listaescritura = servicio.mostra();
			if (listaescritura != null) {
				request.setAttribute("lista", listaescritura);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "EscrituraModificar.jsp";
			break;
			
		case "INS":
			Escritura escritura = new Escritura();
			String finca = request.getParameter("finca");
			String folio = request.getParameter("folio");
			String libro = request.getParameter("libro");
			String partida = request.getParameter("partida");
			String hoja_protocolo = request.getParameter("hoja_protocolo");
			String id_cliente = request.getParameter("id_usuario");
			String descripcion = request.getParameter("descripcion");
			String fecha = request.getParameter("fecha");
			escritura.setFinca(finca);
			escritura.setFolio(folio);
			escritura.setLibro(libro);
			escritura.setPartida(partida);
			escritura.setHoja_protocolo(hoja_protocolo);
			escritura.setId_cliente(Integer.parseInt(id_cliente));
			escritura.setDescripcion(descripcion);
			try {
				
				String dat=fecha;
				long date=new SimpleDateFormat("dd/MM/yyyy").parse(dat,new ParsePosition(0)).getTime();
				java.sql.Date dbDate=new java.sql.Date(date);
			    escritura.setFecha(dbDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			servicio.Insertar(escritura);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				direccion ="EscrituraCrear.jsp?accion=SPA";
			} else {
				direccion ="EscrituraCrear.jsp?accion=SPA";
				msjCreado = "Escritura Creada exitosamente!!!";
			}
			break;
		
		case "SPA":
			List<Usuario> listusuarios = servicio.BuscarUsuario();
			if (listusuarios != null) {
				request.setAttribute("listusuarios", listusuarios);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "EscrituraCrear.jsp?accion=SPA";
			break;		
			
		case "ACT":
			 Escritura escrituraact = new Escritura();
			 escrituraact.setId_escritura(Integer.parseInt(request.getParameter("id_escritura")));
			 escrituraact.setId_cliente(Integer.parseInt(request.getParameter("cliente")));
			 escrituraact.setFinca(request.getParameter("finca"));
			 escrituraact.setFolio(request.getParameter("folio"));
			 escrituraact.setLibro(request.getParameter("libro"));
			 escrituraact.setPartida(request.getParameter("partida"));
			 escrituraact.setHoja_protocolo(request.getParameter("protocolo"));
			 escrituraact.setDescripcion(request.getParameter("descripcion"));;
			 servicio.Actualizar(escrituraact );
			 mensaje = servicio.GetMensaje();
			 if (mensaje != null) {
					request.setAttribute("Escritura",escrituraact);
					direccion ="Escritura?accion=QRY";
				} else {
					direccion ="Escritura?accion=QRY";
					msjCreado = "Escritura Modificada exitosamente!!!";
				}
			break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id_esc"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				msjCreado = "Escritura Eliminada exitosamente!!!";
				
			} else {
				direccion ="Escritura?accion=QRY";
			}
			direccion ="Escritura?accion=QRY";
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
