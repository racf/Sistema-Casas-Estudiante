package edu.uagro.dao;

import edu.uagro.dto.Cat_TipoCasaDTO;
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

public class Cat_TipoCasaDAO {
    
     public int insertar(Cat_TipoCasaDTO cat_tipocasa) {
        if (cat_tipocasa ==null){
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_tipocasaNombre };
        Util tabla = Util.cat_tipocasa;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat_tipocasa.getNombre());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Cat_NivelBeca failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                cat_tipocasa.setId(indice);
            } else {
                throw new SQLException("Creating Cat_NivelBeca failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    

    public boolean eliminar(Cat_TipoCasaDTO cat_tipocasa) {
       
        if (cat_tipocasa == null){
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Delete From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util columna = Util.cat_tipocasaId;
        Util tabla = Util.cat_tipocasa;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_tipocasa.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Cat_NivelBeca failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public boolean modificar(Cat_TipoCasaDTO cat_tipocasa) {
        
        if (cat_tipocasa == null){    
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Update CostoPromedioAlumno set idProyecto = ?, cicloini = ?, ciclofin = ?, costo = ? Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_tipocasaNombre};
        Util tabla = Util.cat_tipocasa;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.cat_tipocasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, cat_tipocasa.getNombre());
            ps.setInt(2, cat_tipocasa.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Cat_NivelBeca failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public Object buscar(Cat_TipoCasaDTO cat_tipocasa) {

        if (cat_tipocasa == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_tipocasaNombre};
        Util tabla = Util.cat_tipocasa;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_tipocasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_tipocasa.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                cat_tipocasa.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tipocasaNombre)));

            } else { 
                cat_tipocasa = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
               cat_tipocasa = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_tipocasa;
    }
    
}
