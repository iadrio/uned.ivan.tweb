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
	<form:form action="finalizar" modelAttribute="certificado" method="POST">
	<form:hidden path="tipo" value ="${certificado.tipo.name()}" />
	<form:hidden path="id" value ="${certificado.id}" />
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
		    	<span class="navbar-text">FINALIZAR CERTIFICADO</span>
		    </ul>
		    <ul class="d-flex navbar-nav">
			     <input class="btn btn-dark" type="submit" value="GUARDAR CERTIFICADO">
		     </ul>
		  </div>
		</nav>	
		<c:choose>       
        	<c:when test = "${ certificado.tipo== 'CERTIFICADO_ENERGETICO'}">
				<label for="viviendas" class="form-label">Selecciona la categoría energética</label>
				<c:forEach var="item" items="${categoriasEnergeticas}">
					<div class="text-sm-start px-4 py-2">
						<input class="form-check-input" type="radio" name="categoria" id="${item}" value="${item}" required="required">
						<label class="form-check-label" for="${item}">${item.toString()}</label>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
        	</c:otherwise>
		</c:choose>
		<div class="mb-3">
		  <form:textarea path="otrosDatos" class="form-control" id="nota" rows="8"></form:textarea>
		</div>
	</form:form>
</body>
</html>