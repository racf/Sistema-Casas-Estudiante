function formularioAltaTipoBecas() {
    bootbox.dialog({
        title: "Alta Nivel de Beca.",
        message: 
                '<div class="row">  ' +
                    '<div class="col-md-12"> ' +
                        '<form class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNomTipoBeca"># Nombre</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNomTipoBeca" name="txtNomTipoBeca" type="text"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txtNivelMaxBeca"># Nivel Maximo</label> ' +
                                '<div class="col-md-4"> ' + 
                                    '<input id="txtNivelMaxBeca" name="txtNivelMaxBeca" type="number" min="1"  class="form-control input-md"> ' +
                                '</div> ' +
                            '</div> ' +
                            '<div class="form-group"> ' +
                                '<label class="col-md-4 control-label" for="txDesTipoBeca">Descripcion </label> ' +
                                '<div class="col-md-4"> ' +                               
                                    '<textarea rows="4" id="txDesTipoBeca" name="txDesTipoBeca" ' +
                                    'placeholder="Aqui introduzca la descripcion..." class="form-control">' +
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
                    
                    var tl = $("#txtNomTipoBeca").val();
                    var tipoLocal = document.getElementById("formTipoBecas:NombreTipoBeca");
                    tipoLocal.value = tl;
                    var tl2 = $("#txtNivelMaxBeca").val();
                    var tipoLocal2 = document.getElementById("formTipoBecas:NivelMaximoBeca");
                    tipoLocal2.value = tl2;
                    var dl = $("#txDesTipoBeca").val();
                    var descLocal = document.getElementById("formTipoBecas:DescripcionTipoBeca");
                    descLocal.value = dl;
                    var boton=document.getElementById("formTipoBecas:AgregarTipo");
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

function eliminarTipoBeca(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro de eliminar el tipo de beca.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById(string+":EliminarTipo");
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


function elipoBeca(button){
    var tableRow = button.parentElement.parentElement;
    var rowIndex = tableRow.rowIndex;
    bootbox.dialog({
        message: "Modificar el tipo de beca.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById("formTipoBecas:TablaTipoBeca:"+(rowIndex-1)+":EliminarTipo");
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