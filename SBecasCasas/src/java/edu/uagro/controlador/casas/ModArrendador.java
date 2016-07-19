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
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "modArrendador")
@ViewScoped
public class ModArrendador {
    
    Tbl_ArrendadorDTO dto;
    Tbl_ArrendadorBO bo;
    public ModArrendador(){
    dto = new Tbl_ArrendadorDTO();
    bo = new Tbl_ArrendadorBO();
    dto.setNumProveedor(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idNumProvedor")));
    bo.obtenerDAtosParametros(dto);
    }

    public Tbl_ArrendadorDTO getDto() {
        return dto;
    }

    public void setDto(Tbl_ArrendadorDTO dto) {
        this.dto = dto;
    }

    public Tbl_ArrendadorBO getBo() {
        return bo;
    }

    public void setBo(Tbl_ArrendadorBO bo) {
        this.bo = bo;
    }

        public ArrayList<Cat_TipoArrendadorDTO> obtenerTiposArrendador() {
        Cat_TipoArrendadorBO tipoBecaBO = new Cat_TipoArrendadorBO();
        return tipoBecaBO.obtenerDatos();
    }
        
        public void EditarArrendador() {
        Tbl_ArrendadorBO arrendorBO = new Tbl_ArrendadorBO();
        arrendorBO.editar(this.dto);

    }

           public String salida() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("idNumProvedor");
        return "Arrendador?faces-redirect=true";
    }

    public String getModArrendaorParam() {
        Map<String, Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return String.valueOf(params.get("idNumProvedor"));
    }

}
