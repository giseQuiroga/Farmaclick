<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
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
							<li><a href="altaProductos?producto=0">Agregar Producto</a></li>					  	
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
					<a>ˇBienvenido, ${sessionScope.razonSocial}!</a>					  	
				</c:if>	
				<c:if test = "${fn:contains(mainObjectClass, 'usuario')}">			          
					<a>ˇBienvenido, ${sessionScope.nombre}!</a>					  	
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
		<div class="panel-heading">Listado de Productos</div>
	    <div class="panel-body">
			<table class="table table-striped">
				<thead>
					<th>Nombre del Producto</th>
					<th>Farmacia</th>
					<th>Usuario</th>
					<th>Precio</th>
					<th>Fecha de Pedido</th>
				</thead>
				<tbody>
					<c:forEach items="${listaPedido}" var="item">
						<tr>
							<td>${item.producto.nombre}</td> 
							<td>${item.producto.farmacia.razonSocial}</td>
							<td>${item.usuario.nombre} </td>
							<td>${item.producto.precio}</td>
							<td>${item.fechaPedido}</td>
						</tr> 
					</c:forEach> 
				</tbody>
			</table>	
		</div>
	</div>
	</div>
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
	</html>