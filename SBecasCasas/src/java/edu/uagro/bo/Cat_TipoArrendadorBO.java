package edu.uagro.bo;

import edu.uagro.dao.Cat_TipoArrendadorDAO;
import edu.uagro.dto.Cat_TipoArrendadorDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Cat_TipoArrendadorBO {
    
    public ArrayList<Cat_TipoArrendadorDTO> obtenerDatos() {
        Cat_TipoArrendadorDAO dao = new Cat_TipoArrendadorDAO();
        return dao.obtenerDatos();
    }
    
}
