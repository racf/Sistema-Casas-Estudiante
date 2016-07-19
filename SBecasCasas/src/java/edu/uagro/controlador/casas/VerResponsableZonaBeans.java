package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ResponsableBO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name="verResponsableZonaBeans")
@RequestScoped
public class VerResponsableZonaBeans {
    Tbl_ResponsableDTO responsableDTO;
    Tbl_ResponsableBO responsableBO;
    Cat_ZonasDTO zonasDTO;
    
    public VerResponsableZonaBeans() {
        responsableDTO = new Tbl_ResponsableDTO();
        responsableBO = new Tbl_ResponsableBO();
        zonasDTO = new Cat_ZonasDTO();
//        System.out.println(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idVerResponsable"))));
        responsableDTO.setId(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idVerResponsable"))));
        responsableBO.buscarDetalleResponsableZona(responsableDTO);
    }

    public Tbl_ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(Tbl_ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }

    public Cat_ZonasDTO getZonasDTO() {
        return zonasDTO;
    }

    public void setZonasDTO(Cat_ZonasDTO zonasDTO) {
        this.zonasDTO = zonasDTO;
    }
    public String getIdVerResponsableParam(){		
        Map<String,Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();                
        return String.valueOf(params.get("idVerResponsable"));		
    }
    
    public String salida(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("idVerResponsable");
        return "GestionResponsableZona?faces-redirect=true";
    }    
    
}
