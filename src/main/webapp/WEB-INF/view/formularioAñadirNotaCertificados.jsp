<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
</head>
<body>
	<%@include file="components/miSesion.jsp" %>
	<form:form action="guardarNota" modelAttribute="certificado" method="POST">
	<form:hidden path="tipo" value ="${certificado.tipo.name()}" />
	<form:hidden path="id" value ="${certificado.id}" />
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
		    	<span class="navbar-text">AÑADIR NOTA</span>
		    </ul>
		    <ul class="d-flex navbar-nav">
			     <input class="btn btn-dark" type="submit" value="GUARDAR NOTA">
		     </ul>
		  </div>
		</nav>	
		<div class="mb-3">
		  <form:textarea path="otrosDatos" class="form-control" id="nota" rows="8"></form:textarea>
		</div>
	</form:form>
</body>
</html>