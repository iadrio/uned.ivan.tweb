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

PROYECTO: ${proyecto.id}
	<table>
	<tr>
		<th>cliente: ${proyecto.cliente}</th>
	</tr>
	<tr>
		<th>arquitecto asignado: ${proyecto.empleado}</th>
	</tr>
	<tr>
		<th>fechaSolicitud: ${proyecto.fechaSolicitud}</th>
	</tr>
	<tr>
		<th>fechaInicioConstruccion: ${proyecto.fechaInicioConstruccion}</th>
	</tr>
	<tr>
		<th>duracionPrevista: ${proyecto.duracionPrevista}</th>
	</tr>
	<tr>
		<th>fechaFin: ${proyecto.fechaFin}</th>
	</tr>
	<tr>
		<th>coste: ${proyecto.coste}</th>
	</tr>
	<tr>
		<th>direccion: ${proyecto.direccion}</th>
	</tr>
	
	<tr>
		<th>tipo: ${proyecto.tipo}</th>
	</tr>
	

	</table>
</body>
</html>