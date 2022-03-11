<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="checkLogin" modelAttribute="userSession" method="POST">

		<table>
			<tr>
				<td>usuario: </td>
				<td><form:input path="usuario"/></td>
			</tr>
			
			<tr>
				<td>contraseña: </td>
				<td><form:password path="contraseña"/></td>
			</tr>
			
			<tr>
				<td colspan="1"><input type="submit" value="login"></td>
				<td><a href="/tweb/usuarios/formularioAgregarCliente"><button type="button">Nuevo Cliente</button></a></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>