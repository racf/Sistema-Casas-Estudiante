/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Tbl_BecarioDAO;
import edu.uagro.dto.Tbl_BecarioDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_BecarioBO {

    public void altaBecario(Tbl_BecarioDTO becarioDTO) {
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        becarioDAO.insertar(becarioDTO);
    }
    
    public ArrayList<Tbl_BecarioDTO> obtenerDatos() {
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        return becarioDAO.obtenerDatos();
    }
     public ArrayList<Tbl_BecarioDTO> obtenerDatosBecarioBaja() {
         Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
         return becarioDAO.obtenerDatosBecarioBaja();
     }
    
    public Tbl_BecarioDTO buscarBecario(Tbl_BecarioDTO becarioDTO){
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        return (Tbl_BecarioDTO) becarioDAO.buscar(becarioDTO);
    }
    
    public boolean bajaBecario(Tbl_BecarioDTO becario) {
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        return becarioDAO.bajaBecario(becario);
    }
    
    public boolean reactivarBecario(Tbl_BecarioDTO becario) {
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        return becarioDAO.reactivarBecario(becario);
    }
    
    public boolean modificarBecario(Tbl_BecarioDTO becario) {
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        return becarioDAO.modificarBecario(becario);
    }
    public boolean validarBecarioExiste(int claveBecario){
        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
        return becarioDAO.validarBecarioExiste(claveBecario);
    }
//    public Tbl_DetalleBecarioDTO buscarExterno(Tbl_DetalleBecarioDTO detalleBecarioDTO) {
//        Tbl_BecarioDAO becarioDAO = new Tbl_BecarioDAO();
//        return becarioDAO.buscarExterno(detalleBecarioDTO);
//    }
}
