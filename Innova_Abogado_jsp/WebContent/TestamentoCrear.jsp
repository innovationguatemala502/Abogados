<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Testamento">
	<jsp:attribute name="content">
	
	
<div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
	<div class="card card-default">
		<div class="card-header card-header-border-bottom">
			<h2>Formulario para creacion de un testamento</h2>
		</div>
		<div>${mensaje}</div>
		<div class="card-body">
		<form action="Testamento" method="POST" class="form-horizontal">
		<input type="hidden" name="accion" value="INS"/>
			<div class="form-group">
				<label for="InputNo_testamento">Numero de Testamento</label>
				<input type="text" class="form-control" id="InputNo_testamento"
								name="no_testamento" value="${testamento.no_testamento}"
								placeholder="Numero de testamento">
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
								name="descripcion" value="${testamento.descripcion}"
								placeholder="Descripcion del testamento">
			</div>						
			<div class="form-group">
				<label for="InputFecha">Fecha de creacion del testamento</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">
							<i class="mdi mdi-calendar"></i>
						</span>
					</div>
				<input type="text" class="form-control" id="InputFecha"
									name="fecha" value="${testamento.fecha}"
									placeholder="Fecha del testamento">
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