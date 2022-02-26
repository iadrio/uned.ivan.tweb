<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario para empleados</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilos.css"/>
</head>
<body>
	<form:form action="actualizarEmpleado" modelAttribute="empleado" method="POST">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Nombre: </td>
				<td><form:input path="nombre"/></td>
			</tr>
			
			<tr>
				<td>Apellido1: </td>
				<td><form:input path="apellido1"/></td>
			</tr>
			
			<tr>
				<td>Apellido2: </td>
				<td><form:input path="apellido2"/></td>
			</tr>
			
			<tr>
				<td>email: </td>
				<td><form:input path="email"/></td>
			</tr>
			
			<tr>
				<td>telefono: </td>
				<td><form:input path="telefono"/></td>
			</tr>
			
			<tr>
				<td>usuario: </td>
				<td><form:input path="usuario"/></td>
			</tr>
			
			<tr>
				<td>contraseña: </td>
				<td><form:input path="contraseña"/></td>
			</tr>
			
			<tr>
				<td>rol: </td>
				<td><form:radiobuttons path="rol" items = "${roles}"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="update/insert"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>