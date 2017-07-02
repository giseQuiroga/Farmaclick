<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			          <c:set var = "mainObjectClass" value = "${mainObject.getClass().name}"/>
     				  <c:if test = "${fn:contains(mainObjectClass, 'Farmacia')}">			          
						<li><a href="altaProductos">Agregar Producto</a></li>					  	
				      </c:if>
									          
			       
			        </ul>
			    </li>
			    
			    
		    </ul>
		    
			<!-- Buscador -->
		    <div class="text-right navbar-right">
			<form:form class="navbar-form navbar-left" action="procesarBusqueda" method="POST" modelAttribute="productoBuscado">  
				<div class="form-group">									
					<input path="nombre" name="nombre" id="nombre" type="text" class="form-control" placeholder="Buscar..."/>
				</div>
				<button class="btn btn-info btn-lg" name="Submit" type="Submit">
					<span class="glyphicon glyphicon-search"></span>  
				</button>
			</form:form>
			
			<a href="cerrarSesion" class="btn btn-notice btn-lg">Cerrar Sesi�n</a>	
			</div>
		</div>
	</nav>
	${mensaje}
	<div class="panel panel-default">
		<div class="panel-heading">Listado de Productos</div>
	    <div class="panel-body">
			<table class="table table-striped">
				<thead>
					<th>Nombre del Producto</th>
					<th>Usuario</th>
					<th>Direccion</th>
					<th>Ciudad</th>
					<th>Email</th>
					<th>Telefono</th>
					<th>Precio</th>
					<th>Fecha de Pedido</th>
					<th>Farmacia</th>
				</thead>
				<tbody>
					<c:forEach items="${listaPedido}" var="item">
						<tr>
							<td>${item.producto.nombre}</td> 
							<td>${item.usuario.nombre} </td>
							<td>${item.usuario.direccion} </td>
							<td>${item.usuario.ciudad} </td>
							<td>${item.usuario.email} </td>
							<td>${item.usuario.telefono} </td>
							<td>${item.producto.precio}</td>
							<td>${item.fechaPedido}</td>
							<td>${item.producto.farmacia.razonSocial}</td>
						</tr> 
					</c:forEach> 
				</tbody>
			</table>	
		</div>
	</div>
	</div>
	</body>
	</html>