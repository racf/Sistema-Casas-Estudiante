package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ResponsableBO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "verBajaResponsableZonaBeans")
@RequestScoped
public class VerBajaResponsableZonaBeans {
    private Tbl_ResponsableDTO responsableDTO;
    private Cat_ZonasDTO zonasDTO;
    
    public VerBajaResponsableZonaBeans() {
        responsableDTO = new Tbl_ResponsableDTO();
        zonasDTO = new Cat_ZonasDTO();
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
    
    public ArrayList<Tbl_ResponsableDTO> obtenerDatosBajaResponsable() {
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        return responsableBO.obtenerDatosBajaResponsable();
    }
    
    public void activar(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        responsableBO.activar(responsable);
    }
    
    public String salir(){
        return "GestionResponsableZona?faces-redirect=true";
    }
    
    
}
