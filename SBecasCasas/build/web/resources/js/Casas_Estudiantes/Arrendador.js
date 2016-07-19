

function buscarAltaArrendador(id) {
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid + ":btnBuscarArrendador");
    button.click();
}


function buscarModArrendador(id) {
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid + ":ActualizarArrendador");
    button.click();
}

function validarAltaArrendador(id, estado) {
    var numprovedor = document.getElementById("formAltaArrendador:txtID").value;
    var aux = document.getElementById("formAltaArrendador:auxNumero").value;
    var domicilio = document.getElementById("formAltaArrendador:txtDomicilio").value;
    var curp = document.getElementById("formAltaArrendador:txtcurp").value;
    var telefono = document.getElementById("formAltaArrendador:txtTelefono").value;
    var email = document.getElementById("formAltaArrendador:txtemail").value;
    var tipoArrendador = document.getElementById("formAltaArrendador:cmbxTipoArrendador").value;
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;

    //alert(numprovedor+" "+aux);
    if (numprovedor != aux) {
        $("#mensajeAltaArrendador").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>No a presionado el boton buscar..!</strong></div>");
    } else if ((numprovedor == "0" || numprovedor == null || numprovedor.length == 0 || /^\s+$/.test(numprovedor))
            || (domicilio == null || domicilio.length == 0 || /^\s+$/.test(domicilio)) ||
            (curp == null || curp.length == 0 || /^\s+$/.test(curp)) ||
            (telefono == "0" || telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) ||
            (email == null || email.length == 0 || /^\s+$/.test(email)) ||
            (tipoArrendador == null || tipoArrendador.length == 0 || /^\s+$/.test(tipoArrendador))) {
        $("#mensajeAltaArrendador").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>No se han rellenado campos obligatorios..!</strong></div>");
        cambiarColor();
    } else if (!patron.test(email)) {
        $("#mensajeAltaArrendador").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Email invalido..!</strong></div>");
        cambiarColor();
    } else {
        if (estado == true) {
            $("#mensajeAltaArrendador").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>El proveedor ya es encuentra en el sistema ..!</strong></div>");
        } else {
            cambiarColor();
            var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
            var button = document.getElementById(auxid + ":btnAltaArrendador");
            $("#mensajeAltaArrendador").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Alta Exitosa..!</strong></div>");
            button.click();
        }
    }

}

function validarModArrendador(id) {
    
    var domicilio = document.getElementById("formModArrendador:txtDomicilio").value;
    var curp = document.getElementById("formModArrendador:txtcurp").value;
    var telefono = document.getElementById("formModArrendador:txtTelefono").value;
    var email = document.getElementById("formModArrendador:txtemail").value;
    var tipoArrendador = document.getElementById("formModArrendador:cmbxTipoArrendador").value;
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;

    //alert(numprovedor+" "+aux);
    if ((domicilio == null || domicilio.length == 0 || /^\s+$/.test(domicilio)) ||
            (curp == null || curp.length == 0 || /^\s+$/.test(curp)) ||
            (telefono == "0" || telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) ||
            (email == null || email.length == 0 || /^\s+$/.test(email)) ||
            (tipoArrendador == null || tipoArrendador.length == 0 || /^\s+$/.test(tipoArrendador))) {
        $("#mensajeAltaArrendador").html("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>No se han rellenado campos obligatorios..!</strong></div>");

    } else if (!patron.test(email)) {
        $("#mensajeAltaArrendador").html("<div class='alert alert-info'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Email invalido..!</strong></div>");

    } else {
            var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
            var button = document.getElementById(auxid + ":btnModArrendador");
            $("#mensajeAltaArrendador").html("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Alta Exitosa..!</strong></div>");
            button.click();
    }

}

function cambiarColor() {
    var domicilio = document.getElementById("formAltaArrendador:txtDomicilio").value;
    var numprovedor = document.getElementById("formAltaArrendador:txtID").value;
    var curp = document.getElementById("formAltaArrendador:txtcurp").value;
    var telefono = document.getElementById("formAltaArrendador:txtTelefono").value;
    var email = document.getElementById("formAltaArrendador:txtemail").value;
    var tipoArrendador = document.getElementById("formAltaArrendador:cmbxTipoArrendador").value;

    if (domicilio == null || domicilio.length == 0 || /^\s+$/.test(domicilio)) {
        document.getElementById("formAltaArrendador:lblDomicilio").style.color = 'red';

    } else {
        document.getElementById("formAltaArrendador:lblDomicilio").style.color = '';
    }

    if (curp == null || curp.length == 0 || /^\s+$/.test(curp)) {
        document.getElementById("formAltaArrendador:lblCurp").style.color = 'red';
    } else {
        document.getElementById("formAltaArrendador:lblCurp").style.color = '';

    }

    if (telefono == "0" || telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) {
        document.getElementById("formAltaArrendador:lblTelefono").style.color = 'red';
    } else {
        document.getElementById("formAltaArrendador:lblTelefono").style.color = '';

    }

    if (email == null || email.length == 0 || /^\s+$/.test(email)) {
        document.getElementById("formAltaArrendador:lblEmail").style.color = 'red';
    } else {
        document.getElementById("formAltaArrendador:lblEmail").style.color = '';

    }

    if (tipoArrendador == null || tipoArrendador.length == 0 || /^\s+$/.test(tipoArrendador)) {
        document.getElementById("formAltaArrendador:lblTipoArrendadro").style.color = 'red';
    } else {
        document.getElementById("formAltaArrendador:lblTipoArrendadro").style.color = '';

    }


}

function eliminarArredador(button){
    var string = button.id.substring(0, button.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro de eliminar el arrendador.",
        buttons: {
            success: {
                label: "Si quiero eliminarlo.",
                className: "btn-default",
                callback: function() {
                    var eliminar = document.getElementById(string+":EliminarArrendador");
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

