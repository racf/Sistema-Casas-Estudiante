package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ResponsableBO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name="gestionResposableBeans")
@RequestScoped
public class GestionResponsableBeans {
    Tbl_ResponsableDTO responsableDTO;
    public GestionResponsableBeans() {
        responsableDTO = new Tbl_ResponsableDTO();
    }

    public Tbl_ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(Tbl_ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }
    
    public ArrayList<Tbl_ResponsableDTO> obtenerDatos() {
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        return responsableBO.obtenerDatos();
    }
    public String outcomeModResponsable(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("id", id);
        return "ModificarResponsableZona?faces-redirect=true";
    }
    
    public String outcomeVerResponsable(int id){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("idVerResponsable", id);
        return "VerResponsableZona?faces-redirect=true";
    } 
    
    public void eliminar(Tbl_ResponsableDTO responsable){
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        responsableBO.eliminar(responsable);
    }
    
}
