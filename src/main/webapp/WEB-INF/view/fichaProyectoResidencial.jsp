<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<th>plantas: ${proyecto.plantas}</th>
		</tr>
		<tr>
			<th>habitaciones: ${proyecto.habitaciones}</th>
		</tr>
		<tr>
			<th>baños: ${proyecto.banhos}</th>
		</tr>
	</table>
</body>
</html>