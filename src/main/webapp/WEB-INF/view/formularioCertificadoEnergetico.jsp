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
	<form:form action="anadirCertificado" modelAttribute="certificado" method="POST">
	<input type="hidden" name="tipo" value="certificado energetico"/>
		<table>
			<tr>
				<td>otrosDatos: </td>
				<td><form:input path="otrosDatos"/></td>
			</tr>
			<tr>
				<td>categoria: </td>
				<td><form:input path="categoria"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="solicitar certificado"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>