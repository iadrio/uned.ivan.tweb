<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Menu Arquitecto</title>
</head>
<body>

	<%@include file="components/miSesion.jsp" %> 

	<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
		<c:param name="clienteId" value="${userSession.user.id}"/>
	</c:url>
	<div class="row">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
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
	<div id="myGroup">
		<div class="collapse" id="proyectos" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">MIS  PROYECTOS ASIGNADOS </span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
							<th scope="col" data-sortable="true">FECHA SOLICITUD</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="estado" data-sortable="true">ESTADO</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col-2"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${proyectosAsignados}">
						<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
							<c:param name="proyectoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="presupuestar" value="/proyectos/formularioPresupuestar">
							<c:param name="proyectoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="iniciarConstruccion" value="/proyectos/iniciarConstruccion">
							<c:param name="proyectoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="finalizar" value="/proyectos/finalizar">
							<c:param name="proyectoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="añadirNota" value="/proyectos/anadirNota">
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
									<a href="${añadirNota}"><button type="button" class="btn btn-secondary">AÑADIR NOTA</button></a>
									<c:if test="${item.esCancelable()}"> 
										<a href="${cancelar}"><button type="button" class="btn btn-secondary">CANCELAR</button></a>
									</c:if>
									<c:if test="${item.esPresupuestable()}"> 
										<a href="${presupuestar}"><button type="button" class="btn btn-secondary">PRESUPUESTAR</button></a>
									</c:if>
									<c:if test="${item.esFinalizable()}"> 
										<a href="${finalizar}"><button type="button" class="btn btn-secondary">FINALIZAR</button></a>
									</c:if>
									<c:if test="${item.esIniciable()}"> 
										<a href="${iniciarConstruccion}"><button type="button" class="btn btn-secondary">INICIAR CONSTRUCCIÓN</button></a>
									</c:if>
									
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
						
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">PROYECTOS</span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
							<th scope="col" data-sortable="true">FECHA SOLICITUD</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="estado" data-sortable="true">ESTADO</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col-2"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${proyectosTodos}">
						<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
							<c:param name="proyectoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="linkAsignarProyecto" value="/proyectos/asignarProyecto">
							<c:param name="proyectoId" value="${item.id}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado }</td>
							<td>${item.tipo }</td>
							<td class="text-end">
								<a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a>
								<a href="${linkAsignarProyecto}"><button type="button" class="btn btn-secondary">ASIGNAR</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<div class="collapse" id="certificados" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">MIS  CERTIFICADOS ASIGNADOS </span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
							<th scope="col" data-sortable="true">FECHA SOLICITUD</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="estado" data-sortable="true">ESTADO</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col-2"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${certificadosAsignados}">
						<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="presupuestar" value="/certificados/formularioPresupuestar">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="finalizar" value="/certificados/formularioFinalizar">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="registrarVisita" value="/certificados/registrarVisita">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="cancelar" value="/certificados/cancelarCertificado">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="añadirNota" value="/certificados/anadirNota">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.vivienda.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado }</td>
							<td>${item.tipo }</td>
							<td class="text-end">
								<a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a>
								<c:if test="${item.esEditable()}"> 
									<a href="${añadirNota}"><button type="button" class="btn btn-secondary">AÑADIR NOTA</button></a>
									<c:if test="${item.esPresupuestable()}"> 
										<a href="${presupuestar}"><button type="button" class="btn btn-secondary">PRESUPUESTAR</button></a>
									</c:if>
									<c:if test="${item.esCancelable()}"> 
										<a href="${cancelar}"><button type="button" class="btn btn-secondary">CANCELAR</button></a>
									</c:if>
									<c:if test="${item.esFinalizable()}"> 
										<a href="${finalizar}"><button type="button" class="btn btn-secondary">FINALIZAR</button></a>
									</c:if>
									<c:if test="${item.esVisitable()}"> 
										<a href="${registrarVisita}"><button type="button" class="btn btn-secondary">REGISTRAR VISITA</button></a>
									</c:if>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">CERTIFICADOS</span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
							<th scope="col" data-sortable="true">FECHA SOLICITUD</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="estado" data-sortable="true">ESTADO</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col-2"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${certificadosTodos}">
						<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="linkAsignarCertificado" value="/certificados/asignarCertificado">
							<c:param name="certificadoId" value="${item.id}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.vivienda.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado }</td>
							<td>${item.tipo }</td>
							<td class="text-end">
								<a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a>
								<c:if test="${item.esEditable()}"> 
									<a href="${linkAsignarCertificado}"><button type="button" class="btn btn-secondary">ASIGNAR</button></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>