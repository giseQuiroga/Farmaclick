<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
<div class = "container">
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
${mensaje}
			<div class="panel panel-default">
			    <div class="panel-heading">Nuevo Producto</div>
			    <div class="panel-body">
			    	<form:form action="listadoProductos" modelAttribute="producto" method="POST" class="form-horizontal" role="form">
					  <div class="form-group">
					    <label class="col-lg-2 control-label">Nombre:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
					    </div>
					    <label class="col-lg-2 control-label">Laboratorio:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="laboratorio" name="laboratorio" placeholder="Laboratorio" required>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-lg-2 control-label">Código:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="codigo" name="codigo" placeholder="Código" required  title="El Codigo debe ser numerico.">
					    </div>
					    <label class="col-lg-2 control-label">Precio:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="precio" name="precio" placeholder="Precio" required pattern="[0-9]+([\.,][0-9]+)?" title="El precio debe ser numerico">
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-lg-2 control-label">Acción Farmacológica:</label>
					    <div class="col-lg-4">
					      <textarea class="form-control" id="accion" name="accion" placeholder="Acción Farmacológica" rows="4" required></textarea>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-lg-2 pull-right">
					      <button type="submit" class="btn btn-success">Guardar</button>
					    </div>
					  </div>
					</form:form>
				</div>
			</div>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>