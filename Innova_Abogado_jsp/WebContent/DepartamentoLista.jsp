<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:plantilla tittle="UsuarioModificar">
	<jsp:attribute name="content">
          
          <!-- CONTENIDO -->
    	 	<div class="content-wrapper">
          		<div class="content">						 
                  <!-- Top Statistics -->
                  	<div class="row">
								<div class="col-lg-6">
									<div class="card card-default">
										<div class="card-header card-header-border-bottom">
											<h2>Departamento</h2>
										</div>
										<div class="card-body">
											<p class="mb-5">Lista de Departamentos
											</p>
											<table id="table_id" class="table">
												<thead>
													<tr>
														<th class="th-sm" scope="col">Id</th>
														<th scope="col">Departamento</th>
														<th scope="col"><button type="button" class="mb-1 btn btn-sm btn-primary" data-toggle="modal" data-target="#Insertar-Modal">
														Crear Departamento</button> </th>
													</tr>
												</thead>
												<tbody>
												<c:forEach var="n" items="${lista}">
													<tr>
														<td>${n.id_departamento}</td>
														<td>${n.descripcion}</td>
														<td style="text-align: center"><a href="#Actualizar_Modal" class="mb-1 btn btn-sm btn-info" 
                                               			data-toggle="modal" data-book-id="${n.id_departamento}" data-book-id2="${n.descripcion}">
                                                		<span class="mdi mdi-update"> Actualizar</span></a></td>
                                                		
                                                		<td style="text-align: center"><a href="#Eliminar_Modal" class="mb-1 btn btn-sm btn-danger" 
                                               			data-toggle="modal" data-book-id="${n.id_departamento}" >
                                                		<span class="mdi mdi-delete"> Eliminar</span></a></td>
													</tr>
												</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
						</div>
					<br/>
					<!-- MODAL PARA INSERTAR -->
					<div class="modal fade" id="Insertar-Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalFormTitle" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalFormTitle">Departamento</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="Departamento" method="POST"  class="form-horizontal">
                                    			<input type="hidden" name="accion" value="INS"/>  
											<div class="form-group">
												<label for="InputDepto">Departamento</label>
												<input type="text" class="form-control" id="InputDepto" name="descripcion" value="${departamento.descripcion}"
												 placeholder="Nuevo Departamento">
											</div>
											<button type="submit" class="btn btn-primary">Crear</button>
											<button type="button" class="btn btn-danger btn-pill" data-dismiss="modal">Cancelar</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						
						<!-- MODAL PARA Actualizar -->
					 	<div class="modal fade" id="Actualizar_Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalFormTitle" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalFormTitle">Actualizar Departamento</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="Departamento" method="POST"  class="form-horizontal">
                                    			<input type="hidden" name="accion" value="UPD"/>  
											<div class="form-group">
												<label for="InputDepto">Id Departamento</label>
												<input type="text" class="form-control" id="id_depto" name="id_depto" value=""
												 readonly=""/>
												<label for="InputDepto">Departamento</label>
												<input type="text" class="form-control" id="descripcion_depto" name="descripcion_depto" value=""
												 placeholder="Nuevo Departamento"/>
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
									<form action="Departamento" method="POST"  class="form-horizontal">
                                     <input type="hidden" name="accion" value="DEL"/>
									<div class="modal-body">  
										Esta seguro de eliminar del Departamento?
										<input type="hidden" class="form-control" id="id_depto_e" name="id_depto_e" value=""/>
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
    $(e.currentTarget).find('input[name="id_depto"]').val(bookId);
    $(e.currentTarget).find('input[name="descripcion_depto"]').val(bookId2);
});
$('#Eliminar_Modal').on('show.bs.modal', function(e) {
    var bookId = $(e.relatedTarget).data('book-id');
    $(e.currentTarget).find('input[name="id_depto_e"]').val(bookId);
});

</script>
</jsp:attribute>	
</mt:plantilla>
