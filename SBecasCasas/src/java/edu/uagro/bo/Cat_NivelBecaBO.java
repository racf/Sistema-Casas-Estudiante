/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Cat_NivelBecaDAO;
import edu.uagro.dto.Cat_NivelBecaDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Cat_NivelBecaBO {

    public int agregar(Cat_NivelBecaDTO nivelBeca) {
        Cat_NivelBecaDAO dao = new Cat_NivelBecaDAO();
        return dao.insertar(nivelBeca);
    }

    public ArrayList<Cat_NivelBecaDTO> obtenerDatos() {
        Cat_NivelBecaDAO dao = new Cat_NivelBecaDAO();
        return dao.obtenerDatos();
    }

    public boolean eliminar(Cat_NivelBecaDTO dto) {
        Cat_NivelBecaDAO dao = new Cat_NivelBecaDAO();
        return dao.eliminar(dto);
    }

    public boolean editar(Cat_NivelBecaDTO dto) {
        Cat_NivelBecaDAO dao = new Cat_NivelBecaDAO();
        return dao.modificar(dto);
    }

}
