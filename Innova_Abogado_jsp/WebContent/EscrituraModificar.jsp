<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="Modificar Escritura">
	<jsp:attribute name="content">
	
			<div class="content-wrapper">
          		<div class=content>						 
                  <!-- Top Statistics -->
                  	<div class="row">
								<div class="col-lg-12">
									<div class="card card-default">
										<div class="card-header card-header-border-bottom">
											<h2>Modificar Escritura</h2>
										</div>
										<div class="card-body">
											<p class="mb-5">Lista de Testamentos
											</p>
											<div>${mensaje}</div>
											<table id="table_id" class="table">
												<thead>
													<tr>
														<th scope="col">Finca</th>
														<th scope="col">Folio</th>
														<th scope="col">Libro</th>
														<th scope="col">Partida</th>
														<th scope="col">Hoja de Protocolo</th>
														<th scope="col">Cliente</th>
														<th scope="col">Descripcion</th>
														<th scope="col">Fecha</th>
														<th scope="col"></th>
														<th scope="col"></th>
													</tr>
												</thead>
												<tbody>
												<c:forEach var="n" items="${lista}">
													<tr>
														<td>${n.finca}</td>
														<td>${n.folio}</td>
														<td>${n.libro}</td>
														<td>${n.partida}</td>
														<td>${n.hoja_protocolo}</td>
														<td>${n.nombre_cliente}</td>
														<td>${n.descripcion}</td>
														<td>${n.fecha}</td>
														<td style="text-align: center"><a href="#Actualizar_Modal" data-toggle="modal"
													class="mb-1 btn btn-sm btn-info"
													data-book-id="${n.finca}" data-book-id2="${n.folio}"
													data-book-id3="${n.libro}" data-book-id4="${n.partida}" data-book-id5="${n.hoja_protocolo}"
													data-book-id6="${n.id_cliente}" data-book-id7="${n.descripcion}" data-book-id8="${n.id_escritura}"
													data-book-id10="${n.nombre_cliente}" data-book-id11="${n.fecha}">
                                                		<span class="mdi mdi-update"> Actualizar</span>
												</a></td>
                                                		
                                                		<td style="text-align: center"><a href="#Eliminar_Modal" data-toggle="modal" class="mb-1 btn btn-sm btn-danger" 
                                               			data-book-id9="${n.id_escritura}"" >
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
										<form action="Escritura" method="POST"  class="form-horizontal">
                                    			<input type="hidden" name="accion" value="ACT"/>  
											<div class="form-group">
												<input type="hidden" class="form-control" id="id_escritura" name="id_escritura" value=""/>
												<label for="InputFinca">Finca</label>
												<input type="text" class="form-control" id="finca" name="finca" value=""
												 placeholder="Finca"/>
												 <label for="InputFolio">Folio</label>
												<input type="text" class="form-control" id="folio" name="folio" value=""
												 placeholder="Folio"/>
												 <label for="InputLibro">Libro</label>
												<input type="text" class="form-control" id="libro" name="libro" value=""
												 placeholder="Libro"/>
												<label for="InputPartida">Partida</label>
												<input type="text" class="form-control" id="partida" name="partida" value=""
												 placeholder="Partida"/>
												 <label for="InputProtocolo">Hoja de Protocolo</label>
												<input type="text" class="form-control" id="protocolo" name="protocolo" value=""
												 placeholder="Modificar Hoja de Protocolo"/>
												 <label for="InputCliente">Cliente</label>
												<input type="text" class="form-control" id="cliente" name="cliente" value=""
												 placeholder="Modificar Cliente"/>
												 <label for="InputDescripcion">Descripcion</label>
												<input type="text" class="form-control" id="descripcion" name="descripcion" value=""
												 placeholder="Modificar Descripcion"/>
												 <label for="InputFecha">Fecha</label>
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
									<form action="Escritura" method="POST"  class="form-horizontal">
                                     <input type="hidden" name="accion" value="DEL"/>
									<div class="modal-body">  
										Esta seguro de eliminar la Escritura?
										<input type="hidden" class="form-control" id="id_esc" name="id_esc" value=""/>
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
    var bookId10 = $(e.relatedTarget).data('book-id10');
    var bookId11 = $(e.relatedTarget).data('book-id11');
    $(e.currentTarget).find('input[name="finca"]').val(bookId);
    $(e.currentTarget).find('input[name="folio"]').val(bookId2);
    $(e.currentTarget).find('input[name="libro"]').val(bookId3);
    $(e.currentTarget).find('input[name="partida"]').val(bookId4);
    $(e.currentTarget).find('input[name="protocolo"]').val(bookId5);
    $(e.currentTarget).find('input[name="cliente"]').val(bookId6);
    $(e.currentTarget).find('input[name="descripcion"]').val(bookId7);
    $(e.currentTarget).find('input[name="fecha"]').val(bookId11);
    $(e.currentTarget).find('input[name="id_escritura"]').val(bookId8);
});

$('#Eliminar_Modal').on('show.bs.modal', function(e) {
	var bookId9 = $(e.relatedTarget).data('book-id9');
	$(e.currentTarget).find('input[name="id_esc"]').val(bookId9);
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