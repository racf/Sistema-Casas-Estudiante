/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.dto.Tbl_BecarioDTO;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "bajaBecarioBeans")
@RequestScoped
public class BajaBecarioBeans {
    private Tbl_BecarioDTO becarioDTO;
    private Tbl_BecarioBO becarioBO;
    
    public BajaBecarioBeans() {
        becarioDTO = new Tbl_BecarioDTO();
        becarioBO = new Tbl_BecarioBO();
        becarioDTO.setId(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"))));
        becarioBO.buscarBecario(becarioDTO);
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
    
    public void bajaBecario() {
        Tbl_BecarioBO becarioBajaBO = new Tbl_BecarioBO();
         becarioBajaBO.bajaBecario(this.becarioDTO);
    }
}
