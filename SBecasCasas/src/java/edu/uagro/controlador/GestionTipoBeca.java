/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;


import edu.uagro.bo.Cat_TipoBecaBO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean; 
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "gestionTipoBeca")
@ViewScoped
public class GestionTipoBeca {

    Cat_TipoBecaDTO tipoBeca;
    ArrayList<Cat_TipoBecaDTO> lista;

    public GestionTipoBeca() {
        tipoBeca = new Cat_TipoBecaDTO();
        cargarLista();
    }

    public Cat_TipoBecaDTO getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(Cat_TipoBecaDTO tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    public ArrayList<Cat_TipoBecaDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cat_TipoBecaDTO> lista) {
        this.lista = lista;
    }

    public void agregarTipo() {
       Cat_TipoBecaBO bo = new Cat_TipoBecaBO();
        bo.agregar(tipoBeca);
        Cat_TipoBecaDTO dto = new Cat_TipoBecaDTO();
        dto.setId(tipoBeca.getId());
        dto.setNombre(tipoBeca.getNombre());
        dto.setNivelMaximo(tipoBeca.getNivelMaximo());
        dto.setDescripcion(tipoBeca.getDescripcion());
        lista.add(dto);
       
    }
    
    public void eliminarTipo(Cat_TipoBecaDTO dto) {
        Cat_TipoBecaBO bo = new Cat_TipoBecaBO();
        bo.eliminar(dto);
        lista.remove(dto);
    }

    public void cargarLista() {
        
         Cat_TipoBecaBO bo = new Cat_TipoBecaBO();
        lista = bo.obtenerDatos();
        
    }
    
    public  void editar(Cat_TipoBecaDTO dto){
        Cat_TipoBecaBO bo = new Cat_TipoBecaBO();
        bo.editar(dto);
        
    }


}
