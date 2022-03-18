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
	<%@include file="components/miSesion.jsp" %>
	<form:form action="presupuestar" modelAttribute="proyecto" method="POST">
	<form:hidden path="tipo" value ="${proyecto.tipo.name()}" />
	<form:hidden path="id" value ="${proyecto.id}" />
		<table>
			<tr>
				<td>duracion prevista: </td>
				<td><form:input path="duracionPrevista"/></td>
			</tr>
			<tr>
				<td>coste: </td>
				<td><form:input path="coste"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="solicitar proyecto"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>