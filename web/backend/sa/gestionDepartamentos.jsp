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
        <div class="col-md-3 sin-margin-left sin-margin-right">
            <button class="btn btn-success full-botton" id="nuevoDepartamento">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
        </div>
    </div>
</div>
<br>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default">
            <div class="alert alert-info"><c:out value="${mensaje}" /></div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th><b>Nombre Departamento</b></th>
                        <th><b>Acciones</b></th>
                    </tr>
                </thead>
                <tbody class="searchable">
                    <c:forEach items="${departamentos}" var="item">
                    <tr style="display:table-row">
                        <td><c:out value="${item.getDepartamento()}" /></td>
                        <td>
                            <div class="btn-group btn-group-sm" role="group">
                                <a class="btn btn-info" href="<%= request.getContextPath() %>/opDepartamentos?accion=edicion&id=<c:out value="${item.getIdDepartamento()}" />" role="button"><i class="glyphicon glyphicon-pencil"></i> Editar</a>
                                <a class="btn btn-danger" href="<%= request.getContextPath() %>/opDepartamentos?accion=eliminar&id=<c:out value="${item.getIdDepartamento()}" />" role="button" onclick="return confirm('Esta seguro de eliminar el registro?');"><i class="glyphicon glyphicon-trash"></i> Eliminar</a>
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
    <div class="col-md-12">
        <p class="derecha"><a class="btn btn-primary btn-lg" href="administracion" role="button">Panel de Administración &raquo;</a>
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
<!--Modal Agregar Departamento-->
<div class="modal fade" id="modalAddDepartamento" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="ModalLabel"></h4>
            </div>
            <div class="modal-body">
                <form action="<%= request.getContextPath()%>/opDepartamentos?accion=agregar" method="POST" id="formAddDepartamento">
                    Nombre del departamento: <input type="text" class="form-control" name="departamento" placeholder="Nombre del Departamento" maxlength="50" autofocus required><br>
                    <input type="submit" value="Registrar">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>
