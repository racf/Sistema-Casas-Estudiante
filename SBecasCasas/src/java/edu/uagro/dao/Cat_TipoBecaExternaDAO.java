/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.dao;

import edu.uagro.dto.Cat_TipoBecaExternaDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio18244
 */
public class Cat_TipoBecaExternaDAO {
    
      public int insertar(Cat_TipoBecaExternaDTO cat_tipobecaexterna) {
        if (cat_tipobecaexterna ==null){
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_tipobecaexternaNombre,
                           Util.cat_nivelbecaexternaId,
                           Util.cat_tipobecaexternaDescripcion};
        Util tabla = Util.cat_tipobecaexterna;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat_tipobecaexterna.getNombre());
            ps.setInt(2, cat_tipobecaexterna.getCat_nivelbecaexternaIdDTO());
            ps.setString(3, cat_tipobecaexterna.getDescripcion());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Cat_TipoBecaExterna failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                cat_tipobecaexterna.setId(indice);
            } else {
                throw new SQLException("Creating Cat_TipoBecaExterna failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    

    public boolean eliminar(Cat_TipoBecaExternaDTO cat_tipobecaexterna) {
       
        if (cat_tipobecaexterna == null){
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Delete From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util columna = Util.cat_tipobecaexternaId;
        Util tabla = Util.cat_tipobecaexterna;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_tipobecaexterna.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Cat_TipoBecaExterna failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public boolean modificar(Cat_TipoBecaExternaDTO cat_tipobecaexterna) {
        
        if (cat_tipobecaexterna == null){    
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Update CostoPromedioAlumno set idProyecto = ?, cicloini = ?, ciclofin = ?, costo = ? Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_tipobecaexternaNombre,
                           Util.cat_nivelbecaexternaId,
                           Util.cat_tipobecaexternaDescripcion};
        Util tabla = Util.cat_tipobecaexterna;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.cat_tipobecaexternaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, cat_tipobecaexterna.getNombre());
            ps.setInt(2, cat_tipobecaexterna.getCat_nivelbecaexternaIdDTO());
            ps.setString(3, cat_tipobecaexterna.getDescripcion());
            ps.setInt(4, cat_tipobecaexterna.getId());

            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Cat_TipoBecaExterna failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public Object buscar(Cat_TipoBecaExternaDTO cat_tipobecaexterna) {

        if (cat_tipobecaexterna == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_tipobecaexternaNombre,
                           Util.cat_nivelbecaexternaId,
                           Util.cat_tipobecaexternaDescripcion};
        Util tabla = Util.cat_tipobecaexterna;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_tipobecaexternaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_tipobecaexterna.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                cat_tipobecaexterna.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tipobecaexternaNombre)));
                cat_tipobecaexterna.setCat_nivelbecaexternaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.cat_nivelbecaexternaId)));
                cat_tipobecaexterna.setDescripcion(rs.getString(Utilerias.getPropiedad(Util.cat_tipobecaexternaDescripcion)));

            } else { 
                cat_tipobecaexterna = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
               cat_tipobecaexterna = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_TipoBecaExternaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_tipobecaexterna;
    }
    
    
}
