/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Tbl_DetalleBecarioDAO;
import edu.uagro.dto.Tbl_BecarioDTO;
import edu.uagro.dto.Tbl_DetalleBecarioDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_DetalleBecarioBO {
    
    public int altaDetalleBecario(Tbl_DetalleBecarioDTO detalleBecario){
        Tbl_DetalleBecarioDAO detalleBecarioDAO = new Tbl_DetalleBecarioDAO();
        return detalleBecarioDAO.insertar(detalleBecario);
    }
    
    public boolean insertarTrasaccionAltaBecario(Tbl_BecarioDTO becarioDTO, Tbl_DetalleBecarioDTO detalleBecario){
        Tbl_DetalleBecarioDAO detalleBecarioDAO = new Tbl_DetalleBecarioDAO();
        return detalleBecarioDAO.insertarTrasaccionAltaBecario(becarioDTO, detalleBecario);
    }

    public ArrayList<Tbl_DetalleBecarioDTO> obtenerDatos(int clave) {
        Tbl_DetalleBecarioDAO detalleBecarioDAO = new Tbl_DetalleBecarioDAO();
        return detalleBecarioDAO.obtenerDatos(clave);
    }
    
    public Tbl_DetalleBecarioDTO buscarDetalleBecario(Tbl_DetalleBecarioDTO detalleBecarioDTO){
        Tbl_DetalleBecarioDAO detalleBecarioDAO = new  Tbl_DetalleBecarioDAO();
        return (Tbl_DetalleBecarioDTO) detalleBecarioDAO.buscarDetalleBecario(detalleBecarioDTO);
    }
    
    public Tbl_DetalleBecarioDTO buscarExterno(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
        Tbl_DetalleBecarioDAO detalleBecarioDAO = new Tbl_DetalleBecarioDAO();
        return detalleBecarioDAO.buscarExterno(detalleBecarioDTO);
    }
    
    public Tbl_DetalleBecarioDTO buscarExternoReactivacion(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
        Tbl_DetalleBecarioDAO detalleBecarioDAO = new Tbl_DetalleBecarioDAO();
        return detalleBecarioDAO.buscarExternoReactivacion(detalleBecarioDTO);
    }
}
