<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
				
			<h1>¡Bienvenidos a FarmaClick!</h1>
			<!-- ACÁ VA EL LOGO -->	
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
				          <li><a href="altaProducto">Agregar Producto</a></li>
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
		<!-- inicio de carrusel -->
		<div id="carruselHome" class="carousel slide" data-ride="carousel">
		<h2>Farmacias y medicamentos a un click de distancia</h2><br><br>
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carruselHome" data-slide-to="0" class="active"></li>
		    <li data-target="#carruselHome" data-slide-to="1"></li>
		    <li data-target="#carruselHome" data-slide-to="2"></li>
		    <li data-target="#carruselHome" data-slide-to="3"></li>
		    <li data-target="#carruselHome" data-slide-to="4"></li>
		    <li data-target="#carruselHome" data-slide-to="5"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		 <div class="carousel-inner">
		    <div class="item active">
		      <img src="img1.jpg" alt="Servicio eficiente">
		    </div>
		
		    <div class="item">
		      <img src="img2.jpg" alt="Estamos para ayudar">
		    </div>
		
		    <div class="item">
		      <img src="img3.jpg" alt="Sencillo y rápido">
		    </div>
		    
		    <div class="item">
		    <img src="img4.jpg" alt="Al alcance de nuestros clientes">
		    </div>
		    
		    <div class="item">
		    <img src="img5.jpg" alt="Aceptamos todos los medios de pago">
		    </div>
		 </div>
		
		  <!-- Left and right controls -->
		  <a class="left carousel-control" href="#carruselHome" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Atras</span>
		  </a>
		  <a class="right carousel-control" href="#carruselHome" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Siguiente</span>
		  </a>
		</div>	
		 
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>