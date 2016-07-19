/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class BDConexionOra {
    public static final int MIN_QUERY_BUFFER = 600;

    public static Connection getConexion() {
        Connection conn;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.10.30.250:1521:DBSIIA", "ADMCONWEB", "conweb2016");            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            conn = null;
        }
        return conn;        	        
    }  
    
    public static void main(String[] args) {
        Connection con = BDConexionOra.getConexion();
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            StringBuilder sql;
            sql = new StringBuilder(400);
            sql.append("SELECT vlstbecarios_conweb.CVE_BECA, vlstbecarios_conweb.TIPO_BECA_FIN ")
                    .append("FROM vlstbecarios_conweb ");
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("cve_beca: "+rs.getString(1)+"\t\ttipo_beca: "+rs.getString(2));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDConexionOra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
