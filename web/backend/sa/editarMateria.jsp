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
        <h2>Editar Materia</h2>
        <p class="derecha btn-cancelar">
            <a class="btn btn-danger" href="materias" role="button"><span class="glyphicon glyphicon-user icon-out" aria-hidden="true"></span>Cancelar&raquo;</a>
        </p>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form action="<%= request.getContextPath()%>/opMaterias?accion=editar" method="POST">
            ID: <input type="text" class="form-control" name="idMateria" readonly maxlength="30" required value="<c:out value="${materia.getIdMateria()}" />"><br>
            Academia: <input type="text" class="form-control" name="materia" maxlength="30" autofocus required value="<c:out value="${materia.getMateria()}" />"><br>
            Nivel: <input type="number" class="form-control" name="nivel" placeholder="Nivel" maxlength="30" max="5" min="1" autofocus required value="<c:out value="${materia.getNivel()}" />"><br>
            Departamento: <select class="form-control" name="academia" required>
                <option value="${materia.getAcademia_idAcademia()}">${materia.getAcademia()}</option>
                <c:forEach items="${academias}" var="aca">
                    <option value="${aca.getIdAcademia()}">${aca.getAcademia()}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Editar">
        </form>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>