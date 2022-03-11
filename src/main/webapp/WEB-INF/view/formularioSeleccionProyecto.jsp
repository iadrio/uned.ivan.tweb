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
	selecciona el tipo de proyecto:
			</br>
	        <input type="radio" name=tipo value="residencial"  required="required"/>Residencial
	        <input type="radio" name=tipo value="no residencial" />No residencial
	        <input type="radio" name=tipo value="rehabilitacion" />Rehabilitacion
	<input type="submit" value="Siguiente" />
</form>
</body>
</html>