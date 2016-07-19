package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ExpedienteCasaBO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author magic
 */
@ManagedBean(name = "casas_verRenovacionContrato")
@RequestScoped
public class VerRenovacionContrato {

    private ArrayList<Tbl_ExpedienteCasaDTO> expedientes;
    private String casaNombre;
    
    public VerRenovacionContrato() {
        Object clave = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("casaClave");
        if (clave != null) {
            String aux = String.valueOf(clave);
            expedientes = new Tbl_ExpedienteCasaBO().obtenerExpedientes(aux);
            casaNombre = expedientes.get(0).getTbl_casaestudianteDTO().getNombre();
        }
    }

    public ArrayList<Tbl_ExpedienteCasaDTO> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Tbl_ExpedienteCasaDTO> expedientes) {
        this.expedientes = expedientes;
    }

    public String getCasaNombre() {
        return casaNombre;
    }

    public void setCasaNombre(String casaNombre) {
        this.casaNombre = casaNombre;
    }
    
    public String detalleExpediente(int expedienteID) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("expedienteID", expedienteID);
        return "./Ver_Detalle_Contrato.xhtml?faces-redirect=true";
    }
    
    public String atras() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("casaClave");
        return "./Gestion_Renovacion_Contrato.xhtml?faces-redirect=true";
    }
}
