/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Cat_TipoBecaDAO;
import edu.uagro.dto.Cat_TipoBecaDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Cat_TipoBecaBO {

    public int agregar(Cat_TipoBecaDTO tipoBeca) {
         Cat_TipoBecaDAO dao = new Cat_TipoBecaDAO();
        return dao.insertar(tipoBeca);
    }

    public ArrayList<Cat_TipoBecaDTO> obtenerDatos() {
        Cat_TipoBecaDAO dao = new Cat_TipoBecaDAO();
        return dao.obtenerDatos();
    }

    public boolean eliminar(Cat_TipoBecaDTO tipoBeca) {
        Cat_TipoBecaDAO dao = new Cat_TipoBecaDAO();
        return dao.eliminar(tipoBeca);
    }

    public boolean editar(Cat_TipoBecaDTO dto) {
        Cat_TipoBecaDAO dao = new Cat_TipoBecaDAO();
        return dao.modificar(dto);
    }
    
}
