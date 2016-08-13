package be.kdg.prog3.thymeleafaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @GetMapping("/show")
    public ModelAndView showAccountBalance() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showAccountBalance");
        modelAndView.getModel().put("account", 7);
        return modelAndView;
    }
}
