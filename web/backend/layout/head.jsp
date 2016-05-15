<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <title>Gestión</title>
      <meta name="description" content="">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="icon" type="image/png" href="backend/assets/img/ipn.png" />
      <link rel="stylesheet" href="backend/assets/css/bootstrap.min.css">
      <link rel="stylesheet" href="backend/assets/css/bootstrap-theme.min.css">
      <link rel="stylesheet" href="backend/assets/css/main.css">
      <script src="backend/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>   
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-right">
                    <p class="derecha">
                        <% HttpSession sesiones = request.getSession(); %>
                        <h5>
                            <b>Bienvenido:</b> <%= (String)sesiones.getAttribute("email") %> 
                            <b>Área:</b> <%= sesiones.getAttribute("tipo").toString() %> 
                            <a class="btn btn-default" href="<%= request.getContextPath()%>/login?accion=cerrar" role="button">Cerrar Sesión <i class="glyphicon glyphicon-off"></i></a>
                        </h5>
                    </p>
                </div>
            </div>
            <div class="jumbotron">
                <div class="row">
                    <div class="col-md-12">
                       <h1>SIGRE</h1>
                       <p>Bienvenido al Sistema Integral de Gestión de Revisión de Evaluación</p>
                       <!--<p class="derecha"><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>-->
                    </div>
                </div>
            </div>
        </div>