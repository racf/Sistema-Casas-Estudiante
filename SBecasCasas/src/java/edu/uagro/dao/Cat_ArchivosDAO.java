package edu.uagro.dao;

import edu.uagro.dto.Cat_ArchivosDTO;
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
public class Cat_ArchivosDAO {
    
        public int insertar(Cat_ArchivosDTO cat_archivos) {
        if (cat_archivos ==null){
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_archivosNombre };
        Util tabla = Util.cat_archivos;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cat_archivos.getNombre());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Creating Cat_Archivos failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if (rs.first()) {
                indice = rs.getInt(1);
                cat_archivos.setId(indice);
            } else {
                throw new SQLException("Creating Cat_Archivos failed, no ID obtained.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return indice;
    }
    

    public boolean eliminar(Cat_ArchivosDTO cat_archivos) {
       
        if (cat_archivos == null){
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.cat_archivosId;
        Util tabla = Util.cat_archivos;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_archivos.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Cat_Archivos failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public boolean modificar(Cat_ArchivosDTO cat_archivos) {
        if (cat_archivos == null){    
            return false;
        }
        boolean band = false;
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.cat_archivosNombre,
                           Util.cat_archivosEstado};
        Util tabla = Util.cat_archivos;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.cat_archivosId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, cat_archivos.getNombre());
            ps.setInt(2, cat_archivos.getEstado());
            ps.setInt(3, cat_archivos.getId());

            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Cat_Archivos failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }


    public Object buscar(Cat_ArchivosDTO cat_archivos) {

        if (cat_archivos == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_archivosNombre,
                           Util.cat_archivosEstado};
        Util tabla = Util.cat_archivos;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_archivosId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, cat_archivos.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                cat_archivos.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_archivosNombre)));
                cat_archivos.setEstado(rs.getInt(Utilerias.getPropiedad(Util.cat_archivosEstado)));
            } else { 
                cat_archivos = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
               cat_archivos = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_archivos;
    }

    public ArrayList<Cat_ArchivosDTO> obtenerCatArchivos() {
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        ArrayList<Cat_ArchivosDTO> cat_archivos = new ArrayList<>();
        Cat_ArchivosDTO cat_archivo;
        //sql.append("Select idProyecto, cicloini, ciclofin, costo From CostoPromedioAlumno Where idCostoPromedioAlumno = ?");
        Util[] columnas = {Util.cat_archivosId,
                           Util.cat_archivosNombre,
                           Util.cat_archivosEstado};
        Util tabla = Util.cat_archivos;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.cat_archivosEstado;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while(rs.first()){
                cat_archivo = new Cat_ArchivosDTO();
                cat_archivo.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_archivosId)));
                cat_archivo.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_archivosNombre)));
                cat_archivo.setEstado(rs.getInt(Utilerias.getPropiedad(Util.cat_archivosEstado)));
                cat_archivos.add(cat_archivo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
               cat_archivos = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cat_ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cat_archivos;
    }

    
}
