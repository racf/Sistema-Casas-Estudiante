package edu.uagro.dto;

import java.util.Date;

public class Tbl_DetalleBecarioDTO{
    private int id;
    private String fecha;
    private int tbl_becarioIdDTO;
    private Date fechaInicioBeca;
    private Date fechaFinBeca;
    private String area;
    private String solicitante;
    private String adscripcion;
    private int cat_zonasIdDTO;
    private int cat_nivelbecaIdDTO;
    private int cat_tipobecaIdDTO;
    private String observacion;
    private int estado;  
    
    private Tbl_BecarioDTO becarioDTO = new Tbl_BecarioDTO();
    private Cat_NivelBecaDTO nivelBecaDTO = new Cat_NivelBecaDTO();
    private Cat_TipoBecaDTO tipoBecaDTO = new Cat_TipoBecaDTO();
    private Cat_ZonasDTO zonasDTO = new Cat_ZonasDTO();

    public Cat_NivelBecaDTO getNivelBecaDTO() {
        return nivelBecaDTO;
    }

    public void setNivelBecaDTO(Cat_NivelBecaDTO nivelBecaDTO) {
        this.nivelBecaDTO = nivelBecaDTO;
    }

    public Cat_TipoBecaDTO getTipoBecaDTO() {
        return tipoBecaDTO;
    }

    public void setTipoBecaDTO(Cat_TipoBecaDTO tipoBecaDTO) {
        this.tipoBecaDTO = tipoBecaDTO;
    }

    public Cat_ZonasDTO getZonasDTO() {
        return zonasDTO;
    }

    public void setZonasDTO(Cat_ZonasDTO zonasDTO) {
        this.zonasDTO = zonasDTO;
    }

    public Tbl_BecarioDTO getBecarioDTO() {
        return becarioDTO;
    }

    public void setBecarioDTO(Tbl_BecarioDTO becarioDTO) {
        this.becarioDTO = becarioDTO;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTbl_becarioIdDTO() {
        return tbl_becarioIdDTO;
    }

    public void setTbl_becarioIdDTO(int tbl_becarioIdDTO) {
        this.tbl_becarioIdDTO = tbl_becarioIdDTO;
    }

    public Date getFechaFinBeca() {
        return fechaFinBeca;
    }

    public void setFechaFinBeca(Date fechaFinBeca) {
        this.fechaFinBeca = fechaFinBeca;
    }

    public Date getFechaInicioBeca() {
        return fechaInicioBeca;
    }

    public void setFechaInicioBeca(Date fechaInicioBeca) {
        this.fechaInicioBeca = fechaInicioBeca;
    }
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getAdscripcion() {
        return adscripcion;
    }

    public void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }

    public int getCat_zonasIdDTO() {
        return cat_zonasIdDTO;
    }

    public void setCat_zonasIdDTO(int cat_zonasIdDTO) {
        this.cat_zonasIdDTO = cat_zonasIdDTO;
    }

    public int getCat_nivelbecaIdDTO() {
        return cat_nivelbecaIdDTO;
    }

    public void setCat_nivelbecaIdDTO(int cat_nivelbecaIdDTO) {
        this.cat_nivelbecaIdDTO = cat_nivelbecaIdDTO;
    }

    public int getCat_tipobecaIdDTO() {
        return cat_tipobecaIdDTO;
    }

    public void setCat_tipobecaIdDTO(int cat_tipobecaIdDTO) {
        this.cat_tipobecaIdDTO = cat_tipobecaIdDTO;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
        
}
