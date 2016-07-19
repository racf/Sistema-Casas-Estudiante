/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.controlador;

import edu.uagro.bo.Cat_NivelBecaBO;
import edu.uagro.bo.Cat_TipoBecaBO;
import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.bo.Tbl_BecarioBO;
import edu.uagro.bo.Tbl_DetalleBecarioBO;
import edu.uagro.dto.Cat_NivelBecaDTO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean (name = "altaBecarioBeans")
@ViewScoped
public final class AltaBecarioBeans {
    private Tbl_DetalleBecarioDTO detalleBecarioDTO;
    
    public AltaBecarioBeans() {
        detalleBecarioDTO = new Tbl_DetalleBecarioDTO();
    }
    
    public Tbl_DetalleBecarioDTO getDetalleBecarioDTO() {
        return detalleBecarioDTO;
    }

    public void setDetalleBecarioDTO(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
        this.detalleBecarioDTO = detalleBecarioDTO;
    }       

    public void altaBecario(){
        Tbl_BecarioBO becarioBO = new Tbl_BecarioBO();
        becarioBO.altaBecario(detalleBecarioDTO.getBecarioDTO());
        Tbl_DetalleBecarioBO detalleBecarioBO = new Tbl_DetalleBecarioBO();
        detalleBecarioBO.altaDetalleBecario(this.detalleBecarioDTO); 

    }
    public boolean altaBecarioTransaccion(){
        Tbl_DetalleBecarioBO detalleBecarioBO = new Tbl_DetalleBecarioBO();        
        return detalleBecarioBO.insertarTrasaccionAltaBecario(detalleBecarioDTO.getBecarioDTO(), this.detalleBecarioDTO);
    }
    
    public String validarBecarioExiste(int claveBecario){
        Tbl_BecarioBO becarioBO = new Tbl_BecarioBO();
        if(becarioBO.validarBecarioExiste(claveBecario)){
            return "true";
        }else{
            return "false";            
        }
    }    
    
    public ArrayList<Cat_NivelBecaDTO> obtenerNivelesBeca(){
        Cat_NivelBecaBO nivelBO = new Cat_NivelBecaBO();
        return nivelBO.obtenerDatos();
    }
    
    public ArrayList<Cat_TipoBecaDTO> obtenerTiposBeca(){
       Cat_TipoBecaBO tipoBecaBO = new Cat_TipoBecaBO();
       return tipoBecaBO.obtenerDatos();
   }
    
    public ArrayList<Cat_ZonasDTO> obtenerZonas(){
        Cat_ZonasBO zonasBO  = new Cat_ZonasBO();
        return zonasBO.obtenerZonas();
    }
    
    public void obtenerDatosExternosBecario(){
        detalleBecarioDTO.setTbl_becarioIdDTO(detalleBecarioDTO.getBecarioDTO().getId());
        System.out.println("Numero Empleado: "+detalleBecarioDTO.getBecarioDTO().getId());
        System.out.println("Fecha Registro: "+detalleBecarioDTO.getBecarioDTO().getFechaRegistro());
        System.out.println("Fecha Inicio: "+detalleBecarioDTO.getFechaInicioBeca());
        System.out.println("Fecha Fin: "+detalleBecarioDTO.getFechaFinBeca());
        Tbl_DetalleBecarioBO detalleBecarioBO = new Tbl_DetalleBecarioBO();
        detalleBecarioBO.buscarExterno(this.detalleBecarioDTO);
    }
     
    
}
