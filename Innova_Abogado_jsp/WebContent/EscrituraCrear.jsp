<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Escritura">
	<jsp:attribute name="content">
	
	
<div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
	<div class="card card-default">
		<div class="card-header card-header-border-bottom">
			<h2>Formulario para creacion de una escritura</h2>
		</div>
		<div>${mensaje}</div>
		<div class="card-body">
		<form action="Escritura" method="POST" class="form-horizontal">
		<input type="hidden" name="accion" value="INS"/>
			<div class="form-group">
				<label for="InputFinca">Finca</label>
				<input type="text" class="form-control" id="InputFinca"
								name="finca" value="${escritura.finca}"
								placeholder="Numero de finca">
			</div>
			<div class="form-group">
				<label for="InputFolio">Folio</label>
				<input type="text" class="form-control" id="InputFolio"
								name="folio" value="${escritura.folio}"
								placeholder="Numero de folio">
			</div>
			<div class="form-group">
				<label for="InputLibro">Libro</label>
				<input type="text" class="form-control" id="InputLibro"
								name="libro" value="${escritura.libro}"
								placeholder="Numero de libro">
			</div>			
			<div class="form-group">
				<label for="InputPartida">Partida</label>
				<input type="text" class="form-control" id="InputPartida"
								name="partida" value="${escritura.partida}"
								placeholder="Numero de partida">
			</div>
			<div class="form-group">
				<label for="InputHoja_protocolo">Hoja de Protocolo</label>
				<input type="text" class="form-control" id="InputHoja_protocolo"
								name="hoja_protocolo" value="${escritura.hoja_protocolo}"
								placeholder="Numero de hoja de protocolo">
			</div>															
			<div class="form-group">
				<label for="InputId_usuario">Cliente</label>								
				<select class="form-control" id="InputId_usuario" name="id_usuario">
				<c:forEach var="n" items="${listusuarios}">
					<option value="${n.id}">${n.nombre}</option>
				</c:forEach>
				</select>			
			</div>	
			<div class="form-group">
				<label for="InputDescripcion">Descripción</label>
				<input type="text" class="form-control" id="InputDescripcion"
								name="descripcion" value="${escritura.descripcion}"
								placeholder="Descripcion de la escritura">
			</div>						
			<div class="form-group">
				<label for="InputFecha">Fecha de escritura</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<i class="mdi mdi-calendar"></i>
						</span>
					</div>
				<input type="text" class="form-control" id="InputFecha"
									name="fecha" value="${escritura.fecha}"
									placeholder="Fecha de escritura">
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