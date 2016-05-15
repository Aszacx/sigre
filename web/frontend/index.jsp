<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/head.jsp"%>
<main class="cd-main">
    <header>
        <div style="width: 30%; float: left; margin-top: 30px;">
            <img src="frontend/assets/img/ipn.png" alt="IPN" width="150px" />
        </div>
        <div style="width: 40%; float: left;">
            <h1>SIGRE</h1>
            <h4>Sistema Integral de Gestión de Revisión de Evaluación</h4>
        </div>
        <div style="width: 30%; float: left; margin-top: 50px;">
            <img src="frontend/assets/img/escom.png" alt="ESCOM" width="150px" />
        </div>
    </header>

    <ul class="cd-gallery">
        <li class="cd-item">
            <a href="frontend/item-1.jsp">
                <div>
                    <h2>¿Qué es SIGRE?</h2>
                    <p>Te contamos que es y cómo te puede ayudar</p>
                    <b>Ver Más</b>
                </div>
            </a>
        </li>

        <li class="cd-item">
            <a href="frontend/items-2.jsp">
                <div>
                    <h2>¿Ya sabes cómo funciona?</h2>
                    <p>Aqui te decimos que hacer y como hacerlo</p>
                    <b>Ver Más</b>
                </div>
            </a>
        </li>

        <li class="cd-item">
            <a class="dark-text" href="examen">
                <div>
                    <h2>¡Solicita una revisión aqui!</h2>
                    <p>Recuerda tener tu boleta y datos del examen cerca</p>
                    <b>Realizar Solicitud</b>
                </div>
            </a>
        </li>

        <li class="cd-item">
            <a href="frontend/items-4.jsp">
                <div>
                    <h2>Gestionar SIGRE</h2>
                    <p>Para docentes/administradores</p>
                    <b>Iniciar Sesión</b>
                </div>
            </a>
        </li>
    </ul> <!-- .cd-gallery -->
</main> <!-- .cd-main -->

<div class="cd-folding-panel">

    <div class="fold-left"></div> <!-- this is the left fold -->

    <div class="fold-right"></div> <!-- this is the right fold -->

    <div class="cd-fold-content">
        <!-- content will be loaded using javascript -->
    </div>

    <a class="cd-close" href="#0"></a>
</div> <!-- .cd-folding-panel -->
<%@include file="layout/foot.jsp"%>