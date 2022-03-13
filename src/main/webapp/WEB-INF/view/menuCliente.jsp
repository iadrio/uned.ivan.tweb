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

	<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
	<a href="/tweb/proyectos/formularioSeleccionProyecto"><button type="button">Solicitar un nuevo proyecto</button></a>
	<a href="/tweb/certificados/formularioSeleccionCertificado"><button type="button">Solicitar un nuevo certificado</button></a>
	<a href="/tweb/viviendas/formularioAgregarVivienda"><button type="button">A�adir vivienda</button></a>
	<a href="${linkActualizar}"><button type="button">Modificar mis datos</button></a>
	<a href="/tweb/login/formularioLogin"><button type="button">Cambiar de usuario</button></a>
	<a href="/tweb/login/cerrarSession"><button type="button">Cerrar sesion</button></a>

	</br>
	MIS  VIVIENDAS
	<table>
			<tr>
				<th>Id</th>
				<th>direccion</th>
			</tr>
		<c:forEach var="item" items="${viviendas}">
		<c:url var="linkFichaVivienda" value="/viviendas/verVivienda">
			<c:param name="viviendaId" value="${item.id}"/>
		</c:url>
			<tr>
				<td>${item.id }</td>
				<td>${item.direccion }</td>
				<td><a href="${linkFichaVivienda}"><button type="button">ver vivienda</button></a></td>
			</tr>
		</c:forEach>
	</table>
MIS  CERTIFICADOS
	<table>
			<tr>
				<th>Id</th>
				<th>Tipo</th>
				<th>Fecha solicitud</th>
				<th>Vivienda</th>
			</tr>
		<c:forEach var="item" items="${certificados}">
		<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
			<c:param name="certificadoId" value="${item.id}"/>
			<c:param name="tipo" value="${item.tipo}"/>
		</c:url>
			<tr>
				<td>${item.id }</td>
				<td>${item.tipo.toString() }</td>
				<td>${item.fechaSolicitud }</td>
				<td>${item.vivienda.id }</td>
				<td><a href="${linkFichaCertificado}"><button type="button">ver certificado</button></a></td>
			</tr>
		</c:forEach>
	</table>
	
	</br>
MIS  PROYECTOS
	<table>
			<tr>
				<th>Id</th>
				<th>Direccion</th>
				<th>Fecha solicitud</th>
				<th>Estado</th>
				<th>Tipo de proyecto</th>
			</tr>
		<c:forEach var="item" items="${proyectos}">
		<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
			<c:param name="proyectoId" value="${item.id}"/>
			<c:param name="tipo" value="${item.tipo}"/>
		</c:url>
			<tr>
				<td>${item.id }</td>
				<td>${item.direccion }</td>
				<td>${item.fechaSolicitud }</td>
				<td>${item.estado }</td>
				<td>${item.tipo }</td>
				<td><a href="${linkFichaProyecto}"><button type="button">ver proyecto</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>