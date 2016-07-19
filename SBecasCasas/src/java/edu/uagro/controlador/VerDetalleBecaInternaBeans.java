/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Tbl_DetalleBecarioBO;
import edu.uagro.dto.Cat_NivelBecaDTO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_BecarioDTO;
import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name="verDetalleBecaInternaBeans")
@RequestScoped
public class VerDetalleBecaInternaBeans {
    private Tbl_DetalleBecarioDTO detalleBecarioDTO;
    private Tbl_DetalleBecarioBO detalleBecarioBO;
    private Tbl_BecarioDTO becarioDTO;
    private Cat_NivelBecaDTO nivelBecaDTO;
    private Cat_TipoBecaDTO tipoBecaDTO;
    private Cat_ZonasDTO zonasDTO;
    
    public VerDetalleBecaInternaBeans() {
        detalleBecarioDTO = new Tbl_DetalleBecarioDTO();
        detalleBecarioBO = new Tbl_DetalleBecarioBO();
        becarioDTO = new Tbl_BecarioDTO();
        nivelBecaDTO = new Cat_NivelBecaDTO();
        tipoBecaDTO = new Cat_TipoBecaDTO();
        zonasDTO = new Cat_ZonasDTO();         
        detalleBecarioDTO.setId(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idDetalleBecario"))));
        detalleBecarioBO.buscarDetalleBecario(detalleBecarioDTO);          
    }

    public Tbl_BecarioDTO getBecarioDTO() {
        return becarioDTO;
    }

    public void setBecarioDTO(Tbl_BecarioDTO becarioDTO) {
        this.becarioDTO = becarioDTO;
    }

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
    

    public Tbl_DetalleBecarioDTO getDetalleBecarioDTO() {
        return detalleBecarioDTO;
    }

    public void setDetalleBecarioDTO(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
        this.detalleBecarioDTO = detalleBecarioDTO;
    }
    
    
    public String getIdDetalleBecarioParam(){		
        Map<String,Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();                
        return String.valueOf(params.get("idDetalleBecario"));		
    }
    
    public String salida(){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("idDetalleBecario");
            return "Gestion_Beca?faces-redirect=true";
    }
    
}
