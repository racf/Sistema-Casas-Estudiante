/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.dao;

import edu.uagro.dto.Cat_NivelBecaDTO;
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
public class Cat_NivelBecaDAO {

    public int insertar(Cat_NivelBecaDTO cat_nivelbeca) {
        if (cat_nivelbeca == null) {
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_nivelbecaNombre};
        Util tabla = Util.cat_nivelbeca;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat_nivelbeca.getNombre());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Cat_NivelBeca failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                cat_nivelbeca.setId(indice);
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

    public boolean eliminar(Cat_NivelBecaDTO cat_nivelbeca) {

        if (cat_nivelbeca == null) {
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Delete From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util columna = Util.cat_nivelbecaId;
        Util tabla = Util.cat_nivelbeca;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_nivelbeca.getId());
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

    public boolean modificar(Cat_NivelBecaDTO cat_nivelbeca) {

        if (cat_nivelbeca == null) {
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        //sql.append("Update CostoPromedioAlumno set idProyecto = ?, cicloini = ?, ciclofin = ?, costo = ? Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_nivelbecaNombre};
        Util tabla = Util.cat_nivelbeca;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.cat_nivelbecaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, cat_nivelbeca.getNombre());
            ps.setInt(2, cat_nivelbeca.getId());

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

    public Object buscar(Cat_NivelBecaDTO cat_nivelbeca) {

        if (cat_nivelbeca == null) {
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_nivelbecaNombre};
        Util tabla = Util.cat_nivelbeca;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_nivelbecaId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_nivelbeca.getId());
            rs = ps.executeQuery();
            if (rs.first()) {
                cat_nivelbeca.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)));

            } else {
                cat_nivelbeca = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            cat_nivelbeca = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_NivelBecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_nivelbeca;
    }

    public ArrayList<Cat_NivelBecaDTO> obtenerDatos() {
        Connection con = BDConexion.getConexion();
        ArrayList<Cat_NivelBecaDTO> lista = new ArrayList();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            // 1. define la cadena sql
            sql = new StringBuilder(400);
            // sql = select * from cat_nivelbeca
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.ASTERISCO)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.cat_nivelbeca));
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Cat_NivelBecaDTO dto = new Cat_NivelBecaDTO();
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_nivelbecaId)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_nivelbecaNombre)));
                lista.add(dto);
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
        return lista;
    }

}
