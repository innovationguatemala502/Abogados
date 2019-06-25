<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Comentario">
	<jsp:attribute name="content">
	
	
<div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
	<div class="card card-default">
		<div class="card-header card-header-border-bottom">
			<h2>Formulario para creacion de un juzgado</h2>
		</div>
		<div>${mensaje}</div>
		<div class="card-body">
		<form action="Comentario" method="POST" class="form-horizontal">
		<input type="hidden" name="accion" value="INS"/>
			<div class="form-group">
				<label for="InputId_usuario">Usuario</label>								
				<select class="form-control" id="InputId_usuario" name="id_usuario">
				<c:forEach var="n" items="${listusuarios}">
					<option value="${n.id}">${n.nombre}</option>
				</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label for="InputId_proceso">Codigo de proceso</label>
				<input type="text" class="form-control" id="InputId_proceso"
								name="id_proceso" value="${comentario.id_proceso}"
								placeholder="Seleccione su caso a comentar">
			</div>			
			<div class="form-group">
				<label for="InputFecha">Fecha de Comentario</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<i class="mdi mdi-calendar"></i>
						</span>
					</div>
				
				<input type="text" class="form-control" id="InputFecha"
									name="fecha" value="${comentario.fecha}"
									placeholder="Fecha de comentario">
				</div>
			</div>
			<div class="form-group">
				<label for="InputComentario">Comentario</label>
				<input type="text" class="form-control" id="InputComentario"
								name="comentario" value="${usuario.comentario}"
								placeholder="Ingrese su mensaje para el Lic.">
			</div>			
				   <button type="submit" class="btn btn-primary">Crear</button>
				   <button type="button" class="btn btn-danger btn-pill">Cancelar</button>
		     </form>
		</div>
	</div>
</div>


	</jsp:attribute>

</mt:plantilla>