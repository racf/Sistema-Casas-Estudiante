/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador.casas;


import edu.uagro.bo.Tbl_ArrendatarioBO;
import edu.uagro.dto.Tbl_ArrendatarioDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean; 
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "gestionArrendatario")
@ViewScoped
public class GestionArrendatario {

    Tbl_ArrendatarioDTO arrenda;
    ArrayList<Tbl_ArrendatarioDTO> lista;

    public GestionArrendatario() {
        arrenda = new Tbl_ArrendatarioDTO();
        cargarLista();
    }

    public Tbl_ArrendatarioDTO getArrenda() {
        return arrenda;
    }

    public void setArrenda(Tbl_ArrendatarioDTO arrenda) {
        this.arrenda= arrenda;
    }

    public ArrayList<Tbl_ArrendatarioDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Tbl_ArrendatarioDTO> lista) {
        this.lista = lista;
    }

    public String agregar() {
        Tbl_ArrendatarioBO bo = new Tbl_ArrendatarioBO();
        bo.agregar(arrenda);
        Tbl_ArrendatarioDTO dto = new Tbl_ArrendatarioDTO();
        dto.setId(arrenda.getId());
        dto.setNombre(arrenda.getNombre());
        dto.setCargo(arrenda.getCargo());
        dto.setDomicilio(arrenda.getDomicilio());
        lista.add(dto);
        return "/app/Casas_Estudiantes/Arrendatario.xhtml?faces-redirect=true";
    }
    
    public String  eliminar(Tbl_ArrendatarioDTO dto) {
        Tbl_ArrendatarioBO bo = new Tbl_ArrendatarioBO();
        bo.eliminar(dto);
        lista.remove(dto);
        return "/app/Casas_Estudiantes/Arrendatario.xhtml?faces-redirect=true";
    }

    public void cargarLista() {
        
         Tbl_ArrendatarioBO bo = new Tbl_ArrendatarioBO();
        lista = bo.obtenerDatos();
        
    }
    
    public  String  editar(Tbl_ArrendatarioDTO dto){
        Tbl_ArrendatarioBO bo = new Tbl_ArrendatarioBO();
        bo.editar(dto);
        return "/app/Casas_Estudiantes/Arrendatario.xhtml?faces-redirect=true";
    }


}
