package edu.uagro.dao;

import edu.uagro.dto.Tbl_ArrendatarioDTO;
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

public class Tbl_ArrendatarioDAO {
    public int insertar (Object t){
        Tbl_ArrendatarioDTO arrendatarioDTO;
        if(t instanceof Tbl_ArrendatarioDTO){
            arrendatarioDTO = (Tbl_ArrendatarioDTO)t;            
        }else{
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendatarioNombre,
                           Util.tbl_arrendatarioCargo,
                           Util.tbl_arrendatarioDomicilio};
        Util tabla = Util.tbl_arrendatario;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, arrendatarioDTO.getNombre());
            ps.setString(2, arrendatarioDTO.getCargo());
            ps.setString(3, arrendatarioDTO.getDomicilio());
            int filMod = ps.executeUpdate();
            if(filMod == 0){
                throw new SQLException("Creating Tbl_Arrendatario failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if(rs.first()){
                indice = rs.getInt(1);
                arrendatarioDTO.setId(indice);
            }else{
                throw new SQLException("Creating Tbl_Arrendatario failed, no ID obtained.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return indice;
    }
    
    public boolean eliminar(Object t){
        Tbl_ArrendatarioDTO arrendatarioDTO;
        if(t instanceof Tbl_ArrendatarioDTO){
            arrendatarioDTO = (Tbl_ArrendatarioDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_arrendatarioId;
        Util tabla = Util.tbl_arrendatario;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, arrendatarioDTO.getId());
            int filaMod = ps.executeUpdate();
            if(filaMod == 0){
                throw new SQLException("Eliminating Tbl_Arrendatario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return band;
    }

    public boolean modificar(Object t){
        Tbl_ArrendatarioDTO arrendatarioDTO;
        if(t instanceof Tbl_ArrendatarioDTO){
            arrendatarioDTO = (Tbl_ArrendatarioDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendatarioNombre,
                           Util.tbl_arrendatarioCargo,
                           Util.tbl_arrendatarioDomicilio};
        Util tabla = Util.tbl_arrendatario;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_arrendatarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, arrendatarioDTO.getNombre());
            ps.setString(2, arrendatarioDTO.getCargo());
            ps.setString(3, arrendatarioDTO.getDomicilio());
            ps.setInt(4, arrendatarioDTO.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Tbl_Arrendatario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return band;
    }
    
    public Object buscar(Object t){
        Tbl_ArrendatarioDTO arrendatarioDTO;
        if(t instanceof Tbl_ArrendatarioDTO){
            arrendatarioDTO = (Tbl_ArrendatarioDTO)t;            
        }else{
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendatarioNombre,
                           Util.tbl_arrendatarioCargo,
                           Util.tbl_arrendatarioDomicilio};
        Util tabla = Util.tbl_arrendatario;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_arrendatarioId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, arrendatarioDTO.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                arrendatarioDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioNombre)));
                arrendatarioDTO.setCargo(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioCargo)));
                arrendatarioDTO.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioDomicilio)));                
            }else{
                arrendatarioDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return arrendatarioDTO;
    }

    public ArrayList<Tbl_ArrendatarioDTO> obtenerArrendatarios() {
        ArrayList<Tbl_ArrendatarioDTO> lista = new ArrayList();
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.ASTERISCO};
        Util tabla = Util.tbl_arrendatario;
        sql = Utilerias.prepareSelect(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                Tbl_ArrendatarioDTO dto = new Tbl_ArrendatarioDTO();
                dto.setCargo(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioCargo)));
                dto.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioDomicilio)));
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendatarioId)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioNombre)));
                lista.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ArrendatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
