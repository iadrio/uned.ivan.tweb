<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario para clientes</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilos.css"/>
</head>
<body>
	<form:form action="anadirVivienda" modelAttribute="vivienda" method="POST">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Direccion: </td>
				<td><form:input path="direccion"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="update/insert"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>