package edu.uagro.dto;

public class Tbl_ResponsableDTO {
   private int id;
   private String nombre;
   private String apellidoPat;
   private String apellidoMat;
   private String email;
   private int cat_zonasIdDTO;
   private int estado;
   private Cat_ZonasDTO zonasDTO = new Cat_ZonasDTO();

    public Cat_ZonasDTO getZonasDTO() {
        return zonasDTO;
    }

    public void setZonasDTO(Cat_ZonasDTO zonasDTO) {
        this.zonasDTO = zonasDTO;
    }
   
    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCat_zonasIdDTO() {
        return cat_zonasIdDTO;
    }

    public void setCat_zonasIdDTO(int cat_zonasIdDTO) {
        this.cat_zonasIdDTO = cat_zonasIdDTO;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
}
