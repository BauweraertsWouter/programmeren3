package be.kdg.prog3.controllers.controller;

import be.kdg.prog3.controllers.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class UserController {
    @GetMapping("/showJos")
    public ModelAndView showUserJos() {
        User jos = new User("Jos Bosmans", "797204", LocalDate.of(1944, 9, 22));
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showUser");
        modelAndView.getModel().put("user", jos);
        return modelAndView;
    }

    @GetMapping("/showMarcel")
    public ModelAndView showUserMarcel(ModelAndView modelAndView) {
        User marcel = new User("Marcel Kittel", "555-MARCEL", LocalDate.of(1988, 5, 11));
        modelAndView.setViewName("showUser");
        modelAndView.getModel().put("user", marcel);
        return modelAndView;
    }

    @GetMapping("/showCas")
    public String showUserCas(ModelMap modelMap) {
        User cas = new User("Cas Goossens", "12345678", LocalDate.of(1937, 8, 13));
        modelMap.put("user", cas);
        return "showUser";
    }

    @GetMapping("/showLance")
    public String showLance(RedirectAttributes redirectAttrs) {
        User lance = new User("Lance Armstrong", "0800-123456", LocalDate.of(1971, 9, 18));
        redirectAttrs.addFlashAttribute("user", lance);
        return "redirect:/showUser";
    }

    @GetMapping("/showUser")
    public String showUser() {
        return "showUser";
    }

    @PostMapping("/showUser")
    public ModelAndView showUser(@RequestParam String name, @RequestParam String phone, @RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth) {
        User user = new User(name, phone, dateOfBirth);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showUser");
        modelAndView.getModel().put("user", user);
        return modelAndView;
    }

    @GetMapping("/show/{name}/{phone}/{dob}")
    public ModelAndView showRequestBody(@PathVariable String name, @PathVariable String phone, @PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth) {
        User user = new User(name, phone, dateOfBirth);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showUser");
        modelAndView.getModel().put("user", user);
        return modelAndView;
    }
}
