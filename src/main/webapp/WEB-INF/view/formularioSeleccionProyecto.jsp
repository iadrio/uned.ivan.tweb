<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form  action="formularioAgregarProyecto" method="get">
		SELECCIONA EL TIPO DE PROYECTO
			<c:forEach var="item" items="${tiposProyecto}">
				</br><input type="radio" name=tipo value="${item}" required="required"/> ${item.toString()} 
			</c:forEach>
			</br>
			<input type="submit" value="Solicitar el certificado" />
		</br>
	</form>
</body>
</html>