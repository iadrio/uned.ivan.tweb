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
	<form:form action="anadirProyecto" modelAttribute="proyecto" method="POST">
	<form:hidden path="tipo" value ="${proyecto.tipo.name()}" />
		<table>
			<tr>
				<td>direccion: </td>
				<td><form:input path="direccion"/></td>
			</tr>
			<tr>
				<td>superficie a reformar: </td>
				<td><form:input path="superficieReforma"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="solicitar proyecto"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>