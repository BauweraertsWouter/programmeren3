package be.kdg.prog3.form.controller;

import be.kdg.prog3.form.model.UserDataForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EqualPasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserDataForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDataForm userData = (UserDataForm) target;

        if(!userData.getPassword().equals(userData.getPasswordConfirmation())) {
            errors.rejectValue("password", "form.invalid.password.not.equal");
            errors.rejectValue("passwordConfirmation", "form.invalid.password.confirmation.not.equal");
        }
    }
}
