<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>Insert title here</title>
</head>
<body class="text-center">
<div class="px-4 py-5 my-5 text-center ">
<form:form action="checkLogin" modelAttribute="userSession" method="POST">
    <h1 class="h1 mb-3 fw-normal">Introduzca sus credenciales</h1>
	<div class="col-lg-2 mx-auto">
	    <div class="form-floating">
	      <form:input class="form-control" path="usuario" id="floatingInput" placeholder="name@example.com"/>
	      <label for="floatingInput">Usuario</label>
	    </div>
	    <div class="form-floating">
	      <form:input class="form-control" path="contraseña" id="floatingInput" placeholder="name@example.com"/>
	      <label for="floatingPassword">Password</label>
	    </div>
	    </br>
	    <button class="w-50btn btn-lg btn-primary" type="submit" value="login">Login</button>
	    <button class="w-50btn btn-lg btn-primary"><a class="text-decoration-none text-white" href="/tweb/usuarios/formularioAgregarCliente">Nuevo Cliente</a></button>
    </div>
  </form:form>
  </div>
</body>
</html>