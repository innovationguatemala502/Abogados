<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Procesos_penales">
	<jsp:attribute name="content">
	
	
<div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
	<div class="card card-default">
		<div class="card-header card-header-border-bottom">
			<h2>Formulario para creacion de un Proceso Penal</h2>
		</div>
		<div>${mensaje}</div>
		<div class="card-body">
		<form action="Procesos_penales" method="POST" class="form-horizontal">
		<input type="hidden" name="accion" value="INS"/>
			<div class="form-group">
				<label for="InputId_cliente">Nombre del cliente</label>								
				<select class="form-control" id="InputId_cliente" name="id_cliente">
				<c:forEach var="n" items="${listusuarios}">
					<option value="${n.id}">${n.nombre}</option>
				</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label for="InputNombre_juzgado">Numero de caso del MP</label>
				<input type="text" class="form-control" id="InputMo_caso_mp"
								name="no_caso_mp" value="${usuario.no_caso_mp}"
								placeholder="Numero de caso del Ministerio Publico">
			</div>
			<div class="form-group">
				<label for="InputDireccion">Numero de caso del juzgado</label>
				<input type="text" class="form-control" id="InputNo_caso_juzgado"
								name="no_caso_juzgado" value="${usuario.no_caso_juzgado}"
								placeholder="Numero de caso del juzgado">
			</div>
			<div class="form-group">
				<label for="InputEstado_caso">Estado Del Caso</label>								
				<select class="form-control" id="estado_caso" name="estado_caso">
				<option value="Abierto">Abierto</option>
				<option value="Cerrado">Cerrado</option>
				</select>
			</div>				
			<div class="form-group">
				<label for="InputTelefono">Descripcion</label>
				<input type="text" class="form-control" id="InputDescripcion"
								name="descripcion" value="${usuario.descripcion}"
								placeholder="Descripcion del Caso">
			</div>
			<div class="form-group">
				<label for="InputFecha_audiencia">Fecha de Audiencia</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<i class="mdi mdi-calendar"></i>
						</span>
					</div>
				
				<input type="text" class="form-control" id="InputFecha_audiencia"
									name="fecha_audiencia" value="${usuario.fecha_audiencia}"
									placeholder="Fecha de audiencia del caso">
				</div>
			</div>
						
				   <button type="submit" class="btn btn-primary">Crear</button>
				   <button type="button" class="btn btn-danger btn-pill">Cancelar</button>
		     </form>
		</div>
	</div>
</div>


	</jsp:attribute>

</mt:plantilla>