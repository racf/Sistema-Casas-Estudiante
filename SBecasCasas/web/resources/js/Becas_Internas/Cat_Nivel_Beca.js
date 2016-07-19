function formularioAltaNivelBecas() {
    bootbox.dialog({
        title: "Alta Nivel de Beca.",
        message: 
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomNivelBeca"># Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomNivelBeca" name="txtNomNivelBeca" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                        '</form> '+
                    '</div>  '+
                '</div>',
        buttons: {
            success: {
                label: "Agregar",
                className: "btn-default",
                callback: function () {
                    var tl = $("#txtNomNivelBeca").val();
                    var tipoLocal = document.getElementById("formNivelBecas:NombreNivelBeca");
                    tipoLocal.value = tl;
                    var boton=document.getElementById("formNivelBecas:AgregarNivel");
                    boton.click();
                }
            },
            cancel: {
                label: "Cancelar",
                className: "btn-default",
                callback: function () {
                    
                }
            }
        }
    }
    );
    e.preventdefault();
    return false;
}

function eliminarNivelBeca(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro de eliminar el nivel de beca.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById(string+":EliminarNivel");
                    eliminar.click();
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-default",
                callback: function() {
                }
            }
        }
    });
    e.preventdefault();
    return false;
}