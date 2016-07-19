package edu.uagro.dao;

import edu.uagro.dto.Tbl_DetalleBecaExternaDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_DetalleBecaExternaDAO {

    
    public int insertar(Tbl_DetalleBecaExternaDTO detalleBecaExterna) {
        int indice = -1;
        if (detalleBecaExterna == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_detallebecaexternaCantidad,
                            Util.tbl_detallebecaexterna_cat_anioId,
                            Util.tbl_detallebecaexterna_cat_tipobecaexternaId,
                            Util.tbl_detallebecaexterna_tbl_unidadacademicaNombre};
        Util tabla = Util.tbl_detallebecaexterna;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalleBecaExterna.getCantidad());
            ps.setInt(2, detalleBecaExterna.getCat_anioIdDTO());
            ps.setInt(3, detalleBecaExterna.getCat_tipobecaexternaIdDTO());
            ps.setString(4, detalleBecaExterna.getUnidadAcademicaNombre());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating DetalleBecaExterna failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                detalleBecaExterna.setId(indice);
            } else {
                throw new SQLException("Creating DetalleBecaExterna failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_DetalleBecaExternaDTO detalleBecaExterna) {
        boolean band = false;
        if (detalleBecaExterna == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_detallebecaexternaId;
        Util tabla = Util.tbl_detallebecaexterna;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, detalleBecaExterna.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating DetalleBecaExterna failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_DetalleBecaExternaDTO detalleBecaExterna) {
        boolean band = false;
        if (detalleBecaExterna == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_detallebecaexternaCantidad,
                            Util.tbl_detallebecaexterna_cat_anioId,
                            Util.tbl_detallebecaexterna_cat_tipobecaexternaId,
                            Util.tbl_detallebecaexterna_tbl_unidadacademicaNombre,
                            Util.tbl_detallebecaexternaEstado};
        Util tabla = Util.tbl_detallebecaexterna;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_detallebecaexternaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, detalleBecaExterna.getCantidad());
            ps.setInt(2, detalleBecaExterna.getCat_anioIdDTO());
            ps.setInt(3, detalleBecaExterna.getCat_tipobecaexternaIdDTO());
            ps.setString(4, detalleBecaExterna.getUnidadAcademicaNombre());
            ps.setInt(5, detalleBecaExterna.getEstado());
            ps.setInt(6, detalleBecaExterna.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying DetalleBecaExterna failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_DetalleBecaExternaDTO buscar(Tbl_DetalleBecaExternaDTO detalleBecaExterna) {
        if (detalleBecaExterna == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_detallebecaexternaCantidad,
                            Util.tbl_detallebecaexterna_cat_anioId,
                            Util.tbl_detallebecaexterna_cat_tipobecaexternaId,
                            Util.tbl_detallebecaexterna_tbl_unidadacademicaNombre,
                            Util.tbl_detallebecaexternaEstado};
        Util tabla = Util.tbl_detallebecaexterna;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_detallebecaexternaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, detalleBecaExterna.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                detalleBecaExterna.setCantidad(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecaexternaCantidad)));
                detalleBecaExterna.setCat_anioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecaexterna_cat_anioId)));
                detalleBecaExterna.setCat_tipobecaexternaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecaexterna_cat_tipobecaexternaId)));
                detalleBecaExterna.setUnidadAcademicaNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_detallebecaexterna_tbl_unidadacademicaNombre)));
                detalleBecaExterna.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_detallebecaexternaEstado)));
            } else { 
                detalleBecaExterna = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            detalleBecaExterna = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_DetalleBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return detalleBecaExterna;
    }

}
