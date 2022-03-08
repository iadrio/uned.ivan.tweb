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

DATOS DE USUARIO
	<table>
	<tr>
		<th>usuario: ${userSession.user.usuario}</th>
	</tr>
	<tr>
		<th>nombre: ${userSession.user.nombre }</th>
	</tr>
	<tr>
		<th>apellido1: ${userSession.user.apellido1 }</th>
	</tr>
	<tr>
		<th>apellido2: ${userSession.user.apellido2 }</th>
	</tr>
	<tr>
		<th>telefono: ${userSession.user.telefono }</th>
	</tr>
	<tr>
		<th>email: ${userSession.user.email }</th>
	</tr>
	</table>
	

	<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
	<a href="/tweb/proyectos/formularioSeleccionProyecto"><button type="button">Solicitar un nuevo proyecto</button></a>
	<a href="/tweb/usuarios/formularioAgregarCliente"><button type="button">Solicitar un nuevo certificado</button></a>
	<a href="${linkActualizar}"><button type="button">Modificar mis datos</button></a>
	<a href="/tweb/login/formularioLogin"><button type="button">Cambiar de usuario</button></a>
	<a href="/tweb/login/cerrarSession"><button type="button">Cerrar sesion</button></a>
	</br>
MIS ULTIMOS CERTIFICADOS
	<table>

	</table>
	
	</br>
MIS ULTIMOS PROYECTOS
	<table>
			<tr>
				<th>Id</th>
				<th>Direccion</th>
				<th>Fecha solicitud</th>
				<th>Estado</th>
				<th>Tipo de proyecto</th>
			</tr>
		<c:forEach var="item" items="${proyectos}">
		<c:url var="linkFichaProyecto" value="/Proyectos/verProyecto">
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