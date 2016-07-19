package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_CasaEstudianteBO;
import edu.uagro.dto.Tbl_CasaEstudianteDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author magic
 */
@RequestScoped 
@ManagedBean (name = "casas_gestionRenovacionContrato")
public class GestionRenovacionContrato {
    
    private ArrayList<Tbl_CasaEstudianteDTO> casas;
    
    public GestionRenovacionContrato() {
        casas = new Tbl_CasaEstudianteBO().obtenerCasasConExpediente();
    }

    public ArrayList<Tbl_CasaEstudianteDTO> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Tbl_CasaEstudianteDTO> casas) {
        this.casas = casas;
    }
    
    public String ver(String clave) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("casaClave", clave);
        return "./Ver_Renovacion_Contrato.xhtml?faces-redirect=true";
    }
    
}
