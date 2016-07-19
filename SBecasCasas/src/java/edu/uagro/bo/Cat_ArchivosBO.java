package edu.uagro.bo;

import edu.uagro.dao.Cat_ArchivosDAO;
import edu.uagro.dto.Cat_ArchivosDTO;
import java.util.ArrayList;

/**
 *
 * @author magic
 */
public class Cat_ArchivosBO {

    public ArrayList<Cat_ArchivosDTO> obtenerCatArchivos() {
        return new Cat_ArchivosDAO().obtenerCatArchivos();
    }
    
}
