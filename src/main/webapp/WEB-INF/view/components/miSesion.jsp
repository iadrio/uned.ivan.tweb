<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<tr>
		<th>rol: ${userSession.user.rol }</th>
	</tr>
	</table>
</body>
</html>