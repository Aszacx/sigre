<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        //if(sesion.getAttribute("tipo").toString().equals(2) == true){
            response.sendRedirect(request.getContextPath());         
    }
%> 
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="opcion derecha">
                <h2>Ver solicitudes de examenes</h2>
                <p>Podrás ver las solicitudes de examenes que tienes que atender.</p>
                <p><a class="btn btn-default" href="examenes_pendientes" role="button">Ver examenes &raquo;</a></p>
            </div>
        </div>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>