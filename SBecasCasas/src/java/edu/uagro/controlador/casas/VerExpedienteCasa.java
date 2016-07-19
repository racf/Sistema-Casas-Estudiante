package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ExpedienteCasaBO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author magic
 */
@ManagedBean (name = "casas_verExpedienteCasa")
@RequestScoped
public class VerExpedienteCasa {

    private Tbl_ExpedienteCasaDTO expediente;
    
    public VerExpedienteCasa() {
        expediente = new Tbl_ExpedienteCasaDTO();
        Object id = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("expedienteID");
        if (id != null) {
            expediente.setId(Integer.parseInt(String.valueOf(id)));
            expediente = new Tbl_ExpedienteCasaBO().obtenerExpediente(expediente);
        }
    }

    public Tbl_ExpedienteCasaDTO getExpediente() {
        return expediente;
    }

    public void setExpediente(Tbl_ExpedienteCasaDTO expediente) {
        this.expediente = expediente;
    }
    
    public String atras() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("expedienteID");
        return "./Gestion_Expediente_Casa.xhtml?faces-redirect=true";
    }
    
}
