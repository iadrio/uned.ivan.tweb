<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>Menu Cliente</title>
</head>
<body>
	<%@include file="components/miSesion.jsp" %>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">MIS  CERTIFICADOS: </span>
	      <li class="nav-item">
	        <a class="nav-link active" href="/tweb/certificados/formularioSeleccionCertificado">SOLICITAR NUEVO CERTIFICADO </a>
	      </li>
	    </ul>
	  </div>
	</nav>	
	<div class="table-responsive">
		<table class="table">
			<thead class="table-secondary" >
				<tr>
					<th scope="col">ID</th>
					<th scope="col">TIPO</th>
					<th scope="col">FECHA SOLICITUD</th>
					<th scope="col">VIVIENDA</th>
					<th scope="col">ESTADO</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach var="item" items="${certificados}">
			<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
				<c:param name="certificadoId" value="${item.id}"/>
				<c:param name="tipo" value="${item.tipo}"/>
			</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.tipo.toString() }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.vivienda.id }</td>
					<td>${item.estado }</td>
					<td><a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">MIS  PROYECTOS: </span>
	      <li class="nav-item">
	        <a class="nav-link active" href="/tweb/proyectos/formularioSeleccionProyecto">SOLICITAR NUEVO PROYECTO</a>
	      </li>
	    </ul>
	  </div>
	</nav>	
	<div class="table-responsive">
		<table class="table">
			<thead class="table-secondary" >
				<tr>
					<th scope="col">ID</th>
					<th scope="col">DIRECCION</th>
					<th scope="col">FECHA SOLICITUD</th>
					<th scope="col">ESTADO</th>
					<th scope="col">TIPO</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach var="item" items="${proyectos}">
			<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
				<c:param name="proyectoId" value="${item.id}"/>
				<c:param name="tipo" value="${item.tipo}"/>
			</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.direccion }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.estado }</td>
					<td>${item.tipo }</td>
					<td><a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">MIS  VIVIENDAS: </span>
	      <li class="nav-item">
	        <a class="nav-link active" href="/tweb/viviendas/formularioAgregarVivienda">AÑADIR VIVIENDA</a>
	      </li>
	    </ul>
	  </div>
	</nav>	 
	<div class="table-responsive">
		<table class="table">
			<thead class="table-secondary" >
				<tr>
					<th scope="col">ID</th>
					<th scope="col">DIRECCION</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach var="item" items="${viviendas}">
			<c:url var="linkFichaVivienda" value="/viviendas/verVivienda">
				<c:param name="viviendaId" value="${item.id}"/>
			</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.direccion }</td>
					<td><a href="${linkFichaVivienda}"><button type="button" class="btn btn-secondary">VER VIVIENDA</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>