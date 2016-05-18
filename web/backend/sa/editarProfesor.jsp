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
        <h2>Editar Profesor</h2>
        <p class="derecha btn-cancelar">
            <a class="btn btn-danger" href="usuarios" role="button"><span class="glyphicon glyphicon-user icon-out" aria-hidden="true"></span>Cancelar&raquo;</a>
        </p>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <form action="<%= request.getContextPath()%>/opUsuarios?accion=editar" method="POST">
                ID: <input type="text" class="form-control" name="idUsuario" readonly required value="<c:out value="${usuario.getIdUsuario()}" />"><br>
                 Área: <p class="alert alert-info text-center" style="padding: 8px; margin: 5px;">1 = Subdirección Academica | 2 = Jefe de Departamento</p>
                 <input type="text" class="form-control" name="tipo" readonly maxlength="30" required value="<c:out value="${usuario.getTipo()}" />"><br>
                Nombre(s): <input type="text" class="form-control" name="nombre" maxlength="30" autofocus required value="<c:out value="${usuario.getNombre()}" />"><br>
                Apellido Paterno: <input type="text" class="form-control" name="apellidoP" maxlength="40" required value="<c:out value="${usuario.getApellidoP()}" />"><br>
                Apellido Materno: <input type="text" class="form-control" name="apellidoM" maxlength="40" required value="<c:out value="${usuario.getApellidoM()}" />"><br>
                Departamento: <select class="form-control" name="departamento" required/>">
                    <option value="${usuario.getDepartamento_idDepartamento()}">${usuario.getDepartamento()}</option>
                    <c:forEach items="${departamentos}" var="depa">
                        <option value="${depa.getIdDepartamento()}">${depa.getDepartamento()}</option>
                    </c:forEach>
                <select><br>
                Celular: <input type="text" class="form-control" name="cel" maxlength="10" required value="<c:out value="${usuario.getCel()}" />"><br>
                E-mail: <input type="email" class="form-control" name="email"  maxlength="40" required value="<c:out value="${usuario.getEmail()}" />"><br>
                Contraseña: <input type="password" class="form-control" name="pass" maxlength="40" required value="<c:out value="${usuario.getPass()}" />"><br>            <br>
            <input type="submit" value="Editar">
        </form>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>