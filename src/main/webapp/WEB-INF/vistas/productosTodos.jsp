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
			          <c:set var = "mainObjectClass" value = "${sessionScope.tipoUsuario}"/>
     				  <c:if test = "${fn:contains(mainObjectClass, 'farmacia')}">			          
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

			<div class="panel panel-default">
				<div class="panel-heading">Listado de Productos</div>
			    <div class="panel-body">
					<table class="table table-striped">
						<thead>
							<th>Codigo</th>
							<th>Nombre del Producto</th>
							<th>Laboratorio</th>
							<th>Precio</th>
							<th>Accion Farmacologica</th>
							<th>Farmacia</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach items="${listaProductos}" var="item">
								<tr>
									<td><c:out value="${item.codigo}"/> </td> 
									<td><c:out value="${item.nombre}"/> </td>
									<td><c:out value="${item.laboratorio}"/> </td> 
									<td><c:out value="${item.precio}"/> </td>
									<td><c:out value="${item.accion}"/> </td>
									<td><c:out value="${item.farmacia.razonSocial}"/> </td>
									<c:if test = "${fn:contains(mainObjectClass, 'usuario')}">
									<td><a href="validarPedido?producto=${item.id}" class="btn btn-success">Comprar</a></td>
									</c:if>
								</tr> 
							</c:forEach> 
						</tbody>
					</table>	
				</div>
			</div>
		
		
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>