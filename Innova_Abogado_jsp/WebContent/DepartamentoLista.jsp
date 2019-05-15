<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Demo - Innova App</title>

  <!-- GOOGLE FONTS -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500|Poppins:400,500,600,700|Roboto:400,500" rel="stylesheet"/>
  <link href="https://cdn.materialdesignicons.com/3.0.39/css/materialdesignicons.min.css" rel="stylesheet" />

  <!-- PLUGINS CSS STYLE -->
  <link href="Resources/assets/plugins/toaster/toastr.min.css" rel="stylesheet" />
  <link href="Resources/assets/plugins/nprogress/nprogress.css" rel="stylesheet" />
  <link href="Resources/assets/plugins/flag-icons/css/flag-icon.min.css" rel="stylesheet"/>
  <link href="Resources/assets/plugins/jvectormap/jquery-jvectormap-2.0.3.css" rel="stylesheet" />
  <link href="Resources/assets/plugins/ladda/ladda.min.css" rel="stylesheet" />
  <link href="Resources/assets/plugins/select2/css/select2.min.css" rel="stylesheet" />
  <link href="Resources/assets/plugins/daterangepicker/daterangepicker.css" rel="stylesheet" />

  <!-- SLEEK CSS -->
  <link id="sleek-css" rel="stylesheet" href="Resources/assets/css/sleek.css" />

  

  <!-- FAVICON -->
  <link href="Resources/assets/img/favicon.png" rel="shortcut icon" />
  
  <!-- TABLA -->


  <!--
    HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
  -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script src="Resources/assets/plugins/nprogress/nprogress.js"></script>
</head>

<body class="header-fixed sidebar-fixed sidebar-dark header-light" id="body">
    
    <div class="mobile-sticky-body-overlay"></div>
    
    <div class="wrapper">
      
              <!--
          ====================================
           LEFT SIDEBAR WITH FOOTER
          =====================================
        -->
        <aside class="left-sidebar bg-sidebar">
          <div id="sidebar" class="sidebar sidebar-with-footer">
            <!-- Aplication Brand -->
            <div class="app-brand">
              <a href="/index.html">
                <svg
                  class="brand-icon"
                  xmlns="http://www.w3.org/2000/svg"
                  preserveAspectRatio="xMidYMid"
                  width="30"
                  height="33"
                  viewBox="0 0 30 33"
                >
                  <g fill="none" fill-rule="evenodd">
                    <path
                      class="logo-fill-blue"
                      fill="#7DBCFF"
                      d="M0 4v25l8 4V0zM22 4v25l8 4V0z"
                    />
                    <path class="logo-fill-white" fill="#FFF" d="M11 4v25l8 4V0z" />
                  </g>
                </svg>
                <span class="brand-name">INICIO</span>
              </a>
            </div>
            <!-- begin sidebar scrollbar -->
            <div class="sidebar-scrollbar">
              <!-- sidebar menu -->
              <ul class="nav sidebar-inner" id="sidebar-menu">
                  <li  class="has-sub active expand" >
                    <a class="sidenav-item-link" href="javascript:void(0)" data-toggle="collapse" data-target="#dashboard"
                      aria-expanded="false" aria-controls="dashboard">
                      <i class="mdi mdi-view-dashboard-outline"></i>
                      <span class="nav-text">Menu de Opciones</span> <b class="caret"></b>
                    </a>
                    <ul  class="collapse show"  id="dashboard"
                      data-parent="#sidebar-menu">
                      <div class="sub-menu">
                            <li class="active">
                              <a class="sidenav-item-link" href="index.xhtml">
                                <span class="nav-text">Departamento</span>
                              </a>
                            </li>
                            <li >
                              <a class="sidenav-item-link" href="invoice.xhtml">
                                <span class="nav-text">Juzgados</span>
                                
                              </a>
                            </li>
                      </div>
                    </ul>
                   </li>
                 </ul>
    		 </div>
    		</div>
    	 </aside>
    	 
    	 <!-- AQUI DEBE IR EL CONTENIDO -->
    	 <div class="page-wrapper">
    	           <header class="main-header " id="header">
            <nav class="navbar navbar-static-top navbar-expand-lg">
              <!-- Sidebar toggle button -->
              <button id="sidebar-toggler" class="sidebar-toggle">
                <span class="sr-only">Toggle navigation</span>
              </button>
              <!-- search form -->
              <div class="search-form d-none d-lg-inline-block">

              </div>

              <div class="navbar-right ">
                <ul class="nav navbar-nav">
                  <!-- Github Link Button -->

                  <li class="dropdown notifications-menu">
                    <button class="dropdown-toggle" data-toggle="dropdown">
                      <i class="mdi mdi-bell-outline"></i>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right">
                      <li class="dropdown-header">You have 5 notifications</li>
                      <li>
                        <a href="#">
                          <i class="mdi mdi-account-plus"></i> New user registered
                          <span class=" font-size-12 d-inline-block float-right"><i class="mdi mdi-clock-outline"></i> 10 AM</span>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="mdi mdi-account-remove"></i> User deleted
                          <span class=" font-size-12 d-inline-block float-right"><i class="mdi mdi-clock-outline"></i> 07 AM</span>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="mdi mdi-chart-areaspline"></i> Sales report is ready
                          <span class=" font-size-12 d-inline-block float-right"><i class="mdi mdi-clock-outline"></i> 12 PM</span>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="mdi mdi-account-supervisor"></i> New client
                          <span class=" font-size-12 d-inline-block float-right"><i class="mdi mdi-clock-outline"></i> 10 AM</span>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <i class="mdi mdi-server-network-off"></i> Server overloaded
                          <span class=" font-size-12 d-inline-block float-right"><i class="mdi mdi-clock-outline"></i> 05 AM</span>
                        </a>
                      </li>
                      <li class="dropdown-footer">
                        <a class="text-center" href="#"> View All </a>
                      </li>
                    </ul>
                  </li>
                  <!-- User Account -->
                  <li class="dropdown user-menu">
                    <button href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                      <img src="Resources/assets/img/user/user.png" class="user-image" alt="User Image" />
                      <span class="d-none d-lg-inline-block">Jorge Perez</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right">
                      <!-- User image -->
                      <li class="dropdown-header">
                        <img src="Resources/assets/img/user/user.png" class="img-circle" alt="User Image" />
                        <div class="d-inline-block">
                          Jorge Perez <small class="pt-1">Jorge12.Usuario@gmail.com</small>
                        </div>
                      </li>

                      <li>
                        <a href="profile.html">
                          <i class="mdi mdi-account"></i> Perfil
                        </a>
                      </li>
                      <li>
                        <a href="email-inbox.html">
                          <i class="mdi mdi-email"></i> Mensajes
                        </a>
                      </li>
                      <li>
                        <a href="#"> <i class="mdi mdi-diamond-stone"></i> Proyectos </a>
                      </li>
                      <li>
                        <a href="#"> <i class="mdi mdi-settings"></i> Opciones de cuenta </a>
                      </li>

                      <li class="dropdown-footer">
                        <a href="signin.html"> <i class="mdi mdi-logout"></i> Salir </a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div>
            </nav>


          </header>
          
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
														<td>${n.id}</td>
														<td>${n.descripcion}</td>
														<td style="text-align: center"><a href="#Actualizar_Modal" class="mb-1 btn btn-sm btn-info" 
                                               			data-toggle="modal" data-book-id="${n.id}" data-book-id2="${n.descripcion}">
                                                		<span class="mdi mdi-update"> Actualizar</span></a></td>
                                                		
                                                		<td style="text-align: center"><a href="#Eliminar_Modal" class="mb-1 btn btn-sm btn-danger" 
                                               			data-toggle="modal" data-book-id="${n.id}" >
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
						
                	<%-- para mensajes  --%>
                	<div>${mensaje}</div>
				</div>
			</div>
    	
    		<footer class="footer mt-auto">
            <div class="copyright bg-white">
              <p>
               <span id="copy-year">2019</span> Innova Desarrollos derechos reservados de App
                <a
                  class="text-primary"
                  href="http://www.iamabdus.com/"
                  target="_blank"
                  >Innova</a
                >.
              </p>
            </div>
            <script>
                var d = new Date();
                var year = d.getFullYear();
                document.getElementById("copy-year").innerHTML = year;
            </script>
          </footer>
    	
    	</div> 
	</div>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCn8TFXGg17HAUcNpkwtxxyT9Io9B_NcM"></script>
<script src="Resources/assets/plugins/jquery/jquery.min.js"></script>
<script src="Resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="Resources/assets/plugins/toaster/toastr.min.js"></script>
<script src="Resources/assets/plugins/slimscrollbar/jquery.slimscroll.min.js"></script>
<script src="Resources/assets/plugins/charts/Chart.min.js"></script>
<script src="Resources/assets/plugins/ladda/spin.min.js"></script>
<script src="Resources/assets/plugins/ladda/ladda.min.js"></script>
<script src="Resources/assets/plugins/jquery-mask-input/jquery.mask.min.js"></script>
<script src="Resources/assets/plugins/select2/js/select2.min.js"></script>
<script src="Resources/assets/plugins/jvectormap/jquery-jvectormap-2.0.3.min.js"></script>
<script src="Resources/assets/plugins/jvectormap/jquery-jvectormap-world-mill.js"></script>
<script src="Resources/assets/plugins/daterangepicker/moment.min.js"></script>
<script src="Resources/assets/plugins/daterangepicker/daterangepicker.js"></script>
<script src="Resources/assets/plugins/jekyll-search.min.js"></script>
<script src="Resources/assets/js/sleek.js"></script>
<script src="Resources/assets/js/chart.js"></script>
<script src="Resources/assets/js/date-range.js"></script>
<script src="Resources/assets/js/map.js"></script>
<script src="Resources/assets/js/custom.js"></script>
<script src="Resources/assets/js/jquery.js"></script>



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
<script>console.log("hello world")</script>
</body>
</html>