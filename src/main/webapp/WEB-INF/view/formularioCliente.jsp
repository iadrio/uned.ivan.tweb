<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>Formulario Cliente</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-secondary navbar-dark"></br></nav>
<div>
	<form:form action="actualizarUsuario" modelAttribute="cliente" method="POST">
		<form:hidden path="id"/>
		<form:hidden path="rol"/>
		<div class="container">
		</br>
		<h4>INTRODUCE LOS DATOS</h4>
		</br>
		<div class="row">
			    <div class="col-2">
		    	    <label for="name" class="form-label">Nombre</label>
				    <form:input path="nombre" type="text" id="name" class="form-control"/>
			    </div>
			    <div class="col" >
		    	    <label for="apellido1" class="form-label">Primer apellido</label>
				    <form:input path="apellido1" type="text" id="apellido1" class="form-control"/>
			    </div>
			    <div class="col">
			    	<label for="apellido2" class="form-label">Segundo apellido</label>
				    <form:input path="apellido2" type="text" id="apellido2" class="form-control"/>
			    </div>
			</div>
		    <div class="row">
			    <div class="col-2">
			    	<label for="telefono" class="form-label">Teléfono</label>
    				<form:input path="telefono" type="text" class="form-control" id="telefono"/>
			    </div>
			    <div class="col">
			    	<label for="email" class="form-label">Email</label>
    				<form:input path="email" type="email" class="form-control" id="email"/>
			    </div>
			</div>

			<div class="row">
			    <div class="col">
			    	<label for="usuario" class="form-label">usuario</label>
    				<form:input path="usuario" type="usuario" class="form-control" id="usuario"/>
			    </div>
			    <div class="col">
			    	<label for="password" class="form-label">constraseña</label>
    				<form:input path="contrasena" type="password" class="form-control" id="password"/>
			    </div>
			    <div class="d-grid col align-self-end">
			    	<button class="btn btn-dark" type="submit">Enviar</button>
			    </div>
			</div>
		</div>
	</form:form>
</div>
	<c:if test = "${error!=null}">
		<div class="alert alert-danger" role="alert">
			${error}
		</div>
	</c:if>
</body>
</html>