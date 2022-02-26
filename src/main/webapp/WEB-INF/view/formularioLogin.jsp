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
				<td>¿Quieres iniciar sesión como empleado o como cliente?</td>
				<td><form:radiobutton path="empleado" label="Empleado" value="true"/>  </td>
				<td><form:radiobutton path="empleado" label="Cliente" value="false"/>  </td>
			</tr>
			
		</table>

		<tr>
			<td colspan="2"><input type="submit" value="login"></td>
		</tr>
	</form:form>
	<a href="/tweb/usuarios/formularioAgregarCliente"><button type="button">Registrarse como cliente</button></a>
</body>
</html>