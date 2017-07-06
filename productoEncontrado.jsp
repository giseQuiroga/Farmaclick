<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de la busqueda</title>

	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	
</head>
<body>
	<div class="row">
		<div class="col-md-6">
			<h3>Producto buscado:  ${productoBuscado.nombre}</h3>
			${valorBuscado}
			<br>
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
</body>
</html>