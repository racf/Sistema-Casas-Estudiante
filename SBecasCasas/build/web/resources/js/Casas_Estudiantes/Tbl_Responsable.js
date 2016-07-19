function validarCamposAltaResponsableZona(button, estado){
    var auxEstado = estado;
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var numeroID = document.getElementById("formAltaResponsableZona:txtNumEmpleado").value;
    var auxNumeroID = document.getElementById("formAltaResponsableZona:txtAuxNumEmpleado").value;
    var zonaId = document.getElementById("formAltaResponsableZona:cmbxZona").value;
    var email = document.getElementById("formAltaResponsableZona:txtEmail").value;

//    var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/;
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    
    
    if(numeroID != auxNumeroID){
        $("#messageAltaResponsableZona").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No ha presionado el boton Buscar...!</strong> </div>");         
    }else if((zonaId == null || zonaId.length == 0 || /^\s+$/.test(zonaId)) || (numeroID == "0" || numeroID == null || numeroID.length == 0 || /^\s+$/.test(numeroID)) ){
       $("#messageAltaResponsableZona").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");          
       cambioColorAltaResponsableZona();
    }else if(email.length > 0 && email != null && !(/^\s+$/.test(email))){
        if(!patron.test(email)){
          $("#messageAltaResponsableZona").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡Email Invalido...!</strong> </div>");              
        } else {
            if (auxEstado == true) {
                $("#messageAltaResponsableZona").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡El responsable ya se encuentra el sistema...!</strong> </div>");
                cambioColorAltaResponsableZona();
            } else {
                var altaResponsable = document.getElementById(string + ":btnAltaResponsable1");
                altaResponsable.click();
                $("#messageAltaResponsableZona").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La alta del responsable se realizó correctamente!</strong></div>");
                cambioColorAltaResponsableZona();
            }
        }       
    }else{
        if(auxEstado == true){
           $("#messageAltaResponsableZona").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡El responsable ya se encuentra el sistema...!</strong> </div>");               
           cambioColorAltaResponsableZona(); 
        }else{
            var altaResponsable = document.getElementById(string+":btnAltaResponsable1");
            altaResponsable.click();
            $("#messageAltaResponsableZona").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La alta del responsable se realizó correctamente!</strong></div>");
            cambioColorAltaResponsableZona(); 
        }
       
    }
}

function cambioColorAltaResponsableZona(){
    var zonaId = document.getElementById("formAltaResponsableZona:cmbxZona").value;
    var numeroID = document.getElementById("formAltaResponsableZona:txtNumEmpleado").value;
    if(zonaId == null || zonaId.length == 0 || /^\s+$/.test(zonaId)){
        document.getElementById('formAltaResponsableZona:lblcmbxZona').style.color='red';   
    }else{
        document.getElementById('formAltaResponsableZona:lblcmbxZona').style.color=''; 
    }
    
    if(numeroID == "0" || numeroID == null || numeroID.length == 0 || /^\s+$/.test(numeroID)){
        document.getElementById('formAltaResponsableZona:lblNumeroEmpleado').style.color='red';   
    }else{
        document.getElementById('formAltaResponsableZona:lblNumeroEmpleado').style.color=''; 
    }
}

function obtenerIdModResponsable(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnModificarResponsable1");
    button.click();
}

function validarCamposModResponsableZona(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var email = document.getElementById("formModResponsableZona:txtEmail").value;
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    if(email.length > 0 && email != null && !(/^\s+$/.test(email))){
        if(!patron.test(email)){
            $("#messageModResponsableZona").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡Email Invalido...!</strong> </div>");              
        } else {
            var modResponsable = document.getElementById(string + ":btnModificarResponsable1");
            modResponsable.click();
            $("#messageModResponsableZona").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La modificación del responsable se realizó correctamente!</strong></div>");           
        }                 
    }else{
        var modResponsable = document.getElementById(string + ":btnModificarResponsable1");
        modResponsable.click();
        $("#messageModResponsableZona").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La modificación del responsable se realizó correctamente!</strong></div>");   
    }
}

function obtenerIdVerResponsable(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnVerResponsable1");
    button.click();
}

function confirmBajaResponsable(button, clave){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        title:"¿Esta seguro que desea dar de baja a este responsable de zona?",
        message: "Con numero de empleado: <strong>"+clave+"</strong>",
        buttons: {
            success: {                
                label: "Confirmar",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnEliminarResponsable1");
                    eliminar.click();
                    $("#messageBajaResponsableZona").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La baja del responsable se realizó correctamente!</strong></div>");
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-primary",
                callback: function() {
                }
            }
        }
    });
    e.preventdefault();
    return false;
}


function confirmActivacionResponsable(button, clave){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        title:"¿Esta seguro que desea activar a este responsable de zona?",
        message: "Con numero de empleado: <strong>"+clave+"</strong>",
        buttons: {
            success: {                
                label: "Confirmar",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnActivarResponsable1");
                    eliminar.click();
                    $("#messageActivarResponsableZona").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La activación del responsable se realizó correctamente!</strong></div>");
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-primary",
                callback: function() {
                }
            }
        }
    });
    e.preventdefault();
    return false;
}



