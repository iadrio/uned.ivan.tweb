<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="components/miSesion.jsp" %> 
	<%@include file="components/fichaProyecto.jsp" %> 
	<table>
		<tr>
			<th>finalidad: ${proyecto.finalidad}</th>
		</tr>
	</table>
</body>
</html>