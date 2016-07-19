/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador.casas;


import edu.uagro.bo.Cat_TipoArrendadorBO;
import edu.uagro.bo.Tbl_ArrendadorBO;
import edu.uagro.dto.Cat_TipoArrendadorDTO;
import edu.uagro.dto.Tbl_ArrendadorDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean; 
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "gestionArrendador")
@ViewScoped
public class GestionArrendador {

    Tbl_ArrendadorDTO arrendador;
    ArrayList<Tbl_ArrendadorDTO> lista;

    public GestionArrendador() {
        arrendador = new Tbl_ArrendadorDTO();
        cargarLista();
    }

    public Tbl_ArrendadorDTO getArrendador() {
        return arrendador;
    }

    public void setArrendador(Tbl_ArrendadorDTO arrendador) {
        this.arrendador= arrendador;
    }

    public ArrayList<Tbl_ArrendadorDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Tbl_ArrendadorDTO> lista) {
        this.lista = lista;
    }

    public String  eliminar(Tbl_ArrendadorDTO dto) {
        Tbl_ArrendadorBO bo = new Tbl_ArrendadorBO();
        bo.eliminar(dto);
        lista.remove(dto);
        return "/app/Casas_Estudiantes/Arrendador.xhtml?faces-redirect=true";
    }


    public ArrayList<Tbl_ArrendadorDTO> cargarLista() {
         Tbl_ArrendadorBO bo = new Tbl_ArrendadorBO();
        return  lista = bo.obtenerDatos();
        
    }
    
    public  String  editar(Tbl_ArrendadorDTO dto){
        Tbl_ArrendadorBO bo = new Tbl_ArrendadorBO();
        bo.editar(dto);
        return "/app/Casas_Estudiantes/Arrendador.xhtml?faces-redirect=true";
    }
    
    public String outcomeModArrendador(int numProvedor){
        FacesContext fc  = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("idNumProvedor", numProvedor);
        return "/app/Casas_Estudiantes/ActualizarArrendador.xhtml?faces-redirect=true";
    }


}
