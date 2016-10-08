package be.kdg.prog3.controllers.controller;

import be.kdg.prog3.controllers.model.SuperUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuperUserController {
    @PostMapping("/showSuperUser")
    public ModelAndView showSuperUser(SuperUser superUser/*, BindingResult errors*/) {
        /*if (errors.hasErrors()) {
            for (ObjectError e : errors.getAllErrors()) {
                System.err.println(e.getDefaultMessage());
            }
        }*/
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showUser");
        modelAndView.getModel().put("user", superUser);
        return modelAndView;
    }

    @PostMapping("/showSuperUser2")
    public String showSuperUser2(@ModelAttribute("user") SuperUser superUser/*, BindingResult errors*/) {
        /*if (errors.hasErrors()) {
            for (ObjectError e : errors.getAllErrors()) {
                System.err.println(e.getDefaultMessage());
            }
        }*/
        return "showUser";
    }
}
