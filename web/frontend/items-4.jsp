<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/head.jsp"%>
<div class="cd-fold-content single-page">
    <h2>Gestión</h2>
    <em>Esta sección es exclusva para administradores/jefe de departamento</em>
    <p>Si eres personal administrativo, jefe de departamento, inicia sesión para ver tus solicitudes.</p>
    <br><br>
    <div id="login">
        <form action="<%= request.getContextPath()%>/login?accion=entrar" method="POST">
            Usuario: <input type="email" class="text-input" name="email" placeholder="Correo Electrrónico" maxlength="30" autofocus required><br>
            Contraseña: <input type="password" class="text-input" name="pass" placeholder="Contraseña" maxlength="40" autofocus required><br>
            <br>
            <input type="submit" value="Entrar">
        </form>
        <a id="recuPass" class="recuperaPass" href="recuperar_contrasena">¿Olvidaste tu contraseña?</a>
    </div>
</div>
<%@include file="layout/foot.jsp"%>