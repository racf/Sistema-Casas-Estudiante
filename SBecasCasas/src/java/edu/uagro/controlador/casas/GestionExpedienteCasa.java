package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ExpedienteCasaBO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean (name = "casas_gestionExpedienteCasa")
public class GestionExpedienteCasa {

    private ArrayList<Tbl_ExpedienteCasaDTO> expedientes;
    
    public GestionExpedienteCasa() {
        expedientes = new Tbl_ExpedienteCasaBO().obtenerExpedientes();
    }

    public ArrayList<Tbl_ExpedienteCasaDTO> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Tbl_ExpedienteCasaDTO> expedientes) {
        this.expedientes = expedientes;
    }
    
    public String editarExpediente(int expedienteID) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("expedienteID", expedienteID);
        return "./Editar_Expediente_Casa.xhtml?faces-redirect=true";
    }
    
    public String verExpediente(int expedienteID) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("expedienteID", expedienteID);
        return "./Ver_Expediente_Casa.xhtml?faces-redirect=true";
    }
    
    public String eliminarExpediente(Tbl_ExpedienteCasaDTO elemento) {
        expedientes.remove(elemento);
        new Tbl_ExpedienteCasaBO().eliminar(elemento);
        return "./Gestion_Expediente_Casa.xhtml?faces-redirect=true";
    }
    
}
