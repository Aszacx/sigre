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

function tipoUsuario() {
    var memb = $('#tipoUsuario').val();
    if (memb == 3) {
        $('.materia').css('display', 'block');
        $('.materia').attr('required', 'required');
        $('.departamento').css('display', 'none');
        $('.departamento').removeAttr('required', 'required');
        $('.pass').css('display', 'none');
        $('.pass').removeAttr('required', 'required');
    } else {
        $('.materia').css('display', 'none');
        $('.materia').removeAttr('required', 'required');
        $('.departamento').css('display', 'block');
        $('.departamento').attr('required', 'required');
        $('.pass').css('display', 'block');
        $('.pass').attr('required', 'required');
    }
}
$('#tipoUsuario').change(tipoUsuario);
tipoUsuario();