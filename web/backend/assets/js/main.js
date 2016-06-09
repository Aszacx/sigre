$(function(){  
    $("#nuevoUsuario").on("click",function(){
        $("#formAddUsuario")[0].reset();
        $(".modal-title").text("Agregar Profesor");
        $("#modalAddUsuario").modal({
            show:true,
            backdrop:"static"
        });
    });
    
    $("#nuevoProfesor").on("click",function(){
        $("#formAddProfe")[0].reset();
        $(".modal-title").text("Agregar Profe");
        $("#modalAddProfe").modal({
            show:true,
            backdrop:"static"
        });
    });
    
    $("#nuevoDepartamento").on("click",function(){
        $(".modal-title").text("Agregar Departamento");
        $("#modalAddDepartamento").modal({
            show:true,
            backdrop:"static"
        });
    });
    
    $("#nuevaAcademia").on("click",function(){
        $(".modal-title").text("Agregar Academia");
        $("#modalAddAcademia").modal({
            show:true,
            backdrop:"static"
        });
    });
    
    $("#nuevaMateria").on("click",function(){
        $("#formAddMateria")[0].reset();
        $(".modal-title").text("Agregar Materia");
        $("#modalAddMateria").modal({
            show:true,
            backdrop:"static"
        });
    });
    
    $("#grafica").on("click",function(){
        $(".modal-title").text("Citas");
        $("#modalGrafica").modal({
            show:true,
            backdrop:"static"
        });
    });
});

$('.modal').on('shown.bs.modal', function() {
  $(this).find('[autofocus]').focus();
});