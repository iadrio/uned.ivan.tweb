<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Inicio</title>
    <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body>
<div class="px-4 py-5 my-5 text-center ">
    <h1 class="display-5 fw-bold">PEC Tecnolog&iacuteas Web 2022</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">Aplicaci&oacuten realizada como proyecto educativo para la asignatura de Tecnolog&iacuteas Web de la UNED.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
        <a href="<%=request.getContextPath()%>/login/formularioLogin" class="btn btn-dark btn-lg px-4 gap-3" role="button">Iniciar aplicaci&oacuten</a>
        <a href="<%=request.getContextPath()%>/login/verEnunciado" class="btn btn-dark btn-lg px-4 gap-3" role="button">Ver Enunciado</a>
        <a href="<%=request.getContextPath()%>/login/verMemoria" class="btn btn-dark btn-lg px-4 gap-3" role="button">Ver Memoria</a>
        <a href="<%=request.getContextPath()%>/login/verManual" class="btn btn-dark btn-lg px-4 gap-3" role="button">Ver Manual</a>
      </div>
    </div>
  </div>
</body>
</html>
