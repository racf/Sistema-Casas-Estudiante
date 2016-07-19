package edu.uagro.dto;

import java.util.Date;

public class Tbl_ExpedienteCasaDTO {
    
    private int id;
    private String tbl_casaestudianteClaveDTO;
    private Tbl_CasaEstudianteDTO tbl_casaestudianteDTO;
    private int tbl_arrendatarioIdDTO;
    private Tbl_ArrendatarioDTO tbl_arrendatarioDTO;
    private String tbl_representanteMatriculaDTO;
    private Tbl_RepresentanteDTO tbl_representanteDTO;
    private int tbl_arrendadorIdDTO;
    private Tbl_ArrendadorDTO tbl_arrendadorDTO;
    private double montoRenta;
    private double aumento;
    private double montoTotal;
    private String montoLetra;
    private String tipoRenta;
    private Date fechaInicio;
    private Date fechaInicialArrendamiento;
    private Date fechaFinalArrendamiento;
    private int estado;

    public Tbl_ExpedienteCasaDTO() {
        
    }
    
    public double getAumento() {
        return aumento;
    }

    public void setAumento(double aumento) {
        this.aumento = aumento;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMontoLetra() {
        return montoLetra;
    }

    public void setMontoLetra(String montoLetra) {
        this.montoLetra = montoLetra;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTbl_casaestudianteClaveDTO() {
        return tbl_casaestudianteClaveDTO;
    }

    public void setTbl_casaestudianteClaveDTO(String tbl_casaestudianteClaveDTO) {
        this.tbl_casaestudianteClaveDTO = tbl_casaestudianteClaveDTO;
    }

    public int getTbl_arrendatarioIdDTO() {
        return tbl_arrendatarioIdDTO;
    }

    public void setTbl_arrendatarioIdDTO(int tbl_arrendatarioIdDTO) {
        this.tbl_arrendatarioIdDTO = tbl_arrendatarioIdDTO;
    }

    public String getTbl_representanteMatriculaDTO() {
        return tbl_representanteMatriculaDTO;
    }

    public void setTbl_representanteMatriculaDTO(String tbl_representanteMatriculaDTO) {
        this.tbl_representanteMatriculaDTO = tbl_representanteMatriculaDTO;
    }

    public int getTbl_arrendadorIdDTO() {
        return tbl_arrendadorIdDTO;
    }

    public void setTbl_arrendadorIdDTO(int tbl_arrendadorIdDTO) {
        this.tbl_arrendadorIdDTO = tbl_arrendadorIdDTO;
    }

    public double getMontoRenta() {
        return montoRenta;
    }

    public void setMontoRenta(double montoRenta) {
        this.montoRenta = montoRenta;
    }

    public String getTipoRenta() {
        return tipoRenta;
    }

    public void setTipoRenta(String tipoRenta) {
        this.tipoRenta = tipoRenta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicialArrendamiento() {
        return fechaInicialArrendamiento;
    }

    public void setFechaInicialArrendamiento(Date fechaInicialArrendamiento) {
        this.fechaInicialArrendamiento = fechaInicialArrendamiento;
    }

    public Date getFechaFinalArrendamiento() {
        return fechaFinalArrendamiento;
    }

    public void setFechaFinalArrendamiento(Date fechaFinalArrendamiento) {
        this.fechaFinalArrendamiento = fechaFinalArrendamiento;
    }

    public Tbl_CasaEstudianteDTO getTbl_casaestudianteDTO() {
        return tbl_casaestudianteDTO;
    }

    public void setTbl_casaestudianteDTO(Tbl_CasaEstudianteDTO tbl_casaestudianteDTO) {
        this.tbl_casaestudianteDTO = tbl_casaestudianteDTO;
    }

    public Tbl_ArrendatarioDTO getTbl_arrendatarioDTO() {
        return tbl_arrendatarioDTO;
    }

    public void setTbl_arrendatarioDTO(Tbl_ArrendatarioDTO tbl_ArrendatarioDTO) {
        this.tbl_arrendatarioDTO = tbl_ArrendatarioDTO;
    }

    public Tbl_RepresentanteDTO getTbl_representanteDTO() {
        return tbl_representanteDTO;
    }

    public void setTbl_representanteDTO(Tbl_RepresentanteDTO tbl_representanteDTO) {
        this.tbl_representanteDTO = tbl_representanteDTO;
    }

    public Tbl_ArrendadorDTO getTbl_arrendadorDTO() {
        return tbl_arrendadorDTO;
    }

    public void setTbl_arrendadorDTO(Tbl_ArrendadorDTO tbl_arrendadorDTO) {
        this.tbl_arrendadorDTO = tbl_arrendadorDTO;
    }

    @Override
    public String toString() {
        return "Tbl_ExpedienteCasaDTO{" + "id=" + id + 
                ", tbl_casaestudianteClaveDTO=" + tbl_casaestudianteClaveDTO + 
                ", tbl_casaestudianteDTO=" + tbl_casaestudianteDTO + 
                ", tbl_arrendatarioIdDTO=" + tbl_arrendatarioIdDTO + 
                ", tbl_arrendatarioDTO=" + tbl_arrendatarioDTO + 
                ", tbl_representanteMatriculaDTO=" + tbl_representanteMatriculaDTO + 
                ", tbl_representanteDTO=" + tbl_representanteDTO + 
                ", tbl_arrendadorIdDTO=" + tbl_arrendadorIdDTO + 
                ", tbl_arrendadorDTO=" + tbl_arrendadorDTO + 
                ", montoRenta=" + montoRenta + 
                ", aumento=" + aumento + 
                ", montoTotal=" + montoTotal + 
                ", montoLetra=" + montoLetra + 
                ", tipoRenta=" + tipoRenta + 
                ", fechaInicio=" + fechaInicio + 
                ", fechaInicialArrendamiento=" + fechaInicialArrendamiento + 
                ", fechaFinalArrendamiento=" + fechaFinalArrendamiento + 
                ", estado=" + estado + '}';
    }
    
}
