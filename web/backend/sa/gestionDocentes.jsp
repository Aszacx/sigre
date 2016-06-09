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
    <div class="col-md-6 col-md-offset-3  sin-margin-left">
        <div class="col-md-9 sin-margin-right">
            <div class="input-group">
                <div class="input-group-addon">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </div>
                <input id="filtrar" type="text" class="search form-control"
                       placeholder="Buscar..."/>
            </div>
        </div>
    </div>
</div>
<br>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="alert alert-info"><c:out value="${mensaje}" /></div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th><b>ID</b></th>
                        <th><b>Nombre(s)</b></th>
                        <th><b>Apellidos</b></th>
                        <th><b>Imparte</b></th>
                        <th><b>Correo</b></th>
                        <th><b>Teléfono</b></th>
                        <th><b>Acciones</b></th>
                    </tr>
                </thead>
                <tbody class="searchable">
                    <c:forEach items="${usuarios}" var="item">
                    <tr style="display:table-row">
                        <td><c:out value="${item.getIdUsuario()}" /></td>
                        <td><c:out value="${item.getNombre()}" /></td>
                        <td><c:out value="${item.getApellidoP()} ${item.getApellidoM()}" /></td>
                        <td><c:out value="${item.getMateria()}" /></td>
                        <td><c:out value="${item.getEmail()}" /></td>
                        <td><c:out value="${item.getCel()}" /></td>
                        <td>
                            <div class="btn-group btn-group-sm" role="group">
                                <a class="btn btn-info" title="Editar" href="<%= request.getContextPath() %>/opUsuarios?accion=edicion&id=<c:out value="${item.getIdUsuario()}" />" role="button" id="editarUsuario">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <a class="btn btn-danger" title="Eliminar" href="<%= request.getContextPath() %>/opUsuarios?accion=eliminar&id=<c:out value="${item.getIdUsuario()}" />" role="button" onclick="return confirm('Esta seguro de eliminar el registro?');">
                                    <i class="glyphicon glyphicon-trash"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="container">
    <div class="container">
        <%@include file="graficas/profesores.jsp"%>
    </div>
    <div class="col-md-10 col-md-offset-1">
        <p class="derecha"><a class="btn btn-primary btn-lg" href="usuarios" role="button">Gestión de Usuarios</a>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        (function ($) {
            $('#filtrar').keyup(function () {
                var rex = new RegExp($(this).val(), 'i');
                $('.searchable tr').hide();
                $('.searchable tr').filter(function () {
                    return rex.test($(this).text());
                }).show();
            })
        }(jQuery));
    });
</script>          
<%@include file="../layout/foot.jsp"%>