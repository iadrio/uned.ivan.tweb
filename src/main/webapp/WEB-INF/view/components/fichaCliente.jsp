<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
</head>
<body>
			<div class="row">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  <div class="container-fluid">
				    <ul class="navbar-nav">
				    	<span class="navbar-text">DATOS DEL USUARIO</span>
				    	<a class="nav-link active">
							${usuario.rol}
				  		</a>
				    </ul>
				  </div>
				</nav>
			</div>
			<div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
		    	    ID
			    </div>
			    <div class="col-sm-2" >
		    	    ${usuario.id}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	USUARIO
			    </div>
			    <div class="col-sm-2">
			    	${usuario.usuario}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	NOMBRE
			    </div>
			    <div class="col-sm-2">
			    	${usuario.nombre}
			    </div>
			</div>
			<div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
		    	    APELLIDO 1
			    </div>
			    <div class="col-sm-2" >
		    	    ${usuario.apellido1}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	APELLIDO 2
			    </div>
			    <div class="col-sm-2">
			    	${usuario.apellido2}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	TELEFONO
			    </div>
			    <div class="col-sm-2">
			    	${usuario.telefono}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	EMAIL
			    </div>
			    <div class="col-sm-2">
			    	${usuario.email}
			    </div>
			</div>
			<div class="row">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  <div class="container-fluid">
				    <ul class="navbar-nav">
				    	<span class="navbar-text">PROYECTOS DEL USUARIO</span>
				    </ul>
				  </div>
				</nav>
			</div>
			<div class="table-responsive">
				<table class="table">
					<thead class="bg-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col">DIRECCION</th>
							<th scope="col">FECHA SOLICITUD</th>
							<th scope="col">ESTADO</th>
							<th scope="col">TIPO</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${usuario.proyectos}">
						<tr>
							<td>${item.id }</td>
							<td>${item.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado }</td>
							<td>${item.tipo }</td>
						</tr>
					</c:forEach>
				</table>
			</div>	
			<div class="row">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  <div class="container-fluid">
				    <ul class="navbar-nav">
				    	<span class="navbar-text">CERTIFICADOS DEL USUARIO</span>
				    </ul>
				  </div>
				</nav>
			</div>
			<div class="table-responsive">
				<table class="table">
					<thead class="bg-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col">TIPO</th>
							<th scope="col">FECHA SOLICITUD</th>
							<th scope="col">ID VIVIENDA</th>
							<th scope="col">ESTADO</th>
						</tr>
					</thead>
					<c:forEach var="item" items="${usuario.certificados}">
						<tr>
							<td>${item.id }</td>
							<td>${item.tipo.toString() }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.vivienda.id }</td>
							<td>${item.estado }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<c:if test="${usuario.rol == 'CLIENTE'}">
				<div class="row">
					<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
					  <div class="container-fluid">
					    <ul class="navbar-nav">
					    	<span class="navbar-text">VIVIENDAS DEL USUARIO</span>
					    </ul>
					  </div>
					</nav>
				</div>
				<div class="table-responsive">
					<table class="table">
						<thead class="bg-secondary" >
							<tr>
								<th scope="col">ID</th>
								<th scope="col">DIRECCION</th>
							</tr>
						</thead>
						<c:forEach var="item" items="${usuario.viviendas}">
							<tr>
								<td>${item.id }</td>
								<td>${item.direccion }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
</body>
</html>