package edu.uagro.dao;

import edu.uagro.dto.Cat_TipoRepresentanteDTO;
import edu.uagro.dto.Tbl_RepresentanteDTO;
import edu.uagro.util.BDConexion;
import edu.uagro.util.BDConexionOra;
import edu.uagro.util.Util;
import edu.uagro.util.Utilerias;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magic
 */
public class Tbl_RepresentanteDAO {
    
    public void insertar(Tbl_RepresentanteDTO representante) {
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = { Util.tbl_representanteMatricula,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteApellidoMat,                            
                            Util.tbl_representanteSexo,
                            Util.tbl_representanteEstadoCivil,
                            Util.tbl_representanteFechaRegistro,
                            Util.tbl_representanteFechaNacimiento,
                            Util.tbl_representanteCurp,
                            Util.tbl_representanteEstadoNacimiento,
                            Util.tbl_representanteMunicipioNacimiento,
                            Util.tbl_representanteUAcademica,
                            Util.tbl_representanteSemestre,
                            Util.tbl_representanteGrado,
                            Util.tbl_representanteTurno,
                            Util.tbl_representantePromedio,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEmail,
                            Util.tbl_representanteClave,
                            Util.tbl_representante_cat_tiporepresentanteId
                           
    };
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareInsert(tabla, columnas);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            ps.setString(2, representante.getNombre());
            ps.setString(3, representante.getApellidoPat());
            ps.setString(4, representante.getApellidoMat());            
            ps.setString(5, representante.getSexo());
            ps.setString(6, representante.getEstadoCivil());
            Calendar c = Calendar.getInstance();
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH)+1);
            String annio = Integer.toString(c.get(Calendar.YEAR));
            String fecha = annio+"-"+mes+"-"+dia;
            representante.setFechaRegistro(fecha);
//            representante.setFechaRegistro();
            ps.setString(7, representante.getFechaRegistro());
            ps.setDate(8, new Date(representante.getFechaNacimiento().getTime()));
//            ps.setString(8, representante.getFechaNacimiento());
            ps.setString(9, representante.getCurp());
            ps.setString(10, representante.getEstadoNacimiento());
            ps.setString(11, representante.getMunicipioNacimiento());
            ps.setString(12, representante.getUAcademica());
            ps.setInt(13, representante.getSemestre());
            ps.setInt(14, representante.getGrado());
            ps.setString(15, representante.getTurno());
            ps.setDouble(16, representante.getPromedio());
            ps.setString(17, representante.getTelefono());
            ps.setString(18, representante.getEmail());
            ps.setString(19, representante.getClave());
            ps.setInt(20, representante.getCat_tiporepresentanteIdDTO());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean validarRepresentanteExiste(String matricula){
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        ResultSet rs;
        Util[] columnas = {Util.tbl_representanteMatricula};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append("?");
//        System.err.println(sql);
        try {
             ps = con.prepareStatement(sql.toString());
             ps.setString(1, matricula);
             rs = ps.executeQuery();
             if(rs.first()){
                 return true;
             }
        } catch (Exception e) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }    
    
    
    public boolean eliminar(Tbl_RepresentanteDTO representante) {
        boolean band = false;
        if (representante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna[] ={Util.tbl_representanteEstado};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareUpdate(tabla, columna);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(representante.getMatricula());     
        try {
            representante.setEstado(0);
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, representante.getEstado());
//            ps.setString(2, representante.getMatricula());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Representante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }
    
    public boolean activar(Tbl_RepresentanteDTO representante) {
        boolean band = false;
        if (representante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util columna[] ={Util.tbl_representanteEstado};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareUpdate(tabla, columna);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql.append(" ").append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(columnaCondicion).append(Utilerias.getPropiedad(Util.ESPACIO_IGUAL_ESPACIO)).append(representante.getMatricula());     
        try {
            representante.setEstado(1);
            ps = con.prepareStatement(sql.toString());
            ps.setInt(1, representante.getEstado());
//            ps.setString(2, representante.getMatricula());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Eliminating Representante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }    

    
    public boolean modificar(Tbl_RepresentanteDTO representante) {
        boolean band = false;
        if (representante == null) {
            return band;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        StringBuilder sql;
        Util[] columnas = { Util.tbl_representanteUAcademica,
                            Util.tbl_representanteSemestre,
                            Util.tbl_representanteGrado,
                            Util.tbl_representanteTurno,                           
                            Util.tbl_representantePromedio,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEmail,
                            Util.tbl_representante_cat_tiporepresentanteId};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareUpdate(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());            
            ps.setString(1, representante.getUAcademica());
            ps.setInt(2, representante.getSemestre());
            ps.setInt(3, representante.getGrado());
            ps.setString(4, representante.getTurno());
            ps.setDouble(5, representante.getPromedio());
            ps.setString(6, representante.getTelefono());
            ps.setString(7, representante.getEmail());
            ps.setInt(8, representante.getCat_tiporepresentanteIdDTO());
            ps.setString(9, representante.getMatricula());
            int filaMod = ps.executeUpdate();
            if (filaMod == 0) {
                throw new SQLException("Modifying Representante failed, no rows affected.");
            }
            band = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return band;
    }

    
    public Tbl_RepresentanteDTO buscar(Tbl_RepresentanteDTO representante) {
        if (representante == null){
            return null;
        }
        Connection con = BDConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        StringBuilder sql;
        Util[] columnas = { Util.tbl_representanteMatricula,
                            Util.tbl_representanteNombre,
                            Util.tbl_representanteApellidoMat,
                            Util.tbl_representanteApellidoPat,
                            Util.tbl_representanteSexo,
                            Util.tbl_representanteUAcademica,
                            Util.tbl_representanteGrado,
                            Util.tbl_representanteTurno,
                            Util.tbl_representantePromedio,
                            Util.tbl_representanteTelefono,
                            Util.tbl_representanteEmail,
                            Util.tbl_representante_cat_tiporepresentanteId};
        Util tabla = Util.tbl_representante;
        sql = Utilerias.prepareSelect(tabla, columnas);
        Util columnaCondicion = Util.tbl_representanteMatricula;
        sql = Utilerias.concatenarWhere(sql, columnaCondicion);
        try {
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representante.getMatricula());
            rs = ps.executeQuery();
            if(rs.first()){
                representante.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMatricula)));
                representante.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representante.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representante.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representante.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteSexo)));
                representante.setUAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)));
                representante.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteGrado)));
                representante.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTurno)));
                representante.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_representantePromedio)));
                representante.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                representante.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representante.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteEstado)));
                representante.setCat_tiporepresentanteIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)));
            } else { 
                representante = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            representante = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return representante;
    }
    
    public ArrayList<Tbl_RepresentanteDTO> obtenerDatos() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_RepresentanteDTO> lista = new ArrayList();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMatricula)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteSexo)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteGrado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTurno)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representantePromedio)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(", ")                    
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append("=").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstado)).append("=").append(1);                   
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_RepresentanteDTO representanteDTO = new Tbl_RepresentanteDTO();
                Cat_TipoRepresentanteDTO tipoRepresentanteDTO = new Cat_TipoRepresentanteDTO();
                representanteDTO.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMatricula)));
                representanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representanteDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representanteDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representanteDTO.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteSexo)));
                representanteDTO.setUAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)));
                representanteDTO.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteGrado)));
                representanteDTO.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTurno)));
                representanteDTO.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_representantePromedio)));
                representanteDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representanteDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                representanteDTO.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteEstado)));
                tipoRepresentanteDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)));
                tipoRepresentanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)));
                representanteDTO.setTipoRepresentanteDTO(tipoRepresentanteDTO);
                lista.add(representanteDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
    public Tbl_RepresentanteDTO obtenerDatos(Tbl_RepresentanteDTO representanteDTO) {
        Connection con = BDConexion.getConexion();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMatricula)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteSexo)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteGrado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTurno)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representantePromedio)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(", ")                    
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append("=").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMatricula)).append("=").append("?");                   
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representanteDTO.getMatricula());
            rs = ps.executeQuery();
            if(rs.first()) {
                Cat_TipoRepresentanteDTO tipoRepresentanteDTO = new Cat_TipoRepresentanteDTO();
                representanteDTO.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMatricula)));
                representanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representanteDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representanteDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representanteDTO.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteSexo)));
                representanteDTO.setUAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)));
                representanteDTO.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteGrado)));
                representanteDTO.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTurno)));
                representanteDTO.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_representantePromedio)));
                representanteDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representanteDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                representanteDTO.setEstado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteEstado)));
                tipoRepresentanteDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)));
                tipoRepresentanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)));
                representanteDTO.setTipoRepresentanteDTO(tipoRepresentanteDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return representanteDTO;
    }
    
    public Tbl_RepresentanteDTO verRepresentanteCasa(Tbl_RepresentanteDTO representanteDTO) {
        if (representanteDTO == null) {
            return null;
        }
        Cat_TipoRepresentanteDTO tipoRepresentanteDTO = new Cat_TipoRepresentanteDTO();
        Connection con = BDConexion.getConexion();

        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(500);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMatricula)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteSexo)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstadoCivil)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteFechaRegistro)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteFechaNacimiento)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteCurp)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstadoNacimiento)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMunicipioNacimiento)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteSemestre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteGrado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTurno)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representantePromedio)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteClave)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append("=").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMatricula)).append("=").append(representanteDTO.getMatricula());
            ps = con.prepareStatement(sql.toString());
            //ps.setString(1, representanteDTO.getMatricula());
            rs = ps.executeQuery();
            if (rs.first()) {
                representanteDTO.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMatricula)));
                representanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representanteDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representanteDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representanteDTO.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteSexo)));
                representanteDTO.setEstadoCivil(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEstadoCivil)));
                representanteDTO.setFechaRegistro(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteFechaRegistro)));
                representanteDTO.setFechaNacimiento(rs.getDate(Utilerias.getPropiedad(Util.tbl_representanteFechaNacimiento)));
                representanteDTO.setCurp(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteCurp)));
                representanteDTO.setEstadoNacimiento(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEstadoNacimiento)));
                representanteDTO.setMunicipioNacimiento(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMunicipioNacimiento)));
                representanteDTO.setUAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)));
                representanteDTO.setSemestre(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteSemestre)));
                representanteDTO.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteGrado)));
                representanteDTO.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTurno)));
                representanteDTO.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_representantePromedio)));
                representanteDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representanteDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                representanteDTO.setClave(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteClave)));
                representanteDTO.setCat_tiporepresentanteIdDTO(rs.getInt(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)));
                tipoRepresentanteDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)));
                tipoRepresentanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)));
                representanteDTO.setTipoRepresentanteDTO(tipoRepresentanteDTO);
            } else {
                representanteDTO = null;
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return representanteDTO;
    }
    
    public ArrayList<Tbl_RepresentanteDTO> obtenerDatosBaja() {
        Connection con = BDConexion.getConexion();
        ArrayList<Tbl_RepresentanteDTO> lista = new ArrayList();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append(Utilerias.getPropiedad(Util.SELECT)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteMatricula)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteNombre)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteSexo)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteGrado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTurno)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representantePromedio)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteTelefono)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEmail)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstado)).append(", ")
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(", ")                    
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append(", ")
                    .append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)).append(" ")
                    .append(Utilerias.getPropiedad(Util.FROM)).append(Utilerias.getPropiedad(Util.ESPACIO))
                    .append(Utilerias.getPropiedad(Util.tbl_representante)).append(" ")
                    .append(Utilerias.getPropiedad(Util.INNER_JOIN)).append(" ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(" ON ").append(Utilerias.getPropiedad(Util.cat_tiporepresentante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)).append("=").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representante_cat_tiporepresentanteId)).append(" ")
                    .append(Utilerias.getPropiedad(Util.WHERE)).append(" ").append(Utilerias.getPropiedad(Util.tbl_representante)).append(Utilerias.getPropiedad(Util.PUNTO)).append(Utilerias.getPropiedad(Util.tbl_representanteEstado)).append("=").append(0);                   
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_RepresentanteDTO representanteDTO = new Tbl_RepresentanteDTO();
                Cat_TipoRepresentanteDTO tipoRepresentanteDTO = new Cat_TipoRepresentanteDTO();
                representanteDTO.setMatricula(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteMatricula)));
                representanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteNombre)));
                representanteDTO.setApellidoPat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoPat)));
                representanteDTO.setApellidoMat(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteApellidoMat)));
                representanteDTO.setSexo(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteSexo)));
                representanteDTO.setUAcademica(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteUAcademica)));
                representanteDTO.setGrado(rs.getInt(Utilerias.getPropiedad(Util.tbl_representanteGrado)));
                representanteDTO.setTurno(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTurno)));
                representanteDTO.setPromedio(rs.getDouble(Utilerias.getPropiedad(Util.tbl_representantePromedio)));
                representanteDTO.setTelefono(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteTelefono)));
                representanteDTO.setEmail(rs.getString(Utilerias.getPropiedad(Util.tbl_representanteEmail)));
                tipoRepresentanteDTO.setId(rs.getInt(Utilerias.getPropiedad(Util.cat_tiporepresentanteId)));
                tipoRepresentanteDTO.setNombre(rs.getString(Utilerias.getPropiedad(Util.cat_tiporepresentanteNombre)));
                representanteDTO.setTipoRepresentanteDTO(tipoRepresentanteDTO);
                lista.add(representanteDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(con != null){
                     con.close();
                }               
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public Tbl_RepresentanteDTO buscarExterno(Tbl_RepresentanteDTO representanteDTO) {
        if (representanteDTO == null) {
            return null;
        }
        Connection con = BDConexionOra.getConexion();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(500);
            sql.append("SELECT  "
                    + "v1_alumnos4.MATRICULA_ALUMNO, v1_alumnos4.NOM_ALUMNO, "
                    + "v1_alumnos4.APE_PATERNO, v1_alumnos4.APE_MATERNO, "
                    + "v1_alumnos4.FECHA_NACIMIENTO, v1_alumnos4.NUM_SEMESTRE, "
                    + "v1_alumnos4.TURNO, v1_alumnos4.CURP_ALUMNO, v1_alumnos4.MAIL_ALUMNO, "
                    + "v1_alumnos4.NOMBRE_UNI_ACADEMICA, v1_alumnos4.EDO_CIVIL, "
                    + "v1_alumnos4.SEXO, v1_alumnos4.ANIO_ULTIMO_PERIODO, "
                    + "v1_alumnos4.ESTADO_NACIMIENTO, v1_alumnos4.MUNICIPIO_NACIMIENTO ")
                    .append("FROM v1_alumnos4 ")
                    .append("WHERE v1_alumnos4.MATRICULA_ALUMNO=")
                    .append("?").append(" AND ")
                    .append(" v1_alumnos4.ANIO_ULTIMO_PERIODO ")
                    .append("IN (SELECT MAX(ANIO_ULTIMO_PERIODO) FROM v1_alumnos4 WHERE MATRICULA_ALUMNO=")
                    .append("?").append(")");
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, representanteDTO.getMatricula());
            ps.setString(2, representanteDTO.getMatricula());
            rs = ps.executeQuery();
            if (rs.next()) {
                representanteDTO.setMatricula(rs.getString("MATRICULA_ALUMNO"));
                representanteDTO.setNombre(rs.getString("NOM_ALUMNO"));
                representanteDTO.setApellidoPat(rs.getString("APE_PATERNO"));
                representanteDTO.setApellidoMat(rs.getString("APE_MATERNO"));
                representanteDTO.setSexo(rs.getString("SEXO"));
                representanteDTO.setEstadoCivil(rs.getString("EDO_CIVIL"));
                representanteDTO.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                representanteDTO.setCurp(rs.getString("CURP_ALUMNO"));
                representanteDTO.setEstadoNacimiento(rs.getString("ESTADO_NACIMIENTO"));
                representanteDTO.setMunicipioNacimiento(rs.getString("MUNICIPIO_NACIMIENTO"));
                representanteDTO.setUAcademica(rs.getString("NOMBRE_UNI_ACADEMICA"));
                representanteDTO.setSemestre(rs.getInt("NUM_SEMESTRE"));
                float modulo=0;
                int divicion=0;
                modulo = (float)representanteDTO.getSemestre()%2;
                divicion = representanteDTO.getSemestre()/2;
                if(modulo>0){
                    representanteDTO.setGrado(divicion+1);
                }else{
                    representanteDTO.setGrado(divicion);
                }
                representanteDTO.setTurno(rs.getString("TURNO"));
                representanteDTO.setEmail(rs.getString("MAIL_ALUMNO"));
            } else {
                representanteDTO = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            representanteDTO = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return representanteDTO;
    } 

    public boolean validarExisteExterno(String matricula) {
        Connection con = BDConexionOra.getConexion();
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append("SELECT  v1_alumnos4.MATRICULA_ALUMNO ")
                    .append("FROM v1_alumnos4 ")
                    .append("WHERE v1_alumnos4.MATRICULA_ALUMNO=").append("?");
            ps = con.prepareStatement(sql.toString());
            ps.setString(1, matricula);
            rs = ps.executeQuery();            
            while(rs.next()){
                return true; 
            }
        } catch (Exception e) {
            Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tbl_RepresentanteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return  false;
    }    
    
//    public static void main(String [] arg){
//        Tbl_RepresentanteDAO dao = new Tbl_RepresentanteDAO();
//        Tbl_RepresentanteDTO dto = new Tbl_RepresentanteDTO();        
//        dto.setMatricula("154651661");
//        System.out.println(dao.validarExisteExterno(dto.getMatricula()));
////        dto.setMatricula("08318087' OR 1=1--");
//        dto.setMatricula("08318087");
//        dao.buscarExterno(dto);
//        System.out.println("Matricula: "+dto.getMatricula());
//        System.out.println("Nombre: "+dto.getNombre()+" Paterno: "+dto.getApellidoPat()+" Materno: "+dto.getApellidoMat());
//        System.out.println("Sexo: "+dto.getSexo());
//        System.out.println("Edo. Civil: "+dto.getEstadoCivil());
//        System.out.println("Fecha Nacimiento: "+dto.getFechaNacimiento());
//        System.out.println("Curp: "+dto.getCurp());
//        System.out.println("Edo. Nacimiento: "+dto.getEstadoNacimiento());
//        System.out.println("Municipio: "+dto.getMunicipioNacimiento());
//        System.out.println("Unidad Academica: "+dto.getUAcademica());
//        System.out.println("Semestre: "+dto.getSemestre());
//        System.out.println("Grado: "+dto.getGrado());
//        System.out.println("Turno: "+dto.getTurno());
//        System.out.println("Email: "+dto.getEmail());
//    }

    
        

}
