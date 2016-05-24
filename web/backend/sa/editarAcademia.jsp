<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    }
    else if(sesion.getAttribute("tipo").equals(1)){
        response.sendRedirect(request.getContextPath()+"/jefeDepartamento");
    }
%> 
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h2>Editar Academia</h2>
        <p class="derecha btn-cancelar">
            <a class="btn btn-danger" href="academias" role="button"><span class="glyphicon glyphicon-user icon-out" aria-hidden="true"></span>Cancelar&raquo;</a>
        </p>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form action="<%= request.getContextPath()%>/opAcademias?accion=editar" method="POST">
            ID: <input type="text" class="form-control" name="idAcademia" readonly required value="<c:out value="${academia.getIdAcademia()}" />"><br>
            Academia: <input type="text" class="form-control" name="academia" maxlength="50" autofocus required value="<c:out value="${academia.getAcademia()}" />"><br>
            Departamento: <select class="form-control" name="departamento" required/>">
                <option value="${academia.getDepartamento_idDepartamento()}">${academia.getDepartamento()}</option>
                <c:forEach items="${departamentos}" var="depa">
                    <option value="${depa.getIdDepartamento()}">${depa.getDepartamento()}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Editar">
        </form>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>