package edu.uagro.controlador.casas;

import edu.uagro.bo.Tbl_ArrendadorBO;
import edu.uagro.bo.Tbl_ArrendatarioBO;
import edu.uagro.bo.Tbl_CasaEstudianteBO;
import edu.uagro.bo.Tbl_ExpedienteCasaBO;
import edu.uagro.bo.Tbl_RepresentanteBO;
import edu.uagro.dto.Tbl_ArrendadorDTO;
import edu.uagro.dto.Tbl_ArrendatarioDTO;
import edu.uagro.dto.Tbl_CasaEstudianteDTO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author magic
 * @fecha jueves mayo 26 2016
 */
@ViewScoped
@ManagedBean(name = "casas_agregarExpedienteCasa")
public class AgregarExpedienteCasa implements Serializable{

    private Tbl_ExpedienteCasaDTO expediente;
    private ArrayList<Tbl_CasaEstudianteDTO> listaCasas;
    private ArrayList<Tbl_ArrendatarioDTO> listaArrendatarios;
    private ArrayList<Tbl_ArrendadorDTO> listaArrendadores;
    private ArrayList<Tbl_RepresentanteDTO> listaRepresentantes;
    private ArrayList<String> listaTipoRentas;

    public AgregarExpedienteCasa() {
        expediente = new Tbl_ExpedienteCasaDTO();
        listaCasas = new Tbl_CasaEstudianteBO().obtenerCasas();
        listaArrendatarios = new Tbl_ArrendatarioBO().obtenerArrendatarios();
        listaArrendadores = new Tbl_ArrendadorBO().obtenerArrendadores();
        listaRepresentantes = new Tbl_RepresentanteBO().obtenerRepresentantes();
        listaTipoRentas = new ArrayList();
        listaTipoRentas.add("Mensual");
        listaTipoRentas.add("Anual");
    }

    //<editor-fold defaultstate="collapsed" desc="setters and getters">
    public Tbl_ExpedienteCasaDTO getExpediente() {
        return expediente;
    }

    public void setExpediente(Tbl_ExpedienteCasaDTO expediente) {
        this.expediente = expediente;
    }

    public ArrayList<Tbl_CasaEstudianteDTO> getListaCasas() {
        return listaCasas;
    }

    public void setListaCasas(ArrayList<Tbl_CasaEstudianteDTO> listaCasas) {
        this.listaCasas = listaCasas;
    }

    public ArrayList<Tbl_ArrendatarioDTO> getListaArrendatarios() {
        return listaArrendatarios;
    }

    public void setListaArrendatarios(ArrayList<Tbl_ArrendatarioDTO> listaArrendatarios) {
        this.listaArrendatarios = listaArrendatarios;
    }

    public ArrayList<Tbl_ArrendadorDTO> getListaArrendadores() {
        return listaArrendadores;
    }

    public void setListaArrendadores(ArrayList<Tbl_ArrendadorDTO> listaArrendadores) {
        this.listaArrendadores = listaArrendadores;
    }

    public ArrayList<Tbl_RepresentanteDTO> getListaRepresentantes() {
        return listaRepresentantes;
    }

    public void setListaRepresentantes(ArrayList<Tbl_RepresentanteDTO> listaRepresentantes) {
        this.listaRepresentantes = listaRepresentantes;
    }

    public ArrayList<String> getListaTipoRentas() {
        return listaTipoRentas;
    }

    public void setListaTipoRentas(ArrayList<String> listaTipoRentas) {
        this.listaTipoRentas = listaTipoRentas;
    }
    //</editor-fold>

    public String agregarExpediente() {
        System.out.println(expediente.toString());
        new Tbl_ExpedienteCasaBO().insertar(expediente);
        return "./Gestion_Expediente_Casa.xhtml?faces-redirect=true";
    }
    
    public String atras() {
        return "./Gestion_Expediente_Casa.xhtml?faces-redirect=true";
    }
    
}
