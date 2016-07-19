/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Tbl_ResponsableDAO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_ResponsableBO {
    public ArrayList<Tbl_ResponsableDTO> obtenerDatos() {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.obtenerDatos();
    }
    public ArrayList<Tbl_ResponsableDTO> obtenerDatosBajaResponsable() {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.obtenerDatosBajaResponsable();
    }
    public void altaResponsableZona(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        responsableDAO.insertar(responsable);
    }
    
    public boolean validarResponsableExiste(int claveResponsable){
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.validarResponsableExiste(claveResponsable);
    } 
    public Tbl_ResponsableDTO buscar(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.buscar(responsable);
    } 
    
    public boolean modificar(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.modificar(responsable);
    }
    public Tbl_ResponsableDTO buscarExterno(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.buscarExterno(responsable);
    }
    
    public Tbl_ResponsableDTO buscarDetalleResponsableZona(Tbl_ResponsableDTO responsableDTO) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.buscarDetalleResponsableZona(responsableDTO);
    }
     
    public boolean validarExisteExterno(int responsableId) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.validarExisteExterno(responsableId);
    }
    
    public boolean eliminar(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.eliminar(responsable);
    }
    public boolean activar(Tbl_ResponsableDTO responsable) {
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        return responsableDAO.activar(responsable);
    }
}
