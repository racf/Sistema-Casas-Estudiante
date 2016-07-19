package edu.uagro.dto;

public class Tbl_DetalleBecaExternaDTO {

    private int id;
    private int cat_anioIdDTO;
    private int cat_tipobecaexternaIdDTO;
    private String unidadAcademicaNombre;
    private int cantidad;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_anioIdDTO() {
        return cat_anioIdDTO;
    }

    public void setCat_anioIdDTO(int cat_anioIdDTO) {
        this.cat_anioIdDTO = cat_anioIdDTO;
    }

    public int getCat_tipobecaexternaIdDTO() {
        return cat_tipobecaexternaIdDTO;
    }

    public void setCat_tipobecaexternaIdDTO(int cat_tipobecaexternaIdDTO) {
        this.cat_tipobecaexternaIdDTO = cat_tipobecaexternaIdDTO;
    }

    public String getUnidadAcademicaNombre() {
        return unidadAcademicaNombre;
    }

    public void setUnidadAcademicaNombre(String unidadAcademicaNombre) {
        this.unidadAcademicaNombre = unidadAcademicaNombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
