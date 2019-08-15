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

import com.innovation.Interfaz.ServicioProcesos_penales;
import com.innovation.daoModelo.ProcesosPenalesDAO;
import com.innovation.modelo.Procesos_penales;
import com.innovation.modelo.Usuario;

/**
 * Servlet implementation class ServletDepartamento
 */
@WebServlet("/Procesos_penales")
public class ServletProcesos_penales  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String mensaje = null;
		String direccion = null;
		String msjCreado = null;
		
		ServicioProcesos_penales servicio = new ProcesosPenalesDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Procesos_penales> listaprocesos = servicio.mostra();
			if (listaprocesos != null) {
				request.setAttribute("lista", listaprocesos);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "ProcesosPenalesModificar.jsp";
			break;
			
		case "INS":
			Procesos_penales proceso = new Procesos_penales();
			String id_cliente = request.getParameter("id_cliente");
			String no_caso_mp = request.getParameter("no_caso_mp");
			String no_caso_juzgado = request.getParameter("no_caso_juzgado");
			String estado_caso = request.getParameter("estado_caso");
			String descripcion = request.getParameter("descripcion");
			String fecha_audiencia = request.getParameter("fecha_audiencia");
			proceso.setId_cliente(Integer.parseInt(id_cliente));
			proceso.setNo_caso_mp(no_caso_mp);
			proceso.setNo_caso_juzgado(no_caso_juzgado);
			proceso.setEstado_caso(estado_caso);
			proceso.setDescripcion(descripcion);
			try {
				
				String dat=fecha_audiencia;
				long date=new SimpleDateFormat("dd/MM/yyyy").parse(dat,new ParsePosition(0)).getTime();
				java.sql.Date dbDate=new java.sql.Date(date);
			    proceso.setFecha_audiencia(dbDate);
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			servicio.Insertar(proceso);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				direccion ="ProcesoPenalCrear.jsp?accion=SPA";
			} else {
				direccion ="ProcesoPenalCrear.jsp?accion=SPA";
				msjCreado = "Proceso Penal Creado exitosamente!!!";
			}
			break;
			
		case "SPA":
			List<Usuario> listusuarios = servicio.BuscarUsuario();
			if (listusuarios != null) {
				request.setAttribute("listusuarios", listusuarios);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "ProcesoPenalCrear.jsp?accion=SPA";
			break;	
		
		case "ACT":
			 Procesos_penales procesoact = new Procesos_penales();
			 procesoact.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
			 procesoact.setNo_caso_mp(request.getParameter("no_caso_mp"));
			 procesoact.setNo_caso_juzgado(request.getParameter("no_caso_juzgado"));
			 procesoact.setEstado_caso(request.getParameter("estado_caso"));
			 procesoact.setDescripcion(request.getParameter("descripcion"));
			 servicio.Actualizar(procesoact);
			 mensaje = servicio.GetMensaje();
			 if (mensaje != null) {
					request.setAttribute("Escritura",procesoact);
					direccion ="ProcesoPenal?accion=QRY";
				} else {
					direccion ="ProcesoPenal?accion=QRY";
					msjCreado = "Proceso Penal Modificado exitosamente!!!";
				}
			break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id_proceso"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				msjCreado = "Proceso Penal Eliminado exitosamente!!!";
				
			} else {
				direccion ="ProcesoPenal?accion=QRY";
			}
			direccion ="ProcesoPenal?accion=QRY";
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
