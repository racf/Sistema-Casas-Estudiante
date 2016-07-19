package edu.uagro.controlador.casas;

import edu.uagro.bo.Cat_TipoRepresentanteBO;
import edu.uagro.bo.Tbl_RepresentanteBO;
import edu.uagro.dto.Cat_TipoRepresentanteDTO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import edu.uagro.util.GenerarClave;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "altaRepresentanteCasaBeans")
@RequestScoped
public class AltaRepresentanteCasaBeans{
    
    private Tbl_RepresentanteDTO representanteDTO;
    private Cat_TipoRepresentanteDTO tipoRepresentanteDTO;
    
    private String auxMatricula;
    
    public AltaRepresentanteCasaBeans() {
        representanteDTO = new Tbl_RepresentanteDTO();
    }

    public Cat_TipoRepresentanteDTO getTipoRepresentanteDTO() {
        return tipoRepresentanteDTO;
    }

    public void setTipoRepresentanteDTO(Cat_TipoRepresentanteDTO tipoRepresentanteDTO) {
        this.tipoRepresentanteDTO = tipoRepresentanteDTO;
    }
    
    
    public Tbl_RepresentanteDTO getRepresentanteDTO() {
        return representanteDTO;
    }

    public void setRepresentanteDTO(Tbl_RepresentanteDTO representanteDTO) {
        this.representanteDTO = representanteDTO;
    }

    public String getAuxMatricula() {
        return auxMatricula;
    }

    public void setAuxMatricula(String auxMatricula) {
        this.auxMatricula = auxMatricula;
    }    
    
    public ArrayList<Cat_TipoRepresentanteDTO> obtenerDatosTipoRepresentante() {
        Cat_TipoRepresentanteBO  tipoRepresentanteBO = new Cat_TipoRepresentanteBO();
        return tipoRepresentanteBO.obtenerDatos();
    }
    
    public void altaRepresentanteCasa(){        
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        GenerarClave gClave = new GenerarClave();
        representanteDTO.setClave(gClave.randomString(8));
        representanteBO.insertar(this.representanteDTO);
    }
    
    public void obtenerDatosAlumnoExterno(){
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        setAuxMatricula(representanteDTO.getMatricula());
        representanteBO.buscarExterno(this.representanteDTO); 
    }
    
    public String validarRepresentanteExiste(String matricula){
        Tbl_RepresentanteBO representanteBO = new Tbl_RepresentanteBO();
        if(representanteBO.validarRepresentanteExiste(matricula)){
            return "true";
        }else{
            return "false";
        }
    }
    
}
