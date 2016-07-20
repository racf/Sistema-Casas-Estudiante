/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Tbl_ArchivosDAO;
import edu.uagro.dto.Tbl_ArchivosDTO;
import java.util.Collection;

/**
 *
 * @author Antonio18244
 */
public class Tbl_ArchivosBO {
    
    public int insertar(Tbl_ArchivosDTO archivo) {
        return new Tbl_ArchivosDAO().insertar(archivo);
    }

    public Collection obtenerArchivos(int expedienteId) {
        return new Tbl_ArchivosDAO().obtenerArchivos(expedienteId);
    }
    
}
