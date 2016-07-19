package edu.uagro.dto;

public class Tbl_ArrendadorDTO {
    private int id;
    private String nombre;
    private String NumProveedor;
    private String RFC;
    private String apellidoPat;
    private String apellidoMat;
    private String domicilio;
    private String curp;
    private String telefono;
    private String email;
    private int cat_tipoarrendadorIdDTO;
    Cat_TipoArrendadorDTO tipoArrendadordto;

    public int getId() {
        return id;
    }

    public String getNumProveedor() {
        return NumProveedor;
    }

    public void setNumProveedor(String NumProveedor) {
        this.NumProveedor = NumProveedor;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCat_tipoarrendadorIdDTO() {
        return cat_tipoarrendadorIdDTO;
    }

    public void setCat_tipoarrendadorIdDTO(int cat_tipoarrendadorIdDTO) {
        this.cat_tipoarrendadorIdDTO = cat_tipoarrendadorIdDTO;
    }

    public Cat_TipoArrendadorDTO getTipoArrendadordto() {
        return tipoArrendadordto;
    }

    public void setTipoArrendadordto(Cat_TipoArrendadorDTO tipoArrendadordto) {
        this.tipoArrendadordto = tipoArrendadordto;
    }
    
}
