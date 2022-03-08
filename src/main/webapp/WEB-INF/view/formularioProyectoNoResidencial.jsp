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
	<input type="hidden" name="tipo" value="no residencial"/>
		<table>
			<tr>
				<td>superficie de terreno de la parcela: </td>
				<td><form:input path="superficieTerreno"/></td>
			</tr>
			
			<tr>
				<td>superficie del edificio: </td>
				<td><form:input path="superficieEdificio"/></td>
			</tr>
			
			<tr>
				<td>finalidad de la obra: </td>
				<td><form:input path="finalidad"/></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="solicitar proyecto"></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>