<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Creacion usuario">
	<jsp:attribute name="content">
	
			<div class="content-wrapper">
          		<div class=content>						 
                  <!-- Top Statistics -->
                  	<div class="row">
								<div class="col-lg-12">
									<div class="card card-default">
										<div class="card-header card-header-border-bottom">
											<h2>Modificar Usuarios</h2>
										</div>
										<div class="card-body">
											<p class="mb-5">Lista de Usuarios
											</p>
											<div>${mensaje}</div>
											<table id="table_id" class="table">
												<thead>
													<tr>
														<th scope="col">DPI</th>
														<th scope="col">Nombre</th>
														<th scope="col">Apellido</th>
														<th scope="col">Telefono</th>
														<th scope="col">Correo</th>
														<th scope="col"></th>
														<th scope="col"></th>
													</tr>
												</thead>
												<tbody>
												<c:forEach var="n" items="${lista}">
													<tr>
														<td>${n.dpi}</td>
														<td>${n.nombre}</td>
														<td>${n.apellido}</td>
														<td>${n.telefono}</td>
														<td>${n.correo}</td>
														<td style="text-align: center"><a href="#Actualizar_Modal" data-toggle="modal"
													class="mb-1 btn btn-sm btn-info"
													data-book-id="${n.dpi}" data-book-id2="${n.nombre}"
													data-book-id3="${n.apellido}" data-book-id4="${n.telefono}" data-book-id5="${n.correo}"
													data-book-id6="${n.direccion}" data-book-id7="${n.password}" data-book-id8="${n.tipo_usuario}"
													data-book-id9="${n.id}" >
                                                		<span class="mdi mdi-update"> Actualizar</span>
												</a></td>
                                                		
                                                		<td style="text-align: center"><a href="#Eliminar_Modal" data-toggle="modal" class="mb-1 btn btn-sm btn-danger" 
                                               			data-book-id9="${n.id}"" >
                                                		<span class="mdi mdi-delete"> Eliminar</span>
												</a></td>
													</tr>
												</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
						</div>
					<br />	
				</div>
			</div>
			
			<!-- MODAL PARA Actualizar -->
					 	<div class="modal fade" id="Actualizar_Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalFormTitle" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalFormTitle">Actualizar Usuario</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="Usuario" method="POST"  class="form-horizontal">
                                    			<input type="hidden" name="accion" value="ACT"/>  
											<div class="form-group">
												<label for="InputId">ID</label>
												<input type="text" class="form-control" id="id" name="id" value=""
												 readonly=""/>
												 <label for="InputDPI">DPI</label>
												<input type="text" class="form-control" id="dpi" name="dpi" value=""
												 placeholder="Modificar DPI"/>
												<label for="InputNombre">Nombre</label>
												<input type="text" class="form-control" id="nombre" name="nombre" value=""
												 placeholder="Modificar Nombre"/>
												 <label for="InputApellido">Apellido</label>
												<input type="text" class="form-control" id="apellido" name="apellido" value=""
												 placeholder="Modificar Apellido"/>
												 <label for="InputTelefono">Telefono</label>
												<input type="text" class="form-control" id="telefono" name="telefono" value=""
												 placeholder="Modificar Telefono"/>
												 <label for="InputCorreo">Correo</label>
												 <input type="text" class="form-control" id="correo" name="correo" value=""
								                 placeholder="Modificar Correo del Usuario">
												 <label for="InputDireccion">Direccion</label>
												 <input type="text" class="form-control" id="direccion" name="direccion" value=""
								                 placeholder="Direccion del Usuario">
												 <label for="InputPassword">Password</label>
												 <input type="password" class="form-control" id="passwordusu" name="passwordusu" value=""
								                 placeholder="Password del Usuario">
								                 <label for="InputPuesto">Puesto</label>
												 <input type="text" class="form-control" id="puesto" name="puesto" value=""
								                 placeholder="Puesto del Usuario">
											</div>
											<button type="submit" class="btn btn-primary">Actualizar</button>
											<button type="button" class="btn btn-danger btn-pill" data-dismiss="modal">Cancelar</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						
				<!-- MODAL PARA Eliminar -->
					 	<div class="modal fade" id="Eliminar_Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="Usuario" method="POST"  class="form-horizontal">
                                     <input type="hidden" name="accion" value="DEL"/>
									<div class="modal-body">  
										Esta seguro de eliminar al Usuario?
										<input type="hidden" class="form-control" id="id" name="id" value=""/>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-danger btn-pill" >Eliminar</button>
										<button type="button" class="btn btn-primary btn-pill" data-dismiss="modal">Cancelar</button>
									</div>
									</form>
								</div>
							</div>
						</div>
	
	
	
	</jsp:attribute>
<jsp:attribute name="content_js">
<script src="Resources/assets/datatable/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="Resources/assets/datatable/dataTables.jqueryui.min.js" type="text/javascript"></script>
        
	<script type="text/javascript">
$('#Actualizar_Modal').on('show.bs.modal', function(e) {
    var bookId = $(e.relatedTarget).data('book-id');
    var bookId2 = $(e.relatedTarget).data('book-id2');
    var bookId3 = $(e.relatedTarget).data('book-id3');
    var bookId4 = $(e.relatedTarget).data('book-id4');
    var bookId5 = $(e.relatedTarget).data('book-id5');
    var bookId6 = $(e.relatedTarget).data('book-id6');
    var bookId7 = $(e.relatedTarget).data('book-id7');
    var bookId8 = $(e.relatedTarget).data('book-id8');
    var bookId9 = $(e.relatedTarget).data('book-id9');
    $(e.currentTarget).find('input[name="dpi"]').val(bookId);
    $(e.currentTarget).find('input[name="nombre"]').val(bookId2);
    $(e.currentTarget).find('input[name="apellido"]').val(bookId3);
    $(e.currentTarget).find('input[name="telefono"]').val(bookId4);
    $(e.currentTarget).find('input[name="correo"]').val(bookId5);
    $(e.currentTarget).find('input[name="direccion"]').val(bookId6);
    $(e.currentTarget).find('input[name="passwordusu"]').val(bookId7);
    $(e.currentTarget).find('input[name="puesto"]').val(bookId8);
    $(e.currentTarget).find('input[name="id"]').val(bookId9);
    
});

$('#Eliminar_Modal').on('show.bs.modal', function(e) {
	var bookId9 = $(e.relatedTarget).data('book-id9');
	$(e.currentTarget).find('input[name="id"]').val(bookId9);
});


$(document).ready(function () {
    $('#table_id').dataTable({
        "lengthMenu": [7, 10, 25, 50, 75, 100],
        "language": {
            "lengthMenu": 'Mostrar <select>' +
                    '<option value="7">7</option>' +
                    '<option value="10">10</option>' +
                    '<option value="25">25</option>' +
                    '<option value="50">50</option>' +
                    '<option value="75">75</option>' +
                    '<option value="100">100</option>' +
                    '<option value="-1">Todo</option>' +
                    '</select>',
            "search": "Buscar:",
            "info": "Mostrando pagina _PAGE_ de _PAGES_",
            "paginate": {
                "previous": "Atras",
                "next": "Adelante"
            }
        }
    });
});


</script>
</jsp:attribute>	
</mt:plantilla>