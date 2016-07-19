function obtenerDetalleBecarioID(id){    
    var auxid = id.id.substring(0, id.id.lastIndexOf(":"));
    var button = document.getElementById(auxid+":btnVerDetalleBeca");
    button.click();    
}

