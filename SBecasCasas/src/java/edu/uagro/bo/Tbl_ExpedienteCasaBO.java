package edu.uagro.bo;

import edu.uagro.dao.Tbl_ExpedienteCasaDAO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_ExpedienteCasaBO {

    public ArrayList<Tbl_ExpedienteCasaDTO> obtenerExpedientes() {
        return new Tbl_ExpedienteCasaDAO().obtenerExpedientes();
    }

    public Tbl_ExpedienteCasaDTO obtenerExpediente(Tbl_ExpedienteCasaDTO expediente) {
        expediente = new Tbl_ExpedienteCasaDAO().obtenerExpediente(expediente);
        expediente.setTbl_representanteDTO(new Tbl_RepresentanteDTO());
        expediente.getTbl_representanteDTO().setMatricula(expediente.getTbl_representanteMatriculaDTO());
        expediente.setTbl_representanteDTO(new Tbl_RepresentanteBO().obtenerRepresentante(expediente.getTbl_representanteDTO()));
        return expediente;
    }
    
    public int insertar(Tbl_ExpedienteCasaDTO expediente) {
        return new Tbl_ExpedienteCasaDAO().insertar(expediente);
    }

    public boolean modificar(Tbl_ExpedienteCasaDTO elemento) {
        return new Tbl_ExpedienteCasaDAO().modificar(elemento);
    }

    public boolean eliminar(Tbl_ExpedienteCasaDTO elemento) {
        elemento.setEstado(0);
        return new Tbl_ExpedienteCasaDAO().modificar(elemento);
    }

    /**
     * obtiene todos los expedientes del cual pertenecen a la casa 'claveCasa'
     * @param claveCasa
     * @return lista con los expedientes o una lista vacia si la casa no tiene 
     * expedientes, devuelve nulo en caso de un sql exception
     */
    public ArrayList<Tbl_ExpedienteCasaDTO> obtenerExpedientes(String claveCasa) {
        return new Tbl_ExpedienteCasaDAO().obtenerExpedientes(claveCasa);
    }

}
