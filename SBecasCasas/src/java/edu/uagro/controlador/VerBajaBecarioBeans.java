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
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean (name = "verBajaBecarioBeans")
@ViewScoped
public class VerBajaBecarioBeans {
    private Tbl_BecarioDTO becarioDTO;
    
    
    public VerBajaBecarioBeans() {
        becarioDTO = new Tbl_BecarioDTO();
    }
    
    public Tbl_BecarioDTO getBecarioDTO() {
        return becarioDTO;
    }

    public void setBecarioDTO(Tbl_BecarioDTO becarioDTO) {
        this.becarioDTO = becarioDTO;
    }
    
    public ArrayList<Tbl_BecarioDTO> obtenerDatosBecarioBaja() {
        Tbl_BecarioBO becarioBO = new Tbl_BecarioBO();
        return becarioBO.obtenerDatosBecarioBaja();
    }
    
    public void reactivarBecario(Tbl_BecarioDTO becario) {
        Tbl_BecarioBO becarioBO = new Tbl_BecarioBO();
        becarioBO.reactivarBecario(becario);
    }
    public String salir(){
        return "Gestion_Beca?faces-redirect=true";
    }
    
}
