package edu.uagro.dao;


import edu.uagro.dto.Cat_AnioDTO;
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
 * @author magic
 */
public class Cat_AnioDAO  {


    public int insertar(Cat_AnioDTO cat_anio) {
        if (cat_anio ==null){
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_anioNombre };
        Util tabla = Util.cat_anio;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat_anio.getNombre());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Cat_Anio failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                cat_anio.setId(indice);
            } else {
                throw new SQLException("Creating Cat_Anio failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    

    public boolean eliminar(Cat_AnioDTO cat_anio) {
       
        if (cat_anio == null){
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Delete From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util columna = Util.cat_anioid;
        Util tabla = Util.cat_anio;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_anio.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Cat_Anio failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public boolean modificar(Cat_AnioDTO cat_anio) {
        
        if (cat_anio == null){    
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Update CostoPromedioAlumno set idProyecto = ?, cicloini = ?, ciclofin = ?, costo = ? Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_anioNombre};
        Util tabla = Util.cat_anio;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.cat_anioid;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, cat_anio.getNombre());
            ps.setInt(2, cat_anio.getId());

            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Cat_Anio failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public Object buscar(Cat_AnioDTO cat_anio) {

        if (cat_anio == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_anioNombre};
        Util tabla = Util.cat_anio;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_anioid;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_anio.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                cat_anio.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_anioNombre)));

            } else { 
                cat_anio = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
               cat_anio = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_AnioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_anio;
    }

}