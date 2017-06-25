<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
	<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="home"><img src="img/logo.jpg" alt="Farmaclick" style="width:60%"></a>
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
			<form:form class="navbar-form navbar-left" action="procesarBusqueda" method="POST" modelAttribute="productoBuscado">  
				<div class="form-group">									
					<input path="nombre" name="nombre" id="nombre" type="text" class="form-control" placeholder="Buscar..."/>
				</div>
				<button class="btn btn-info btn-lg" name="Submit" type="Submit">
					<span class="glyphicon glyphicon-search"></span>  
				</button>
			</form:form>
			
			<!-- Viejo buscador (sin funcion)-->
		    <!--form class="navbar-form navbar-left">
		      <div class="form-group">
		        <input type="text" class="form-control" placeholder="Medicamentos, farmacias y mucho más">
		      </div>
		      <button type="submit" class="btn btn-default">Buscar</button>
		    </form-->
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