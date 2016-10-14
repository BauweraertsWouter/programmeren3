package be.kdg.prog3.form.controller;

import be.kdg.prog3.form.model.UserDataForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final EqualPasswordValidator passwordValidator;

    @Autowired
    public RegistrationController(EqualPasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userData", new UserDataForm());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userData") @Valid UserDataForm userDataForm, Errors errors) {
        this.passwordValidator.validate(userDataForm, errors);

        if (errors.hasErrors()) {
            return "registrationForm";
        }
        else {
            return "success";
        }
    }
}
