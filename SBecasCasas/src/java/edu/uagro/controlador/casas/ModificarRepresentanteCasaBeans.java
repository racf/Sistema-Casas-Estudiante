/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador.casas;

import edu.uagro.bo.Cat_TipoRepresentanteBO;
import edu.uagro.bo.Tbl_RepresentanteBO;
import edu.uagro.dto.Cat_TipoRepresentanteDTO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "modificarRepresentanteCasaBeans")
@RequestScoped
public class ModificarRepresentanteCasaBeans {
    Tbl_RepresentanteDTO representanteDTO;
    Tbl_RepresentanteBO representanteBO;
    
    public ModificarRepresentanteCasaBeans() {
        representanteDTO = new Tbl_RepresentanteDTO();
        representanteBO = new Tbl_RepresentanteBO();
        representanteDTO.setMatricula(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idModRepresentante")));
        representanteBO.verRepresentanteCasa(representanteDTO);
    }

    public Tbl_RepresentanteDTO getRepresentanteDTO() {
        return representanteDTO;
    }

    public void setRepresentanteDTO(Tbl_RepresentanteDTO representanteDTO) {
        this.representanteDTO = representanteDTO;
    }
    
    public String getModRepresentanteCasaParam() {
        Map<String, Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return String.valueOf(params.get("idModRepresentante"));
    }

    public String salida() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("idModRepresentante");
        return "GestionRepresentanteCasa?faces-redirect=true";
    }
    public ArrayList<Cat_TipoRepresentanteDTO> obtenerDatosTipoRepresentante() {
        Cat_TipoRepresentanteBO  tipoRepresentanteBO = new Cat_TipoRepresentanteBO();
        return tipoRepresentanteBO.obtenerDatos();
    }
    
    public void obtenerDatosAlumnoExterno(){
        Tbl_RepresentanteBO representanteBO1 = new Tbl_RepresentanteBO();
        representanteBO1.buscarExterno(this.representanteDTO); 
    }
    public boolean modificarRepresentante(){
        Tbl_RepresentanteBO representanteBO1 = new Tbl_RepresentanteBO();
        return representanteBO1.modificar(this.representanteDTO);
    }
    
}
