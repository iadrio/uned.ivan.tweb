<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>PROYECTO NO RESIDENCIAL</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-secondary navbar-dark"></br></nav>
<div>
	<form:form action="anadirProyecto" modelAttribute="proyecto" method="POST">
		<form:hidden path="tipo" value ="${proyecto.tipo.name()}" />
		<div class="container">
		</br>
		<h4>INTRODUCE LOS DATOS DEL PROYECTO</h4>
		</br>
		<div class="row">
		    <div class="col">
	    	    <label for="superficieTerreno" class="form-label">Superficie de terreno de la parcela(m2)</label>
			    <form:input path="superficieTerreno" type="text" id="superficieTerreno" class="form-control"/>
		    </div>
		    <div class="col" >
	    	    <label for="superficieEdificio" class="form-label">Superficie del edificio(m2)</label>
			    <form:input path="superficieEdificio" type="text" id="superficieEdificio" class="form-control"/>
		    </div>
		</div>
		<div class="row">
		    <div class="col">
		    	<label for="finalidad" class="form-label">Finalidad de la obra</label>
   				<form:input path="finalidad" type="finalidad" class="form-control" id="usuario"/>
		    </div>
		</div>
		<div class="row">
			<div class="col">
	    	    <label for="direccion" class="form-label">Dirección del proyecto</label>
			    <form:input type="text" path="direccion" id="direccion" class="form-control"/>
		    </div>
		</div>
		<div class="row"><div class="col"></br></div></div>
		<div class="row align-items-center">
			<div class="col"> </div>
		    <div class="d-grid col-5 align-items-center">
		    	<button class="btn btn-dark" type="submit">Enviar</button>
		    </div>
		    <div class="col"></div>
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