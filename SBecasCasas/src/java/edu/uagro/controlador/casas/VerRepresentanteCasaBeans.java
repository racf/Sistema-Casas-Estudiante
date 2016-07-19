package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_RepresentanteBO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "verRepresentanteCasaBeans")
@RequestScoped
public class VerRepresentanteCasaBeans {
    Tbl_RepresentanteDTO representanteDTO;
    Tbl_RepresentanteBO representanteBO;
    
    public VerRepresentanteCasaBeans() {
        representanteDTO = new Tbl_RepresentanteDTO();
        representanteBO = new Tbl_RepresentanteBO();
        representanteDTO.setMatricula(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idVerRepresentante")));
        representanteBO.verRepresentanteCasa(representanteDTO);
    }

    public Tbl_RepresentanteDTO getRepresentanteDTO() {
        return representanteDTO;
    }

    public void setRepresentanteDTO(Tbl_RepresentanteDTO representanteDTO) {
        this.representanteDTO = representanteDTO;
    }
    
    public String getIdVerRepresentanteParam(){		
        Map<String,Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();                
        return String.valueOf(params.get("idVerRepresentante"));		
    }
    
    public String salida(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("idVerRepresentante");
        return "GestionRepresentanteCasa?faces-redirect=true";
    }      
    
}
