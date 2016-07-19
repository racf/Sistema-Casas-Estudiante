package edu.uagro.dto;

public class Tbl_CasaEstudianteDTO {
   private String clave;
   private String nombre;
   private String direccion;
   private String latitud;
   private String longitud;
   private String observacion;
   private int cat_tipocasaIdDTO;
   private int cat_zonasIdDTO;
   private Cat_ZonasDTO cat_zonasDTO;
   private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCat_tipocasaIdDTO() {
        return cat_tipocasaIdDTO;
    }

    public void setCat_tipocasaIdDTO(int cat_tipocasaIdDTO) {
        this.cat_tipocasaIdDTO = cat_tipocasaIdDTO;
    }

    public int getCat_zonasIdDTO() {
        return cat_zonasIdDTO;
    }

    public void setCat_zonasIdDTO(int cat_zonasIdDTO) {
        this.cat_zonasIdDTO = cat_zonasIdDTO;
    }

    public Cat_ZonasDTO getCat_zonasDTO() {
        return cat_zonasDTO;
    }

    public void setCat_zonasDTO(Cat_ZonasDTO cat_zonasDTO) {
        this.cat_zonasDTO = cat_zonasDTO;
    }
    
}
