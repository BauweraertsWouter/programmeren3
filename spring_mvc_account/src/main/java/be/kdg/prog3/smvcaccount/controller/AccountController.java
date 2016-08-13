package be.kdg.prog3.smvcaccount.controller;

import be.kdg.prog3.smvcaccount.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/show")
    public String showAccountBalance(ModelMap modelMap) {
        final Account account = new Account("Marcel");
        account.setBalance(37.5);

        modelMap.addAttribute("account", account);
        return "showAccountBalance";
    }
}
