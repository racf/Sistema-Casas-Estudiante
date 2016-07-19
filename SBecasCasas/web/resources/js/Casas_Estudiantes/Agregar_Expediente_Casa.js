
function validarCampos(tipo) { // el tipo puede ser 1 o 2 en donde 1 = agregar y 2 = editar
    var casas = document.getElementById("formulario:casas");
    var arrendatarios = document.getElementById("formulario:arrendatarios");
    var montoRenta = document.getElementById("formulario:montoRenta");
    var tipoRenta = document.getElementById("formulario:tipoRenta");
    var fechaInicial = document.getElementById("formulario:fechaInicial");
    var arrendadores = document.getElementById("formulario:arrendadores");
    var aumentoRenta = document.getElementById("formulario:aumentoRenta");
    var montoTotal = document.getElementById("formulario:montoTotal");
    var fechaFinal = document.getElementById("formulario:fechaFinal");
    var hiddenMatricula = document.getElementById("formulario:hiddenMatricula");
    var band = true; // validacion correcta

//    console.log("casas = " + casas.value + "\n" +
//            "arrendatarios = " + arrendatarios.value + "\n" +
//            "montoRenta = " + montoRenta.value + "\n" +
//            "tipoRenta = " + tipoRenta.value + "\n" +
//            "fechaInicial = " + fechaInicial.value + "\n" +
//            "arrendadores = " + arrendadores.value + "\n" +
//            "aumentoRenta = " + aumentoRenta.value + "\n" +
//            "montoTotal = " + montoTotal.value + "\n" +
//            "cantLetra = " + cantLetra.value + "\n" +
//            "fechaFinal = " + fechaFinal.value + "\n" +
//            "hiddenMatricula = " + hiddenMatricula.value + "\n");
//
    if (casas.value.length === 0) {
        document.getElementById("formulario_casas_chosen").style.border = '1px solid red';
        band = false;
    } else {
        document.getElementById("formulario_casas_chosen").style.border = '';
    }
    if (arrendatarios.value.length === 0) {
        document.getElementById("formulario_arrendatarios_chosen").style.border = '1px solid red';
        band = false;
    } else {
        document.getElementById("formulario_arrendatarios_chosen").style.border = '';
    }
    if (montoRenta.value == 0 || montoRenta.value.length === 0) {
        montoRenta.parentNode.className += ' has-error';
        band = false;
    } else {
        montoRenta.parentNode.className = montoRenta.parentNode.className.split(' has-error').join('');
    }
    if (tipoRenta.value.length === 0) {
        document.getElementById("formulario_tipoRenta_chosen").style.border = '1px solid red';
        band = false;
    } else {
        document.getElementById("formulario_tipoRenta_chosen").style.border = '';
    }
    if (fechaInicial.value.length === 0) {
        fechaInicial.parentNode.className += ' has-error';
        band = false;
    } else {
        fechaInicial.parentNode.className = fechaInicial.parentNode.className.split(' has-error').join('');
    }
    if (arrendadores.value.length === 0) {
        document.getElementById("formulario_arrendadores_chosen").style.border = '1px solid red';
        band = false;
    } else {
        document.getElementById("formulario_arrendadores_chosen").style.border = '';
    }
    if (aumentoRenta.value.length === 0) {
        aumentoRenta.parentNode.className += ' has-error';
        band = false;
    } else {
        aumentoRenta.parentNode.className = aumentoRenta.parentNode.className.split(' has-error').join('');
    }
    if (montoTotal.value == 'NaN') {
        montoRenta.parentNode.className += ' has-error';
        aumentoRenta.parentNode.className += ' has-error';
        band = false;
    }
    if (fechaFinal.value.length === 0) {
        fechaFinal.parentNode.className += ' has-error';
        band = false;
    } else {
        fechaFinal.parentNode.className = fechaFinal.parentNode.className.split(' has-error').join('');
    }
    if (band === true) {
        var auxfechaIncio = fechaInicial.value.split("-");
        var auxfechaFin = fechaFinal.value.split("-");
        var dateInicio = new Date(auxfechaIncio[0], (auxfechaIncio[1] - 1), auxfechaIncio[2]);
        var dateFin = new Date(auxfechaFin[0], (auxfechaFin[1] - 1), auxfechaFin[2]);
//            console.log("auxfechaInicio = " + auxfechaIncio + "\n" +
//                "auxfechaFin = " + auxfechaFin + "\n" +
//                "dateInicio = " + dateInicio + "\n" +
//                "dateFin = " + dateFin + "\n");
        if (dateInicio > dateFin) {
//                console.log("dateInicio is after dateFin = " + (dateInicio > dateFin));
            fechaInicial.parentNode.className += ' has-error';
            fechaFinal.parentNode.className += ' has-error';
            band = false;
        } else {
//                console.log("dateInicio is before dateFin = " + (dateInicio < dateFin));
            fechaInicial.parentNode.className = fechaFinal.parentNode.className.split(' has-error').join('');
            fechaFinal.parentNode.className = fechaFinal.parentNode.className.split(' has-error').join('');
        }
        if (band === true) {
            if (hiddenMatricula.value.length === 0) {
                band = false;
            }
            if (band === true) {
                $("#message").html("");
                var boton;
                if (tipo === 1) {
                    boton = document.getElementById("formulario:agregarExpediente");
                    boton.click();
                } else {
                    boton = document.getElementById("formulario:editarExpediente");
                    boton.click();
                }
            } else {
                $("#message").html(
                        "<div class='alert alert-danger'>\n\
                            <button type='button' class='close' data-dismiss='alert'>&times;</button>\n\
                            <span class='glyphicon glyphicon-chevron-down'\n\
                            <strong> \n\
                                Es necesario seleccionar un representante.\n\
                            </strong> \n\
                        </div>"
                        );
            }
        } else {
            $("#message").html(
                    "<div class='alert alert-danger'>\n\
                        <button type='button' class='close' data-dismiss='alert'>&times;</button>\n\
                        <span class='glyphicon glyphicon-chevron-up'\n\
                        <strong> \n\
                            La Fecha Inicial de Arrendamiento debe de ser anterior a la Fecha Final.\n\
                        </strong> \n\
                    </div>"
                    );
        }
    } else {
        $("#message").html(
                "<div class='alert alert-danger'>\n\
                    <button type='button' class='close' data-dismiss='alert'>&times;</button>\n\
                    <span class='glyphicon glyphicon-chevron-up'></span>\n\
                    <strong> \n\
                        Hace falta rellenar algunos campos obligatorios.\n\
                    </strong> \n\
                </div>"
                );
    }
    e.preventDefault();
    return false;
}

function calcularMontoTotal() {
    var montoRenta = document.getElementById("formulario:montoRenta");
    var aumentoRenta = document.getElementById("formulario:aumentoRenta");
    var montoTotal = document.getElementById("formulario:montoTotal");
    var cantidadLetra = document.getElementById("formulario:cantLetra");
    montoTotal.value = (parseFloat(montoRenta.value) + (parseFloat(montoRenta.value) * (parseFloat(aumentoRenta.value) / 100))).toFixed(2);
    cantidadLetra.value = NumeroALetras(montoTotal.value);
}

function procesarCheckBox(htmlComp) {
    var hiddenMatricula = document.getElementById("formulario:hiddenMatricula");
    var inputHidden = htmlComp.parentNode.getElementsByTagName('input')[1];
    console.log(inputHidden);
    console.log('hiddenMatricula b4 = ' + hiddenMatricula.value);
    hiddenMatricula.value = inputHidden.value;
    console.log('matricula procesada es = ' + hiddenMatricula.value);
    var boton = document.getElementById("formulario:hiddenButton");
    boton.click();
}

function procesarTableCheckBox() {
    var expMatricula = document.getElementById("formulario:hiddenMatricula").value;
    console.log('la matricula recibida es = ' + expMatricula);
    var table = document.getElementById("form:table");
    var row;
    var cell;
    var checkBox;
    var inputHidden;
    console.log('/////////////////////////////');
    for (var i = 1, row; row = table.rows[i]; i++) {
//iterate through rows
//rows would be accessed using the "row" variable assigned in the for loop
        cell = row.cells[5];
        checkBox = cell.getElementsByTagName('input')[0];
        inputHidden = cell.getElementsByTagName('input')[1];
        
        console.log('inputHidden.value = ' + inputHidden.value + ' ------ expMatricula = ' + expMatricula);
        console.log('(inputHidden.value === expMatricula) = ' + (inputHidden.value === expMatricula));
        if (inputHidden.value === expMatricula) {
            checkBox.checked = true;
        } else {
            checkBox.checked = false;
        }
    }
    console.log('------------------------');
}

//<editor-fold defaultstate="collapsed" desc="Numero - A - Letras">
function Unidades(num) {

    switch (num)
    {
        case 1:
            return "UN";
        case 2:
            return "DOS";
        case 3:
            return "TRES";
        case 4:
            return "CUATRO";
        case 5:
            return "CINCO";
        case 6:
            return "SEIS";
        case 7:
            return "SIETE";
        case 8:
            return "OCHO";
        case 9:
            return "NUEVE";
    }

    return "";
}

function Decenas(num) {

    decena = Math.floor(num / 10);
    unidad = num - (decena * 10);
    switch (decena)
    {
        case 1:
            switch (unidad)
            {
                case 0:
                    return "DIEZ";
                case 1:
                    return "ONCE";
                case 2:
                    return "DOCE";
                case 3:
                    return "TRECE";
                case 4:
                    return "CATORCE";
                case 5:
                    return "QUINCE";
                default:
                    return "DIECI" + Unidades(unidad);
            }
        case 2:
            switch (unidad)
            {
                case 0:
                    return "VEINTE";
                default:
                    return "VEINTI" + Unidades(unidad);
            }
        case 3:
            return DecenasY("TREINTA", unidad);
        case 4:
            return DecenasY("CUARENTA", unidad);
        case 5:
            return DecenasY("CINCUENTA", unidad);
        case 6:
            return DecenasY("SESENTA", unidad);
        case 7:
            return DecenasY("SETENTA", unidad);
        case 8:
            return DecenasY("OCHENTA", unidad);
        case 9:
            return DecenasY("NOVENTA", unidad);
        case 0:
            return Unidades(unidad);
    }
}//Unidades()

function DecenasY(strSin, numUnidades) {
    if (numUnidades > 0)
        return strSin + " Y " + Unidades(numUnidades)

    return strSin;
}//DecenasY()

function Centenas(num) {

    centenas = Math.floor(num / 100);
    decenas = num - (centenas * 100);
    switch (centenas)
    {
        case 1:
            if (decenas > 0)
                return "CIENTO " + Decenas(decenas);
            return "CIEN";
        case 2:
            return "DOSCIENTOS " + Decenas(decenas);
        case 3:
            return "TRESCIENTOS " + Decenas(decenas);
        case 4:
            return "CUATROCIENTOS " + Decenas(decenas);
        case 5:
            return "QUINIENTOS " + Decenas(decenas);
        case 6:
            return "SEISCIENTOS " + Decenas(decenas);
        case 7:
            return "SETECIENTOS " + Decenas(decenas);
        case 8:
            return "OCHOCIENTOS " + Decenas(decenas);
        case 9:
            return "NOVECIENTOS " + Decenas(decenas);
    }

    return Decenas(decenas);
}//Centenas()

function Seccion(num, divisor, strSingular, strPlural) {
    cientos = Math.floor(num / divisor)
    resto = num - (cientos * divisor)

    letras = "";
    if (cientos > 0)
        if (cientos > 1)
            letras = Centenas(cientos) + " " + strPlural;
        else
            letras = strSingular;
    if (resto > 0)
        letras += "";
    return letras;
}//Seccion()

function Miles(num) {
    divisor = 1000;
    cientos = Math.floor(num / divisor)
    resto = num - (cientos * divisor)

    strMiles = Seccion(num, divisor, "UN MIL", "MIL");
    strCentenas = Centenas(resto);
    if (strMiles == "")
        return strCentenas;
    return strMiles + " " + strCentenas;
    //return Seccion(num, divisor, "UN MIL", "MIL") + " " + Centenas(resto);
}//Miles()

function Millones(num) {
    divisor = 1000000;
    cientos = Math.floor(num / divisor)
    resto = num - (cientos * divisor)

    strMillones = Seccion(num, divisor, "UN MILLON", "MILLONES");
    strMiles = Miles(resto);
    if (strMillones == "")
        return strMiles;
    return strMillones + " " + strMiles;
    //return Seccion(num, divisor, "UN MILLON", "MILLONES") + " " + Miles(resto);
}//Millones()

function NumeroALetras(num) {
    var data = {
        numero: num,
        enteros: Math.floor(num),
        centavos: (((Math.round(num * 100)) - (Math.floor(num) * 100))),
        letrasCentavos: "",
        letrasMonedaPlural: "PESOS",
        letrasMonedaSingular: "PESO"
    };
    if (data.centavos > 0)
        data.letrasCentavos = "CON " + data.centavos + "/100";
    if (data.enteros == 0)
        return "CERO " + data.letrasMonedaPlural + " " + data.letrasCentavos;
    if (data.enteros == 1)
        return Millones(data.enteros) + " " + data.letrasMonedaSingular + " " + data.letrasCentavos;
    else
        return Millones(data.enteros) + " " + data.letrasMonedaPlural + " " + data.letrasCentavos;
}//NumeroALetras()

//</editor-fold>
