package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_RepresentanteBO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "verBajaRepresentanteCasaBeans")
@RequestScoped
public class VerBajaRepresentanteCasaBeans {
    Tbl_RepresentanteDTO representanteDTO;
    
    public VerBajaRepresentanteCasaBeans() {
        representanteDTO = new Tbl_RepresentanteDTO();
    }

    public Tbl_RepresentanteDTO getRepresentanteDTO() {
        return representanteDTO;
    }

    public void setRepresentanteDTO(Tbl_RepresentanteDTO representanteDTO) {
        this.representanteDTO = representanteDTO;
    }
    
    public ArrayList<Tbl_RepresentanteDTO> obtenerDatosBaja() {
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        return representanteBO.obtenerDatosBaja();
    }
    
    public String salir(){
        return "GestionRepresentanteCasa?faces-redirect=true";
    } 
    
    public void activar(Tbl_RepresentanteDTO representante) {
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        representanteBO.activar(representante);
    }    
    
}
