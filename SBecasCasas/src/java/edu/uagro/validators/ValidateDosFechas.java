package edu.uagro.validators;

import java.io.Serializable;
import java.util.Date;
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
@FacesValidator("validateDosFechas")
public class ValidateDosFechas implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent component, Object value)
            throws ValidatorException {
        Date fechaInicial = (Date) component.getAttributes().get("fechaInicialValor");
        Date fechaFinal = (Date) value;
        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final 2: " + fechaFinal);
        if (fechaFinal.before(fechaInicial)) {
            FacesMessage message = new FacesMessage();
            message.setSummary("La fecha final debe ser mayor a la fecha inicial");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}
