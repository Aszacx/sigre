<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <title>Recuperar Contraseña</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="backend/assets/css/bootstrap.min.css">
      <link rel="stylesheet" href="backend/assets/css/main.css">
      <script src="backend/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>   
        <div class="container-fluid">
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
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h2>Recuperar Contraseña</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form action="<%= request.getContextPath()%>/reset?accion=recuperar" method="POST">
                    E-mail: <input type="email" class="form-control" name="email" maxlength="30" autofocus required><br>
                    <input type="submit" value="Enviar">
                </form>
            </div>
        </div>
<%@include file="../layout/foot.jsp"%>
