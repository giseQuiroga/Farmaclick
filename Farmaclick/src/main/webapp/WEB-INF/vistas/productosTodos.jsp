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
	<nav class="navbar navbar-default" role="navigation">
  <!-- El logotipo y el icono que despliega el menú se agrupan
       para mostrarlos mejor en los dispositivos móviles -->
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse"
	            data-target=".navbar-ex1-collapse">
	      <span class="sr-only">Desplegar navegación</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="#">FarmaClick</a>
	  </div>
	 
	  <!-- Agrupar los enlaces de navegación, los formularios y cualquier
	       otro elemento que se pueda ocultar al minimizar la barra -->
	  <div class="collapse navbar-collapse navbar-ex1-collapse">
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Crear Producto</a></li>
	      <li><a href="registroUsuario">Registrarse</a></li>
	      <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          Iniciar Sesión <b class="caret"></b>
	        </a>
	        <ul class="dropdown-menu">
	          <li><a href="loginUsuario">Usuario</a></li>
	          <li><a href="#">Farmacia</a></li>
	        </ul>
	      </li>
	    </ul>
	 
	    <form class="navbar-form navbar-left" role="search">
	      <div class="form-group">
	        <input type="text" class="form-control" placeholder="Buscar Productos">
	      </div>
	      <button type="submit" class="btn btn-default">Buscar</button>
	    </form>
	  </div>
	</nav>
	<div class = "container">
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
						</thead>
						<tbody>
							<c:forEach items="${lista}" var="item">
								<tr>
									<td><c:out value="${item.codigo}"/> </td> 
									<td><c:out value="${item.nombre}"/> </td>
									<td><c:out value="${item.laboratorio}"/> </td> 
									<td><c:out value="${item.precio}"/> </td>
									<td><c:out value="${item.accion}"/> </td>
								</tr> 
							</c:forEach> 
						</tbody>
					</table>	
				</div>
			</div>
		</div>
</body>
</html>