/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.dao;

import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio18244
 */
public class Cat_ZonasDAO {
    
    public int insertar(Cat_ZonasDTO cat_zonas) {
        if (cat_zonas ==null){
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_zonasNombre,
                           Util.cat_zonasDescripcion};
        Util tabla = Util.cat_zonas;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat_zonas.getNombre());
            ps.setString(2, cat_zonas.getDescripcion());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Cat_NivelBeca failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                cat_zonas.setId(indice);
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
    

    public boolean eliminar(Cat_ZonasDTO cat_zonas) {
       
        if (cat_zonas == null){
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Delete From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util columna = Util.cat_zonasId;
        Util tabla = Util.cat_zonas;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_zonas.getId());
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


    public boolean modificar(Cat_ZonasDTO cat_zonas) {
        
        if (cat_zonas == null){    
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Update CostoPromedioAlumno set idProyecto = ?, cicloini = ?, ciclofin = ?, costo = ? Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_zonasNombre,
                           Util.cat_zonasDescripcion};
        Util tabla = Util.cat_zonas;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.cat_zonasId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, cat_zonas.getNombre());
            ps.setString(2, cat_zonas.getDescripcion());

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


    public Object buscar(Cat_ZonasDTO cat_zonas) {

        if (cat_zonas == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_zonasNombre,
                           Util.cat_zonasDescripcion};
        Util tabla = Util.cat_zonas;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_zonasId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_zonas.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                cat_zonas.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_zonasNombre)));
                cat_zonas.setDescripcion(rs.getString(Utilerias.getPropiedad(Util.cat_zonasDescripcion)));

            } else { 
                cat_zonas = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
               cat_zonas = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_zonas;
    }
    
     public ArrayList<Cat_ZonasDTO> obtenerZonas(){
        Connection con = BDConexion.getConexion();
        ArrayList<Cat_ZonasDTO> lstZonas = new ArrayList<>();
        //Statement estatuto;
        Statement st = null;
        ResultSet rs = null;
        Cat_ZonasDTO zonasDTO;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT cat_zonasId, cat_zonasNombre FROM cat_zonas");
            while(rs.next()){
                zonasDTO = new Cat_ZonasDTO();
                zonasDTO.setId(rs.getInt("cat_zonasId"));
                zonasDTO.setNombre(rs.getString("cat_zonasNombre"));
                lstZonas.add(zonasDTO);
            }
        } catch (Exception e) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstZonas;                
    }
}
