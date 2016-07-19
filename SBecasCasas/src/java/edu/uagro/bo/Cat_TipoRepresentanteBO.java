/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Cat_TipoRepresentanteDAO;
import edu.uagro.dto.Cat_TipoRepresentanteDTO;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class Cat_TipoRepresentanteBO {
    public ArrayList<Cat_TipoRepresentanteDTO> obtenerDatos() {
        Cat_TipoRepresentanteDAO tipoRepresentanteDAO = new Cat_TipoRepresentanteDAO();
        return tipoRepresentanteDAO.obtenerDatos();
    }
}
