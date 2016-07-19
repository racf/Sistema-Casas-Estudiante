function formularioAltaZonas() {
    bootbox.dialog({
        title: "Alta de Zona.",
        message: 
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomZona"># Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomZona" name="txtNomZoba" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txOficina">Oficina </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txOficina" name="txOficina" ' +
                                    'placeholder="Aqui introduzca los datos..." class="form-control">' +
                                    '</textarea>' + 
                                '</div> ' +
                        '</form> '+
                    '</div>  '+
                '</div>',
                
        buttons: {
            success: {
                label: "Agregar",
                className: "btn-default",
                callback: function () {
                    
                    var tl = $("#txtNomZona").val();
                    var tipoLocal = document.getElementById("formZonas:NombreZona");
                    tipoLocal.value = tl;
                    var dl = $("#txOficina").val();
                    var descLocal = document.getElementById("formZonas:Oficina");
                    descLocal.value = dl;
                    var boton=document.getElementById("formZonas:AgregarZona");
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

function eliminarZona(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro de eliminar la Zona.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById(string+":EliminarZona");
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


function editarZona(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var nom = document.getElementById(string+":nombreZona");
    var des = document.getElementById(string+":Oficina");
    bootbox.dialog({
        title: "Editar Zona.",
        message:  
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomZona"> Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomZona" name="txtNomZona" value="'+nom.value+'" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txOficina">Oficina </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txOficina" name="txOficina" ' +
                                    'placeholder="" class="form-control">' +
                                        des.value+
                                    '</textarea>' + 
                                '</div> ' +
                        '</form> '+
                    '</div>  '+
                '</div>',
        buttons: {
            success: {
                label: "Guardar Cambios.",
                className: "btn-default",
                callback: function() {
                    var tl = $("#txtNomZona").val();
                    nom.value= tl;
                    var tl2 = $("#txOficina").val();
                    des.value= tl2;
                    
                    var editar = document.getElementById(string+":EditZona");
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