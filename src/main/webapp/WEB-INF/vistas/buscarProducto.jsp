<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar</title>

	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	
</head>
<body>
	<div class="row">
		<div class="col-md-6">
			<form:form action="procesarBusqueda" method="POST" modelAttribute="productoBuscado">  
				<div class="col-md-5">			
					<label for="nombre">Buscar Producto</label>
					<form:input path="nombre" id="nombre" type="text" class="form-control" />
				</div>
				<div class="col-md-1">
					<br>				
					<button class="btn btn-info btn-lg" name="Submit" type="Submit">
						<span class="glyphicon glyphicon-search"></span>  
					</button>
        		</div>
			</form:form>
		</div>
	</div>
</body>
</html>