<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.18.1/bootstrap-table.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.18.1/extensions/filter-control/bootstrap-table-filter-control.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.18.1/bootstrap-table.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.18.1/extensions/filter-control/bootstrap-table-filter-control.min.js" ></script>
<title>Menu Cliente</title>
</head>
<body>
	<%@include file="components/miSesion.jsp" %>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	    	<span class="navbar-text">MIS  CERTIFICADOS </span>
	 
	    </ul>
	    <ul class="d-flex navbar-nav">
		     <a class="nav-link active" href="/tweb/certificados/formularioSeleccionCertificado">SOLICITAR NUEVO CERTIFICADO </a>
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
			<c:forEach var="item" items="${certificados}">
			<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
				<c:param name="certificadoId" value="${item.id}"/>
				<c:param name="tipo" value="${item.tipo}"/>
			</c:url>
			<c:url var="linkFichaCertificadoPDF" value="/certificados/verCertificadoPDF">
				<c:param name="certificadoId" value="${item.id}"/>
			</c:url>
			<c:url var="cancelar" value="/certificados/cancelarCertificado">
				<c:param name="certificadoId" value="${item.id}"/>
				<c:param name="tipo" value="${item.tipo}"/>
			</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.tipo.toString() }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.vivienda.id }</td>
					<td>${item.estado }</td>
					<td class="text-end">
						<a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a>
						<a href="${linkFichaCertificadoPDF}"><button type="button" class="btn btn-secondary">VER PDF</button></a>
						<c:if test="${item.esEditable()}"> 
							<c:if test="${item.esCancelable()}"> 
								<a href="${cancelar}"><button type="button" class="btn btn-secondary">CANCELAR</button></a>
							</c:if>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	  	<span class="navbar-text">MIS  PROYECTOS</span>
	   	<ul class="d-flex navbar-nav">
	        <a class="nav-link active" href="/tweb/proyectos/formularioSeleccionProyecto">SOLICITAR NUEVO PROYECTO</a>
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
				<c:forEach var="item" items="${proyectos}">
				<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<c:url var="cancelar" value="/proyectos/cancelar">
					<c:param name="proyectoId" value="${item.id}"/>
					<c:param name="tipo" value="${item.tipo}"/>
				</c:url>
				<tr>
					<td>${item.id }</td>
					<td>${item.direccion }</td>
					<td>${item.fechaSolicitud }</td>
					<td>${item.estado }</td>
					<td>${item.tipo }</td>
					<td class="text-end">
						<a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a>
						<c:if test="${item.esEditable()}"> 
							<c:if test="${item.esCancelable()}"> 
								<a href="${cancelar}"><button type="button" class="btn btn-secondary">CANCELAR</button></a>
							</c:if>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="d-flex navbar-nav">
	    	<span class="navbar-text">MIS  VIVIENDAS</span>
	    </ul>
	    <form class="form-inline" action="/tweb/viviendas/anadirVivienda" method="get">
	    	<div class="row">
	    		<div class="col" >
	    			<input class="form-control w-auto" name="direccion" required="required" type="direccion" placeholder="Dirección Nueva vivienda" aria-label="Search">
			    </div>
			   	<div class="col" >
			    	<input class="btn btn-dark"  type="submit"  value="AÑADIR VIVIENDA" />
			    </div>
		    </div>
		</form>
	  </div>
	</nav>	 
	
	<div class="table-responsive">
		<table class="table" data-toggle="table" data-filter-control="true">
			<thead class="table-secondary" >
				<tr>
					<th>ID</th>
					<th data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody id="viviendas">
				<c:forEach var="item" items="${viviendas}">
				<c:url var="linkFichaVivienda" value="/viviendas/verVivienda">
					<c:param name="viviendaId" value="${item.id}"/>
				</c:url>
					<tr>
						<td>${item.id }</td>
						<td>${item.direccion }</td>
						<td class="text-end"><a href="${linkFichaVivienda}"><button type="button" class="btn btn-secondary">VER VIVIENDA</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:if test = "${error!=null}">
		<div class="alert alert-danger" role="alert">
			${error}
		</div>
	</c:if>
</body>
</html>