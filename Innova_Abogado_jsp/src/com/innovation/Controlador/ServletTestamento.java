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

import com.innovation.Interfaz.ServicioTestamento;
import com.innovation.daoModelo.TestamentoDAO;
import com.innovation.modelo.Testamento;
import com.innovation.modelo.Usuario;

@WebServlet("/Testamento")
public class ServletTestamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String mensaje = null;
		String direccion = null;
		String msjCreado = null;
		
		ServicioTestamento servicio = new TestamentoDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Testamento> listatestamento = servicio.mostra();
			if (listatestamento != null) {
				request.setAttribute("lista", listatestamento);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "Testamento.jsp";
			break;
			
		case "INS":
			Testamento testamento = new Testamento();
			String no_testamento = request.getParameter("no_testamento");
			String id_cliente = request.getParameter("id_usuario");
			String descripcion = request.getParameter("descripcion");
			String fecha = request.getParameter("fecha");
			testamento.setNo_testamento(no_testamento);
			testamento.setId_cliente(Integer.parseInt(id_cliente));
			testamento.setDescripcion(descripcion);
			try {
				
				String dat=fecha;
				long date=new SimpleDateFormat("dd/MM/yyyy").parse(dat,new ParsePosition(0)).getTime();
				java.sql.Date dbDate=new java.sql.Date(date);
				testamento.setFecha(dbDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			servicio.Insertar(testamento);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				direccion ="TestamentoCrear.jsp?accion=SPA";
			} else {
				direccion ="TestamentoCrear.jsp?accion=SPA";
				msjCreado = "Testamento Creado exitosamente!!!";
			}
			break;
		
		case "SPA":
			List<Usuario> listusuarios = servicio.BuscarUsuario();
			if (listusuarios != null) {
				request.setAttribute("listusuarios", listusuarios);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "TestamentoCrear.jsp?accion=SPA";
			break;		
			
		case "ACT":
			 Testamento testamentoact = new Testamento();
			 testamentoact.setId_testamento(Integer.parseInt(request.getParameter("id_testamento")));
			 testamentoact.setId_cliente(Integer.parseInt(request.getParameter("id_usuario")));
			 testamentoact.setDescripcion(request.getParameter("descripcion"));
			 servicio.Actualizar(testamentoact);
			 mensaje = servicio.GetMensaje();
			 if (mensaje != null) {
					request.setAttribute("Testamento",testamentoact);
					direccion ="Testamento.jsp?accion=QRY";
				} else {
					direccion ="Testamento.jsp?accion=QRY";
					msjCreado = "Testamento Modificado exitosamente!!!";
				}
			break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id_testamento"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				msjCreado = "Testamento Eliminado exitosamente!!!";
				
			} else {
				direccion ="Testamento.jsp?accion=QRY";
			}
			direccion ="Testamento.jsp?accion=QRY";
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
