package edu.uagro.dao;

import edu.uagro.dto.Tbl_ExpedienteCasaMoradorDTO;
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
public class Tbl_ExpedienteCasaMoradorDAO {

    
    public int insertar(Tbl_ExpedienteCasaMoradorDTO expedienteCasaMorador) {
        int indice = -1;
        if (expedienteCasaMorador == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = { Util.tbl_expedientecasamorador_tbl_expedientecasaId,
                            Util.tbl_expedientecasamoradorMatricula,
                            Util.tbl_expedientecasamoradorNombre,
                            Util.tbl_expedientecasamoradorApellidoMat,
                            Util.tbl_expedientecasamoradorApellidoPat,
                            Util.tbl_expedientecasamoradorSexo,
                            Util.tbl_expedientecasamoradorUAcademica,
                            Util.tbl_expedientecasamoradorGrado,
                            Util.tbl_expedientecasamoradorTurno,
                            Util.tbl_expedientecasamoradorPromedio,
                            Util.tbl_expedientecasamoradorEdad,
                            Util.tbl_expedientecasamoradorMunicipio,
                            Util.tbl_expedientecasamoradorRegion,
                            Util.tbl_expedientecasamoradorPlanEstudio,
                            Util.tbl_expedientecasamoradorHablaLenguaIndigena,
                            Util.tbl_expedientecasamorador_cat_lenguaindigenaId,
                            Util.tbl_expedientecasamoradorFoto,
                            Util.tbl_expedientecasamoradorObservacion,                      
                            };
        Util tabla = Util.tbl_expedientecasamorador;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, expedienteCasaMorador.getTbl_expedientecasaIdDTO());
            ps.setString(2, expedienteCasaMorador.getMatricula());
            ps.setString(3, expedienteCasaMorador.getNombre());
            ps.setString(4, expedienteCasaMorador.getApellidoMat());
            ps.setString(5, expedienteCasaMorador.getApellidoPat());
            ps.setString(6, expedienteCasaMorador.getSexo());
            ps.setString(7, expedienteCasaMorador.getuAcademica());
            ps.setInt(8, expedienteCasaMorador.getGrado());
            ps.setString(9, expedienteCasaMorador.getTurno());
            ps.setDouble(10, expedienteCasaMorador.getPromedio());
            ps.setInt(11, expedienteCasaMorador.getEdad());
            ps.setString(12, expedienteCasaMorador.getMunicipio());
            ps.setString(13, expedienteCasaMorador.getRegion());
            ps.setString(14, expedienteCasaMorador.getPlanEstudio());
            ps.setInt(15, expedienteCasaMorador.getHablaLenguaIndigena());
            ps.setInt(16, expedienteCasaMorador.getCat_lenguaIndigena());
            ps.setString(17, expedienteCasaMorador.getFoto());
            ps.setString(18, expedienteCasaMorador.getObservacion());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating ExpedienteCasaMorador failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                expedienteCasaMorador.setId(indice);
            } else {
                throw new SQLException("Creating ExpedienteCasaMorador failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_ExpedienteCasaMoradorDTO expedienteCasaMorador) {
        boolean band = false;
        if (expedienteCasaMorador == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_expedientecasamoradorId;
        Util tabla = Util.tbl_expedientecasamorador;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasaMorador.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating ExpedienteCasaMorador failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_ExpedienteCasaMoradorDTO expedienteCasaMorador) {
        boolean band = false;
        if (expedienteCasaMorador == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {
                            Util.tbl_expedientecasamoradorEdad,
                            Util.tbl_expedientecasamoradorHablaLenguaIndigena,  
                            Util.tbl_expedientecasamorador_cat_lenguaindigenaId};
        Util tabla = Util.tbl_expedientecasamorador;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_expedientecasamoradorId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasaMorador.getEdad());
            ps.setInt(2, expedienteCasaMorador.getHablaLenguaIndigena());
            ps.setInt(2, expedienteCasaMorador.getTbl_expedientecasaIdDTO());
      
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying ExpedienteCasaMorador failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_ExpedienteCasaMoradorDTO buscar(Tbl_ExpedienteCasaMoradorDTO expedienteCasaMorador) {
        if (expedienteCasaMorador == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasamorador_tbl_expedientecasaId,
                            Util.tbl_expedientecasamoradorMatricula,
                            Util.tbl_expedientecasamoradorNombre,
                            Util.tbl_expedientecasamoradorApellidoMat,
                            Util.tbl_expedientecasamoradorApellidoPat,
                            Util.tbl_expedientecasamoradorSexo,
                            Util.tbl_expedientecasamoradorUAcademica,
                            Util.tbl_expedientecasamoradorGrado,
                            Util.tbl_expedientecasamoradorTurno,
                            Util.tbl_expedientecasamoradorPromedio,
                            Util.tbl_expedientecasamoradorEdad,
                            Util.tbl_expedientecasamoradorMunicipio,
                            Util.tbl_expedientecasamoradorRegion,
                            Util.tbl_expedientecasamoradorPlanEstudio,
                            Util.tbl_expedientecasamoradorHablaLenguaIndigena,
                            Util.tbl_expedientecasamorador_cat_lenguaindigenaId,
                            Util.tbl_expedientecasamoradorFoto,
                            Util.tbl_expedientecasamoradorObservacion,      
                            Util.tbl_expedientecasamoradorStatus};
        Util tabla = Util.tbl_expedientecasamorador;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_expedientecasamoradorId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasaMorador.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                expedienteCasaMorador.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorNombre)));
                expedienteCasaMorador.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorApellidoMat)));
                expedienteCasaMorador.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorApellidoPat)));
                expedienteCasaMorador.setEdad(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorEdad)));
                expedienteCasaMorador.setFoto(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorFoto)));
                expedienteCasaMorador.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorGrado)));
                expedienteCasaMorador.setHablaLenguaIndigena(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorHablaLenguaIndigena)));
                expedienteCasaMorador.setCat_lenguaIndigena(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasamorador_cat_lenguaindigenaId)));
                expedienteCasaMorador.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorMatricula)));
                expedienteCasaMorador.setMunicipio(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorMunicipio)));
                expedienteCasaMorador.setObservacion(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorObservacion)));
                expedienteCasaMorador.setPlanEstudio(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorPlanEstudio)));
                expedienteCasaMorador.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorPromedio)));
                expedienteCasaMorador.setRegion(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorRegion)));
                expedienteCasaMorador.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorSexo)));
                expedienteCasaMorador.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorTurno)));
                expedienteCasaMorador.setuAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorUAcademica)));
                expedienteCasaMorador.setTbl_expedientecasaIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasamorador_tbl_expedientecasaId)));
                expedienteCasaMorador.setStatus(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasamoradorStatus)));
            } else { 
                expedienteCasaMorador = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            expedienteCasaMorador = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaMoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expedienteCasaMorador;
    }

}
