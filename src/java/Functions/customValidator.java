/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;
 
/**
 * Created by ilkaygunel on 09/02/16.
 */
@FacesValidator("customValidator")
public class customValidator implements Validator{
 
    String emailPattern="^[A-Za-z0-9+-]+(\\.[A-Za-z0-9+-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
 
    private Pattern patternObject;
    private Matcher matcherObject;
 
    public customValidator()
    {
        patternObject = Pattern.compile(emailPattern);
    }
    
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcherObject = patternObject.matcher(o.toString());
        if (!matcherObject.matches())
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"E-Posta doğrulaması başarısız oldu.", "Geçersiz E-Posta Adresi");
            throw new ValidatorException(message);
        }
    }
}
