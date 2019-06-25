<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Juzgado">
	<jsp:attribute name="content">
	
	
<div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
	<div class="card card-default">
		<div class="card-header card-header-border-bottom">
			<h2>Formulario para creacion de un juzgado</h2>
		</div>
		<div>${mensaje}</div>
		<div class="card-body">
		<form action="Juzgado" method="POST" class="form-horizontal">
		<input type="hidden" name="accion" value="INS"/>
			<div class="form-group">
				<label for="InputNombre_juzgado">Nombre del Juzgado</label>
				<input type="text" class="form-control" id="InputNombre_juzgado"
								name="nombre_juzgado" value="${usuario.nombre_juzgado}"
								placeholder="Nombre del Juzgado">
			</div>
			<div class="form-group">
				<label for="InputDireccion">Direccion del Juzgado</label>
				<input type="text" class="form-control" id="InputDireccion"
								name="direccion" value="${usuario.direccion}"
								placeholder="Direccion del Juzgado">
			</div>
			<div class="form-group">
				<label for="InputId_departamento">Departamento</label>								
				<select class="form-control" id="InputId_departamento" name="id_departamento">
				<c:forEach var="n" items="${listdepartamento}">
					<option value="${n.id_departamento}">${n.descripcion}</option>
				</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label for="InputId_municipio">Municipio</label>								
				<select class="form-control" id="InputId_municipio" name="id_municipio">
				<c:forEach var="n" items="${listmunicipio}">
					<option value="${n.id_municipio}">${n.descripcion}</option>
				</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label for="InputNombre_encargado">Nombre del Lic. encargado del caso</label>
				<input type="text" class="form-control" id="InputNombre_encargado"
								name="nombre_encargado" value="${usuario.nombre_encargado}"
								placeholder="Nombre del Lic. encargado del caso">
			</div>			
			<div class="form-group">
				<label for="InputTelefono">Numero de telefono</label>
				<input type="text" class="form-control" id="InputTelefono"
								name="telefono" value="${usuario.telefono}"
								placeholder="Numero de telefono del Lic. encargado del caso">
			</div>			
				   <button type="submit" class="btn btn-primary">Crear</button>
				   <button type="button" class="btn btn-danger btn-pill">Cancelar</button>
		     </form>
		</div>
	</div>
</div>


	</jsp:attribute>

</mt:plantilla>