/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Cat_ZonasDAO;
import edu.uagro.dto.Cat_ZonasDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Cat_ZonasBO {

    public ArrayList<Cat_ZonasDTO> obtenerZonas() {
        Cat_ZonasDAO zonasDAO = new Cat_ZonasDAO();
        return zonasDAO.obtenerZonas();
    }
    
    public int agregar(Cat_ZonasDTO zona) {
        Cat_ZonasDAO dao = new Cat_ZonasDAO();
        return dao.insertar(zona);
    }

    public boolean eliminar(Cat_ZonasDTO zona) {
        Cat_ZonasDAO dao = new Cat_ZonasDAO();
        return dao.eliminar(zona);

    }

    public boolean editar(Cat_ZonasDTO zona) {
        Cat_ZonasDAO dao = new Cat_ZonasDAO();
        return dao.modificar(zona);
    }
}
