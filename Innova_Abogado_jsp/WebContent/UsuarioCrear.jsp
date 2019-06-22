<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Usuario">
	<jsp:attribute name="content">
	
	
<div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
	<div class="card card-default">
		<div class="card-header card-header-border-bottom">
			<h2>Formulario para creacion de Usuario</h2>
		</div>
		<div>${mensaje}</div>
		<div class="card-body">
		<form action="Usuario" method="POST" class="form-horizontal">
		<input type="hidden" name="accion" value="INS"/>
			<div class="form-group">
				<label for="InputNombre">Nombre</label>
				<input type="text" class="form-control" id="InputNombre"
								name="nombre" value="${usuario.nombre}"
								placeholder="Nombre del Usuario">
			</div>
			<div class="form-group">
				<label for="InputApellido">Apellido</label>
				<input type="text" class="form-control" id="InputApellido"
								name="apellido" value="${usuario.apellido}"
								placeholder="Apellido del Usuario">
			</div>
			<div class="form-group">
				<label for="InputDPI">Numero de DPI</label>
				<input type="text" class="form-control" id="InputDPI"
								name="dpi" value="${usuario.dpi}"
								placeholder="Numero del dpi Usuario">
			</div>
			<div class="form-group">
				<label for="InputDireccion">Direccion</label>
				<input type="text" class="form-control" id="InputDireccion"
								name="direccion" value="${usuario.direccion}"
								placeholder="Direccion del Usuario">
			</div>
			<div class="form-group">
				<label for="InputId_departamento">Departamento</label>								
				<select class="form-control" id="InputId_departamento" name="id_departamento">
				<c:forEach var="n" items="${listadepartamento}">
					<option value="${n.id_departamento}">${n.descripcion}</option>
				</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label for="InputId_municipio">Municipio</label>								
				<select class="form-control" id="InputId_departamento" name="id_municipio">
				<c:forEach var="n" items="${listamunicipio}">
					<option value="${n.id_municipio}">${n.descripcion}</option>
				</c:forEach>
				</select>			
			</div>
			<div class="form-group">
				<label for="InputTelefono">Numero de telefono</label>
				<input type="text" class="form-control" id="InputTelefono"
								name="telefono" value="${usuario.telefono}"
								placeholder="Numero de telefono del Usuario">
			</div>			
			<div class="form-group">
				<label for="InputCorreo">Correo electronico del cliente</label>
				<input type="text" class="form-control" id="InputCorreo"
								name="correo" value="${usuario.correo}"
								placeholder="Correo electronico del cliente">
			</div>			
			<div class="form-group">
				<label for="InputPassword">Password</label>
				<input type="password" class="form-control" id="InputPassword"
								name="password" value="${usuario.password}"
								placeholder="Password del Usuario">
			</div>
			<div class="form-group">
				<label for="InputTipo_usuario">Tipo Usuario</label>								
				<select class="form-control" id="InputTipo_usuario" name="tipo_usuario">
				<c:forEach var="n" items="${listaTipoUsuario}">
					<option value="${n.tipo_usuario}">${n.descripcion}</option>
				</c:forEach>
				</select>			
			</div>			
			  	   
				   <button type="submit" class="btn btn-primary">Crear</button>
				   <button type="button" class="btn btn-danger btn-pill">Cancelar</button>
		     </form>
		</div>
	</div>
</div>


	</jsp:attribute>

</mt:plantilla>