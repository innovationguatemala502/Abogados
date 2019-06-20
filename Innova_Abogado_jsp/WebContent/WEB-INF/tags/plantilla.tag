<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="tittle" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="content_js" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>${tittle }</title>

<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500|Poppins:400,500,600,700|Roboto:400,500"
	rel="stylesheet" />
<link
	href="https://cdn.materialdesignicons.com/3.0.39/css/materialdesignicons.min.css"
	rel="stylesheet" />

<!-- PLUGINS CSS STYLE -->
<link href="Resources/assets/plugins/toaster/toastr.min.css"
	rel="stylesheet" />
<link href="Resources/assets/plugins/nprogress/nprogress.css"
	rel="stylesheet" />
<link href="Resources/assets/plugins/flag-icons/css/flag-icon.min.css"
	rel="stylesheet" />
<link
	href="Resources/assets/plugins/jvectormap/jquery-jvectormap-2.0.3.css"
	rel="stylesheet" />
<link href="Resources/assets/plugins/ladda/ladda.min.css"
	rel="stylesheet" />
<link href="Resources/assets/plugins/select2/css/select2.min.css"
	rel="stylesheet" />
<link
	href="Resources/assets/plugins/daterangepicker/daterangepicker.css"
	rel="stylesheet" />

<!-- SLEEK CSS -->
<link id="sleek-css" rel="stylesheet"
	href="Resources/assets/css/sleek.css" />

<!-- TABLA -->
<link href="Resources/assets/datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
<link href="Resources/assets/datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>

<!-- FAVICON -->
<link href="Resources/assets/img/favicon.png" rel="shortcut icon" />


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

<body class="header-fixed sidebar-fixed sidebar-dark header-light"
	id="body">

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
					<a href="/index.html"> <svg class="brand-icon"
							xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid"
							width="30" height="33" viewBox="0 0 30 33">
                  <g fill="none" fill-rule="evenodd">
                    <path class="logo-fill-blue" fill="#7DBCFF"
								d="M0 4v25l8 4V0zM22 4v25l8 4V0z" />
                    <path class="logo-fill-white" fill="#FFF"
								d="M11 4v25l8 4V0z" /> 
                  </g>
                </svg> <span class="brand-name">INICIO</span>
					</a>
				</div>
				<!-- begin sidebar scrollbar -->
				<div class="sidebar-scrollbar">
					<!-- sidebar menu -->
					<ul class="nav sidebar-inner" id="sidebar-menu">
						<li class="has-sub active expand"><a
							class="sidenav-item-link" href="javascript:void(0)"
							data-toggle="collapse" data-target="#escritura"
							aria-expanded="false" aria-controls="escritura"> <i
								class="mdi mdi-book-open-variant"></i> <span class="nav-text">Escritura</span> <b class="caret"></b>
						</a>
							<ul class="collapse" id="escritura" data-parent="#sidebar-menu">
								<div class="sub-menu">
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Crear</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Modificar</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Buscar</span>
									</a></li>
								</div>
							</ul></li>
						<li class="has-sub active expand"><a
							class="sidenav-item-link" href="javascript:void(0)"
							data-toggle="collapse" data-target="#testamento"
							aria-expanded="false" aria-controls="testamento"> <i
								class="mdi mdi-book"></i> <span class="nav-text">Testamentos</span> <b class="caret"></b>
						</a>
							<ul class="collapse" id="testamento" data-parent="#sidebar-menu">
								<div class="sub-menu">
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Crear</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Modificar</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Buscar</span>
									</a></li>
								</div>
							</ul></li>
						<li class="has-sub active expand"><a
							class="sidenav-item-link" href="javascript:void(0)"
							data-toggle="collapse" data-target="#penales"
							aria-expanded="false" aria-controls="penales"> <i
								class="mdi mdi-human-child"></i> <span class="nav-text">Procesos Penales</span> <b class="caret"></b>
						</a>
							<ul class="collapse" id="penales" data-parent="#sidebar-menu">
								<div class="sub-menu">
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Crear</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Modificar</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Buscar</span>
									</a></li>
								</div>
							</ul></li>
						<li class="has-sub active expand"><a
							class="sidenav-item-link" href="javascript:void(0)"
							data-toggle="collapse" data-target="#contacto"
							aria-expanded="false" aria-controls="contaco"> <i
								class="mdi mdi-contact-mail"></i> <span class="nav-text">Contacto Clientes</span> <b class="caret"></b>
						</a>
							<ul class="collapse" id="contacto" data-parent="#sidebar-menu">
								<div class="sub-menu">
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Crear</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Modificar</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Buscar</span>
									</a></li>
								</div>
							</ul></li>
						<li class="has-sub active expand"><a
							class="sidenav-item-link" href="javascript:void(0)"
							data-toggle="collapse" data-target="#familia"
							aria-expanded="false" aria-controls="familia"> <i
								class="mdi mdi-account-group"></i> <span class="nav-text">Procesos Familiares</span> <b class="caret"></b>
						</a>
							<ul class="collapse" id="familia" data-parent="#sidebar-menu">
								<div class="sub-menu">
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Crear</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Modificar</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#">
											<span class="nav-text">Buscar</span>
									</a></li>
								</div>
							</ul></li>
						<li class="has-sub active expand"><a
							class="sidenav-item-link" href="javascript:void(0)"
							data-toggle="collapse" data-target="#sistema"
							aria-expanded="false" aria-controls="sistema"> <i
								class="mdi mdi-pokeball"></i> <span class="nav-text">Configuracion</span>
								<b class="caret"></b>
						</a>
							<ul class="collapse" id="sistema" data-parent="#sidebar-menu">
								<div class="sub-menu">
									<li><a class="sidenav-item-link"
										href="../Innova_Abogado_jsp/Usuario?accion=SPA"> <span class="nav-text">Crear Usuario</span>
									</a></li>
									<li><a class="sidenav-item-link"
										href="#"> <span class="nav-text">
											Modificar Usuario</span>
									</a></li>
									<li><a class="sidenav-item-link" href="#"> <span
											class="nav-text">Eliminar Usuario</span>
									</a></li>
								</div>
							</ul></li>
						</li>
					</ul>
				</div>
			</div>
		</aside>

		<!-- Header -->
		<div class="page-wrapper">
			<header class="main-header " id="header">
				<nav class="navbar navbar-static-top navbar-expand-lg">
					<!-- Sidebar toggle button -->
					<button id="sidebar-toggler" class="sidebar-toggle">
						<span class="sr-only">Toggle navigation</span>
					</button>
					<!-- search form -->
					<div class="search-form d-none d-lg-inline-block"></div>

					<div class="navbar-right ">
						<ul class="nav navbar-nav">
							<!-- Github Link Button -->

							<li class="dropdown notifications-menu">
								<button class="dropdown-toggle" data-toggle="dropdown">
									<i class="mdi mdi-bell-outline"></i>
								</button>
								<ul class="dropdown-menu dropdown-menu-right">
									<li class="dropdown-header">You have 5 notifications</li>
									<li><a href="#"> <i class="mdi mdi-account-plus"></i>
											New user registered <span
											class=" font-size-12 d-inline-block float-right"><i
												class="mdi mdi-clock-outline"></i> 10 AM</span>
									</a></li>
									<li><a href="#"> <i class="mdi mdi-account-remove"></i>
											User deleted <span
											class=" font-size-12 d-inline-block float-right"><i
												class="mdi mdi-clock-outline"></i> 07 AM</span>
									</a></li>
									<li><a href="#"> <i class="mdi mdi-chart-areaspline"></i>
											Sales report is ready <span
											class=" font-size-12 d-inline-block float-right"><i
												class="mdi mdi-clock-outline"></i> 12 PM</span>
									</a></li>
									<li><a href="#"> <i class="mdi mdi-account-supervisor"></i>
											New client <span
											class=" font-size-12 d-inline-block float-right"><i
												class="mdi mdi-clock-outline"></i> 10 AM</span>
									</a></li>
									<li><a href="#"> <i class="mdi mdi-server-network-off"></i>
											Server overloaded <span
											class=" font-size-12 d-inline-block float-right"><i
												class="mdi mdi-clock-outline"></i> 05 AM</span>
									</a></li>
									<li class="dropdown-footer"><a class="text-center"
										href="#"> View All </a></li>
								</ul>
							</li>
							<!-- User Account -->
							<li class="dropdown user-menu">
								<button href="#" class="dropdown-toggle nav-link"
									data-toggle="dropdown">
									<img src="Resources/assets/img/user/user.png"
										class="user-image" alt="User Image" /> <span
										class="d-none d-lg-inline-block">Jorge Perez</span>
								</button>
								<ul class="dropdown-menu dropdown-menu-right">
									<!-- User image -->
									<li class="dropdown-header"><img
										src="Resources/assets/img/user/user.png" class="img-circle"
										alt="User Image" />
										<div class="d-inline-block">
											Jorge Perez <small class="pt-1">Jorge12.Usuario@gmail.com</small>
										</div></li>

									<li><a href="profile.html"> <i class="mdi mdi-account"></i>
											Perfil
									</a></li>
									<li><a href="email-inbox.html"> <i
											class="mdi mdi-email"></i> Mensajes
									</a></li>
									<li><a href="#"> <i class="mdi mdi-diamond-stone"></i>
											Proyectos
									</a></li>
									<li><a href="#"> <i class="mdi mdi-settings"></i>
											Opciones de cuenta
									</a></li>

									<li class="dropdown-footer"><a href="signin.html"> <i
											class="mdi mdi-logout"></i> Salir
									</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</nav>
			</header>

			<!-- CONTENIDO -->

			<jsp:invoke fragment="content"></jsp:invoke>

			<footer class="footer mt-auto">
				<div class="columna1">
					<h4>Contactos</h4>
					<i class="mdi mdi-email"><a
						href="mailto:innovationguatemala502@gmail.com">Correo</a></i>
					<p>+50235202402</p>
				</div>
				<div class="columna2">
					<h4>Frase</h4>
					<p>El buen médico trata la enfermedad; el gran médico</p>
					<p>trata al paciente que tiene la enfermedad</p>
				</div>
				<div class="columna3">
					<h4>Redes sociales</h4>
					<i class="mdi mdi-facebook-box"><a
						href="https://www.facebook.com/profile.php?id=100015131490682"
						target="_blank">Facebook</a> </i>
				</div>
				<div class="columna4">
					<h4>Derechos</h4>
					<p>Innovation Guatemala Desarrollos</p>
					<a class="text-primary" href="http://www.iamabdus.com/"
						target="_blank">ERP Hospitales 2019</a>.
				</div>
			</footer>
		</div>


	</div>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCn8TFXGg17HAUcNpkwtxxyT9Io9B_NcM"></script>
	<script src="Resources/assets/plugins/jquery/jquery.min.js"></script>
	<script
		src="Resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="Resources/assets/plugins/toaster/toastr.min.js"></script>
	<script
		src="Resources/assets/plugins/slimscrollbar/jquery.slimscroll.min.js"></script>
	<script src="Resources/assets/plugins/charts/Chart.min.js"></script>
	<script src="Resources/assets/plugins/ladda/spin.min.js"></script>
	<script src="Resources/assets/plugins/ladda/ladda.min.js"></script>
	<script
		src="Resources/assets/plugins/jquery-mask-input/jquery.mask.min.js"></script>
	<script src="Resources/assets/plugins/select2/js/select2.min.js"></script>
	<script
		src="Resources/assets/plugins/jvectormap/jquery-jvectormap-2.0.3.min.js"></script>
	<script
		src="Resources/assets/plugins/jvectormap/jquery-jvectormap-world-mill.js"></script>
	<script src="Resources/assets/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="Resources/assets/plugins/daterangepicker/daterangepicker.js"></script>
	<script src="Resources/assets/plugins/jekyll-search.min.js"></script>
	<script src="Resources/assets/js/sleek.js"></script>
	<script src="Resources/assets/js/chart.js"></script>
	<script src="Resources/assets/js/date-range.js"></script>
	<script src="Resources/assets/js/map.js"></script>
	<script src="Resources/assets/js/custom.js"></script>
	<script src="Resources/assets/js/jquery.js"></script>

<jsp:invoke fragment="content_js"></jsp:invoke>

</body>
</html>