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
		    height: auto;
		}
		</style>
	</head>
	<body>
		<div class="container">	
		<c:set var = "mainObjectClass" value = "${sessionScope.tipoUsuario}"/>
     				  <c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
						<li><h1>¡Bienvenido a FarmaClick, ${sessionScope.razonSocial}!</h1></li>					  	
				      </c:if>	
			 <c:if test = "${fn:contains(mainObjectClass, 'usuario')}">			          
						<li><h1>¡Bienvenido a FarmaClick, ${sessionScope.nombre}!</h1></li>					  	
				      </c:if>
		
		<!-- ACÁ VA EL LOGO -->	
		<nav class="navbar navbar-default">
		  <div class="container-fluid" style="width:auto;">
		    <div class="navbar-header">
		      <a href="home"><img src="img/logo.jpg" alt="Farmaclick" style="width:50%;"></a>
		    </div>		    
		    
		    <ul class="nav navbar-nav">
		      <li class="dropdown">
		      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
		      		Productos<b class="caret"></b>
		      	</a>
		      		<ul class="dropdown-menu">
			           <li><a href="Productos">Listado de medicamentos</a></li>
			          
     				  <c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
						<li><a href="altaProductos">Agregar Producto</a></li>					  	
				      </c:if>
			        </ul>
			    </li>
		    </ul>
		    
		    <!-- Buscador -->
		    <div class="navbar-form navbar-right">
			<form:form class="navbar-form navbar-left" action="procesarBusqueda" method="POST" modelAttribute="productoBuscado">  
				<div class="form-group">									
					<input path="nombre" name="nombre" id="nombre" type="text" class="form-control" placeholder="Buscar..."/>
				</div>
				<button class="btn btn-info btn-lg" name="Submit" type="Submit">
					<span class="glyphicon glyphicon-search"></span>  
				</button>
			</form:form>
			
			<a href="cerrarSesion" class="btn btn-notice btn-lg">Cerrar Sesión</a>	
			</div>
			
			
			<!-- Viejo buscador (sin funcion)-->
		    <!--form class="navbar-form navbar-left">
		      <div class="form-group">
		        <input type="text" class="form-control" placeholder="Medicamentos, farmacias y mucho más">
		      </div>
		      <button type="submit" class="btn btn-default">Buscar</button>
		    </form-->
		  </div>
		</nav>
		
		<div class="row">
			<div class="col-md-6">
				<h3>${productoBuscado.nombre}</h3>
				<label>${mensaje}</label>
				<br>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<c:forEach items="${productoList}" var="item">				
					Nombre:<c:out value="${item.nombre}"></c:out><br>
					Codigo:<c:out value="${item.codigo}"></c:out><br>
					Accion:<c:out value="${item.accion}"></c:out><br>				
				</c:forEach>
			</div>
		</div>	
		
		<h2>Farmacias y medicamentos a un click de distancia</h2><br><br>
		
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
		    </div>
		
		    <div class="item">
		      <img src="img/img2.jpg" alt="Estamos para ayudar">
		    </div>
		
		    <div class="item">
		      <img src="img/img3.jpg" alt="Sencillo y rápido">
		    </div>
		    
		    <div class="item">
		    <img src="img/img4.jpg" alt="Al alcance de nuestros clientes">
		    </div>
		    
		    <div class="item">
		    <img src="img/img5.jpg" alt="Aceptamos todos los medios de pago">
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
		 
		</br>
		</br>

		<div class="navbar navbar-default">
		</div>		 
		 
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>