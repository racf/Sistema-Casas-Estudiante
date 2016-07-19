package edu.uagro.bo;

import edu.uagro.dao.Tbl_UsuariosDAO;
import edu.uagro.dto.Tbl_UsuariosDTO;

/**
 *
 * @author Antonio18244
 */
public class Tbl_UsuariosBO {
    
    private Tbl_UsuariosDAO dao;

    public Tbl_UsuariosBO() {
        dao = new Tbl_UsuariosDAO();
    }
    
    public boolean login(Tbl_UsuariosDTO usuario) {
        if (dao.verificar(usuario)) {
            return true;
        } else {
            usuario = null;
            return false;
        }
    }
    
}
