/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Cat_NivelBecaBO;
import edu.uagro.bo.Cat_TipoBecaBO;
import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.bo.Tbl_DetalleBecarioBO;
import edu.uagro.dto.Cat_NivelBecaDTO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_BecarioDTO;
import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name="reactivacionBecaBeans")
@RequestScoped
public class ReactivacionBecaBeans {
    
    private Tbl_BecarioDTO becarioDTO;
    private Tbl_BecarioBO becarioBO;
    private Tbl_DetalleBecarioDTO detalleBecarioDTO;
    
    public ReactivacionBecaBeans(){
        becarioDTO = new Tbl_BecarioDTO();
        becarioBO = new Tbl_BecarioBO();
        detalleBecarioDTO = new Tbl_DetalleBecarioDTO();
        becarioDTO.setId(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"))));
        becarioBO.buscarBecario(becarioDTO);
        detalleBecarioDTO.setTbl_becarioIdDTO(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"))));
    }

    public Tbl_DetalleBecarioDTO getDetalleBecarioDTO() {
        return detalleBecarioDTO;
    }

    public void setDetalleBecarioDTO(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
        this.detalleBecarioDTO = detalleBecarioDTO;
    }
    

    public Tbl_BecarioDTO getBecarioDTO() {
        return becarioDTO;
    }

    public void setBecarioDTO(Tbl_BecarioDTO becarioDTO) {
        this.becarioDTO = becarioDTO;
    }

//    public String outcome(int id){
//		FacesContext fc = FacesContext.getCurrentInstance();
//                fc.getExternalContext().getSessionMap().put("id", id);                
//		return "ReactivacionBeca?faces-redirect=true";
//    }
    
    public String getBecarioParam(){		
            Map<String,Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();                
            return String.valueOf(params.get("id"));		
    }     
    
    public String salida(){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("id");
            return "Gestion_Beca?faces-redirect=true";
    }
    
    public ArrayList<Cat_NivelBecaDTO> obtenerNivelesBeca(){
        Cat_NivelBecaBO nivelBO = new Cat_NivelBecaBO();
        return nivelBO.obtenerDatos();
    }
    
    public ArrayList<Cat_TipoBecaDTO> obtenerTiposBeca(){
       Cat_TipoBecaBO tipoBecaBO = new Cat_TipoBecaBO();
       return tipoBecaBO.obtenerDatos();
   }
    
    public ArrayList<Cat_ZonasDTO> obtenerZonas(){
        Cat_ZonasBO zonasBO  = new Cat_ZonasBO();
        return zonasBO.obtenerZonas();
    }
    
    public void altaDetalleBecario(){
        Tbl_DetalleBecarioBO detalleBecarioBO = new Tbl_DetalleBecarioBO();
        detalleBecarioBO.altaDetalleBecario(this.detalleBecarioDTO);
    }
    
    public void obtenerDatosExternosBecario(){
        detalleBecarioDTO.setTbl_becarioIdDTO(becarioDTO.getId());
        Tbl_DetalleBecarioBO detalleBecarioBO = new Tbl_DetalleBecarioBO();
        detalleBecarioBO.buscarExternoReactivacion(this.detalleBecarioDTO);
    }            
}
