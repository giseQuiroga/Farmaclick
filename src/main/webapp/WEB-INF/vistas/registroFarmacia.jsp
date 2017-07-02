<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">


		<!-- Website CSS style -->
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link rel="stylesheet" href="style.css">
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<title>Registrar Farmacia</title>
	</head>
	
	
	<body>
	<!--  PARA VALIDAR LOS PASSWORDS  --> 	
								
						<script type="text/javascript">
							var password, password2;

							password = document.getElementById('password');
							confirm = document.getElementById('confirm');
							
							password.onchange = confirm.onkeyup = passwordMatch;
							
							function passwordMatch() {
							    if(password.value !== confirm.value)
							        confirm.setCustomValidity('Las contraseñas deben coincidir.');
							    else
							        confirm.setCustomValidity('');
							}
						</script>	
	<!--  PARA VALIDAR LOS PASSWORDS  --> 	
		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
									<div class="bg-primary text-center" style="margin-top:50px; border-top-right-radius: 7px; border-top-left-radius: 7px;">
					</br>
					<h2>REGISTRAR FARMACIA</h2>
					</br>
				</div>
					</br>
					
					<form:form action="confirmarRegistroFarmacia" method="POST" modelAttribute="farmacia">
					


<!--         <label for="email">Ingresar Correo Electronico</label> -->
<%--         <form:input path="email" id="email" type="email" class="form-control"/> --%>

<!--         <br> -->
<!--         <label for="password">Ingresar Contraseña</label> -->
<%--         <form:input path="password" type="password" id="password" class="form-control"/> --%>

<!--         <br> -->

<!--         <div class="form-group col-lg-12"> -->
<!--             <button type="submit" class="btn btn-success">Registrar</button> -->
<!--         </div> -->
						
						<div class="form-group">
							<label for="razonSocial" class="cols-sm-2 control-label">Razon Social</label>
							<div class="cols-sm-10">
								<div class="input-group">
								
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									
									
									<input type="text" class="form-control" name="razonSocial" id="razonSocial"  placeholder="Ingrese razon social"
									required pattern="[a-zA-Z ñÑáéíóúÁÉÍÓÚ]{3,20}" title="Mayor a 3 caracteres, menor a 20 y solo letras." value="${farmacia.razonSocial}"/>
								</div>
							</div>
						</div>

						<div class="form-group">
						${mensajeConfirmacionRegistroFarmaciaNueva}</br>
							<label for="cuit" class="cols-sm-2 control-label">CUIT</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="cuit" id="cuit"  placeholder="Ingrese el CUIT"
									required pattern="[0-9]{11,11}" title="CUIT incorrecto." value="${farmacia.cuit}" />
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="telefono" class="cols-sm-2 control-label">Telefono</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="telefono" id="telefono"  placeholder="Ingrese un telefono"
									required pattern="[0-9]{8,10}" title="Telefono incorrecto." value="${farmacia.telefono}"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="email" class="form-control" name="email" id="email"  placeholder="Ingrese un e-mail"
									required pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}" 
									title="Ej.: miFarmacia@mail.com" value="${farmacia.email}" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Ingrese un password"
									required pattern="[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ!?¡¿*/%&$@-#+._-]{8,12}" title="Minimo 4 caracteres" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirmar password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Ingrese el password nuevamente"
									placeholder="Ingrese Su Password" required pattern="[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ!?¡¿*/%&$@-#+._-]{8,12}"
									oninvalid="setCustomValidity('Ambos password deben coincidir.')"  />
								</div>
							</div>
						</div>

						<div class="form-group ">
<!-- 							<a href="http://deepak646.blogspot.in" target="_blank" type="button" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</a> -->
						 <button type="submit" class="btn btn-success btn-lg btn-primary btn-block">Registrar</button>
						 
						</div>
						
<!--             <button type="submit" class="btn btn-success">Registrar</button> -->						
					</form:form> 
					<a href="loginFarmacia"><button class="btn btn-success btn-lg btn-primary btn-block">Volver al login</button></a>
					</br>
				</div>
			</div>
		</div>

		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>




<!-- <html> -->
<!-- <head> -->
<!--     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!--     <title>Registro Usuario</title> -->
<!-- </head> -->
<!-- <body> -->


<!-- <div> -->
<%--     <form:form action="registrar-usuario" method="POST" modelAttribute="usuario"> --%>

<!--         <label for="nombre">Ingresar Nombre</label> -->
<%--         <form:input path="nombre" id="nombre" type="text" class="form-control"/> --%>
<!--         <br> -->

<!--         <label for="apellido">Ingresar Apellido</label> -->
<%--         <form:input path="apellido" id="apellido" type="text" class="form-control"/> --%>
<!--         <br> -->

<!--         <label for="email">Ingresar Correo Electronico</label> -->
<%--         <form:input path="email" id="email" type="email" class="form-control"/> --%>

<!--         <br> -->
<!--         <label for="password">Ingresar Contraseña</label> -->
<%--         <form:input path="password" type="password" id="password" class="form-control"/> --%>

<!--         <br> -->

<!--         <div class="form-group col-lg-12"> -->
<!--             <button type="submit" class="btn btn-success">Registrar</button> -->
<!--         </div> -->

<!--         <br> -->

<%--     </form:form> --%>
<!-- </div> -->

<!-- </body> -->
<!-- </html> -->

