<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>SELECCION DE TIPO DE PROYECTO</title>
</head>
<body>
	<%@include file="components/miSesion.jsp" %>
	<form  action="formularioAgregarProyecto" method="get">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
		    	<span class="navbar-text">SELECCIONA EL TIPO DE PROYECTO</span>
		    </ul>
		      <li class="nav-item">
		      	<input class="btn btn-dark"  type="submit" value="SOLICITAR EL PROYECTO" />
		      </li>
		  </div>
		</nav>
		<c:forEach var="item" items="${tiposProyecto}">
			<div class="text-sm-start px-4 py-2">
				<input class="form-check-input" type="radio" name="tipo" id="${item}" value="${item}" required="required">
				<label class="form-check-label" for="${item}">${item.toString()}</label>
			</div>
		</c:forEach>
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>