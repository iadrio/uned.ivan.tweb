<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>PROYECTO REHABILITACION</title>
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
   	    <label for="superficieReforma" class="form-label">Superficie a reformar m2</label>
	    <form:input path="superficieReforma" type="text" id="superficieReforma" class="form-control"/>
		</br>			    
		<label for="viviendas" class="form-label">Selecciona la vivienda</label>
		</br>
     	
		<c:forEach var="item" items="${viviendas}">
			<div class="px-4 py-2">
					<input class="form-check-input" type="radio" name="direccion" id="${item.id}" value="${item.id}" required="required">
					<label class="form-check-label" for="${item.id}">
						<div class="row"> 
							<div class="col">${item.direccion} (id vivienda:${item.id}) </div>
						</div>
					</label>
			</div>
		</c:forEach>

		<div class="row"><div class="col"></br></div></div>
		<div class="row align-items-center">
			<div class="col"> </div>
		    <div class="d-grid col-5 align-items-center">
		    	<button class="btn btn-dark" type="submit">Enviar</button>
		    </div>
		    <div class="col"></div>
		</div>
		</div>
	</form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<c:if test = "${error!=null}">
		<div class="alert alert-danger" role="alert">
			${error}
		</div>
	</c:if>
</body>
</html>