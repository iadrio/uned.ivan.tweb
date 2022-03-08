<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Apellido 1</th>
		<th>Apellido 2</th>
		<th>Email</th>
		<th>Usuario</th>
		<th>Contraseña</th>
	</tr>
	
	<c:forEach var="item" items="${clientes}">

		<tr>
			<td>${item.id }</td>
			<td>${item.nombre }</td>
			<td>${item.apellido1 }</td>
			<td>${item.apellido2 }</td>
			<td>${item.email }</td>
			<td>${item.usuario }</td>
			<td>${item.contraseña }</td>			
		</tr>
	</c:forEach>
</body>
</html>