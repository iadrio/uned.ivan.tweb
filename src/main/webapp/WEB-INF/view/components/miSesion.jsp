<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
<nav class="navbar navbar-expand-sm bg-secondary navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
        <li class="nav-item">
        	<a class="nav-link active">USUARIO: ${userSession.user.usuario}</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link active">ROL: ${userSession.user.rol }</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link active">NOMBRE: ${userSession.user.nombre}</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link active">${userSession.user.apellido1}</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link active">${userSession.user.apellido2}</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link active">CONTACTO: ${userSession.user.email}</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link active">${userSession.user.telefono}</a>
        </li>
    </ul>
    <ul class="d-flex navbar-nav">
    	<a class="nav-link active" href="<%=request.getContextPath()%>">INICIO</a>
    	<a class="nav-link active" href="<%=request.getContextPath()%>/usuarios/menu">MENU</a>
    	<a class="nav-link active" href="<%=request.getContextPath()%>/login/formularioLogin">CAMBIAR DE USUARIO</a>
	    <a class="nav-link active" href="${linkActualizar}">EDITAR MI USUARIO</a>
    	<a class="nav-link active" href="<%=request.getContextPath()%>/login/cerrarSession">CERRAR SESION</a>
    </ul>
  </div>
</nav>

</body>
</html>