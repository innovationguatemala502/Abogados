package com.innovation.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.innovation.Interfaz.ServicioDepartamento;
import com.innovation.daoModelo.DepartamentoDAO;
import com.innovation.modelo.Departamento;

/**
 * Servlet implementation class ServletDepartamento
 */
@WebServlet("/Departamento")
public class ServletDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String mensaje = null;
		String direccion = null;
		
		ServicioDepartamento servicio = new DepartamentoDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Departamento> lista = servicio.mostra();
			if (lista != null) {
				request.setAttribute("lista", lista);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "DepartamentoLista.jsp";
			break;
			
		case "INS":
			Departamento depto = new Departamento();
			String descripcion = request.getParameter("descripcion");
			depto.setDescripcion(descripcion);
			servicio.Insertar(depto);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				request.setAttribute("departamento",depto);
				direccion ="Departamento?accion=QRY";
			} else {
				direccion ="Departamento?accion=QRY";
			}
			break;
			
		case "FND":
			depto = null;
			int id_depto = Integer.parseInt(request.getParameter("id"));
			if (id_depto != 0) {
				depto = servicio.Buscar(id_depto);
				
				if(depto != null) {
					request.setAttribute("departamento", depto);
				}else {
					mensaje = servicio.GetMensaje();
					direccion ="Departamento?accion=QRY";
				}
			} else {
                mensaje = "No se ha recibido el ID de Departamento.";
                direccion = "Departamento?accion=QRY";
            }
			break;
			
			
		case "UPD":
			 depto = new Departamento();
			 depto.setDescripcion(request.getParameter("descripcion_depto"));
			 depto.setId_departamento(Integer.parseInt(request.getParameter("id_depto")));
			 servicio.Actualizar(depto);
			 mensaje = servicio.GetMensaje();
				if (mensaje != null) {
					request.setAttribute("departamento",depto);
					direccion ="Departamento?accion=QRY";
				} else {
					direccion ="Departamento?accion=QRY";
				}
				break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id_depto_e"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				
			} else {
				mensaje = "No se obtuvo el valor a eliminar";
				direccion ="Departamento?accion=QRY";
			}
			direccion ="Departamento?accion=QRY";
			break;
			
		default:
			mensaje = "No se reconoce la accion";
		
		}
		
		if (mensaje != null) {
			String msg = "<div class=\"col-md-5 col-md-offset-3\" style=\"text-align: center\">";
			msg += "<div class=\"alert alert-danger\">";
			msg += "<button class=\"close\" data-dismiss=\"alert\"><span>&times;</span></button>";
			msg += "<strong>Alerta!!</strong><br/>";
			msg += mensaje;
			msg += "</div></div>";
			request.setAttribute("mensaje", msg);
		}
		
		RequestDispatcher despachador = request.getRequestDispatcher(direccion);
		despachador.forward(request, response);
		
	}

}
