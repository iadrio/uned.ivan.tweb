<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilos.css"/>

</head>
<body>
	<%@include file="components/miSesion.jsp" %>
	
	<c:url var="linkActualizarEmpleado" value="/usuarios/formularioActualizarEmpleado">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
	<c:url var="linkAgregarEmpleado" value="/usuarios/formularioAgregarEmpleado"> </c:url>
	<c:url var="linkActualizarCliente" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${item.id}"/>
	</c:url>
	<c:url var="linkAgregarCliente" value="/usuarios/formularioAgregarCliente"> </c:url>
	
	<a href="${linkActualizarEmpleado}"><button type="button">Modificar mis datos</button></a>
	<a href="/tweb/login/formularioLogin"><button type="button">Cambiar de usuario</button></a>
	<a href="/tweb/login/cerrarSession"><button type="button">Cerrar sesion</button></a>
</br>
</br>
CLIENTES
</br>
	<a href=""><button type="button">ver clientes pendientes de contactar</button></a>
	<a href="/tweb/usuarios/listaClientes"><button type="button">ver todos los clientes</button></a>
	<a href="${linkAgregarCliente}"><button type="button">Agregar cliente</button></a>
	<a href=""><button type="button">buscar cliente</button></a>
</br>
</br>
EMPLEADOS
</br>
	<a href="/tweb/usuarios/listaEmpleados"><button type="button">ver todos los empleados</button></a>
	<a href="${linkAgregarEmpleado}"><button type="button">alta nuevo empleado</button></a>
	<a href=""><button type="button">buscar empleado</button></a>

</body>
</html>