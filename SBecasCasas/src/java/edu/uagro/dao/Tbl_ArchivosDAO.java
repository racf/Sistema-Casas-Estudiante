package edu.uagro.dao;

import edu.uagro.dto.Cat_ArchivosDTO;
import edu.uagro.dto.Tbl_ArchivosDTO;
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
 * @author Fernando
 */
public class Tbl_ArchivosDAO {
    
    public int insertar (Object t){
//        if(archivosDTO == null){
//            return -1;
//        }else{
//            archivosDTO = new Tbl_ArchivosDTO();
//        }
        Tbl_ArchivosDTO archivosDTO;
        if(t instanceof Tbl_ArchivosDTO){
            archivosDTO = (Tbl_ArchivosDTO)t;            
        }else{
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_archivos_tbl_expedientecasaId,
                           Util.tbl_archivosNombre,
                           Util.tbl_archivosExtencion,
                           Util.tbl_archivosURL,
                           Util.tbl_archivosDescripcion,
                           Util.tbl_archivos_cat_archivosId};
        Util tabla = Util.tbl_archivos;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, archivosDTO.getTbl_expedientecasaIdDTO());
            ps.setString(2, archivosDTO.getNombre());
            ps.setString(3, archivosDTO.getExtencion());
            ps.setString(4, archivosDTO.getUrl());
            ps.setString(5, archivosDTO.getDescripcion());
            ps.setInt(6, archivosDTO.getCat_archivosIdDTO());
            int filMod = ps.executeUpdate();
            if(filMod == 0){
                throw new SQLException("Creating Tbl_Archivos failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if(rs.first()){
                indice = rs.getInt(1);
                archivosDTO.setId(indice);
            }else{
                throw new SQLException("Creating Tbl_Archivos failed, no ID obtained.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return indice;
    }
    
    public boolean eliminar(Object t){
        Tbl_ArchivosDTO archivosDTO;
        if(t instanceof Tbl_ArchivosDTO){
            archivosDTO = (Tbl_ArchivosDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_archivosId;
        Util tabla = Util.tbl_archivos;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, archivosDTO.getId());
            int filaMod = ps.executeUpdate();
            if(filaMod == 0){
                throw new SQLException("Eliminating Tbl_Archivos failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return band;
    }
    
    public boolean modificar(Object t){
        Tbl_ArchivosDTO archivosDTO;
        if(t instanceof Tbl_ArchivosDTO){
            archivosDTO = (Tbl_ArchivosDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_archivos_tbl_expedientecasaId,
                           Util.tbl_archivosNombre,
                           Util.tbl_archivosExtencion,
                           Util.tbl_archivosURL,
                           Util.tbl_archivosDescripcion,
                           Util.tbl_archivos_cat_archivosId};
        Util tabla = Util.tbl_archivos;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_archivosId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, archivosDTO.getTbl_expedientecasaIdDTO());
            ps.setString(2, archivosDTO.getNombre());
            ps.setString(3, archivosDTO.getExtencion());
            ps.setString(4, archivosDTO.getUrl());
            ps.setString(5, archivosDTO.getDescripcion());
            ps.setInt(6, archivosDTO.getCat_archivosIdDTO());
            ps.setInt(7, archivosDTO.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Tbl_Archivos failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return band;
    }
    
    public Object buscar(Object t){
        Tbl_ArchivosDTO archivosDTO;
        if(t instanceof Tbl_ArchivosDTO){
            archivosDTO = (Tbl_ArchivosDTO)t;            
        }else{
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_archivos_tbl_expedientecasaId,
                           Util.tbl_archivosNombre,
                           Util.tbl_archivosExtencion,
                           Util.tbl_archivosURL,
                           Util.tbl_archivosDescripcion,
                           Util.tbl_archivos_cat_archivosId};
        Util tabla = Util.tbl_archivos;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_archivosId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, archivosDTO.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                archivosDTO.setTbl_expedientecasaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_archivos_tbl_expedientecasaId)));
                archivosDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosNombre)));
                archivosDTO.setExtencion(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosExtencion)));
                archivosDTO.setUrl(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosURL)));
                archivosDTO.setDescripcion(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosDescripcion)));
                archivosDTO.setCat_archivosIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_archivos_cat_archivosId)));
            }else{
                archivosDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return archivosDTO;
    }

    public ArrayList<Tbl_ArchivosDTO> obtenerArchivos(int expedienteId) {
        ArrayList<Tbl_ArchivosDTO> archivos = new ArrayList();
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.ASTERISCO};
        Util tabla = Util.tbl_archivos;
        sql = Utilerias.prepareSelect(tabla, columnas);
        sql.append(Util.INNER_JOIN).append(Util.ESPACIO)
                .append(Util.cat_archivos).append(Util.ESPACIO)
                .append(Util.ON).append(Util.ESPACIO)
                .append(Util.cat_archivos).append(Util.PUNTO).append(Util.cat_archivosId).append(Util.ESPACIO_IGUAL_ESPACIO)
                .append(Util.tbl_archivos).append(Util.PUNTO).append(Util.tbl_archivos_cat_archivosId).append(Util.ESPACIO);
        Util columnaCondicion = Util.tbl_archivos_tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteId);
            rs = ps.executeQuery();
            while(rs.next()){
                Tbl_ArchivosDTO archivosDTO = new Tbl_ArchivosDTO();
                archivosDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_archivosId)));
                archivosDTO.setTbl_expedientecasaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_archivos_tbl_expedientecasaId)));
                archivosDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosNombre)));
                archivosDTO.setExtencion(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosExtencion)));
                archivosDTO.setUrl(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosURL)));
                archivosDTO.setDescripcion(rs.getString(Utilerias.getPropiedad(Util.tbl_archivosDescripcion)));
                archivosDTO.setCat_archivosIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_archivos_cat_archivosId)));
                Cat_ArchivosDTO catArch = new Cat_ArchivosDTO();
                catArch.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_archivosId)));
                catArch.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_archivosNombre)));
                catArch.setEstado(rs.getInt(Utilerias.getPropiedad(Util.cat_archivosEstado)));
                archivosDTO.setCat_archivosDTO(catArch);
                archivos.add(archivosDTO);
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return archivos;
    }
}
