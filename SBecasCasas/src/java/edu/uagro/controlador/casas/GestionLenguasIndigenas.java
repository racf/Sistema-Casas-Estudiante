/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador.casas;


import edu.uagro.bo.Cat_LenguaindigenaBO;
import edu.uagro.dto.Cat_LenguaindigenaDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean; 
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "gestionLenguasIndigenas")
@ViewScoped
public class GestionLenguasIndigenas {

    Cat_LenguaindigenaDTO lengua;
    ArrayList<Cat_LenguaindigenaDTO> lista;

    public GestionLenguasIndigenas() {
        lengua = new Cat_LenguaindigenaDTO();
        cargarLista();
    }

    public Cat_LenguaindigenaDTO getLengua() {
        return lengua;
    }

    public void setLengua(Cat_LenguaindigenaDTO lengua) {
        this.lengua= lengua;
    }

    public ArrayList<Cat_LenguaindigenaDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cat_LenguaindigenaDTO> lista) {
        this.lista = lista;
    }

    public String agregar() {
        Cat_LenguaindigenaBO bo = new Cat_LenguaindigenaBO();
        bo.agregar(lengua);
        Cat_LenguaindigenaDTO dto = new Cat_LenguaindigenaDTO();
        dto.setId(lengua.getId());
        dto.setNombre(lengua.getNombre());
        lista.add(dto);
        
        return "/app/Casas_Estudiantes/LenguasIndigenas.xhtml?faces-redirect=true";
       
    }
    
    public String eliminar(Cat_LenguaindigenaDTO dto) {
        Cat_LenguaindigenaBO bo = new Cat_LenguaindigenaBO();
        bo.eliminar(dto);
        lista.remove(dto);
        return "/app/Casas_Estudiantes/LenguasIndigenas.xhtml?faces-redirect=true";
    }

    public void cargarLista() {
        
        Cat_LenguaindigenaBO bo = new Cat_LenguaindigenaBO();
        lista = bo.obtenerDatos();
        
    }
    
    public  String editar(Cat_LenguaindigenaDTO dto){
        Cat_LenguaindigenaBO bo = new Cat_LenguaindigenaBO();
        bo.editar(dto);
        return "/app/Casas_Estudiantes/LenguasIndigenas.xhtml?faces-redirect=true";
    }


}
