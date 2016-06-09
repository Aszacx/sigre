<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    }
    else if(sesion.getAttribute("tipo").equals(3)){
        response.sendRedirect(request.getContextPath()+"/subAcademica");
    }
%> 
<div class="container-fluid">
    <div class="container">
        <div class="col-md-12">
            <h2>Generar una Cita y Jurado</h2>
            <p>Seleccione por lo menos 3 profesores para conformar el jurado.</p>
        </div>
    </div>
    <div class="container">
        <div class="col-md-12">
            <div class="input-group">
                <div class="input-group-addon">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </div>
                <input id="filtrar" type="text" class="search form-control" placeholder="Buscar..."/>
            </div>
            <!-- /input-group -->
        </div>
    </div>
    <form action="<%= request.getContextPath() %>/opCitas?accion=notificar" method="POST">
        <div class="container">
            <div class="col-md-12 ">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th><b>Nombre(s)</b></th>
                            <th><b>Apellidos</b></th>
                            <th><b>Correo</b></th>
                            <th><b>Teléfono</b></th>
                            <th><b>Seleccionar</b></th>
                        </tr>
                    </thead>
                    <tbody class="searchable">
                        <c:forEach items="${usuarios}" var="item">
                            <tr style="display:table-row">
                                <td><c:out value="${item.getNombre()}" /></td>
                                <td><c:out value="${item.getApellidoP()} ${item.getApellidoM()}" /></td>
                                <td><c:out value="${item.getEmail()}" /></td>
                                <td><c:out value="${item.getCel()}" /></td>
                                <td><input type="checkbox" name="seleccionar"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container">
            <div class="form">
                <h4><strong>Mensaje de correo para los participantes de la revisón, no olvides poner la fecha y hora</strong></h4>
            <br>
            <textarea name="correo" class="tex-correo centrar">
                Por medio de este correo se te notifica que el dia FECHA a las HORA, en la academia LUGAR, se realizará la revisión del examen
                del alumno <c:out value="${usuario.getNombre()}" />. 
                Ya todos los preparativos estan listos, por favor confirma tu asistencia, o la cancelación de dicha revisión. 
                Atte: Jefe de departamento Nombre
            </textarea>
            <br>
            <p class="centrar"><input type="submit" class="btn btn-lg" value="Notificar" /></p>
            </div>
        </div>
    </form>
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
         