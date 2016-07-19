package edu.uagro.controlador.casas;

import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.bo.Tbl_ResponsableBO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean (name = "modificarResponsableZonaBeans")
@RequestScoped
public class ModificarResponsableZonaBeans {
    Tbl_ResponsableDTO responsableDTO;
    Tbl_ResponsableBO responsableBO;
    public ModificarResponsableZonaBeans() {
        responsableDTO = new Tbl_ResponsableDTO();
        responsableBO = new Tbl_ResponsableBO();
        responsableDTO.setId(Integer.parseInt(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"))));
        responsableBO.buscar(responsableDTO);
    }

    public Tbl_ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(Tbl_ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }
    
    public String getModResponsableZonaParam() {
        Map<String, Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return String.valueOf(params.get("id"));
    }

    public String salida() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("id");
        return "GestionResponsableZona?faces-redirect=true";
    }
    
    public ArrayList<Cat_ZonasDTO> obtenerZonas() {
        Cat_ZonasBO zonasBO = new Cat_ZonasBO();
        return zonasBO.obtenerZonas();
    }
    
    public boolean modificarResponsable() {
        Tbl_ResponsableBO responsableBOMod = new Tbl_ResponsableBO();
        return responsableBOMod.modificar(this.responsableDTO);
    }    
    
}
