<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
</head>
<body>
			<div class="row">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				  <div class="container-fluid">
				    <ul class="navbar-nav">
				    	<span class="navbar-text">DATOS DEL PROYECTO</span>
				    	<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#datosCliente" role="button" aria-expanded="true" aria-controls="datosCliente" data-parent="#myGroup">
							VER DATOS DEL CLIENTE
				  		</a>
				  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#datosEmpleado" role="button" aria-expanded="true" aria-controls="datosEmpleado" data-parent="#myGroup">
							VER DATOS DEL EMPLEADO ASIGNADO
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
		    	    ${proyecto.id}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	TIPO
			    </div>
			    <div class="col-sm-2">
			    	${proyecto.tipo}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	ESTADO
			    </div>
			    <div class="col-sm-2">
			    	${proyecto.estado}
			    </div>
			</div>
			<div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
			    	FECHA SOLICITUD 
			    </div>
			    <div class="col-sm-2" >
			    	${proyecto.fechaSolicitud}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	FECHA INICIO CONSTRUCCION 
			    </div>
			    <div class="col-sm-2" >
			    	${proyecto.fechaInicioConstruccion}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	FECHA FIN 
			    </div>
			    <div class="col-sm-2" >
			    	${proyecto.fechaFin}
			    </div>
			</div>
						<div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
			    	PRESUPUESTO(&euro;)
			    </div>
			    <div class="col-sm-2">
			    	${proyecto.coste}
			    </div>
			    <div class="col-sm-2 bg-secondary fw-bold">
			    	DURACIÓN PREVISTA 
			    </div>
			    <div class="col-sm-2" >
			    	${proyecto.duracionPrevista}
			    </div>
			</div>
			<div class="row">
				<div class="col-sm-2 bg-secondary fw-bold">
		    	    DIRECCION
			    </div>
			    <div class="col-sm-10" >
		    	    ${proyecto.direccion}
			    </div>
			</div>
		 	<c:choose>       
		        <c:when test = "${ proyecto.tipo== 'RESIDENCIAL'}">
		            <div class="row">
						<div class="col-sm-2 bg-secondary fw-bold">
				    	    PLANTAS
					    </div>
					    <div class="col-sm-2" >
				    	    ${proyecto.plantas}
					    </div>
					    <div class="col-sm-2 bg-secondary fw-bold">
					    	HABITACIONES
					    </div>
					    <div class="col-sm-2">
					    	${proyecto.habitaciones}
					    </div>
					    <div class="col-sm-2 bg-secondary fw-bold">
					    	BAÑOS
					    </div>
					    <div class="col-sm-2">
					    	${proyecto.banhos}
					    </div>
					</div>
		        </c:when>
		         
		        <c:when test = "${proyecto.tipo== 'NO_RESIDENCIAL'}">
		            datos proyecto no residencial
		        </c:when>
		        <c:when test = "${proyecto.tipo== 'REHABILITACION'}">
		            datos rehabilitacion
		        </c:when>
		        <c:otherwise>
		        </c:otherwise>
		    </c:choose>
			<div id="myGroup">
		  		<div class="collapse" id="datosCliente" data-bs-parent="#myGroup">
					<c:set value="${proyecto.cliente}" var="usuario" />
					<%@include file="fichaCliente.jsp" %>
				</div>
				<div class="collapse" id="datosEmpleado" data-bs-parent="#myGroup">
					<c:set value="${proyecto.empleado}" var="usuario" />
					<%@include file="fichaCliente.jsp" %>
				</div>
			</div>		
		
		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>