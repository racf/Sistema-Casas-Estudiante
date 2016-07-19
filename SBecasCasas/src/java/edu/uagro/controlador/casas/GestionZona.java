/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador.casas;


import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.dto.Cat_ZonasDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean; 
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "gestionZona")
@ViewScoped
public class GestionZona {

    Cat_ZonasDTO zona;
    ArrayList<Cat_ZonasDTO> lista;

    public GestionZona() {
        zona = new Cat_ZonasDTO();
        cargarLista();
    }

    public Cat_ZonasDTO getZona() {
        return zona;
    }

    public void setZona(Cat_ZonasDTO zona) {
        this.zona= zona;
    }

    public ArrayList<Cat_ZonasDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cat_ZonasDTO> lista) {
        this.lista = lista;
    }

    public String agregarZona() {
        Cat_ZonasBO bo = new Cat_ZonasBO();
        bo.agregar(zona);
        Cat_ZonasDTO dto = new Cat_ZonasDTO();
        dto.setId(zona.getId());
        dto.setNombre(zona.getNombre());
        dto.setDescripcion(zona.getDescripcion());
        lista.add(dto);
        return "/app/Casas_Estudiantes/Zonas.xhtml?faces-redirect=true";
    }
    
    public String eliminarZona(Cat_ZonasDTO dto) {
        Cat_ZonasBO bo = new Cat_ZonasBO();
        bo.eliminar(dto);
        lista.remove(dto);
        return "/app/Casas_Estudiantes/Zonas.xhtml?faces-redirect=true";
    }

    public void cargarLista() {
        
         Cat_ZonasBO bo = new Cat_ZonasBO();
        lista = bo.obtenerZonas();
        
    }
    
    public  String editar(Cat_ZonasDTO dto){
        Cat_ZonasBO bo = new Cat_ZonasBO();
        bo.editar(dto);
        return "/app/Casas_Estudiantes/Zonas.xhtml?faces-redirect=true";
    }


}
