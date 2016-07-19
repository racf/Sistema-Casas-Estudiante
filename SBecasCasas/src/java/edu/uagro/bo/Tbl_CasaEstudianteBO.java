package edu.uagro.bo;

import edu.uagro.dao.Tbl_CasaEstudianteDAO;
import edu.uagro.dto.Tbl_CasaEstudianteDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_CasaEstudianteBO {

    public ArrayList<Tbl_CasaEstudianteDTO> obtenerCasas() {
        Tbl_CasaEstudianteDAO dao = new Tbl_CasaEstudianteDAO();
        return dao.obtenerCasas();
    }
    
    public ArrayList<Tbl_CasaEstudianteDTO> obtenerCasasConExpediente() {
        return new Tbl_CasaEstudianteDAO().obtenerCasasConExpediente();
    }
    
}
