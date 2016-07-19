package edu.uagro.dao;

import edu.uagro.dto.Tbl_UsuariosDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_UsuariosDAO {
    
    /**
     * 
     * @param usuario - contiene email y contraseña
     * @return  si usuario es nulo, devuelve false. si existe en la bd, devuelve 
     * un bean cargado con los datos y true, si no existe devuelve false.
     */
    public boolean verificar(Tbl_UsuariosDTO usuario) {
        try {
            Connection con = BDConexion.getConexion();
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(500);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.ASTERISCO)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_usuarios)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_usuariosEmail)).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                    .append(Utilerias.getPropiedad(Util.QUESTION_MARK)).append(" ")
                    .append(Utilerias.getPropiedad(Util.AND)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_usuariosContrasenia)).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                    .append(Utilerias.getPropiedad(Util.QUESTION_MARK));
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasenia());
            rs = ps.executeQuery();
            if (rs.first()) {
                usuario.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_usuariosId)));
                usuario.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_usuariosEstado)));
                usuario.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_usuariosNombre)));
                usuario.setFechaCreacion(new java.util.Date(rs.getDate(Utilerias.getPropiedad(Util.tbl_usuariosFechaCreacion)).getTime()));
                usuario.setCat_tipousuarioDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_usuarios_cat_tipousuarioId)));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
}
