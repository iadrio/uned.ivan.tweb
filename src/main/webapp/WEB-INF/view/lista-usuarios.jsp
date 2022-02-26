<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilos.css"/>

</head>
<body>
DATOS DE LA SESION
	<table>
	<tr>
		<th>Usuario</th>
		<th>Rol</th>
		<th>Tipo</th>
	</tr>
		<tr>
			<td>${userSession.usuario }</td>
			<td>${userSession.rol }</td>
			<td>${userSession.empleado }</td>
		</tr>
	<table>
Estos son los empleados

<table>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Apellido 1</th>
		<th>Apellido 2</th>
		<th>Email</th>
		<th>Usuario</th>
		<th>Contraseña</th>
		<th>Rol</th>
	</tr>
	
	<c:forEach var="item" items="${empleados}">
		<c:url var="linkActualizar" value="/usuarios/formularioActualizarEmpleado">
			<c:param name="clienteId" value="${item.id}"/>
		</c:url>
		<c:url var="linkEliminar" value="/usuarios/eliminarEmpleado">
			<c:param name="clienteId" value="${item.id}"/>
		</c:url>
		<tr>
			<td>${item.id }</td>
			<td>${item.nombre }</td>
			<td>${item.apellido1 }</td>
			<td>${item.apellido2 }</td>
			<td>${item.email }</td>
			<td>${item.usuario }</td>
			<td>${item.contraseña }</td>
			<td>${item.rol }</td>
			<td><a href="${linkActualizar}"><button type="button">modificar</button></a></td>
			<td><a href="${linkEliminar}"><button type="button" onClick="if(!confirm('estas seguro?')) return false">borrar</button></a></td>
		
		</tr>
	</c:forEach>
</table>

</br></br></br>
Estos son los clientes

<table>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Apellido 1</th>
		<th>Apellido 2</th>
		<th>Email</th>
		<th>Usuario</th>
		<th>Contraseña</th>
	</tr>
	
	<c:forEach var="item" items="${clientes}">
		<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
			<c:param name="clienteId" value="${item.id}"/>
		</c:url>
		<c:url var="linkEliminar" value="/usuarios/eliminarCliente">
			<c:param name="clienteId" value="${item.id}"/>
		</c:url>
		<tr>
			<td>${item.id }</td>
			<td>${item.nombre }</td>
			<td>${item.apellido1 }</td>
			<td>${item.apellido2 }</td>
			<td>${item.email }</td>
			<td>${item.usuario }</td>
			<td>${item.contraseña }</td>	
			<td><a href="${linkActualizar}"><button type="button">modificar</button></a></td>
			<td><a href="${linkEliminar}"><button type="button" onClick="if(!confirm('estas seguro?')) return false">borrar</button></a></td>
		
		</tr>
	</c:forEach>
</table>
<button type="button"  onclick="window.location.href='formularioAgregarCliente';return false;"/> Agregar Cliente </button>
<button type="button"  onclick="window.location.href='formularioAgregarEmpleado';return false;"/> Agregar Empleado </button>
<a href="/tweb/login/formularioLogin"><button type="button">cambiar de usuario</button></a>


</body>
</html>