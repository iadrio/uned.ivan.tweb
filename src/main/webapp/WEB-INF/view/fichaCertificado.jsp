<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
</head>
<body>
	<%@include file="components/miSesion.jsp" %> 
	<div class="row">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
		    	<span class="navbar-text">DATOS DEL CERTIFICADO</span>
		    	<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#datosCliente" role="button" aria-expanded="true" aria-controls="datosCliente" data-parent="#fichaCertificado">
					VER DATOS DEL CLIENTE
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#datosEmpleado" role="button" aria-expanded="true" aria-controls="datosEmpleado" data-parent="#fichaCertificado">
					VER DATOS DEL EMPLEADO ASIGNADO
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#datosVivienda" role="button" aria-expanded="true" aria-controls="datosVivienda" data-parent="#fichaCertificado">
					VER DATOS DE LA VIVIENDA
		  		</a>
		    </ul>
		  </div>
		</nav>
	</div>
	<div class="row">
		<div class="col-sm-2 bg-secondary fw-bold">
    	    ID
	    </div>
	    <div class="col-sm-2" >
    	    ${certificado.id}
	    </div>
	    <div class="col-sm-2 bg-secondary fw-bold">
	    	TIPO
	    </div>
	    <div class="col-sm-2">
	    	${certificado.tipo}
	    </div>
	    <div class="col-sm-2 bg-secondary fw-bold">
	    	ESTADO
	    </div>
	    <div class="col-sm-2">
	    	${certificado.estado}
	    </div>
	</div>
	<div class="row">
		<div class="col-sm-2 bg-secondary fw-bold">
	    	FECHA SOLICITUD 
	    </div>
	    <div class="col-sm-2" >
	    	${certificado.fechaSolicitud}
	    </div>
	    <div class="col-sm-2 bg-secondary fw-bold">
	    	FECHA ENTREGA 
	    </div>
	    <div class="col-sm-2" >
	    	${certificado.fechaEntrega}
	    </div>
	    <div class="col-sm-2 bg-secondary fw-bold">
	    	PRESUPUESTO(&euro;)
	    </div>
	    <div class="col-sm-2">
	    	${certificado.precio}
	    </div>
	</div>
	<div class="row">
		<div class="col-sm-2 bg-secondary fw-bold">
	    	ID VIVIENDA
	    </div>
	    <div class="col-sm-2" >
	    	${certificado.vivienda.id}
	    </div>
	    <div class="col-sm-2 bg-secondary fw-bold">
	    	DIRECCION
	    </div>
	    <div class="col-sm-6" >
	    	${certificado.vivienda.direccion}
	    </div>
	</div>
 	<c:choose>       
        <c:when test = "${ certificado.tipo== 'CERTIFICADO_ENERGETICO'}">
            <div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
		    	    CATEGORÍA
			    </div>
			    <div class="col-sm-2" >
		    	    ${certificado.categoria}
			    </div>
			</div>
        </c:when>
         
        <c:when test = "${ certificado.tipo== 'INFORME_PERICIAL'}">

        </c:when>
        <c:when test = "${ certificado.tipo== 'HABITABILIDAD'}">
           <div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
		    	    FECHA VISITA
			    </div>
			    <div class="col-sm-2" >
		    	    ${certificado.fechaVisita}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
		    	    FECHA CADUCIDAD
			    </div>
			    <div class="col-sm-2" >
		    	    ${certificado.fechaCaducidad}
			    </div>
			</div>
        </c:when>
        <c:when test = "${ certificado.tipo== 'INSPECCION_TECNICA'}">
            <div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
		    	    FECHA CADUCIDAD
			    </div>
			    <div class="col-sm-2" >
		    	    ${certificado.fechaCaducidad}
			    </div>
			</div>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
	<div class="row">
		<div class="col-sm-2 bg-secondary fw-bold">
	    	NOTAS
	    </div>
	    <div class="col-sm-22" >
	    	${certificado.otrosDatos}
	    </div>
	</div>
	<div id="fichaCertificado">
  		<div class="collapse" id="datosCliente" data-bs-parent="#fichaCertificado">
			<c:set value="${certificado.cliente}" var="usuario" />
			<%@include file="fichaUsuario.jsp" %>
		</div>
		<div class="collapse" id="datosEmpleado" data-bs-parent="#fichaCertificado">
			<c:set value="${certificado.arquitecto}" var="usuario" />
			<%@include file="fichaUsuario.jsp" %>
		</div>
		<div class="collapse" id="datosVivienda" data-bs-parent="#fichaCertificado">
			<c:set value="${certificado.vivienda}" var="vivienda" />
			<%@include file="fichaVivienda.jsp" %>
		</div>
	</div>		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>