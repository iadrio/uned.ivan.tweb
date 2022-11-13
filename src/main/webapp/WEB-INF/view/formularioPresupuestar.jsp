<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
</head>
<body>
	<%@include file="components/miSesion.jsp" %>
	<c:catch var="exception">
		<c:if test="${proyecto!=null}">
			<form:form action="presupuestar" modelAttribute="proyecto" method="POST">
			<form:hidden path="tipo" value ="${proyecto.tipo.name()}" />
			<form:hidden path="id" value ="${proyecto.id}" />
				<div class="row">
					<div class="col-2" >
			    	    <label for="duracionPrevista" class="form-label">Duración prevista(días)</label>
					    <form:input path="duracionPrevista" type="text" id="duracionPrevista" class="form-control"/>
				    </div>
				    <div class="col">
			    	    <label for="coste" class="form-label">Coste</label>
					    <form:input path="coste" type="text" id="coste" class="form-control"/>
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
		</c:if>
		<c:if test="${certificado!=null}">
			<form:form action="presupuestar" modelAttribute="certificado" method="POST">
			<form:hidden path="tipo" value ="${certificado.tipo.name()}" />
			<form:hidden path="id" value ="${certificado.id}" />
				<div class="row">
				    <div class="col">
			    	    <label for="precio" class="form-label">Precio</label>
					    <form:input path="precio" type="text" id="precio" class="form-control"/>
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
		</c:if>
	</c:catch>
	<c:if test = "${error!=null}">
		<div class="alert alert-danger" role="alert">
			${error}
		</div>
	</c:if>
</body>
</html>