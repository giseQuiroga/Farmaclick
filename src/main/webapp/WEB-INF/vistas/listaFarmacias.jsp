<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de farmacias</title>
</head>
<body>
	<div class="container">
		<h1>¡Bienvenidos a FarmaClick!</h1>
			<!-- ACÁ VA EL LOGO QUE ECLIPSE NO MUESTRA-->	
			 <nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="home">FARMACLICK</a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li class="dropdown">
			      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			      		Registrarse<b class="caret"></b>
			      	</a>
			      		<ul class="dropdown-menu">
				          <li><a href="registroFarmacia">Farmacias</a></li>
				          <li><a href="registroUsuario">Usuarios</a></li>
				        </ul>
				    </li>    
			      
			      <li class="dropdown">
			      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			      		Farmacias<b class="caret"></b>
			      	</a>
			      		<ul class="dropdown-menu">
				          <li><a href="listaFarmacias">Listado de farmacias</a></li>
				          <li><a href="#">Buscar por farmacia</a></li>
				        </ul>
				    </li>    
			      <li class="dropdown">
			      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			      		Productos<b class="caret"></b>
			      	</a>
			      		<ul class="dropdown-menu">
				          <li><a href="productosTodos">Listado de medicamentos</a></li>
				          <li><a href="#">Buscar por genérico</a></li>
				        </ul>
				    </li>
				    
				    <li><a href="nosotros">Sobre nosotros</a></li>   
			    </ul>
			    <form class="navbar-form navbar-left">
			      <div class="form-group">
			        <input type="text" class="form-control" placeholder="Medicamentos, farmacias y mucho más">
			      </div>
			      <button type="submit" class="btn btn-default">Buscar</button>
			    </form>
			  </div>
			</nav>
	</div>
	
		<pre>Acá va el listado de las farmacias que tenemos en la BD</pre>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>