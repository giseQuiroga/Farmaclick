<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-login" method="POST" modelAttribute="usuario">      
			    	<h3 class="form-signin-heading">Farmaclick - Inicio de Sesión</h3>
					<hr class="colorgraph">
					
					Email<form:input path="email" id="email" type="email" class="form-control" /></br>
					Contraseña<form:input path="password" type="password" id="password" class="form-control"/></br></br>     		  
					
					<button class="btn btn-success btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Entrar</button>  			
				</form:form>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>
		        </br>
		        <a href="registroUsuario" class="btn btn-notice btn-lg btn-primary btn-block">Registrá tu Usuario</a>	
		        </br>
		        <a href="registroFarmacia" class="btn btn-notice btn-lg btn-primary btn-block">Registrá tu farmacia</a>
			</div>
			</br>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
