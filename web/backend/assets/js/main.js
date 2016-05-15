$(function(){  
    $("#nuevoUsuario").on("click",function(){
        $("#formAddUsuario")[0].reset();
        $(".modal-title").text("Agregar Usuario");
        $("#modalAddUsuario").modal({
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
});

$('.modal').on('shown.bs.modal', function() {
  $(this).find('[autofocus]').focus();
});