package edu.uagro.dao;

import edu.uagro.dto.Tbl_BecarioArchivoDTO;
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

public class Tbl_BecarioArchivoDAO {
    public int insertar (Object t){
        Tbl_BecarioArchivoDTO becarioarchivoDTO;
        if(t instanceof Tbl_BecarioArchivoDTO){
            becarioarchivoDTO = (Tbl_BecarioArchivoDTO)t;            
        }else{
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioarchivo_tblbecarioId,
                           Util.tbl_becarioarchivoNombre,
                           Util.tbl_becarioarchivoExtencion,
                           Util.tbl_becarioarchivoURL,
                           Util.tbl_becarioarchivoDescripcion};
        Util tabla = Util.tbl_becarioarchivo;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, becarioarchivoDTO.getTbl_becarioIdDTO());
            ps.setString(2, becarioarchivoDTO.getNombre());
            ps.setString(3, becarioarchivoDTO.getExtencion());
            ps.setString(4, becarioarchivoDTO.getUrl());
            ps.setString(5, becarioarchivoDTO.getDescripcion());
            int filMod = ps.executeUpdate();
            if(filMod == 0){
                throw new SQLException("Creating Tbl_BecarioArchivo failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if(rs.first()){
                indice = rs.getInt(1);
                becarioarchivoDTO.setId(indice);
            }else{
                throw new SQLException("Creating Tbl_BecarioArchivo failed, no ID obtained.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return indice;
    }
    
    public boolean eliminar(Object t){
        Tbl_BecarioArchivoDTO becarioarchivoDTO;
        if(t instanceof Tbl_BecarioArchivoDTO){
            becarioarchivoDTO = (Tbl_BecarioArchivoDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_becarioarchivoId;
        Util tabla = Util.tbl_becarioarchivo;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, becarioarchivoDTO.getId());
            int filaMod = ps.executeUpdate();
            if(filaMod == 0){
                throw new SQLException("Eliminating Tbl_BecarioArchivo failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return band;
    }
    
    public boolean modificar(Object t){
         Tbl_BecarioArchivoDTO becarioarchivoDTO;
        if(t instanceof Tbl_BecarioArchivoDTO){
            becarioarchivoDTO = (Tbl_BecarioArchivoDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioarchivo_tblbecarioId,
                           Util.tbl_becarioarchivoNombre,
                           Util.tbl_becarioarchivoExtencion,
                           Util.tbl_becarioarchivoURL,
                           Util.tbl_becarioarchivoDescripcion};
        Util tabla = Util.tbl_becarioarchivo;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioarchivoId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, becarioarchivoDTO.getTbl_becarioIdDTO());
            ps.setString(2, becarioarchivoDTO.getNombre());
            ps.setString(3, becarioarchivoDTO.getExtencion());
            ps.setString(4, becarioarchivoDTO.getUrl());
            ps.setString(5, becarioarchivoDTO.getDescripcion());
             ps.setInt(6, becarioarchivoDTO.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Tbl_ArchivoBecario failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return band;
    }
    
    public Object buscar(Object t){
         Tbl_BecarioArchivoDTO becarioarchivoDTO;
        if(t instanceof Tbl_BecarioArchivoDTO){
            becarioarchivoDTO = (Tbl_BecarioArchivoDTO)t;            
        }else{
            return false;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_becarioarchivo_tblbecarioId,
                           Util.tbl_becarioarchivoNombre,
                           Util.tbl_becarioarchivoExtencion,
                           Util.tbl_becarioarchivoURL,
                           Util.tbl_becarioarchivoDescripcion};
        Util tabla = Util.tbl_becarioarchivo;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_becarioarchivoId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, becarioarchivoDTO.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                becarioarchivoDTO.setTbl_becarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_becarioarchivo_tblbecarioId)));
                becarioarchivoDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioarchivoNombre)));
                becarioarchivoDTO.setExtencion(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioarchivoExtencion)));
                becarioarchivoDTO.setUrl(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioarchivoURL)));
                becarioarchivoDTO.setDescripcion(rs.getString(Utilerias.getPropiedad(Util.tbl_becarioarchivoDescripcion)));                
            }else{
                becarioarchivoDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_BecarioArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return becarioarchivoDTO;
    }
}
