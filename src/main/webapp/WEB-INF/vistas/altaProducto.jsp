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
			    <div class="panel-heading">Nuevo Producto</div>
			    <div class="panel-body">
			    	<form:form action="listadoProductos" modelAttribute="producto" method="POST" class="form-horizontal" role="form">
					  <div class="form-group">
					    <label class="col-lg-2 control-label">Nombre:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
					    </div>
					    <label class="col-lg-2 control-label">Laboratorio:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="laboratorio" name="laboratorio" placeholder="Laboratorio">
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-lg-2 control-label">Código:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="codigo" name="codigo" placeholder="Código">
					    </div>
					    <label class="col-lg-2 control-label">Precio:</label>
					    <div class="col-lg-4">
					      <input type="text" class="form-control" id="precio" name="precio" placeholder="Precio">
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-lg-2 control-label">Acción Farmacológica:</label>
					    <div class="col-lg-4">
					      <textarea class="form-control" id="accion" name="accion" placeholder="Acción Farmacológica" rows="4"></textarea>
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