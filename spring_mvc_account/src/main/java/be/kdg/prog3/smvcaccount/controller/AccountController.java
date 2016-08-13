package be.kdg.prog3.smvcaccount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/show")
    public String showAccountBalance(ModelMap modelMap) {
        modelMap.addAttribute("account", 7);
        return "showAccountBalance";
    }
}
