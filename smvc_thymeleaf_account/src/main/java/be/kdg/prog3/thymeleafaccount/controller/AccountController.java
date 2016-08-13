package be.kdg.prog3.thymeleafaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import be.kdg.prog3.thymeleafaccount.model.Account;

@Controller
public class AccountController {
    @GetMapping("/show")
    public ModelAndView showAccountBalance() {
        final Account account = new Account("Marcel");
        account.setBalance(37.5);

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showAccountBalance");
        modelAndView.getModel().put("account", account);
        return modelAndView;
    }
}
