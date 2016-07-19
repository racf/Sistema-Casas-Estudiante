package edu.uagro.controlador.casas;

import edu.uagro.bo.Cat_ZonasBO;
import edu.uagro.bo.Tbl_ResponsableBO;
import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "altaResponsableZonaBeans")
@RequestScoped
public class AltaResponsableZonaBeans {
    private Cat_ZonasDTO zonasDTO;    
    private Tbl_ResponsableDTO responsableDTO;
    private int auxResponsableId;
    
    public AltaResponsableZonaBeans() {
        responsableDTO = new Tbl_ResponsableDTO();
    }

    public int getAuxResponsableId() {
        return auxResponsableId;
    }

    public void setAuxResponsableId(int auxResponsableId) {
        this.auxResponsableId = auxResponsableId;
    }
    
    public Tbl_ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(Tbl_ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }    

    public Cat_ZonasDTO getZonasDTO() {
        return zonasDTO;
    }

    public void setZonasDTO(Cat_ZonasDTO zonasDTO) {
        this.zonasDTO = zonasDTO;
    }
        
    public ArrayList<Cat_ZonasDTO> obtenerZonas(){
        Cat_ZonasBO zonasBO  = new Cat_ZonasBO();
        return zonasBO.obtenerZonas();
    }
    
    public void altaResponsableZona() {
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        responsableBO.altaResponsableZona(this.responsableDTO);        
    }
    public String validarResponsableExiste(int claveResponsable){
        System.out.println("Ejecutando");
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        if(responsableBO.validarResponsableExiste(claveResponsable)){
            return "true";
        }else{
            return "false";
        }        
    }
    
    public String validarExisteExterno(){
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        setAuxResponsableId(responsableDTO.getId());
        if(responsableBO.validarExisteExterno(responsableDTO.getId())){
            return "true";
        }else{
            return "false";
        }
    }
    
    public void obtenerDatosExternosPersonal(){
        Tbl_ResponsableBO responsableBO = new Tbl_ResponsableBO();
        setAuxResponsableId(responsableDTO.getId());
        responsableBO.buscarExterno(this.responsableDTO);
    }
    
}
