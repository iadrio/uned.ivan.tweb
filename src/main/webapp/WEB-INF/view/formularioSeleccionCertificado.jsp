<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>SELECCION DE CERTIFICADO</title>
</head>
<body>
	<%@include file="components/miSesion.jsp" %>

<form  action="formularioAgregarCertificado" method="get">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">SELECCIONA EL TIPO DE CERTIFICADO</span>
	      <li class="nav-item">
	      	<input class="btn btn-dark"  type="submit" value="SOLICITAR EL CERTIFICADO" />
	      </li>
	    </ul>
	  </div>
	</nav>


	<c:forEach var="item" items="${tiposCertificado}">
		<div class="text-sm-start px-4 py-2">
			<input class="form-check-input" type="radio" name="tipo" id="${item}" value="${item}" required="required">
			<label class="form-check-label" for="${item}">${item.toString()}</label>
		</div>
	</c:forEach>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">SELECCIONA LA  VIVIENDA</span>
	      <li class="nav-item">
	      	<a class="nav-link active" href="/tweb/viviendas/formularioAgregarVivienda">AÑADIR VIVIENDA </a>
	      </li>
	    </ul>
	  </div>
	</nav>

		<c:forEach var="item" items="${viviendas}">
			<div class="px-4 py-2">
					<input class="form-check-input" type="radio" name="idVivienda" id="${item.id}" value="${item.id}">
					<label class="form-check-label" for="${item.id}">
						<div class="row"> 
							<div class="col">${item.direccion} (id vivienda:${item.id}) </div>
						</div>
					</label>
			</div>
		</c:forEach>
		<c:if test = "${error!=null}">
			<div class="alert alert-danger" role="alert">
				${error}
			</div>
		</c:if>
	
</form>
</body>
</html>