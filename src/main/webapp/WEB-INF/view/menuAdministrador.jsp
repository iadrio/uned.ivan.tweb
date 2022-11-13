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
<title>Menu Administrador</title>
</head>
<body>

	<%@include file="components/miSesion.jsp" %> 

	<c:url var="linkAgregarUsuario" value="/usuarios/formularioAgregarUsuario"> </c:url>
	<div class="row">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <ul class="navbar-nav">
		    	<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#clientes" role="button" aria-expanded="true" aria-controls="clientes" data-parent="#myGroup">
					VER CLIENTES
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#empleados" role="button" aria-expanded="true" aria-controls="empleados" data-parent="#myGroup">
					VER EMPLEADOS
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#certificados" role="button" aria-expanded="true" aria-controls="certificados" data-parent="#myGroup">
					VER CERTIFICADOS
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#proyectos" role="button" aria-expanded="true" aria-controls="proyectos" data-parent="#myGroup">
					VER PROYECTOS
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#certificadosCaducados" role="button" aria-expanded="true" aria-controls="certificadosCaducados" data-parent="#myGroup">
					VER CERTIFICADOS CADUCADOS
		  		</a>
		  		<a class="nav-link active" data-bs-toggle="collapse" data-bs-target="#proyectosCaducados" role="button" aria-expanded="true" aria-controls="proyectosCaducados" data-parent="#myGroup">
					VER PROYECTOS RESIDENCIALES SIN CERTIFICADO
		  		</a>
		  		<a href="${linkAgregarUsuario}"><button type="button" class="btn btn-dark">AÑADIR USUARIO</button></a>
		    </ul>
		  </div>
		</nav>
	</div>
	<div id="myGroup">
		<div class="collapse" id="clientes" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">CLIENTES</span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
					
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="usuario" data-sortable="true">USUARIO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="nombre" data-sortable="true">NOMBRE</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="apellido" data-sortable="true">APELLIDO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="telefono" data-sortable="true">TELEFONO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="email" data-sortable="true">EMAIL</th>
							<th scope="col-2">
								
							</th>
						</tr>
					</thead>
					<c:forEach var="item" items="${clientes}">
						<c:url var="verCliente" value="/usuarios/verUsuario">
							<c:param name="usuarioId" value="${item.id}"/>
						</c:url>
						<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
							<c:param name="clienteId" value="${item.id}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.usuario }</td>
							<td>${item.nombre }</td>
							<td>${item.apellido1 }</td>
							<td>${item.telefono }</td>
							<td>${item.email }</td>
							<td class="text-center">
								<a href="${verCliente}"><button type="button" class="btn btn-secondary">VER CLIENTE</button></a>
								<a href="${linkActualizar}"><button type="button" class="btn btn-secondary">EDITAR CLIENTE</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="collapse" id="empleados" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">EMPLEADOS</span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
					
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="usuario" data-sortable="true">USUARIO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="nombre" data-sortable="true">NOMBRE</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="apellido" data-sortable="true">APELLIDO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="telefono" data-sortable="true">TELEFONO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="email" data-sortable="true">EMAIL</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="rol" data-sortable="true">ROL</th>
							<th scope="col-2">
								
							</th>
						</tr>
					</thead>
					<c:forEach var="item" items="${empleados}">
						<c:url var="verEmpleado" value="/usuarios/verUsuario">
							<c:param name="usuarioId" value="${item.id}"/>
						</c:url>
						<c:url var="linkActualizar" value="/usuarios/formularioActualizarCliente">
							<c:param name="clienteId" value="${item.id}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.usuario }</td>
							<td>${item.nombre }</td>
							<td>${item.apellido1 }</td>
							<td>${item.telefono }</td>
							<td>${item.email }</td>
							<td>${item.rol }</td>
							<td class="text-center">
								<a href="${verEmpleado}"><button type="button" class="btn btn-secondary">VER EMPLEADO</button></a>
								<a href="${linkActualizar}"><button type="button" class="btn btn-secondary">EDITAR EMPLEADO</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="collapse" id="certificadosCaducados" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">CERTIFICADOS CADUCADOS</span>
			    </ul>
			  </div>
			</nav>	
			<div class="table-responsive">
				<table class="table" data-toggle="table" data-filter-control="true">
					<thead class="table-secondary" >
						<tr>
							<th scope="col">ID</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="direccion" data-sortable="true">DIRECCION</th>
							<th scope="col" data-sortable="true">FECHA CADUCIDAD</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="nombre" data-sortable="true">NOMBRE</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="apellido" data-sortable="true">APELLIDO</th>
							<th scope="col" data-searchable="true" data-filter-control="input" data-field="telefono" data-sortable="true">TELEFONO</th>
							<th scope="col" data-searchable="true" data-filter-control="select" data-field="tipo" data-sortable="true">TIPO</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<c:forEach var="item" items="${certificadosCaducados}">
						<c:url var="linkFichaCertificado" value="/certificados/verCertificado">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="linkRenovar" value="/certificados/solicitarRenovacion">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="linkDescartar" value="/certificados/descartarCertificado">
							<c:param name="certificadoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="verCliente" value="/usuarios/verUsuario">
							<c:param name="usuarioId" value="${item.cliente.id}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.vivienda.direccion }</td>
							<td>${item.fechaCaducidad }</td>
							<td>${item.cliente.nombre }</td>
							<td>${item.cliente.apellido1 }</td>
							<td>${item.cliente.telefono }</td>
							<td>${item.tipo }</td>
							<td class="text-center">
								<a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a>
								<a href="${verCliente}"><button type="button" class="btn btn-secondary">VER CLIENTE</button></a>
								<a href="${linkRenovar}"><button type="button" class="btn btn-secondary">RENOVAR</button></a>
								<a href="${linkDescartar}"><button type="button" class="btn btn-secondary">DESCARTAR</button></a>
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
						<tr>
							<td>${item.id }</td>
							<td>${item.vivienda.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado }</td>
							<td>${item.tipo }</td>
							<td class="text-center">
								<a href="${linkFichaCertificado}"><button type="button" class="btn btn-secondary">VER CERTIFICADO</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="collapse" id="proyectos" data-bs-parent="#myGroup">
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
						<tr>
							<td>${item.id }</td>
							<td>${item.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado.toString() }</td>
							<td>${item.tipo }</td>
							<td class="text-end">
								<a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="collapse" id="proyectosCaducados" data-bs-parent="#myGroup">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			  <div class="container-fluid">
			    <ul class="navbar-nav">
			    	<span class="navbar-text">PROYECTOS CANDIDATOS</span>
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
					<c:forEach var="item" items="${proyectosCaducados}">
						<c:url var="linkFichaProyecto" value="/proyectos/verProyecto">
							<c:param name="proyectoId" value="${item.id}"/>
							<c:param name="tipo" value="${item.tipo}"/>
						</c:url>
						<c:url var="descartar" value="/proyectos/descartarInspeccionTecnica">
							<c:param name="proyectoId" value="${item.id}"/>
						</c:url>
						<c:url var="solicitarCertificado" value="/certificados/solicitarInspeccionTecnica">
							<c:param name="proyectoId" value="${item.id}"/>
						</c:url>
						<tr>
							<td>${item.id }</td>
							<td>${item.direccion }</td>
							<td>${item.fechaSolicitud }</td>
							<td>${item.estado.toString()}</td>
							<td>${item.tipo }</td>
							<td class="text-end">
								<a href="${linkFichaProyecto}"><button type="button" class="btn btn-secondary">VER PROYECTO</button></a>
								<a href="${descartar}"><button type="button" class="btn btn-secondary">DESCARTAR</button></a>
								<a href="${solicitarCertificado}"><button type="button" class="btn btn-secondary">SOLICITAR INSPECCION TECNICA</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>