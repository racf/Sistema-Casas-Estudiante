function validarCamposAltaRepresentanteCasa(button, estado){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var auxEstado = estado;
    var matricula = document.getElementById("formAltaRepresentante:txtMatricula").value;
    var auxmatricula = document.getElementById("formAltaRepresentante:txtAuxMatricula").value;
    var telefono = document.getElementById("formAltaRepresentante:txtTelefono").value;
    var email = document.getElementById("formAltaRepresentante:txtEmail").value;  
    var tipoRepresentante = document.getElementById("formAltaRepresentante:cmbxTipoRepresentante").value;
    
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    if(matricula != auxmatricula){
        $("#messageAltaRepresentante").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No ha presionado el boton Buscar...!</strong> </div>");                 
    }
    else if((matricula == null || matricula.length == 0 || /^\s+$/.test(matricula)) || (telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) || (email == null || email.length == 0 || /^\s+$/.test(email)) || (tipoRepresentante == null || tipoRepresentante.length == 0 || /^\s+$/.test(tipoRepresentante))){
        $("#messageAltaRepresentante").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");          
        cambioColorEtiquetasCamposVacios();
    }else if(!patron.test(email)){
        $("#messageAltaRepresentante").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡Email Invalido...!</strong> </div>");              
        cambioColorEtiquetasCamposVacios();
    }else{
        if (auxEstado == true) {
            $("#messageAltaRepresentante").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡El representante ya se encuentra el sistema...!</strong> </div>");
            cambioColorEtiquetasCamposVacios();
        } else {
            var altaRepresentante = document.getElementById(string + ":btnAltaRepresentante1");
            altaRepresentante.click();
            $("#messageAltaRepresentante").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La alta del representante se realizó correctamente!</strong></div>");
            cambioColorEtiquetasCamposVacios();
        }         
    }

}

function cambioColorEtiquetasCamposVacios(){
    var telefono = document.getElementById("formAltaRepresentante:txtTelefono").value;
    var email = document.getElementById("formAltaRepresentante:txtEmail").value;  
    var tipoRepresentante = document.getElementById("formAltaRepresentante:cmbxTipoRepresentante").value;
    if(telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)){
        document.getElementById('formAltaRepresentante:lblTelefono').style.color='red';   
    }else{
       document.getElementById('formAltaRepresentante:lblTelefono').style.color='';  
    }
    
    if(email == null || email.length == 0 || /^\s+$/.test(email)){
        document.getElementById('formAltaRepresentante:lblEmail').style.color='red';   
    }else{
       document.getElementById('formAltaRepresentante:lblEmail').style.color='';  
    } 
    
    if(tipoRepresentante == null || tipoRepresentante.length == 0 || /^\s+$/.test(tipoRepresentante)){
        document.getElementById('formAltaRepresentante:lblTipoRepresentante').style.color='red';   
    }else{
       document.getElementById('formAltaRepresentante:lblTipoRepresentante').style.color='';  
    }         
}

function obtenerIdVerRepresentante(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnVerRepresentante1");
    button.click();
}

function validarModRepresentante(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var telefono = document.getElementById("formModRepresentante:txtTelefono").value;
    var email = document.getElementById("formModRepresentante:txtEmail").value;
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    if((telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) || (email == null || email.length == 0 || /^\s+$/.test(email))){        
        $("#messageModRepresentante").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");          
        cambioColorEtiquetasCamposVaciosMod();
    }else if(!patron.test(email)){
        $("#messageModRepresentante").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡Email Invalido...!</strong> </div>");              
        cambioColorEtiquetasCamposVaciosMod();
    }else{
        var button = document.getElementById(auxid+":btnModRepresentante1");
        button.click();
        $("#messageModRepresentante").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La modificación del representante se realizó correctamente!</strong> </div>");              
        cambioColorEtiquetasCamposVaciosMod();
    }

}
function cambioColorEtiquetasCamposVaciosMod(){
    var telefono = document.getElementById("formModRepresentante:txtTelefono").value;
    var email = document.getElementById("formModRepresentante:txtEmail").value;
    if(telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)){
        document.getElementById('formModRepresentante:lblTelefono').style.color='red';   
    }else{
       document.getElementById('formModRepresentante:lblTelefono').style.color='';  
    }
    
    if(email == null || email.length == 0 || /^\s+$/.test(email)){
        document.getElementById('formModRepresentante:lblEmail').style.color='red';   
    }else{
       document.getElementById('formModRepresentante:lblEmail').style.color='';  
    }         
}

function obtenerIdModRepresentante(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnModificarRepresentante1");
    button.click();
}

function buscarRepresentante(id){
    var matricula = document.getElementById("formAltaRepresentante:txtMatricula").value;
    if(matricula == null || matricula.length == 0 || /^\s+$/.test(matricula)){
        $("#messageAltaRepresentante").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡Escribe la matricula en el campo de texto!</strong> </div>");          
    }else{
        var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
        var button = document.getElementById(auxid+":btnBuscarRepresentanteCasa1");
        button.click();        
    }

}

function buscarRepresentanteMod(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnBuscarRepresentanteCasa1");
    button.click();            
}

function confirmBajaRepresentante(button, matricula){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        title:"¿Esta seguro que desea dar de baja a este representante de casa?",
        message: "Con matricula: <strong>"+matricula+"</strong>",
        buttons: {
            success: {                
                label: "Confirmar",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnEliminarRepresentante1");
                    eliminar.click();
                    $("#messageBajaRepresentante").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La baja del representante se realizó correctamente!</strong></div>");
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

function confirmActivacionRepresentante(button, matricula){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        title:"¿Esta seguro que desea activar a este representante de casa?",
        message: "Con matricula: <strong>"+matricula+"</strong>",
        buttons: {
            success: {                
                label: "Confirmar",
                className: "btn-danger",
                callback: function() {
                    var activar = document.getElementById(string+":btnActivarRepresentante1");
                    activar.click();
                    $("#messageActivacionRepresentante").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La activación del representante se realizó correctamente!</strong></div>");
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


