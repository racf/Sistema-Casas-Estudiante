/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uagro.validators;

import edu.uagro.dao.Tbl_RepresentanteDAO;
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
@FacesValidator (value = "existeAlumnoExternoValidate")
public class ExisteAlumnoExternoValidate implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String matricula = String.valueOf(value);
        Tbl_RepresentanteDAO representanteDAO = new Tbl_RepresentanteDAO();
        if(representanteDAO.validarExisteExterno(matricula)==false){
            FacesMessage message = new FacesMessage();
            message.setSummary("La matricula de este alumno no se encuentra en el sistema...");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
