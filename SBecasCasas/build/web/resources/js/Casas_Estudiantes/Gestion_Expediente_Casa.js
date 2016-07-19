
function eliminarExpediente (casa, boton) {
    var string = boton.id.substring(0, boton.id.lastIndexOf(':'));
    bootbox.dialog({
        message: "Esta seguro que quiere eliminar el expediente de la casa '"+ casa +"'?",
        title: "",
        buttons: {
            success: {
                label: "Si querio eliminar el expediente.",
                className: "btn-danger",
                callback: function () {
                    var boton = document.getElementById(string + ":eliminarExpediente");
                    boton.click();
                }
            },
            danger: {
                label: "Cancelar",
                className: "btn-default",
                callback: function () {

                }
            },
        }
    });
    e.preventdefault();
    return false;
}
