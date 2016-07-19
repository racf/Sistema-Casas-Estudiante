/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Cat_NivelBecaBO;
import edu.uagro.dto.Cat_NivelBecaDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean; 
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "gestionNivelBeca")
@ViewScoped
public class GestionNivelBeca {

    Cat_NivelBecaDTO nivelBeca;
    ArrayList<Cat_NivelBecaDTO> lista;

    public GestionNivelBeca() {
        nivelBeca = new Cat_NivelBecaDTO();
        cargarLista();
    }

    public Cat_NivelBecaDTO getNivelBeca() {
        return nivelBeca;
    }

    public void setNivelBeca(Cat_NivelBecaDTO nivelBeca) {
        this.nivelBeca = nivelBeca;
    }

    public ArrayList<Cat_NivelBecaDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cat_NivelBecaDTO> lista) {
        this.lista = lista;
    }
    
    public void agregarNivel(){
        Cat_NivelBecaBO bo = new Cat_NivelBecaBO();
        bo.agregar(nivelBeca);
        Cat_NivelBecaDTO dto = new Cat_NivelBecaDTO();
        dto.setId(nivelBeca.getId());
        dto.setNombre(nivelBeca.getNombre());
        lista.add(dto);
    }
    
    public void eliminarNivel(Cat_NivelBecaDTO dto) {
        Cat_NivelBecaBO bo = new Cat_NivelBecaBO();
        bo.eliminar(dto);
        lista.remove(dto);
    
    }
    
    public void cargarLista(){
        Cat_NivelBecaBO bo = new Cat_NivelBecaBO();
        lista = bo.obtenerDatos();
    }
    
    public  void editar(Cat_NivelBecaDTO dto){
        Cat_NivelBecaBO bo = new Cat_NivelBecaBO();
        bo.editar(dto);
    }
    
    
}
