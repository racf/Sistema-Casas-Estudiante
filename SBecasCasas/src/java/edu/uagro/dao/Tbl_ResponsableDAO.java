package edu.uagro.dao;

import edu.uagro.dto.Cat_ZonasDTO;
import edu.uagro.dto.Tbl_ResponsableDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.BDConexionOra;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_ResponsableDAO {

    
    public void insertar(Tbl_ResponsableDTO responsable) {
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_responsableId,
                            Util.tbl_responsableNombre,
                            Util.tbl_responsableApellidoPat,
                            Util.tbl_responsableApellidoMat,                            
                            Util.tbl_responsableEmail,                            
                            Util.tbl_responsable_cat_zonasId};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, responsable.getId());
            ps.setString(2, responsable.getNombre());
            ps.setString(3, responsable.getApellidoPat());
            ps.setString(4, responsable.getApellidoMat());            
            ps.setString(5, responsable.getEmail());            
            ps.setInt(6, responsable.getCat_zonasIdDTO());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                    con.close();
                }                
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean validarResponsableExiste(int claveResponsable){
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        ResultSet rs;
        Util[] columnas = {Util.tbl_responsableId};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_responsableId;
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(claveResponsable);
        try {
            System.err.println(sql);
             ps = con.prepareStatement(sql.toString());
             rs = ps.executeQuery();
             if(rs.first()){
                 return true;
             }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }    
    
    
    public boolean eliminar(Tbl_ResponsableDTO responsable) {
        boolean band = false;
        if (responsable == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_responsableEstado;
        Util tabla = Util.tbl_responsable;
        Util columnaCondicion = Util.tbl_responsableId;
        sql = Utilerias.prepareUpdate(tabla, columna);
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(responsable.getId());
        try {
            ps = con.prepareStatement(sql.toString());
            responsable.setEstado(0);
            ps.setInt(1, responsable.getEstado());            
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Responsable failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }
    
    public boolean activar(Tbl_ResponsableDTO responsable) {
        boolean band = false;
        if (responsable == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_responsableEstado;
        Util tabla = Util.tbl_responsable;
        Util columnaCondicion = Util.tbl_responsableId;
        sql = Utilerias.prepareUpdate(tabla, columna);
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(responsable.getId());
        try {
            ps = con.prepareStatement(sql.toString());
            responsable.setEstado(1);
            ps.setInt(1, responsable.getEstado());            
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Responsable failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }    

    
    public boolean modificar(Tbl_ResponsableDTO responsable) {
        boolean band = false;
        if (responsable == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_responsableEmail,
                            Util.tbl_responsable_cat_zonasId};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_responsableId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        System.out.println("Consulta: "+sql);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, responsable.getEmail());
            ps.setInt(2, responsable.getCat_zonasIdDTO());
            ps.setInt(3, responsable.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Responsable failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_ResponsableDTO buscar(Tbl_ResponsableDTO responsable) {
        if (responsable == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_responsableId,
                            Util.tbl_responsableNombre,
                            Util.tbl_responsableApellidoPat,
                            Util.tbl_responsableApellidoMat,                            
                            Util.tbl_responsableEmail,                            
                            Util.tbl_responsable_cat_zonasId,
                            Util.tbl_responsableEstado};
        Util tabla = Util.tbl_responsable;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_responsableId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, responsable.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                responsable.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsableId)));
                responsable.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableNombre)));
                responsable.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)));
                responsable.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)));                
                responsable.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableEmail)));                
                responsable.setCat_zonasIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)));
                responsable.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsableEstado)));
            } else { 
                responsable = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            responsable = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return responsable;
    }
    
    public ArrayList<Tbl_ResponsableDTO> obtenerDatos() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_ResponsableDTO> lista = new ArrayList();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            // 1. define la cadena sql
            sql = new StringBuilder(400);
            // sql = select * from cat_nivelbeca
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append("=").append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEstado)).append("=").append(1);                   
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_ResponsableDTO responsableDTO = new Tbl_ResponsableDTO();
                Cat_ZonasDTO zonasDTO = new Cat_ZonasDTO();
                responsableDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsableId)));
                responsableDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableNombre)));
                responsableDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)));
                responsableDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)));
                responsableDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableEmail)));
                zonasDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_zonasId)));
                zonasDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_zonasNombre)));
                responsableDTO.setZonasDTO(zonasDTO);
                lista.add(responsableDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    public ArrayList<Tbl_ResponsableDTO> obtenerDatosBajaResponsable() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_ResponsableDTO> lista = new ArrayList();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append("=").append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEstado)).append("=").append(0);                   
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_ResponsableDTO responsableDTO = new Tbl_ResponsableDTO();
                Cat_ZonasDTO zonasDTO = new Cat_ZonasDTO();
                responsableDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsableId)));
                responsableDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableNombre)));
                responsableDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)));
                responsableDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)));
                responsableDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableEmail)));
                zonasDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_zonasId)));
                zonasDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_zonasNombre)));
                responsableDTO.setZonasDTO(zonasDTO);
                lista.add(responsableDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_BecarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }    
    
    public Tbl_ResponsableDTO buscarDetalleResponsableZona(Tbl_ResponsableDTO responsableDTO) {
        if(responsableDTO == null){
            return null;
        }
//        if (t instanceof Tbl_ResponsableDTO) {
//            responsableDTO = (Tbl_ResponsableDTO) t;
//        } else {
//            return null;
//        }
        Cat_ZonasDTO zonasDTO = new Cat_ZonasDTO();
        Connection con = BDConexion.getConexion();

        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasDescripcion)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_responsable)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_zonas)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_zonasId)).append("=").append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsable_cat_zonasId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_responsable)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_responsableId)).append("=").append(responsableDTO.getId());
//            System.err.println(sql);
            ps = con.prepareStatement(sql.toString());
//           ps.setInt(1, detalleBecarioDTO.getId());
            rs = ps.executeQuery();
//            System.err.println(rs);
            if (rs.first()) {
                responsableDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_responsableId)));
                responsableDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableNombre)));
                responsableDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoPat)));
                responsableDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableApellidoMat)));
                responsableDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_responsableEmail)));

                //DATOS DE LA ZONA 
                zonasDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_zonasNombre)));
                zonasDTO.setDescripcion(rs.getString(Utilerias.getPropiedad(Util.cat_zonasDescripcion)));
                responsableDTO.setZonasDTO(zonasDTO);
            } else {
//                System.err.println("No entro");
                responsableDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return responsableDTO;
    }       
    
    public Tbl_ResponsableDTO buscarExterno(Tbl_ResponsableDTO responsable) {
        if (responsable == null){
            return null;
        }
        Connection con = BDConexionOra.getConexion();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append("SELECT  ventemp.CVEENTEMP, ventemp.NOMENTEMP, ventemp.APEPATEMP, ventemp.APEMATEMP, ventemp.SEXENTEMP ")
                    .append("FROM ventemp ")
                    .append("WHERE ventemp.CVEENTEMP=").append(responsable.getId());
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if(rs.next()){
                responsable.setId(rs.getInt("CVEENTEMP"));
                responsable.setNombre(rs.getString("NOMENTEMP"));
                responsable.setApellidoPat(rs.getString("APEPATEMP"));
                responsable.setApellidoMat(rs.getString("APEMATEMP"));                
            } else { 
                responsable = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            responsable = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return responsable;
    } 
    
    public boolean validarExisteExterno(int responsableId) {
        Connection con = BDConexionOra.getConexion();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append("SELECT  ventemp.CVEENTEMP ")
                    .append("FROM ventemp ")
                    .append("WHERE ventemp.CVEENTEMP=").append(responsableId);
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();            
            while(rs.next()){
                return true; 
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return  false;
    }
    

//    public static void main(String [] arg){
//        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
////        System.out.println(responsableDAO.validarResponsableExiste(35100));
//        Tbl_ResponsableDTO responsableDTO = new Tbl_ResponsableDTO();
//        responsableDTO.setId(3648);
//         responsableDAO.buscarExterno(responsableDTO);
//             Tbl_ResponsableDTO responsableDTO = new Tbl_ResponsableDTO();
//             Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
//             
//             responsableDTO.setId(1);
////             System.out.println(responsableDAO.validarExisteExterno(responsableDTO));
//             responsableDAO.buscarDetalleResponsableZona(responsableDTO);
//             System.out.println("Nuemro: "+responsableDTO.getId());
////             
//             System.out.println("Nombre: "+responsableDTO.getNombre()+" "+responsableDTO.getApellidoPat()+" "+responsableDTO.getApellidoMat());
//             System.out.println("Zona: "+responsableDTO.getZonasDTO().getNombre());
//    }    
}
