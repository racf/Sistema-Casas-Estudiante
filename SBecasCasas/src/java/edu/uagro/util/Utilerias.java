package edu.uagro.util;

import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Utilerias {

    public static final int MIN_QUERY_BUFFER = 600;
    public static final ResourceBundle rb = ResourceBundle.getBundle(Util.RUTA_PROPERTIES.getPropiedad());
   
    /**
     * 
     * @param util - Objeto Util del cual se quiere la proiedad
     * @return - ResourceBundle rb.getString(util.getPropiedad());
     */
    public static String getPropiedad(Util util){
        return rb.getString(util.getPropiedad());
    }
    
    /**
     * 
     * @param tabla - nombre de la tabla
     * @param columnas - nombre/s de la/s columna/s
     * @return - un objeto StringBuilder que contiene Select {columnas} from {tabla}
     */
    public static StringBuilder prepareSelect(Util tabla, Util... columnas){
        StringBuilder sql = new StringBuilder(MIN_QUERY_BUFFER);
        sql.append(rb.getString(Util.SELECT.getPropiedad())).append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(parseColumnas(", ", columnas)).append(" "/*rb.getString(Util.ESPACIO.getPropiedad()) no concatena el espacio*/);
        sql.append(rb.getString(Util.FROM.getPropiedad())).append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(rb.getString(tabla.getPropiedad()));
        return sql;
    }

    /**
     * 
     * @param tabla - nombre de la tabla
     * @param columnas - nombre de las columnas
     * @return - un objeto StringBuilder que contiene Insert Into {tabla}({columnas}) values({?})
     */
    public static StringBuilder prepareInsert(Util tabla, Util... columnas){
        StringBuilder sql = new StringBuilder(MIN_QUERY_BUFFER);
        sql.append(rb.getString(Util.INSERT_INTO.getPropiedad())).append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(rb.getString(tabla.getPropiedad())).append(rb.getString(Util.OPEN_PARANTESIS.getPropiedad()));
        sql.append(parseColumnas(", ", columnas)).append(rb.getString(Util.CLOSE_PARANTESIS.getPropiedad())).append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(rb.getString(Util.VALUES.getPropiedad())).append(rb.getString(Util.OPEN_PARANTESIS.getPropiedad()));
        Util[] campos = new Util[columnas.length];
        for (int i = 0; i < campos.length; i++) {
            campos[i] = Util.QUESTION_MARK;
        }
        sql.append(parseColumnas(", ", campos)).append(rb.getString(Util.CLOSE_PARANTESIS.getPropiedad()));
        return sql;
    }
    
    /**
     * 
     * @param tabla - nombre de la tabla
     * @return - un objeto StringBuilder que contiene Delete From {tabla}
     */
    public static StringBuilder prepareDelete(Util tabla){
        StringBuilder sql = new StringBuilder(MIN_QUERY_BUFFER);
        sql.append(rb.getString(Util.DELETE_FROM.getPropiedad())).append(" ");
        sql.append(rb.getString(tabla.getPropiedad()));
        return sql;
    }
    
    /**
     * 
     * @param tabla - nombre de la tabla
     * @param columnas - nombre de las columnas
     * @return - un objeto StringBuilder que contiene Update {tabla} set {columnas = ?}
     */
    public static StringBuilder prepareUpdate(Util tabla, Util... columnas){
        StringBuilder sql = new StringBuilder(MIN_QUERY_BUFFER);
        sql.append(rb.getString(Util.UPDATE.getPropiedad())).append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(rb.getString(tabla.getPropiedad())).append(" "/*rb.getString(Util.ESPACIO.getPropiedad())*/);
        sql.append(rb.getString(Util.SET.getPropiedad())).append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(parseColumnas(", ", " = ?", columnas));
        return sql;
    }
    
    /**
     * 
     * @param sql - StringBuilder al que se le va concatener la sentencia
     * @param columnas - nombre de columnas
     * @return - un objeto StringBuilder que contiene {sql} where {columnas = ?} las columnas estan separados por and
     */
    public static StringBuilder concatenarWhere(StringBuilder sql, Util... columnas){
        //sql.append(rb.getString(Util.ESPACIO.getPropiedad()))  por alguna razon no concatena solo el primer espacio
        sql.append(" ")
                .append(rb.getString(Util.WHERE.getPropiedad()))
                .append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(parseColumnas(" and ", " = ?", columnas));
        return sql;
    }
    
    public static StringBuilder concaternarOrderBy(StringBuilder sql, Util... columnas) {
        sql.append(" ")
                .append(rb.getString(Util.ORDER_BY.getPropiedad()))
                .append(rb.getString(Util.ESPACIO.getPropiedad()));
        sql.append(parseColumnas(", ", columnas));
        return sql;
    }
    
    public static String parseColumnas(String separador, String concat, Util... columnas){
        String salida = "";
        String coma = "";
        if (columnas.length > 1){
            coma = separador;
        }
        for (Util columna : columnas) {
            salida += rb.getString(columna.getPropiedad()) + concat + coma;
        }
        if (columnas.length > 1){
            salida = salida.substring(0, salida.length() - separador.length());
        }
        return salida;
    }
    
    private static String parseColumnas(String separador, Util... columnas){
        String salida = "";
        String coma = "";
        if (columnas.length > 1){
            coma = separador;
        }
        for (Util columna : columnas) {
            salida += rb.getString(columna.getPropiedad()) + coma;
        }
        if (columnas.length > 1){
            salida = salida.substring(0, salida.length() - separador.length());
        }
        return salida;
    }    

}
