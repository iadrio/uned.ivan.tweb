<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		    <div class="col-3">
	    	    <label for="superficieTerreno" class="form-label">Superficie de terreno de la parcela</label>
			    <form:input path="superficieTerreno" type="text" id="superficieTerreno" class="form-control"/>
		    </div>
		    <div class="col" >
	    	    <label for="superficieEdificio" class="form-label">Superficie del edificio</label>
			    <form:input path="superficieEdificio" type="text" id="superficieEdificio" class="form-control"/>
		    </div>
		    <div class="col">
		    	<label for="finalidad" class="form-label">Finalidad de la obra</label>
   				<form:input path="finalidad" type="finalidad" class="form-control" id="usuario"/>
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

</body>
</html>