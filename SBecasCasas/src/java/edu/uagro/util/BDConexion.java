package edu.uagro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author magic
 * @version 1.0
 * @created 27-Oct-2015 10:00:58 a.m.
 */
public class BDConexion {

    public static final int MIN_QUERY_BUFFER = 600;

    public static Connection getConexion() {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/becascasas", "becas", "casas");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdproyectos", "usrproyectos", "usrproy*/&");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            conn = null;
        }
        return conn;
    }

//    public static void main(String args[]) {
//        try {
//            Connection con = getConexion();
//            System.out.println("Conexion: " + con);
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BDConexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}//end BDConexion
