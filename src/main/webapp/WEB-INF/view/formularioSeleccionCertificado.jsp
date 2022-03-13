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
SELECCIONA EL TIPO DE CERTIFICADO
	<c:forEach var="item" items="${tiposCertificado}">
		</br><input type="radio" name=tipo value="${item}" required="required"/> ${item.toString()} 
	</c:forEach>
</br>
SELECCIONA LA  VIVIENDA
	<table>
		<c:forEach var="item" items="${viviendas}">
			</br>
			<input type="radio" name=idVivienda value="${item.id}" id:> id:${item.id}  direccion:${item.direccion}
		</c:forEach>
	</table>	
	</br>
	<input type="submit" value="Solicitar el certificado" />
	<a href="/tweb/viviendas/formularioAgregarVivienda"><button type="button">Añadir vivienda</button></a>
	
	${error}
</form>
</body>
</html>