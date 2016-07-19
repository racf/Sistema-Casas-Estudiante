function formularioAltaArrendatario() {
    bootbox.dialog({
        title: "Alta de Arrendatario.",
        message: 
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomArrendatario"># Nombre Completo</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomArrendatario" name="txtNomArrendatario" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txCargo">Cargo </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txCargo" name="txCargo" ' +
                                    'placeholder="Aqui introduzca los datos..." class="form-control">' +
                                    '</textarea>' + 
                                '</div> ' +
                           '</div> ' +
                           '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txDomicilio">Domicilio </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txDomicilio" name="txDomicilio" ' +
                                    'placeholder="Aqui introduzca los datos..." class="form-control">' +
                                    '</textarea>' + 
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
                    
                    var tl = $("#txtNomArrendatario").val();
                    var tipoLocal = document.getElementById("formArrenda:NombreArrendatario");
                    tipoLocal.value = tl;
                    var dl = $("#txCargo").val();
                    var cargoLocal = document.getElementById("formArrenda:Cargo");
                    cargoLocal.value = dl;
                    var dl1 = $("#txDomicilio").val();
                    var domiLocal = document.getElementById("formArrenda:Domicilio");
                    domiLocal.value = dl1;
                    var boton=document.getElementById("formArrenda:AgregarArre");
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

function eliminarArredatario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro de eliminar el arrendatario.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById(string+":EliminarArrendatario");
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


function editarArrendatario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var nom = document.getElementById(string+":nombreArrendatario");
    var car = document.getElementById(string+":Cargo");
    var dom = document.getElementById(string+":Domicilio");
    bootbox.dialog({
        title: "Editar Zona.",
        message:  
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomArrendatario"> Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomArrendatario" name="txtNomArrendatario" value="'+nom.value+'" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txCargo">Cargo </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txCargo" name="txCargo" ' +
                                    'placeholder="" class="form-control">' +
                                        car.value +
                                    '</textarea>' + 
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txDomicilio">Oficina </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txDomicilio" name="txDomicilio" ' +
                                    'placeholder="" class="form-control">' +
                                        dom.value +
                                    '</textarea>' + 
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
                    var tl = $("#txtNomArrendatario").val();
                    nom.value= tl;
                    var tl2 = $("#txCargo").val();
                    car.value= tl2;
                    var tl3 = $("#txDomicilio").val();
                    dom.value= tl3;
                    
                    var editar = document.getElementById(string+":EditArenda");
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