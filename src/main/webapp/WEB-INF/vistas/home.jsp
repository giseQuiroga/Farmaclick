<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
		<style>
		img {
		    width: 100%;  		
			}
		
		.navbar 
			{
		    margin-bottom: 0px;
			}	
			
		.carousel-caption h1 
			{			
			color: #33cc33 !important;
			}
			
		/* Description text */
		.carousel-caption p 
			{			
			color: #33cc33 !important;
			}

		</style>
	</head>
	<body>
		<div class="container">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a href="home"><img src="img/logo.jpg" alt="Farmaclick" style="width:50%;"></a>
		    </div>
		    
		      <ul class="nav navbar-nav">
		      <li class="dropdown">
		      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
		      		Productos<b class="caret"></b>
		      	</a>
		      		<ul class="dropdown-menu">
		      			<c:set var = "mainObjectClass" value = "${sessionScope.tipoUsuario}"/>
		      			<c:if test = "${fn:contains(mainObjectClass, 'usuario')}">	
			           		<li><a href="Productos">Listado de medicamentos</a></li>
			           	</c:if>
			           	
			           	<c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
							<li><a href="misProductos">Listado de medicamentos</a></li>					  	
					    </c:if>
				          
     				  	<c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
							<li><a href="altaProductos">Agregar Producto</a></li>					  	
				     	 </c:if>
			        </ul>
			    </li>
			    <c:if test = "${fn:contains(mainObjectClass, 'usuario')}">			          
					<li><a href="misCompras">Mis Compras</a></li>					  	
				</c:if>
				<c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
					<li><a href="misPedidos">Mis Pedidos</a></li>					  	
				</c:if>
		    </ul>
		    
		    <form:form class="navbar-form navbar-left" action="procesarBusqueda" method="POST" modelAttribute="productoBuscado">  
				<div class="form-group">									
					<input path="nombre" name="nombre" id="nombre" type="text" class="form-control" placeholder="Buscar..."/>
				</div>
				<button class="btn btn-info btn-md" name="Submit" type="Submit">
					<span class="glyphicon glyphicon-search"></span>  
				</button>
		  	</form:form>
		    
		    <ul class="nav navbar-nav navbar-right">
		      <li>		      	
		      	<c:set var = "mainObjectClass" value = "${sessionScope.tipoUsuario}"/>		   			
			   	<c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
					<a>¡Bienvenido, ${sessionScope.razonSocial}!</a>					  	
				</c:if>	
				<c:if test = "${fn:contains(mainObjectClass, 'usuario')}">			          
					<a>¡Bienvenido, ${sessionScope.nombre}!</a>					  	
				</c:if>
			  </li>
		      <li>
		      	<a href="cerrarSesion" class="btn btn-notice btn-md"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesión</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		      
		<!-- inicio de carrusel -->
		<div id="carruselHome" class="carousel slide" data-ride="carousel">
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
		      <img src="img/img1.jpg" alt="Servicio eficiente">
		      <div class="carousel-caption">
			      <h1>Farmaclick</h1>
			      <p>Farmacias y medicamentos a un click de distancia</p>
		      </div>
		    </div>
							
		    <div class="item">
		      <img src="img/img2.jpg" alt="Estamos para ayudar">
		      <div class="carousel-caption">
			      <h1>Farmaclick</h1>
			      <p>Farmacias y medicamentos a un click de distancia</p>
		      </div>
		    </div>
		
		    <div class="item">
		      <img src="img/img3.jpg" alt="Sencillo y rápido">
		      <div class="carousel-caption">
			      <h1>Farmaclick</h1>
			      <p>Farmacias y medicamentos a un click de distancia</p>
		      </div>
		    </div>
		    
		    <div class="item">
			  <img src="img/img4.jpg" alt="Al alcance de nuestros clientes">
			  <div class="carousel-caption">
			  	  <h1>Farmaclick</h1>
			      <p>Farmacias y medicamentos a un click de distancia</p>
			  </div>
		    </div>
		    
		    <div class="item">
		      <img src="img/img5.jpg" alt="Aceptamos todos los medios de pago">
		      <div class="carousel-caption">
			  	  <h1>Farmaclick</h1>
			      <p>Farmacias y medicamentos a un click de distancia</p>
			  </div>
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