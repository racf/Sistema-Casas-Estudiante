package edu.uagro.dto;

public class Cat_TipoBecaExternaDTO {
    private int id;
    private String nombre;
    private int cat_nivelbecaexternaIdDTO;
    private String descripcion;

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

    public int getCat_nivelbecaexternaIdDTO() {
        return cat_nivelbecaexternaIdDTO;
    }

    public void setCat_nivelbecaexternaIdDTO(int cat_nivelbecaexternaIdDTO) {
        this.cat_nivelbecaexternaIdDTO = cat_nivelbecaexternaIdDTO;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
