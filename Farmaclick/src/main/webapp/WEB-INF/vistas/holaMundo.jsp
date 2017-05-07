<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<title>Registro Exitoso</title>
</head>
<body>

<span>Usted se ha registrado correctamente</span></br></br>

	<table class="table table-bordered table-responsive table-hover">
		<tr>
			<td>Nombre</td><td>Apellido</td><td>Email</td>
		</tr>
				<tr>
					<td><c:out value="${usuarioNuevoRegistrado.nombre}"></c:out></td>
					<td><c:out value="${usuarioNuevoRegistrado.apellido}"></c:out></td>
					<td><c:out value="${usuarioNuevoRegistrado.email}"></c:out></td>
				</tr>	
		</table></br>
		<a href="loginUsuario" class="btn btn-notice btn-lg btn-primary">Ir al Login</a>
</body>
</html>