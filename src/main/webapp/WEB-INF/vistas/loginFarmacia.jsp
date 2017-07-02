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
				<form:form action="validar-loginFarmacia" method="POST" modelAttribute="farmacia">      
			    	<h3 class="form-signin-heading text-center">Farmaclick - Farmacia</h3>
					<hr class="colorgraph">
					
					<div class="text-center text-danger">
						<c:if test="${not empty error}">
					        <h4><span><b>${error}</b></span></h4>
				        </c:if>
		       		</div>
					
					CUIT<form:input path="cuit" id="cuit" type="text" class="form-control" name="cuit" /></br>
					Contraseña<form:input path="password" type="password" id="password" name="password" class="form-control"/></br></br>     		  
					
					<button class="btn btn-success btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Entrar</button>  			
				</form:form>
				</br>
		        
		        <a href="registroFarmacia" class="btn btn-notice btn-lg btn-primary btn-block">Registrá tu farmacia</a>
				</br>
					        <a href="loginUsuario" class="btn btn-notice btn-lg btn-primary btn-block">Acceso para Usuarios</a>	
			
			</div>
			</br>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>