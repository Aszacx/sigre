<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/head.jsp"%>
<div class="cd-fold-content single-page">
    <h2>REGISTRAR SOLICITUD DE REVISIÓN</h2>
    <em>Llena el siguiente formulario adecuadamente.</em>
    <form action="<%= request.getContextPath()%>/solicitud" method="POST">
        <input type="hidden" name="tipo" value="3">
        Nombre(s): <input type="text" class="text-input" name="nombre" placeholder="Nombre" maxlength="30" pattern="[A-Za-z]" autofocus required><br>
        Apellido Paterno: <input type="text" class="text-input" name="apellidoP" placeholder="Apellido Paterno" maxlength="40" autofocus required><br>
        Apellido Materno: <input type="text" class="text-input" name="apellidoM" placeholder="Apellido Materno" maxlength="40" autofocus required><br>
        No. Boleta: <input type="text" class="text-input" name="boleta" placeholder="No. de Boleta" maxlength="40" autofocus required><br>
        E-mail: <input type="email" class="text-input" name="email" placeholder="Ej:algo@dominio.com"  maxlength="40" autofocus required><br>
        Celular: <input type="text" class="text-input" name="cel" placeholder="Ej:1234567890" maxlength="10" autofocus required><br>
        Materia: <select class="text-input" name="materia" required>
            <option value="">Selecciona una Materia</option>
            <c:forEach items="${materias}" var="mate">
                <option value="${mate.getIdMateria()}">${mate.getMateria()}</option>
            </c:forEach>      
        </select>
        <br>
        Motivos: <br> 
        <textarea rows="5" cols="50" name="motivos" size="140" placeholder="A tu parecer ¿por qué está mal calificado tu examen?" autofocus></textarea>
        <br><br>
        <span>NOTA: si tienes más de una materia para revisión, registra por separado cada materia.</span>
        <br><br>
        <input type="submit" value="Realizar Solicitud">
    </form>
    <br><br<hr>
</div>
<%@include file="layout/foot.jsp"%>