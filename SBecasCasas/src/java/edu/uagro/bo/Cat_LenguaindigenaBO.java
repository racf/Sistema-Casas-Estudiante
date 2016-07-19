/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.bo;

import edu.uagro.dao.Cat_LenguaindigenaDAO;
import edu.uagro.dto.Cat_LenguaindigenaDTO;
import java.util.ArrayList;

/**
 *
 * @author Antonio18244
 */
public class Cat_LenguaindigenaBO {
         public ArrayList<Cat_LenguaindigenaDTO> obtenerDatos(){
         Cat_LenguaindigenaDAO dao  = new Cat_LenguaindigenaDAO();
         return dao.obtenrlengua();
     }

    public int agregar(Cat_LenguaindigenaDTO lengua) {
        Cat_LenguaindigenaDAO dao = new Cat_LenguaindigenaDAO();
        return dao.insertar(lengua);
    }

    public boolean eliminar(Cat_LenguaindigenaDTO lengua) {
        Cat_LenguaindigenaDAO dao = new Cat_LenguaindigenaDAO();
        return dao.eliminar(lengua);
        
    }

    public boolean editar(Cat_LenguaindigenaDTO lengua) {
        Cat_LenguaindigenaDAO dao = new Cat_LenguaindigenaDAO();
        return dao.modificar(lengua);
    }

}
