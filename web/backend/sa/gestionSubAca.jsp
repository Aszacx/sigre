<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    }     
%> 
<div class="container text-center">
    <div class="col-md-3">
        <div class="opcion-sa">
            <h2>Profesores</h2>
            <p>Podrás agregar, modificar y eliminar profesores</p>
            <a class="btn btn-default fondo" href="usuarios" role="button">Gestionar &raquo;</a> 
        </div>
    </div>
    <div class="col-md-3">
        <div class="opcion-sa">
            <h2>Departamentos</h2>
            <p>Podrás agregar, modificar y eliminar departamentos, así­ como asignarles academias</p>
            <a class="btn btn-default fondo" href="departamentos" role="button">Gestionar &raquo;</a> 
        </div>
    </div>
    <div class="col-md-3">
        <div class="opcion-sa">
            <h2>Academias</h2>
            <p>Podrás agregar, modificar y eliminar academias, así­ como asignarles sus respectivas materias</p>
            <a class="btn btn-default fondo" href="academias" role="button">Gestionar &raquo;</a> 
        </div>
    </div>
    <div class="col-md-3">
        <div class="opcion-sa">
            <h2>Materias</h2>
            <p>Podrás agregar, modificar y eliminar profesores, así­ como asignarles un departamento y academia</p>
            <a class="btn btn-default fondo" href="materias" role="button">Gestionar &raquo;</a> 
        </div>
    </div>
</div>
<br><br>
<div class="container">
    <div class="col-md-12">
        <p class="derecha"><a class="btn btn-primary btn-lg" href="subAcademica" role="button">Ir a Home &raquo;</a>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>