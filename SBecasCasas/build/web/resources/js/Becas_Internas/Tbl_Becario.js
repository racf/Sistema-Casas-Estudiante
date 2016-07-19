function obtenerId(id){
    //alert(id);
    var auxid = id.id.substring(0,id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnReactiva");
    button.click();
}

function obtenerIdBajaBecario(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnBajaBecario");
    button.click();
}

function obtenerIdModificarBecario(id){
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnModBecario");
    button.click();
}

function obtenerIdDetalleBecario(id){    
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnDBecario");
    button.click();    
}

function buscarBecario(id){ 
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnBuscarBecario1");
    button.click();  
    
}

function reactivarBecario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "<strong>¿Esta seguro que desea reactivar al becario?</strong>",
        buttons: {
            success: {
                label: "Reactivar",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnReactivarBecario1");
                    eliminar.click();
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

function confirmBajaBecario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "<strong>¿Esta seguro que desea dar de baja a este becario?</strong>",
        buttons: {
            success: {                
                label: "Confirmar",
                className: "btn-danger",
                callback: function() {
                    var eliminar = document.getElementById(string+":btnEnviarBajaBecario1");
                    eliminar.click();
                    $("#messageBajaBecario").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La baja del becario se realizó correctamente!</strong></div>");
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

function confirmarModificarBecario(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var curp = document.getElementById("formModificarBecario:txtModBecarioCurp").value;
    var telefono = document.getElementById("formModificarBecario:txtModBecarioTelefono").value;
    alert(curp+"  "+telefono);
    
    if((telefono == "0" || telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) || (curp == null || curp.length == 0 || /^\s+$/.test(curp))){
        $("#messageModificarBecario").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong></div>");  
    } else if (curp.length == 18) {
        bootbox.dialog({
            message: "<strong>¿Esta seguro que desea modificar los datos de este becario?</strong>",
            buttons: {
                success: {
                    label: "Confirmar",
                    className: "btn-danger",
                    callback: function () {
                        var btn = document.getElementById(string + ":btnConfModBecario1");
                        btn.click();
                        $("#messageModificarBecario").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La modificación del becario se realizó correctamente!</strong></div>");
                    }
                },
                danger: {
                    label: "Cancelar",
                    className: "btn-primary",
                    callback: function () {
                    }
                }
            }
        });
        e.preventdefault();
        return false;        
    } else {
        $("#messageModificarBecario").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La curp no se escribio completamente...!</strong></div>");          
    }
}

function validarCamposAltaBecario(button, estado){
    var auxEstado = estado;
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var numeroID = document.getElementById("formAltaBecario:txtNumeroID").value;
    var auxNumeroID = document.getElementById("formAltaBecario:auxClaveBecario").value;
    var fechaRegistro = document.getElementById("formAltaBecario:txtFechaRegistro").value; 
    var area = document.getElementById("formAltaBecario:txtArea").value;
//    var fechaInicio = document.getElementById("formAltaBecario:txtFechaInicioBeca").value;
//    var fechaFin = document.getElementById("formAltaBecario:txtFechaFinalBeca").value;
    var solicitante = document.getElementById("formAltaBecario:txtSolicitante").value;
    var adscripcion = document.getElementById("formAltaBecario:txtAdcripcion").value;
    var zona = document.getElementById("formAltaBecario:cmbxZona").value;
//    console.log("fechaInicio = " + fechaInicio );
    
    //MANIPULACION DE LA FECHAS
//    var auxfechaIncio = fechaInicio.split("-");
//    var auxfechaFin = fechaFin.split("-");
//    
//    console.log("auxfechaInicio = " + auxfechaIncio + "\n" + 
//            "auxfechaFin = " + auxfechaFin);
    
//    alert(auxfechaIncio[2]+" "+auxfechaIncio[1]+" "+auxfechaIncio[0]);
//    var dateInicio = new Date(auxfechaIncio[0],(auxfechaIncio[1]-1),auxfechaIncio[2]);
//    var dateFin = new Date(auxfechaFin[0], (auxfechaFin[1]-1), auxfechaFin[2]);
//    console.log("dateInicio = " + dateInicio + "\n" + 
//            "dateFin = " + dateFin);
//    console.log("dateInicio < dateFin = " + (dateInicio < dateFin));
//    alert(dateInicio);
    if(numeroID != auxNumeroID){
       $("#messageAltaBecario").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No ha presionado el boton Buscar...!</strong> </div>"); 
//       cambiaColorCamposVaciosAltaBecario();
    }else if((numeroID == "0" || numeroID == null || numeroID.length == 0 || /^\s+$/.test(numeroID)) || (fechaRegistro == null || fechaRegistro.length == 0 || /^\s+$/.test(fechaRegistro)) || (area == null || area.length == 0 || /^\s+$/.test(area)) || (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) || (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) || (zona == null || zona.length == 0 || /^\s+$/.test(zona))){
        $("#messageAltaBecario").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");
        cambiaColorCamposVaciosAltaBecario(); 
    }else{
        if(auxEstado == true){
            $("#messageAltaBecario").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡El becario ya se encuentra en el sistema!</strong></div>");
        }else{
            var altaBecario = document.getElementById(string+":btnAltaBecario1");
            altaBecario.click();
            $("#messageAltaBecario").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La alta del becario se realizó correctamente!</strong></div>");
            cambiaColorCamposVaciosAltaBecario()            
        }
    }
   
}

function validarCamposReactivacionBeca(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    var area = document.getElementById("formReactivacionBeca:txtArea").value;
    var solicitante = document.getElementById("formReactivacionBeca:txtSolicitante").value;
    var adscripcion = document.getElementById("formReactivacionBeca:txtAdcripcion").value;
    var zona = document.getElementById("formReactivacionBeca:cmbxZona").value;
    
        //MANIPULACION DE LA FECHAS
//    var auxfechaIncio = fechaInicio.split("-");
//    var auxfechaFin = fechaFin.split("-");
//    var dateInicio = new Date(auxfechaIncio[2],(auxfechaIncio[1]-1),auxfechaIncio[0]);
//    var dateFin = new Date(auxfechaFin[2], (auxfechaFin[1]-1), auxfechaFin[0]);
    
    if((area == null || area.length == 0 || /^\s+$/.test(area)) || (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) || (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) || (zona == null || zona.length == 0 || /^\s+$/.test(zona))){
        $("#message").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡No se han rellenado campos obligatorios!</strong> </div>");
        CambiaColorCamposVacios();        
    }else{
        var reactivarBeca = document.getElementById(string+":reactivarBecario");
        reactivarBeca.click();
        $("#message").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>¡La reactivación de la beca se realizó correctamente!</strong></div>");
        CambiaColorCamposVacios();
    }
//    alert(area);
}

function cambiaColorCamposVaciosAltaBecario(){
    var numeroID = document.getElementById("formAltaBecario:txtNumeroID").value;
    var fechaRegistro = document.getElementById("formAltaBecario:txtFechaRegistro").value;  
    var area = document.getElementById("formAltaBecario:txtArea").value;
    var solicitante = document.getElementById("formAltaBecario:txtSolicitante").value;
    var adscripcion = document.getElementById("formAltaBecario:txtAdcripcion").value;
    var zona = document.getElementById("formAltaBecario:cmbxZona").value;   
    
    if(numeroID == "0" || numeroID == null || numeroID.length == 0 || /^\s+$/.test(numeroID)){
        document.getElementById('formAltaBecario:lblNumeroID').style.color='red'; 
    }else{
        document.getElementById('formAltaBecario:lblNumeroID').style.color='';
    }
    if(fechaRegistro == null || fechaRegistro.length == 0 || /^\s+$/.test(fechaRegistro)){
        document.getElementById('formAltaBecario:lblFechaRegistro').style.color='red'; 
    }else{
      document.getElementById('formAltaBecario:lblFechaRegistro').style.color='';   
    }    
    if(area == null || area.length == 0 || /^\s+$/.test(area)){
        document.getElementById('formAltaBecario:lblArea').style.color='red'; 
    }else{
      document.getElementById('formAltaBecario:lblArea').style.color='';   
    }
    if (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) {
        document.getElementById('formAltaBecario:lblSolicitante').style.color = 'red';
    } else {
        document.getElementById('formAltaBecario:lblSolicitante').style.color = '';
    }
    if (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) {
        document.getElementById('formAltaBecario:lblAdcripcion').style.color = 'red';
    } else {
        document.getElementById('formAltaBecario:lblAdcripcion').style.color = '';
    }
    if (zona == null || zona.length == 0 || /^\s+$/.test(zona)) {
        document.getElementById('formAltaBecario:lblZona').style.color = 'red';
    } else {
        document.getElementById('formAltaBecario:lblZona').style.color = '';
    }    
}

function CambiaColorCamposVacios(){
    var area = document.getElementById("formReactivacionBeca:txtArea").value;
    var solicitante = document.getElementById("formReactivacionBeca:txtSolicitante").value;
    var adscripcion = document.getElementById("formReactivacionBeca:txtAdcripcion").value;
    var zona = document.getElementById("formReactivacionBeca:cmbxZona").value;
    if(area == null || area.length == 0 || /^\s+$/.test(area)){
        document.getElementById('formReactivacionBeca:lblArea').style.color='red'; 
    }else{
      document.getElementById('formReactivacionBeca:lblArea').style.color='';   
    }
    if (solicitante == null || solicitante.length == 0 || /^\s+$/.test(solicitante)) {
        document.getElementById('formReactivacionBeca:lblSolicitante').style.color = 'red';
    } else {
        document.getElementById('formReactivacionBeca:lblSolicitante').style.color = '';
    }
    if (adscripcion == null || adscripcion.length == 0 || /^\s+$/.test(adscripcion)) {
        document.getElementById('formReactivacionBeca:lblAdcripcion').style.color = 'red';
    } else {
        document.getElementById('formReactivacionBeca:lblAdcripcion').style.color = '';
    }
    if (zona == null || zona.length == 0 || /^\s+$/.test(zona)) {
        document.getElementById('formReactivacionBeca:lblZona').style.border = 'red';
    } else {
        document.getElementById('formReactivacionBeca:lblZona').style.border = '';
    }    
}




