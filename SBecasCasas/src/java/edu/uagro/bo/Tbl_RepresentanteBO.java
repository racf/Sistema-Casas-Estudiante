package edu.uagro.bo;

import edu.uagro.dao.Tbl_RepresentanteDAO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_RepresentanteBO {

    public ArrayList<Tbl_RepresentanteDTO> obtenerRepresentantes() {
        Tbl_RepresentanteDAO dao = new Tbl_RepresentanteDAO();
        return dao.obtenerDatos();
    }

    Tbl_RepresentanteDTO obtenerRepresentante(Tbl_RepresentanteDTO tbl_representanteDTO) {
        return new Tbl_RepresentanteDAO().obtenerDatos(tbl_representanteDTO);
    }
    
    public ArrayList<Tbl_RepresentanteDTO> obtenerDatos() {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.obtenerDatos();
    }
    public void insertar(Tbl_RepresentanteDTO representante) {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        representanteDAO.insertar(representante);
    }  
    
    public boolean validarRepresentanteExiste(String matricula){
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.validarRepresentanteExiste(matricula);
    }
    public Tbl_RepresentanteDTO verRepresentanteCasa(Tbl_RepresentanteDTO representanteDTO) {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.verRepresentanteCasa(representanteDTO);
    }
    
    public boolean eliminar(Tbl_RepresentanteDTO representante) {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.eliminar(representante);
    }
    
    public ArrayList<Tbl_RepresentanteDTO> obtenerDatosBaja() {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.obtenerDatosBaja();
    }
    
    public boolean activar(Tbl_RepresentanteDTO representante) {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.activar(representante);
    }
    
    public Tbl_RepresentanteDTO buscarExterno(Tbl_RepresentanteDTO representanteDTO) {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.buscarExterno(representanteDTO);
    }  
    
    public boolean modificar(Tbl_RepresentanteDTO representante) {
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        return representanteDAO.modificar(representante);
    }
    
}
