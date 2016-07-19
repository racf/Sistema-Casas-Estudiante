/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.dao;

import edu.uagro.dto.Cat_TipoRepresentanteDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class Cat_TipoRepresentanteDAO {
    
    public ArrayList<Cat_TipoRepresentanteDTO> obtenerDatos() {
        Connection con = BDConexion.getConexion();
        ArrayList<Cat_TipoRepresentanteDTO> lista = new ArrayList();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.ASTERISCO)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante));
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Cat_TipoRepresentanteDTO dto = new Cat_TipoRepresentanteDTO();
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)));
                lista.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_TipoRepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_TipoRepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
