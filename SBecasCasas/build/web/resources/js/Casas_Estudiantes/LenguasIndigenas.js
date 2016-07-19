function formularioAltaLenguasIndigenas() {
    bootbox.dialog({
        title: "Alta de Lengua Indigena.",
        message: 
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomLenguaIndigena"># Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomLenguaIndigena" name="txtNomLenguaIndigena" type="text"  class="form-control input-md"> ' +
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
                    
                    var tl = $("#txtNomLenguaIndigena").val();
                    var tipoLocal = document.getElementById("formLenguasIndigenas:NombreLenguaIndigena");
                    tipoLocal.value = tl;
                    var boton=document.getElementById("formLenguasIndigenas:AgregarLenguaIndigena");
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

function eliminarLenguaIndigena(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro de eliminar la Lengua Indigena.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById(string+":EliminarLenguaIndigena");
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


function editarLenguasIndigenas(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var nom = document.getElementById(string+":nombreLenguaIndigena");
    bootbox.dialog({
        title: "Editar Zona.",
        message:  
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomLenguaIndigena"> Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomLenguaIndigena" name="txtNomLenguaIndigena" value="'+nom.value+'" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                        '</form> '+
                    '</div>  '+
                '</div>',
        buttons: {
            success: {
                label: "Guardar Cambios.",
                className: "btn-default",
                callback: function() {
                    var tl = $("#txtNomLenguaIndigena").val();
                    nom.value= tl;
                    var editar = document.getElementById(string+":EditLenguaIndigena");
                    editar.click();
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