<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
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
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th><b>Materia</b></th>
                            <th><b>fecha</b></th>
                            <th><b>Nombre</b></th>
                            <th><b>Estado</b></th>
                        </tr>
                    </thead>
                    <tbody class="searchable">
                        <tr style="display:table-row">
                            <td>Análisis Vectorial</td>
                            <td>dd/mm/aaaa</td>
                            <td>Nombre Apellido</td>
                            <td>Con cita</td>
                        </tr>
                        <tr style="display:table-row">
                            <td>Cálculo</td>
                            <td>dd/mm/aaaa</td>
                            <td>nombre apeido</td>
                            <td>Pendiente</td>
                        </tr>
                        <tr style="display:table-row">
                            <td>Ecuaciones Diferenciales</td>
                            <td>dd/mm/aaaa</td>
                            <td>nombre apeido</td>
                            <td>Con cita</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12">
            <p class="derecha"><a class="btn btn-primary btn-lg" href="administracion" role="button">Ir a Home &raquo;</a>
        </div>
    </div>
</div>
<SCRIPT type="text/javascript">
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
</SCRIPT>
<%@include file="../layout/foot.jsp"%>