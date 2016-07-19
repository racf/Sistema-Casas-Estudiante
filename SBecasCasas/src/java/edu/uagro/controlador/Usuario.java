package edu.uagro.controlador;

import edu.uagro.bo.Tbl_UsuariosBO;
import edu.uagro.dto.Tbl_UsuariosDTO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author magic
 * @since Abr 28 2016
 */
@ManagedBean (name="usuario")
@SessionScoped
public class Usuario implements Serializable{

    Tbl_UsuariosDTO usuario;
    
    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
        usuario = new Tbl_UsuariosDTO();
    }
    
    public String login() {
        Tbl_UsuariosBO bo = new Tbl_UsuariosBO();
        if (bo.login(usuario)) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario.getNombre());
            return "app/inicio.xhtml?faces-redirect=true";
        } 
        return "index.xhtml?faces-redirect=true";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public Tbl_UsuariosDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(Tbl_UsuariosDTO usuario) {
        this.usuario = usuario;
    }
    
    
}
