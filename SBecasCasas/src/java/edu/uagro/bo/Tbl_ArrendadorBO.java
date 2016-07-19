package edu.uagro.bo;

import edu.uagro.dao.Tbl_ArrendadorDAO;
import edu.uagro.dto.Tbl_ArrendadorDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_ArrendadorBO {

    public ArrayList<Tbl_ArrendadorDTO> obtenerArrendadores() {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.obtenerArrendadores();
    }

    public int agregar(Tbl_ArrendadorDTO arrendador) {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.insertar(arrendador);
    }

    public boolean eliminar(Tbl_ArrendadorDTO dto) {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.eliminar(dto);
    }

    public ArrayList<Tbl_ArrendadorDTO> obtenerDatos() {
        return this.obtenerArrendadores();
    }

    public boolean editar(Tbl_ArrendadorDTO dto) {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.modificar(dto);
    }

    public Tbl_ArrendadorDTO buscarArredadorExterno(Tbl_ArrendadorDTO dto) {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.buscarArrendadorExterno(dto);
    }

    public boolean validarInterno(int numProvedor) {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.validarInterno(numProvedor);
    }

    public ArrayList<Tbl_ArrendadorDTO> obtenerDAtosParametros(Tbl_ArrendadorDTO dto) {
        Tbl_ArrendadorDAO dao = new Tbl_ArrendadorDAO();
        return dao.obtenerDAtosParametros(dto);
    }
}
