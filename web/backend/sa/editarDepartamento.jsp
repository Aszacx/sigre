<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    }
%> 
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h2>Editar Departamento</h2>
        <p class="derecha btn-cancelar">
            <a class="btn btn-danger" href="departamentos" role="button"><span class="glyphicon glyphicon-user icon-out" aria-hidden="true"></span>Cancelar&raquo;</a>
        </p>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form action="<%= request.getContextPath()%>/opDepartamentos?accion=editar" method="POST">
            ID: <input type="text" class="form-control" name="idDepartamento" readonly required value="<c:out value="${departamento.getIdDepartamento()}" />"><br>
            Departamento: <input type="text" class="form-control" name="departamento" maxlength="50" autofocus required value="<c:out value="${departamento.getDepartamento()}" />"><br>
            <br>
            <input type="submit" value="Editar">
        </form>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>