<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Modificar Testamento">
	<jsp:attribute name="content">
	
			<div class="content-wrapper">
          		<div class=content>						 
                  <!-- Top Statistics -->
                  	<div class="row">
								<div class="col-lg-12">
									<div class="card card-default">
										<div class="card-header card-header-border-bottom">
											<h2>Modificar Testamento</h2>
										</div>
										<div class="card-body">
											<p class="mb-5">Lista de Testamentos
											</p>
											<div>${mensaje}</div>
											<table id="table_id" class="table">
												<thead>
													<tr>
														<th scope="col">Numero</th>
														<th scope="col">Cliente</th>
														<th scope="col">Descripcion</th>
														<th scope="col">Fecha Creacion</th>
														<th scope="col"></th>
														<th scope="col"></th>
													</tr>
												</thead>
												<tbody>
												<c:forEach var="n" items="${lista}">
													<tr>
														<td>${n.no_testamento}</td>
														<td>${n.nombre_cliente}</td>
														<td>${n.descripcion}</td>
														<td>${n.fecha}</td>
														<td style="text-align: center"><a href="#Actualizar_Modal" data-toggle="modal"
													class="mb-1 btn btn-sm btn-info"
													data-book-id="${n.id_testamento}" data-book-id2="${n.no_testamento}"
													data-book-id3="${n.id_cliente}" data-book-id4="${n.descripcion}" data-book-id5="${n.fecha}"
													data-book-id6="${n.nombre_cliente}">
                                                		<span class="mdi mdi-update"> Actualizar</span>
												</a></td>
                                                		
                                                		<td style="text-align: center"><a href="#Eliminar_Modal" data-toggle="modal" class="mb-1 btn btn-sm btn-danger" 
                                               			data-book-id9="${n.id_testamento}"" >
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
										<form action="Testamento" method="POST"  class="form-horizontal">
                                    			<input type="hidden" name="accion" value="ACT"/>  
											<div class="form-group">
												<label for="InputId">Id_Testamento</label>
												<input type="text" class="form-control" id="id" name="id" value=""
												 readonly=""/>
												 <label for="InputDPI">No_Testamento</label>
												<input type="text" class="form-control" id="num_testamento" name="num_testamento" value=""
												 placeholder="No Testamento"/>
												<label for="InputNombre">Cliente</label>
												<input type="text" class="form-control" id="cliente" name="cliente" value=""
												 placeholder="Nombre Cliente"/>
												 <label for="InputApellido">Descripcion</label>
												<input type="text" class="form-control" id="descripcion" name="descripcion" value=""
												 placeholder="Modificar Descripcion"/>
												 <label for="InputTelefono">Fecha</label>
												<input type="text" class="form-control" id="fecha" name="fecha" value=""
												 readonly=""/>
												 
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
									<form action="Testamento" method="POST"  class="form-horizontal">
                                     <input type="hidden" name="accion" value="DEL"/>
									<div class="modal-body">  
										Esta seguro de eliminar el Testamento?
										<input type="hidden" class="form-control" id="id_test" name="id_test" value=""/>
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
    $(e.currentTarget).find('input[name="id"]').val(bookId);
    $(e.currentTarget).find('input[name="num_testamento"]').val(bookId2);
    $(e.currentTarget).find('input[name="cliente"]').val(bookId3);
    $(e.currentTarget).find('input[name="descripcion"]').val(bookId4);
    $(e.currentTarget).find('input[name="fecha"]').val(bookId5);
});

$('#Eliminar_Modal').on('show.bs.modal', function(e) {
	var bookId9 = $(e.relatedTarget).data('book-id9');
	$(e.currentTarget).find('input[name="id_test"]').val(bookId9);
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