package edu.uagro.dao;

import edu.uagro.dto.Tbl_ArrendadorDTO;
import edu.uagro.dto.Tbl_ArrendatarioDTO;
import edu.uagro.dto.Tbl_CasaEstudianteDTO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_ExpedienteCasaDAO {

    
    public int insertar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        int indice = -1;
        if (expedienteCasa == null) {
            return indice;
        }
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaAumento,
                            Util.tbl_expedientecasaMontoTotal,
                            Util.tbl_expedientecasaMontoLetra,};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            if (expedienteCasa.getFechaFinalArrendamiento() != null) {
                ps.setDate(1, new Date (expedienteCasa.getFechaFinalArrendamiento().getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicialArrendamiento() != null) {
                ps.setDate(2, new Date (expedienteCasa.getFechaInicialArrendamiento().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicio() != null) {
                ps.setDate(3, new Date (expedienteCasa.getFechaInicio().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }
            ps.setDouble(4, expedienteCasa.getMontoRenta());
            ps.setString(5, expedienteCasa.getTipoRenta());
            ps.setInt(6, expedienteCasa.getTbl_arrendadorIdDTO());
            ps.setInt(7, expedienteCasa.getTbl_arrendatarioIdDTO());
            ps.setString(8, expedienteCasa.getTbl_casaestudianteClaveDTO());
            ps.setString(9, expedienteCasa.getTbl_representanteMatriculaDTO());
            ps.setDouble(10, expedienteCasa.getAumento());
            ps.setDouble(11, expedienteCasa.getMontoTotal());
            ps.setString(12, expedienteCasa.getMontoLetra());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating ExpedienteCasa failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                expedienteCasa.setId(indice);
            } else {
                throw new SQLException("Creating ExpedienteCasa failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    
    
    public boolean eliminar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        boolean band = false;
        if (expedienteCasa == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna[] = {Util.tbl_expedientecasaEstado};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareUpdate(tabla);
        Util columnaCondicion = Util.tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            expedienteCasa.setEstado(0);
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasa.getEstado());
            ps.setInt(2, expedienteCasa.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating ExpedienteCasa failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public boolean modificar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        boolean band = false;
        if (expedienteCasa == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaEstado};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            if (expedienteCasa.getFechaFinalArrendamiento() != null) {
                ps.setDate(1, new Date (expedienteCasa.getFechaFinalArrendamiento().getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicialArrendamiento() != null) {
                ps.setDate(2, new Date (expedienteCasa.getFechaInicialArrendamiento().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            if (expedienteCasa.getFechaInicio() != null) {
                ps.setDate(3, new Date (expedienteCasa.getFechaInicio().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }
            ps.setDouble(4, expedienteCasa.getMontoRenta());
            ps.setString(5, expedienteCasa.getTipoRenta());
            ps.setInt(6, expedienteCasa.getTbl_arrendadorIdDTO());
            ps.setInt(7, expedienteCasa.getTbl_arrendatarioIdDTO());
            ps.setString(8, expedienteCasa.getTbl_casaestudianteClaveDTO());
            ps.setString(9, expedienteCasa.getTbl_representanteMatriculaDTO());
            ps.setInt(10, expedienteCasa.getEstado());
            ps.setInt(11, expedienteCasa.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying ExpedienteCasa failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_ExpedienteCasaDTO buscar(Tbl_ExpedienteCasaDTO expedienteCasa) {
        if (expedienteCasa == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaAumento,
                            Util.tbl_expedientecasaMontoTotal,
                            Util.tbl_expedientecasaMontoLetra,
                            Util.tbl_expedientecasaEstado};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expedienteCasa.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                expedienteCasa.setFechaFinalArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaFinalArrendamiento)));
                expedienteCasa.setFechaInicialArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaInicialArrendamiento)));
                expedienteCasa.setFechaInicio(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaRegistro)));
                expedienteCasa.setMontoRenta(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoRenta)));
                expedienteCasa.setTipoRenta(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaTipoRenta)));
                expedienteCasa.setTbl_arrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)));
                expedienteCasa.setTbl_arrendatarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)));
                expedienteCasa.setTbl_casaestudianteClaveDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)));
                expedienteCasa.setTbl_representanteMatriculaDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_representanteMatricula)));
                expedienteCasa.setAumento(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaAumento)));
                expedienteCasa.setMontoTotal(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoTotal)));
                expedienteCasa.setMontoLetra(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoLetra)));
                expedienteCasa.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaEstado)));
            } else { 
                expedienteCasa = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            expedienteCasa = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expedienteCasa;
    }

    public ArrayList<Tbl_ExpedienteCasaDTO> obtenerExpedientes() {
        ArrayList<Tbl_ExpedienteCasaDTO> expedientes = new ArrayList();
        Tbl_ExpedienteCasaDTO expediente;
        Tbl_CasaEstudianteDTO casa;
        Tbl_ArrendadorDTO arrendador;
        Tbl_ArrendatarioDTO arrendatario;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaId,
                            Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaAumento,
                            Util.tbl_expedientecasaMontoTotal,
                            Util.tbl_expedientecasaMontoLetra,
                            Util.tbl_expedientecasaEstado,
                            Util.tbl_arrendatarioNombre,
                            Util.tbl_casaestudianteNombre,
                            Util.tbl_arrendadorNombre,
                            Util.tbl_arrendadorApellidoPat,
                            Util.tbl_arrendadorApellidoMat};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareSelect(tabla, columnas);
        sql.append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatario)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatario)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatarioId))
                .append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudiante)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudiante)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudianteClave))
                .append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendadorId));
        Util columnaCondicion = Util.tbl_expedientecasaEstado;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                expediente = new Tbl_ExpedienteCasaDTO();
                casa = new Tbl_CasaEstudianteDTO();
                arrendador = new Tbl_ArrendadorDTO();
                arrendatario = new Tbl_ArrendatarioDTO();
                expediente.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaId)));
                expediente.setFechaFinalArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaFinalArrendamiento)));
                expediente.setFechaInicialArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaInicialArrendamiento)));
                expediente.setFechaInicio(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaRegistro)));
                expediente.setMontoRenta(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoRenta)));
                expediente.setTipoRenta(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaTipoRenta)));
                expediente.setTbl_arrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)));
                expediente.setTbl_arrendatarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)));
                expediente.setTbl_casaestudianteClaveDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)));
                expediente.setTbl_representanteMatriculaDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_representanteMatricula)));
                expediente.setAumento(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaAumento)));
                expediente.setMontoTotal(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoTotal)));
                expediente.setMontoLetra(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoLetra)));
                expediente.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaEstado)));
                casa.setClave(expediente.getTbl_casaestudianteClaveDTO());
                casa.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteNombre)));
                arrendatario.setId(expediente.getTbl_arrendatarioIdDTO());
                arrendatario.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioNombre)));
                arrendador.setId(expediente.getId());
                arrendador.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                arrendador.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoPat)));
                arrendador.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoMat)));
                expediente.setTbl_casaestudianteDTO(casa);
                expediente.setTbl_arrendatarioDTO(arrendatario);
                expediente.setTbl_arrendadorDTO(arrendador);
                expedientes.add(expediente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            expedientes = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expedientes;
    }

    public Tbl_ExpedienteCasaDTO obtenerExpediente(Tbl_ExpedienteCasaDTO expediente) {
        Tbl_CasaEstudianteDTO casa;
        Tbl_ArrendadorDTO arrendador;
        Tbl_ArrendatarioDTO arrendatario;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaId,
                            Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaAumento,
                            Util.tbl_expedientecasaMontoTotal,
                            Util.tbl_expedientecasaMontoLetra,
                            Util.tbl_expedientecasaEstado,
                            Util.tbl_arrendatarioNombre,
                            Util.tbl_casaestudianteNombre,
                            Util.tbl_arrendadorNombre,
                            Util.tbl_arrendadorApellidoPat,
                            Util.tbl_arrendadorApellidoMat};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareSelect(tabla, columnas);
        sql.append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatario)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatario)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatarioId))
                .append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudiante)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudiante)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudianteClave))
                .append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendadorId));
        Util columnaCondicion = Util.tbl_expedientecasaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, expediente.getId());
            rs = ps.executeQuery();
            if (rs.first()){
                expediente = new Tbl_ExpedienteCasaDTO();
                casa = new Tbl_CasaEstudianteDTO();
                arrendador = new Tbl_ArrendadorDTO();
                arrendatario = new Tbl_ArrendatarioDTO();
                expediente.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaId)));
                expediente.setFechaFinalArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaFinalArrendamiento)));
                expediente.setFechaInicialArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaInicialArrendamiento)));
                expediente.setFechaInicio(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaRegistro)));
                expediente.setMontoRenta(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoRenta)));
                expediente.setTipoRenta(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaTipoRenta)));
                expediente.setTbl_arrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)));
                expediente.setTbl_arrendatarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)));
                expediente.setTbl_casaestudianteClaveDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)));
                expediente.setTbl_representanteMatriculaDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_representanteMatricula)));
                expediente.setAumento(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaAumento)));
                expediente.setMontoTotal(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoTotal)));
                expediente.setMontoLetra(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoLetra)));
                expediente.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaEstado)));
                casa.setClave(expediente.getTbl_casaestudianteClaveDTO());
                casa.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteNombre)));
                arrendatario.setId(expediente.getTbl_arrendatarioIdDTO());
                arrendatario.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioNombre)));
                arrendador.setId(expediente.getId());
                arrendador.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                arrendador.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoPat)));
                arrendador.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoMat)));
                expediente.setTbl_casaestudianteDTO(casa);
                expediente.setTbl_arrendatarioDTO(arrendatario);
                expediente.setTbl_arrendadorDTO(arrendador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            expediente = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expediente;
    }

    public ArrayList<Tbl_ExpedienteCasaDTO> obtenerExpedientes(String claveCasa) {
        ArrayList<Tbl_ExpedienteCasaDTO> expedientes = new ArrayList();
        Tbl_ExpedienteCasaDTO expediente;
        Tbl_CasaEstudianteDTO casa;
        Tbl_ArrendadorDTO arrendador;
        Tbl_ArrendatarioDTO arrendatario;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_expedientecasaId,
                            Util.tbl_expedientecasaFechaFinalArrendamiento,
                            Util.tbl_expedientecasaFechaInicialArrendamiento,
                            Util.tbl_expedientecasaFechaRegistro,
                            Util.tbl_expedientecasaMontoRenta,
                            Util.tbl_expedientecasaTipoRenta,
                            Util.tbl_expedientecasa_tbl_arrendadorId,
                            Util.tbl_expedientecasa_tbl_arrendatarioId,
                            Util.tbl_expedientecasa_tbl_casaestudianteClave,
                            Util.tbl_expedientecasa_tbl_representanteMatricula,
                            Util.tbl_expedientecasaAumento,
                            Util.tbl_expedientecasaMontoTotal,
                            Util.tbl_expedientecasaMontoLetra,
                            Util.tbl_expedientecasaEstado,
                            Util.tbl_arrendatarioNombre,
                            Util.tbl_casaestudianteNombre,
                            Util.tbl_arrendadorNombre,
                            Util.tbl_arrendadorApellidoPat,
                            Util.tbl_arrendadorApellidoMat};
        Util tabla = Util.tbl_expedientecasa;
        sql = Utilerias.prepareSelect(tabla, columnas);
        sql.append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatario)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatario)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendatarioId))
                .append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudiante)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudiante)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_casaestudianteClave))
                .append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(" ")
                .append(Utilerias.getPropiedad(Util.ON)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)).append(Utilerias.getPropiedad(Util.ESPACIO))
                .append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO))
                .append(Utilerias.getPropiedad(Util.tbl_arrendadorId));
        Util[] columnasCondicion = {Util.tbl_expedientecasaEstado,
                                    Util.tbl_expedientecasa_tbl_casaestudianteClave};
        sql = Utilerias.concatenarWhere(sql, columnasCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, 1);
            ps.setString(2, claveCasa);
            rs = ps.executeQuery();
            while(rs.next()){
                expediente = new Tbl_ExpedienteCasaDTO();
                casa = new Tbl_CasaEstudianteDTO();
                arrendador = new Tbl_ArrendadorDTO();
                arrendatario = new Tbl_ArrendatarioDTO();
                expediente.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaId)));
                expediente.setFechaFinalArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaFinalArrendamiento)));
                expediente.setFechaInicialArrendamiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaInicialArrendamiento)));
                expediente.setFechaInicio(rs.getDate(Utilerias.getPropiedad(Util.tbl_expedientecasaFechaRegistro)));
                expediente.setMontoRenta(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoRenta)));
                expediente.setTipoRenta(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaTipoRenta)));
                expediente.setTbl_arrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendadorId)));
                expediente.setTbl_arrendatarioIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_arrendatarioId)));
                expediente.setTbl_casaestudianteClaveDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_casaestudianteClave)));
                expediente.setTbl_representanteMatriculaDTO(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasa_tbl_representanteMatricula)));
                expediente.setAumento(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaAumento)));
                expediente.setMontoTotal(rs.getDouble(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoTotal)));
                expediente.setMontoLetra(rs.getString(Utilerias.getPropiedad(Util.tbl_expedientecasaMontoLetra)));
                expediente.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_expedientecasaEstado)));
                casa.setClave(expediente.getTbl_casaestudianteClaveDTO());
                casa.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_casaestudianteNombre)));
                arrendatario.setId(expediente.getTbl_arrendatarioIdDTO());
                arrendatario.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendatarioNombre)));
                arrendador.setId(expediente.getId());
                arrendador.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                arrendador.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoPat)));
                arrendador.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoMat)));
                expediente.setTbl_casaestudianteDTO(casa);
                expediente.setTbl_arrendatarioDTO(arrendatario);
                expediente.setTbl_arrendadorDTO(arrendador);
                expedientes.add(expediente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            expedientes = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ExpedienteCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return expedientes;
    }

}
