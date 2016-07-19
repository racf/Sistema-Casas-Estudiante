package edu.uagro.dao;

import edu.uagro.dto.Cat_TipoArrendadorDTO;
import edu.uagro.dto.Tbl_ArrendadorDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.BDConexionOra;
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

public class Tbl_ArrendadorDAO {
    
    public int insertar (Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return -1;
        }
        int indice = -1;
        Connection con = BDConexion.getConexion();
        ResultSet rs;
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendadorNombre,
                           Util.tbl_arrendadorNumProveedor,
                           Util.tbl_arrendadorRFC,
                           Util.tbl_arrendadorApellidoPat,
                           Util.tbl_arrendadorApellidoMat,
                           Util.tbl_arrendadorDomicilio,
                           Util.tbl_arrendadorCurp,
                           Util.tbl_arrendadorTelefono,
                           Util.tbl_arrendadorEmail,
                           Util.tbl_arrendador_cat_tipoarrendadorId};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, arrendadorDTO.getNombre());
            ps.setString(2, arrendadorDTO.getNumProveedor());
            ps.setString(3, arrendadorDTO.getRFC());
            ps.setString(4, arrendadorDTO.getApellidoPat());
            ps.setString(5, arrendadorDTO.getApellidoMat());
            ps.setString(6, arrendadorDTO.getDomicilio());
            ps.setString(7, arrendadorDTO.getCurp());
            ps.setString(8, arrendadorDTO.getTelefono());
            ps.setString(9, arrendadorDTO.getEmail());
            ps.setInt(10, arrendadorDTO.getCat_tipoarrendadorIdDTO());
            int filMod = ps.executeUpdate();
            if(filMod == 0){
                throw new SQLException("Creating Tbl_Arrendador failed, no rows affected.");
            }
            rs = ps.getGeneratedKeys();
            if(rs.first()){
                indice = rs.getInt(1);
                arrendadorDTO.setId(indice);
            }else{
                throw new SQLException("Creating Tbl_Arrendador failed, no ID obtained.");
            }
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return indice;
    }
        
    public boolean eliminar(Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna = Util.tbl_arrendadorId;
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareDelete(tabla);
        sql = Utilerias.concatenarWhere(sql, columna);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, arrendadorDTO.getId());
            int filaMod = ps.executeUpdate();
            if(filaMod == 0){
                throw new SQLException("Eliminating Tbl_Arrendador failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return band;
    }
    
    public boolean modificar(Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return false;
        }
        boolean band = false;       
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = {Util.tbl_arrendadorNombre,
                           Util.tbl_arrendadorNumProveedor,
                           Util.tbl_arrendadorRFC,
                           Util.tbl_arrendadorApellidoPat,
                           Util.tbl_arrendadorApellidoMat,
                           Util.tbl_arrendadorDomicilio,
                           Util.tbl_arrendadorCurp,
                           Util.tbl_arrendadorTelefono,
                           Util.tbl_arrendadorEmail,
                           Util.tbl_arrendador_cat_tipoarrendadorId};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_arrendadorId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, arrendadorDTO.getNombre());
            ps.setString(2, arrendadorDTO.getNumProveedor());
            ps.setString(3, arrendadorDTO.getRFC());
            ps.setString(4, arrendadorDTO.getApellidoPat());
            ps.setString(5, arrendadorDTO.getApellidoMat());
            ps.setString(6, arrendadorDTO.getDomicilio());
            ps.setString(7, arrendadorDTO.getCurp());
            ps.setString(8, arrendadorDTO.getTelefono());
            ps.setString(9, arrendadorDTO.getEmail());
            ps.setInt(10, arrendadorDTO.getCat_tipoarrendadorIdDTO());
            ps.setInt(11, arrendadorDTO.getId());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Tbl_Arrendador failed, no rows affected.");
            }
            band = true;
        } catch (SQLException e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);            
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        return band;
    }
    
    public Object buscar(Object t){
        Tbl_ArrendadorDTO arrendadorDTO;
        if(t instanceof Tbl_ArrendadorDTO){
            arrendadorDTO = (Tbl_ArrendadorDTO)t;            
        }else{
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
         Util[] columnas = {Util.tbl_arrendadorNombre,
                            Util.tbl_arrendadorNumProveedor,
                            Util.tbl_arrendadorRFC,
                            Util.tbl_arrendadorApellidoPat,
                            Util.tbl_arrendadorApellidoMat,
                            Util.tbl_arrendadorDomicilio,
                            Util.tbl_arrendadorCurp,
                            Util.tbl_arrendadorTelefono,
                            Util.tbl_arrendadorEmail,
                            Util.tbl_arrendador_cat_tipoarrendadorId};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_arrendadorId;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, arrendadorDTO.getId());
            rs = ps.executeQuery();
            if(rs.first()){
                arrendadorDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                arrendadorDTO.setNumProveedor(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)));
                arrendadorDTO.setRFC(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)));
                arrendadorDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoPat)));
                arrendadorDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoMat)));
                arrendadorDTO.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)));
                arrendadorDTO.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)));
                arrendadorDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)));
                arrendadorDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)));
                arrendadorDTO.setCat_tipoarrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)));
            }else{
                arrendadorDTO = null;
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
        return arrendadorDTO;
    }

    public ArrayList<Tbl_ArrendadorDTO> obtenerArrendadores() {
        ArrayList<Tbl_ArrendadorDTO> lista = new ArrayList();
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = {Util.ASTERISCO};
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareSelect(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                Tbl_ArrendadorDTO dto = new Tbl_ArrendadorDTO();
                dto.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoMat)));
                dto.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorApellidoPat)));
                dto.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)));
                dto.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)));
                dto.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)));
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendadorId)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                dto.setNumProveedor(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)));
                dto.setRFC(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)));
                dto.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)));
                dto.setCat_tipoarrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)));
                lista.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
    public Tbl_ArrendadorDTO buscarArrendadorExterno(Tbl_ArrendadorDTO dto) {
        if (dto == null) {
            return null;
        }
        Connection con = BDConexionOra.getConexion();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append("SELECT  ventpro.clave, ventpro.nombre, ventpro.rfc ")
                    .append("FROM ventpro")
                    .append(" WHERE ventpro.clave=").append("?");
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, dto.getNumProveedor());
            rs = ps.executeQuery();
            if (rs.next()) {
                dto.setNumProveedor(rs.getString("clave"));
                dto.setNombre(rs.getString("nombre"));
                System.out.println("dto.getNombre() = " + dto.getNombre());
                dto.setRFC(rs.getString("rfc"));
            } else {
                System.out.println("no encontro");
                dto = null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dto;
    }
    
    public boolean validarExterno(int numProvedor) {
        Connection con = BDConexionOra.getConexion();

        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append("SELECT  ventpro.clave ")
                    .append("FROM ventpro ")
                    .append("WHERE ventpro.clave=").append("?");
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, numProvedor);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    public boolean validarInterno(int numProvedor) {
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util columna = Util.tbl_arrendadorNumProveedor;
        Util tabla = Util.tbl_arrendador;
        sql = Utilerias.prepareSelect(tabla, columna);
        Util columnaCondicion = Util.tbl_arrendadorNumProveedor;
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append("?");
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, numProvedor);
            rs = ps.executeQuery();
            if (rs.first()) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }

        }
        return false;
    }

    
    public ArrayList<Tbl_ArrendadorDTO> obtenerDAtosParametros(Tbl_ArrendadorDTO dto) {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_ArrendadorDTO> lista = new ArrayList();
        //Tbl_ArrendadorDTO dto = new Tbl_ArrendadorDTO();
        Cat_TipoArrendadorDTO tipoArrendadordto = new Cat_TipoArrendadorDTO();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            // sql = select * from tbl_Arrendador
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipoarrendadorId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipoarrendadorNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipoarrendadorId)).append("=").append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)).append(" = ").append('?');
                    
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, dto.getNumProveedor());
            rs = ps.executeQuery();
            while (rs.next()) {

                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendadorId)));
                dto.setCat_tipoarrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)));
                dto.setNumProveedor(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)));
                dto.setRFC(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                dto.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)));
                dto.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)));
                dto.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)));
                dto.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)));
                tipoArrendadordto.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tipoarrendadorId)));
                tipoArrendadordto.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tipoarrendadorNombre)));
                dto.setTipoArrendadordto(tipoArrendadordto);
                lista.add(dto);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public ArrayList<Tbl_ArrendadorDTO> obtenerDAtos() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_ArrendadorDTO> lista = new ArrayList();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            // sql = select * from tbl_Arrendador
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipoarrendadorId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipoarrendadorNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO)).append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tipoarrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tipoarrendadorId)).append("=").append(Utilerias.getPropiedad(Util.tbl_arrendador)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)).append(" ");

            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_ArrendadorDTO dto = new Tbl_ArrendadorDTO();
                Cat_TipoArrendadorDTO tipoArrendadordto = new Cat_TipoArrendadorDTO();
                dto.setId(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendadorId)));
                dto.setCat_tipoarrendadorIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_arrendador_cat_tipoarrendadorId)));
                dto.setNumProveedor(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNumProveedor)));
                dto.setRFC(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorRFC)));
                dto.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorNombre)));
                dto.setDomicilio(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorDomicilio)));
                dto.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorCurp)));
                dto.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorTelefono)));
                dto.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_arrendadorEmail)));
                tipoArrendadordto.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tipoarrendadorId)));
                tipoArrendadordto.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tipoarrendadorNombre)));
                dto.setTipoArrendadordto(tipoArrendadordto);
                lista.add(dto);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_ArrendadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
