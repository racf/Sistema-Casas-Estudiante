package edu.uagro.bo;

import edu.uagro.dao.Tbl_ArrendatarioDAO;
import edu.uagro.dto.Tbl_ArrendatarioDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Tbl_ArrendatarioBO {

    public int agregar(Tbl_ArrendatarioDTO arrenda) {
        Tbl_ArrendatarioDAO dao = new Tbl_ArrendatarioDAO();
        return dao.insertar(arrenda);
    }

    public boolean eliminar(Tbl_ArrendatarioDTO dto) {
        Tbl_ArrendatarioDAO dao = new Tbl_ArrendatarioDAO();
        return dao.eliminar(dto);   
    }

    public ArrayList<Tbl_ArrendatarioDTO> obtenerDatos() {
        return this.obtenerArrendatarios();
    
    }

    public boolean editar(Tbl_ArrendatarioDTO dto) {
        Tbl_ArrendatarioDAO dao = new Tbl_ArrendatarioDAO();
        return dao.modificar(dto);   
    }
    
    public ArrayList<Tbl_ArrendatarioDTO> obtenerArrendatarios() {
        Tbl_ArrendatarioDAO dao = new Tbl_ArrendatarioDAO();
        return dao.obtenerArrendatarios();
    }
    
}
