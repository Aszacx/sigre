<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    
    if(sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    }
    else if(sesion.getAttribute("tipo").equals(1)){
        response.sendRedirect(request.getContextPath()+"/jefeDepartamento");
    }
%> 
<div class="container">
    <div class="row">
        <div class="col-md-7">
            <div class="opcion">
                <h2>Gestionar departamentos y academias</h2>
                <p>Podrás agregar, eliminar departamentos, así­ como asignarles academias y sus respectivas materias</p>
                <p><a class="btn btn-default" href="administracion" role="button">Ver Detalles &raquo;</a></p>
            </div>
        </div>
        <div class="col-md-5">
            <div class="opcion">
                <h2>Examenes en progreso</h2>
                <p>Podrás ver el historial de los examenes de revisión</p>
                <p><a class="btn btn-default" href="listaExamenes" role="button">Ver Detalles &raquo;</a></p>
            </div>
        </div>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>