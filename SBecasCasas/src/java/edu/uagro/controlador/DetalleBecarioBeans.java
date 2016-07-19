/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.bo.Tbl_DetalleBecarioBO;
import edu.uagro.dto.Cat_NivelBecaDTO;
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
@ManagedBean(name="detalleBecarioBeans")
@RequestScoped
public class DetalleBecarioBeans {
    private Tbl_BecarioDTO becarioDTO;
    private Tbl_BecarioBO becarioBO;
    private Tbl_DetalleBecarioDTO detalleBecarioDTO;
    private Tbl_DetalleBecarioBO detalleBecarioBO;
    private Cat_NivelBecaDTO nivelBecaDTO;
    
    public DetalleBecarioBeans() {
        becarioDTO = new Tbl_BecarioDTO();
        becarioBO = new Tbl_BecarioBO();
        //OBTENER LOS DATOS DEL DETALLE DEL BECARIO...
        becarioDTO.setId(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"))));
        becarioBO.buscarBecario(becarioDTO);
        
        nivelBecaDTO = new Cat_NivelBecaDTO();
        
        detalleBecarioDTO = new Tbl_DetalleBecarioDTO();
        detalleBecarioBO = new Tbl_DetalleBecarioBO();
//        detalleBecarioDTO.setTbl_becarioIdDTO(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"))));
//        detalleBecarioBO.obtenerDatos(detalleBecarioDTO);
    }

    public Cat_NivelBecaDTO getNivelBecaDTO() {
        return nivelBecaDTO;
    }

    public void setNivelBecaDTO(Cat_NivelBecaDTO nivelBecaDTO) {
        this.nivelBecaDTO = nivelBecaDTO;
    }
    
    public Tbl_BecarioBO getBecarioBO() {
        return becarioBO;
    }

    public void setBecarioBO(Tbl_BecarioBO becarioBO) {
        this.becarioBO = becarioBO;
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
    
    public String getBecarioParam(){		
            Map<String,Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();                
            return String.valueOf(params.get("id"));		
    }     
    
    public String salida(){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("id");
            return "Gestion_Beca?faces-redirect=true";
    }
    
    public String outcomeVerDetalleBecario(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("idDetalleBecario", id);
        return "VerDetalleBecaInterna?faces-redirect=true";
    }
    
  
    
    public ArrayList<Tbl_DetalleBecarioDTO> obtenerDatos(int clave) {
       Tbl_DetalleBecarioBO detalleBecarioBO1 = new Tbl_DetalleBecarioBO();
       return detalleBecarioBO1.obtenerDatos(clave);
    }
        
}
