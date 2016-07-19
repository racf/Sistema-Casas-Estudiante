package edu.uagro.controlador;

import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_BecarioDTO;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean (name = "modificarBecarioBeans")
@RequestScoped
public class ModificarBecarioBeans {
    private Tbl_BecarioDTO becarioDTO;
    private Tbl_BecarioBO becarioBO;

    public ModificarBecarioBeans() {        
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
    
    public boolean modificarBecario() {
        Tbl_BecarioBO becarioModBO = new Tbl_BecarioBO();
        return becarioModBO.modificarBecario(this.becarioDTO);              
    }
    public ArrayList<Cat_ZonasDTO> obtenerZonas(){
        Cat_ZonasBO zonasBO  = new Cat_ZonasBO();
        return zonasBO.obtenerZonas();
    }    
    
}
