<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<title>Menu Arquitecto</title>
</head>
<body>

	<%@include file="components/miSesion.jsp" %> 

	<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">MIS  PROYECTOS ASIGNADOS </span>
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
					<th scope="col-2"></th>
				</tr>
			</thead>
			<c:forEach var="item" items="${proyectosAsignados}">
				<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="presupuestar" value="/proyectos/formularioPresupuestar">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="iniciarConstruccion" value="/proyectos/iniciarConstruccion">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="finalizar" value="/proyectos/finalizar">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="añadirNota" value="/proyectos/anadirNota">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.direccion }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.estado }</td>
					<td>${item.tipo }</td>
					<td class="text-end">
						<a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a>
						<a href="${añadirNota}"><button type="button" class="btn btn-secondary">AÑADIR NOTA</button></a>
						<c:choose>
							<c:when test="${item.estado=='ASIGNADO'}"> 
								<a href="${presupuestar}"><button type="button" class="btn btn-secondary">PRESUPUESTAR</button></a>
							</c:when>
							<c:when test="${item.estado=='EN_CURSO'}"> 
								<a href="${finalizar}"><button type="button" class="btn btn-secondary">FINALIZAR</button></a>
							</c:when >
							<c:when test="${item.estado=='PRESUPUESTADO'}">
								<a href="${iniciarConstruccion}"><button type="button" class="btn btn-secondary">INICIAR CONSTRUCCIÓN</button></a>
							</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">PROYECTOS SIN ASIGNAR </span>
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
					<th scope="col-2"></th>
				</tr>
			</thead>
			<c:forEach var="item" items="${proyectosSinAsignar}">
				<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="linkAsignarProyecto" value="/proyectos/asignarProyecto">
					<c:param name="proyectoId" value="${item.id}"/>
				</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.direccion }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.estado }</td>
					<td>${item.tipo }</td>
					<td class="text-end">
						<a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a>
						<a href="${linkAsignarProyecto}"><button type="button" class="btn btn-secondary">ASIGNAR</button></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">PROYECTOS TERMINADOS</span>
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
			<c:forEach var="item" items="${proyectosFinalizados}">
				<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="linkAsignarProyecto" value="/proyectos/asignarProyecto">
					<c:param name="proyectoId" value="${item.id}"/>
				</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.direccion }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.estado }</td>
					<td>${item.tipo }</td>
					<td class="text-end"><a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>