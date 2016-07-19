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
import javax.faces.view.ViewScoped;

/**
 *
 * @author Antonio18244
 */
@ManagedBean(name = "altaArrendador")
@ViewScoped
public class AltaArrendador {

    Tbl_ArrendadorDTO dto;
    String aux;

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public AltaArrendador() {
        dto = new Tbl_ArrendadorDTO();
    }

    public Tbl_ArrendadorDTO getDto() {
        return dto;
    }

    public void setDto(Tbl_ArrendadorDTO dto) {
        this.dto = dto;
    }

    public void obtenerdatosArrendador() {
        Tbl_ArrendadorBO bo = new Tbl_ArrendadorBO();
        setAux(dto.getNumProveedor());
        bo.buscarArredadorExterno(this.dto);
    }

    public ArrayList<Cat_TipoArrendadorDTO> obtenerTiposArrendador() {
        Cat_TipoArrendadorBO tipoBecaBO = new Cat_TipoArrendadorBO();
        return tipoBecaBO.obtenerDatos();
    }

    public void altaArrendador() {
        Tbl_ArrendadorBO arrendorBO = new Tbl_ArrendadorBO();
        arrendorBO.agregar(this.dto);

    }

    public String validarInterno(int numpro) {
        Tbl_ArrendadorBO arrendorBO = new Tbl_ArrendadorBO();
        if (arrendorBO.validarInterno(numpro)) {
            return "true";
        } else {
            return "false";
        }

    }

}
