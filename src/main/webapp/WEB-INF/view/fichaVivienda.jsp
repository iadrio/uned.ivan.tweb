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
		    	<span class="navbar-text">DATOS DE LA VIVIENDA</span>
		    	<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#datosCliente" role="button" aria-expanded="true" aria-controls="datosCliente" data-parent="#myGroup">
					VER DATOS DEL CLIENTE
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#certificados" role="button" aria-expanded="true" aria-controls="certificados" data-parent="#myGroup">
					VER CERTIFICADOS
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#proyectos" role="button" aria-expanded="true" aria-controls="proyectos" data-parent="#myGroup">
					VER PROYECTOS
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
    	    ${vivienda.id}
	    </div>
	    <div class="col-sm-2 bg-secondary fw-bold">
	    	DIRECCION
	    </div>
	    <div class="col-sm-2">
	    	${vivienda.direccion}
	    </div>
	</div>

	<div id="myGroup">
  		<div class="collapse" id="datosCliente" data-bs-parent="#myGroup">
			<c:set value="${vivienda.cliente}" var="usuario" />
			<%@include file="fichaUsuario.jsp" %>
		</div>
		<div class="collapse" id="certificados" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">CERTIFICADOS DE LA VIVIENDA</span>
			 
			    </ul>
			    <ul class="d-flex navbar-nav">
				     <a class="nav-link active" href="<%=request.getContextPath()%>/certificados/formularioSeleccionCertificado">SOLICITAR NUEVO CERTIFICADO </a>
			     </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col" data-sortable="true">FECHA SOLICITUD</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="id_vivienda" data-sortable="true">ID_VIVIENDA</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="estado" data-sortable="true">ESTADO</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${vivienda.certificados}">
					<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
						<c:param name="certificadoId" value="${item.id}"/>
						<c:param name="tipo" value="${item.tipo}"/>
					</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.tipo.toString() }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.vivienda.id }</td>
							<td>${item.estado }</td>
							<td class="text-end"><a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<div class="collapse" id="proyectos" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">PROYECTOS DE LA VIVIENDA</span>
			    </ul>
			    <ul class="d-flex navbar-nav">
			        <a class="nav-link active" href="<%=request.getContextPath()%>/proyectos/formularioSeleccionProyecto">SOLICITAR NUEVO PROYECTO</a>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table"data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col" data-sortable="true">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
							<th scope="col" data-sortable="true">FECHA SOLICITUD</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="estado" data-sortable="true">ESTADO</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="proyectos">
						<c:forEach var="item" items="${vivienda.proyectos}">
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
								<td class="text-end"><a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>