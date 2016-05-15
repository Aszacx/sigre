<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/head.jsp"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath());
    }
%> 
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h2>Generar una Cita y Jurado</h2>
            <p>Seleccione por lo menos 4 profesores para conformar el juado</p>
        </div>
    </div>
    <div class="row">
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
    <div class="row">
        <div class="col-md-12 ">
            <div class="form">
                <div class="panel panel-default">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th><b>Nombre</b></th>
                                <th><b>Turno</b></th>
                                <th><b>Correo</b></th>
                                <th><b>Celular</b></th>
                                <th><b>SelecciÃ³n</b></th>
                            </tr>
                        </thead>
                        <tbody class="searchable">
                            <tr style="display:table-row">
                                <td>nombre apeido</td>
                                <td>turno</td>
                                <td>algo@dominio.com</td>
                                <td>##########</td>
                                <td><input type="checkbox" name="seleccionado"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <p class="derecha"><a class="btn btn-primary btn-lg" href="#" role="button">Seleccionar&raquo;</a></p>
            </div>
        </div> 
    </div>
    <div class="row">
        <div class="form">
            <strong>Redacta el correo para el alumno, no olvides poner la fecha y hora</strong>
        <br>
        <textarea name="message" class="tex-correo centrar">
            Por medio de este correo se te notifica que el dia FECHA a las HORA, en la academia LUGAR, se realizarÃ¡ la revisiÃ³n del examen. 
            Ya todos los preparativos estan listos, por favor confirma tu asistencia, o la cancelaciÃ³n de dicha revisiÃ³n. 
            Atte: Jefe de departamento Nombre
        </textarea>
        <br>
        <p class="centrar"><a class="btn btn-primary btn-lg" href="listaExamenesPendientes.jsp" role="button">Enviar&raquo;</a></p>
        </div>
    </div>
</div>
<%@include file="../layout/foot.jsp"%>
         