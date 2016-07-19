
package edu.uagro.validators;

import edu.uagro.dao.Tbl_ResponsableDAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Fernando
 */
@FacesValidator (value = "existeResponsableExternoValidate")
public class ExisteResponsableExternoValidate implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        int claveEmpleado = Integer.parseInt(texto);
        Tbl_ResponsableDAO responsableDAO = new Tbl_ResponsableDAO();
        if(responsableDAO.validarExisteExterno(claveEmpleado)==false){
            FacesMessage message = new FacesMessage();
            message.setSummary("El numero de empleado no se encuentra en el sistema...");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
