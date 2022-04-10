<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>Acceso no autorizado</title>
</head>
<body class="text-center">
	<div class="alert alert-danger px-4 py-5 my-5 text-center " role="alert">
		Acceso no autorizado. Debes loguearte primero o bien acceder con un usuario con los permisos adecuados. </br>
		Pulsa siguiente para acceder al formulario de login.
	</div>

	<a href="/tweb/login/formularioLogin"><button class="w-50btn btn-lg btn-dark" type="button">siguiente</button></a>

</body>
</html>