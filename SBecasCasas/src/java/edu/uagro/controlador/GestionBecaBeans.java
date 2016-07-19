/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.dto.Tbl_BecarioDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */

@ManagedBean (name = "gestionBecaBeans")
@ViewScoped
public class GestionBecaBeans {
    private Tbl_BecarioDTO becarioDTO;
    
    public GestionBecaBeans() {
        becarioDTO = new Tbl_BecarioDTO();                
    }

    public Tbl_BecarioDTO getBecarioDTO() {
        return becarioDTO;
    }

    public void setBecarioDTO(Tbl_BecarioDTO becarioDTO) {
        this.becarioDTO = becarioDTO;
    }
    
    public ArrayList<Tbl_BecarioDTO> obtenerDatos() {
        Tbl_BecarioBO becarioBO = new Tbl_BecarioBO();
        return becarioBO.obtenerDatos();
    }
    
    public String outcome(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("id", id);                
        return "ReactivacionBeca?faces-redirect=true";
    }
    
    public String outcomeBajaBecario(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("id", id);                
        return "BajaBecario?faces-redirect=true";        
    }
    
    public String outcomeModBecario(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("id", id);
        return "ModificarBecario?faces-redirect=true";
    }
    
    public String outcomeDetalleBecario(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("id", id);
        return "DetalleBecario?faces-redirect=true";
    }
}
