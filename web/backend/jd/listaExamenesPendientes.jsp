<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="..layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    } else {

    }
%> 
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h2>Lista de Examenes</h2>
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
                            <th><b>Nomnbre</b></th>
                            <th><b>Celular</b></th>
                            <th><b>Correo</b></th>
                            <th><b>AcciÃ³n</b></th>
                        </tr>
                    </thead>
                    <tbody class="searchable">
                        <tr style="display:table-row">
                            <td>AnÃ¡lisis Vectorial</td>
                            <td>dd/mm/aaaa</td>
                            <td>nombre apeido</td>
                            <td>##########</td>
                            <td>algo@dominio.com</td>
                            <td>
                                <div class="btn-group btn-group-sm" role="group">
                                    <a class="btn btn-info" href="generarCita.jsp" role="button">Generar Cita &raquo;</a>
                                    <a class="btn btn-danger" href="generarCita.jsp" role="button">Cancelar RevisiÃ³n &raquo;</a>
                                    <a class="btn btn-warning" href="generarCita.jsp" role="button">Finalizar &raquo;</a>
                                </div>
                            </td>
                        </tr>
                        <tr style="display:table-row">
                            <td>CÃ¡lculo</td>
                            <td>dd/mm/aaaa</td>
                            <td>nombre apeido</td>
                            <td>##########</td>
                            <td>algo@dominio.com</td>
                            <td>
                                <div class="btn-group btn-group-sm" role="group">
                                    <a class="btn btn-info" href="generarCita.jsp" role="button">Generar Cita &raquo;</a>
                                    <a class="btn btn-danger" href="generarCita.jsp" role="button">Cancelar RevisiÃ³n &raquo;</a>
                                    <a class="btn btn-warning" href="generarCita.jsp" role="button">Finalizar &raquo;</a>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p class="derecha"><a class="btn btn-primary btn-lg" href="index.jsp" role="button">Ir a Home &raquo;</a></p>
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