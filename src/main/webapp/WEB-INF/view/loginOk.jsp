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
	<tr>
		<td>${userSession.usuario }</td>
		<td>${userSession.rol }</td>
		<td>${userSession.empleado }</td>
	</tr>

	login correcto
	
	<form:form action="returnMenu" modelAttribute="userSession" method="POST">
		<form:hidden path="usuario"/>
		<form:hidden path="rol"/>
		<form:hidden path="empleado"/>
		<tr>
			<td colspan="2"><input type="submit" value="siguiente"></td>
		</tr>
	</form:form>
</body>
</html>