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
				<td>superficie de terreno de la parcela: </td>
				<td><form:input path="superficieTerreno"/></td>
			</tr>
			
			<tr>
				<td>superficie de terreno que se quiere construir: </td>
				<td><form:input path="superficieEdificio"/></td>
			</tr>
			
			<tr>
				<td>número de plantas en las que se va a distribuir: </td>
				<td><form:input path="plantas"/></td>
			</tr>
			
			<tr>
				<td>número de habitaciones: </td>
				<td><form:input path="habitaciones"/></td>
			</tr>
			
			<tr>
				<td>número de baños: </td>
				<td><form:input path="banhos"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="solicitar proyecto"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>