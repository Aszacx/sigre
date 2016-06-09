<%@page import="cont.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
       
            Dao dao = new Dao();
            
            int basicas=0,integral = 0, compu = 0, inge = 0;
           //out.println(session.getAttribute("role")); 
            String query = "SELECT DISTINCT "
                            +"(SELECT count(*) From cita where estatus= 'pendiente') as dep1,"
                            +"(SELECT count(*) From cita where estatus= 'cita') as dep2, "
                            +"(SELECT count(*) From cita where estatus= 'finalizado') as dep3 "
                            +" FROM sigre.cita;";
                   
            
            //out.println(query);
              ResultSet rs = dao.consulta(query);
            while (rs.next()) {
 
               basicas = Integer.parseInt( rs.getString("dep1"));
               integral = Integer.parseInt( rs.getString("dep2"));
               compu = Integer.parseInt( rs.getString("dep3"));
            }
            
            //out.println(query);
%>

<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45
            }
        },
        title: {
            text: 'Información Académica'
        },
        subtitle: {
            text: 'Estado de Citas'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                { name: 'Pendientes', y: <%= basicas %> },
                { name: 'Con cita', y: <%= integral %> },
                { name: 'Finalizadas', y: <%= compu %> }
            ]
        }]
    });
});

</script>

<input type="submit" class="" id="mostrar" value="Mostrar Grafico" >
    <div class="grafico">
    <input type="submit" id="ocultar" value="Ocultar Grafico" >
    </div>
    
<script type="text/javascript">
$(document).ready(function(){
    $('.grafico').hide(0);
    $("#mostrar").click(function(){ 
        console.log("mostrar");
         $('.grafico').show("slow");
         $('#mostrar').hide("slow");
    });
    $("#ocultar").click(function(){
        $('.grafico').hide("slow");
        $('#mostrar').show("slow");
        console.log("ocultar");  
    });  
});
   
</script>
<div class="grafico">
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</div>
