package edu.uagro.dto;

public class Tbl_BecarioArchivoDTO {
    private int id;
    private int tbl_becarioIdDTO;
    private String nombre;
    private String extencion;
    private String url;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTbl_becarioIdDTO() {
        return tbl_becarioIdDTO;
    }

    public void setTbl_becarioIdDTO(int tbl_becarioIdDTO) {
        this.tbl_becarioIdDTO = tbl_becarioIdDTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtencion() {
        return extencion;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
