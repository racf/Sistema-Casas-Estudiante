package edu.uagro.dto;

public class Tbl_ArchivosDTO {
    private int id;
    private int tbl_expedientecasaIdDTO;
    private String nombre;
    private String extencion;
    private String url;
    private String descripcion;
    private int cat_archivosIdDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTbl_expedientecasaIdDTO() {
        return tbl_expedientecasaIdDTO;
    }

    public void setTbl_expedientecasaIdDTO(int tbl_expedientecasaIdDTO) {
        this.tbl_expedientecasaIdDTO = tbl_expedientecasaIdDTO;
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

    public int getCat_archivosIdDTO() {
        return cat_archivosIdDTO;
    }

    public void setCat_archivosIdDTO(int cat_archivosIdDTO) {
        this.cat_archivosIdDTO = cat_archivosIdDTO;
    }
    
}
