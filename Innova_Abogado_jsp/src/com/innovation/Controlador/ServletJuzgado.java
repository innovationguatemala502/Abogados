package com.innovation.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.innovation.Interfaz.ServicioJuzgado;
import com.innovation.daoModelo.JuzgadoDAO;
import com.innovation.modelo.Departamento;
import com.innovation.modelo.Juzgado;
import com.innovation.modelo.Municipio;

public class ServletJuzgado extends HttpServlet {

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
		
		ServicioJuzgado servicio = new JuzgadoDAO();
		
		switch (accion) {
		
		case "QRY":
			List<Juzgado> listajuzgado = servicio.mostra();
			if (listajuzgado != null) {
				request.setAttribute("lista", listajuzgado);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "Juzgado.jsp";
			break;
			
		case "INS":
			Juzgado juzgado = new Juzgado();
			String nombre_juzgado = request.getParameter("nombre_juzgado");
			String direccion1 = request.getParameter("direccion");
			String id_departamento = request.getParameter("id_departamento");
			String id_municipio = request.getParameter("id_municipio");
			String nombre_encargado = request.getParameter("nombre_encargado");
			String telefono = request.getParameter("telefono");
			juzgado.setNombre_juzgado(nombre_juzgado);
			juzgado.setDireccion(direccion1);
			juzgado.setId_departamento(Integer.parseInt(id_departamento));
			juzgado.setId_municipio(Integer.parseInt(id_municipio));
			juzgado.setNombre_encargado(nombre_encargado);
			juzgado.setTelefono(telefono);
			servicio.Insertar(juzgado);
			mensaje = servicio.GetMensaje();
			if (mensaje != null) {
				direccion ="JuzgadoCrear.jsp?accion=SPA";
			} else {
				direccion ="JuzgadoCrear.jsp?accion=SPA";
				msjCreado = "Juzgado Creado exitosamente!!!";
			}
			break;
		
		case "SPA":
			List<Departamento> listdepartamento = servicio.BuscarDepartamento();
			List<Municipio> listmunicipio = servicio.BuscarMunicipio();
			if (listdepartamento != null) {
				request.setAttribute("listdepartamento", listdepartamento);
				System.out.println("Lista de departamentos : " + listdepartamento);
			} else {
				mensaje = servicio.GetMensaje();
			}
			if (listmunicipio != null) {
				request.setAttribute("listmunicipio", listmunicipio);
			} else {
				mensaje = servicio.GetMensaje();
			}
			direccion = "JuzgadoCrear.jsp";
			break;	
			
		case "ACT":
			 Juzgado juzgadoact = new Juzgado();
			 juzgadoact.setId_juzgado(Integer.parseInt(request.getParameter("id_juzgado")));
			 juzgadoact.setNombre_juzgado(request.getParameter("nombre_juzgado"));
			 juzgadoact.setDireccion(request.getParameter("direccion"));
			 juzgadoact.setId_departamento(Integer.parseInt(request.getParameter("id_departamento")));
			 juzgadoact.setId_municipio(Integer.parseInt(request.getParameter("id_municipio")));
			 juzgadoact.setNombre_encargado(request.getParameter("nombre_encargado"));
			 juzgadoact.setTelefono(request.getParameter("telefono"));
			 servicio.Actualizar(juzgadoact );
			 mensaje = servicio.GetMensaje();
			 if (mensaje != null) {
					request.setAttribute("Juzgado",juzgadoact);
					direccion ="Juzgado?accion=QRY";
				} else {
					direccion ="Juzgado?accion=QRY";
					msjCreado = "Juzgado Modificado exitosamente!!!";
				}
			break;
		
				
		case "DEL":
			int id_el = Integer.parseInt(request.getParameter("id_juzgado"));
			
			if (id_el != 0) {
				servicio.Eliminar(id_el);
				mensaje = servicio.GetMensaje();
				msjCreado = "Usuario Eliminado exitosamente!!!";
				
			} else {
				direccion ="Juzgado?accion=QRY";
			}
			direccion ="Juzgado?accion=QRY";
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
