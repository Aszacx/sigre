<%@page import="entidades.Materia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.materiaModel"%>
<%@page import="cont.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
       
            Dao dao = new Dao();
            
            int basicas = 0,integral = 0, compu = 0;
            /*
            int cantidad = 0, variable = 0;
            
            String sql = "SELECT DISTINCT (SELECT count(*) FROM materia) as a";
            ResultSet rs = dao.consulta(sql);
            if (rs.next()) {
                cantidad = Integer.parseInt(rs.getString("a"));
            }
            
            for (int i = 0; i < cantidad; i++) {
                String query = "select distinct("
                    + " select count(*) from profesor p" 
                    + " join profesor_has_materia pm on p.idProfesor = pm.Profesor_idProfesor"
                    + " join materia m on m.idMateria = pm.Materia_idMateria"
                    + " where m.idMateria = " +i+ ") as " +'i'+ "";
                   
                rs = dao.consulta(query);
                while (rs.next()) {
                    variable = Integer.parseInt(rs.getString());
                    System.out.println(variable);
                }
            }
            */
            String query = "select distinct( " 
                    +"select count(*) from profesor "
                    + "join profesor_has_materia on profesor.idProfesor = profesor_has_materia.Profesor_idProfesor "
                    + "join materia on materia.idMateria = profesor_has_materia.Materia_idMateria "
                    + "where profesor.idProfesor = 24 "
                    + ") as a, "
                    + "(select count(*) from profesor " 
                    + "join profesor_has_materia on profesor.idProfesor = profesor_has_materia.Profesor_idProfesor "
                    + "join materia on materia.idMateria = profesor_has_materia.Materia_idMateria "
                    + "where profesor.idProfesor = 25) as b, "
                    + "(select count(*) from profesor " 
                    + "join profesor_has_materia on profesor.idProfesor = profesor_has_materia.Profesor_idProfesor "
                    + "join materia on materia.idMateria = profesor_has_materia.Materia_idMateria "
                    + "where profesor.idProfesor = 26) as c from profesor";
            
            ResultSet rs = dao.consulta(query);
                while (rs.next()) {
                    basicas = Integer.parseInt(rs.getString("a"));
                    integral = Integer.parseInt(rs.getString("b"));
                    compu = Integer.parseInt(rs.getString("c"));
                }
            
            
            
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
            text: 'Profesores'
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
                { name: 'Profesor Uno', y: <%= basicas %> },
                { name: 'Profesor Dos', y: <%= integral %> },
                { name: 'Profesor Tres', y: <%= compu %> }
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
