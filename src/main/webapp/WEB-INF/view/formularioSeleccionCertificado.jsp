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
<form  action="formularioAgregarCertificado" method="get">
	selecciona el tipo de certificado:
			</br>
	        <input type="radio" name=tipo value="certificado energetico"  required="required"/>Certificado Energético
	        <input type="radio" name=tipo value="informe pericial" />Informe pericial
	<input type="submit" value="Siguiente" />
</form>
</body>
</html>