<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="components/miSesion.jsp" %> 

	<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
	<a href="${linkActualizar}"><button type="button">Modificar mis datos</button></a>
	<a href="/tweb/login/formularioLogin"><button type="button">Cambiar de usuario</button></a>
	<a href="/tweb/login/cerrarSession"><button type="button">Cerrar sesion</button></a>

	</br>	
	</br>
MIS  PROYECTOS ASIGNADOS
	<table>
			<tr>
				<th>Id</th>
				<th>Direccion</th>
				<th>Fecha solicitud</th>
				<th>Estado</th>
				<th>Tipo de proyecto</th>
			</tr>
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
				<td>${item.estado.toString() }</td>
				<td>${item.tipo.toString() }</td>
				<td><a href="${linkFichaProyecto}"><button type="button">ver proyecto</button></a></td>
				<td><a href="${añadirNota}"><button type="button">añadir nota</button></a></td>
				<c:choose>
					<c:when test="${item.estado=='ASIGNADO'}"> 
						<td><a href="${presupuestar}"><button type="button">presupuestar</button></a></td>
					</c:when>
					<c:when test="${item.estado=='EN_CURSO'}"> 
						<td><a href="${finalizar}"><button type="button">finalizar</button></a></td>
					</c:when >
					<c:when test="${item.estado=='PRESUPUESTADO'}">
						<td><a href="${iniciarConstruccion}"><button type="button">iniciar construccion</button></a></td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
PROYECTOS SIN ASIGNAR
	<table>
			<tr>
				<th>Id</th>
				<th>Direccion</th>
				<th>Fecha solicitud</th>
				<th>Estado</th>
				<th>Tipo de proyecto</th>
			</tr>
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
				<td><a href="${linkFichaProyecto}"><button type="button">ver proyecto</button></a></td>
				<td><a href="${linkAsignarProyecto}"><button type="button">asignar</button></a></td>
			</tr>
		</c:forEach>
	</table>
PROYECTOS TERMINADOS
	<table>
			<tr>
				<th>Id</th>
				<th>Direccion</th>
				<th>Fecha solicitud</th>
				<th>Estado</th>
				<th>Tipo de proyecto</th>
			</tr>
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
				<td><a href="${linkFichaProyecto}"><button type="button">ver proyecto</button></a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>