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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h2>Lista de Citas</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="input-group">
                <div class="input-group-addon">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </div>
                <input id="filtrar" type="text" class="search form-control"
                       placeholder="Buscar..."/>
            </div>
            <!-- /input-group -->
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">
                <div class="alert alert-info"><c:out value="${mensaje}" /></div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th><b>Materia</b></th>
                            <th><b>Fecha</b></th>
                            <th><b>Alumno</b></th>
                            <th><b>Estatus</b></th>
                        </tr>
                    </thead>
                    <tbody class="searchable">
                        <c:forEach items="${citas}" var="item">
                        <tr style="display:table-row">
                            <td><c:out value="${item.getMateria()}" /></td>
                            <td><c:out value="${item.getFecha()}" /></td>
                            <td><c:out value="${item.getNombre()} ${item.getApellidoP()} ${item.getApellidoM()}" /></td>
                            <td><c:out value="${item.getEstatus()}" /></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
        <div class="container">
            <%@include file="graficas/citas.jsp"%>
        </div>
        <div class="col-md-12">
            <p class="derecha"><a class="btn btn-primary btn-lg" href="subAcademica" role="button">Ir a Home &raquo;</a>
        </div>
</div>
<!--Modal Generar Gráfica-->
<div class="modal fade" id="modalGrafica" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="ModalLabel"></h4>
            </div>
            <div class="modal-body">
                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
            </div>
        </div>
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