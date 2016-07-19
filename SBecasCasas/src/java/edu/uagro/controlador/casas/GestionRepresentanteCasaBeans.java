package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_RepresentanteBO;
import edu.uagro.dto.Cat_TipoRepresentanteDTO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "gestionRepresentanteCasaBeans")
@RequestScoped
public class GestionRepresentanteCasaBeans {
    Tbl_RepresentanteDTO representanteDTO;
    
    public GestionRepresentanteCasaBeans() {
        representanteDTO = new Tbl_RepresentanteDTO();
    }

    public Tbl_RepresentanteDTO getRepresentanteDTO() {
        return representanteDTO;
    }

    public void setRepresentanteDTO(Tbl_RepresentanteDTO representanteDTO) {
        this.representanteDTO = representanteDTO;
    }
    public ArrayList<Tbl_RepresentanteDTO> obtenerDatos() {
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        return representanteBO.obtenerDatos();
    }
    
    public String outcomeVerRepresentante(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("idVerRepresentante", id);
        return "VerRepresentanteCasa?faces-redirect=true";
    }
    public void bajaRepresentante(Tbl_RepresentanteDTO representante) {
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        representanteBO.eliminar(representante);
    } 
    
    public String outcomeModRepresentante(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("idModRepresentante", id);
        return "ModificarRepresentanteCasa?faces-redirect=true";
    }    
}
