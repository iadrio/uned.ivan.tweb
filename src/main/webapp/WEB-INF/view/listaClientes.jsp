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
</body>
</html>