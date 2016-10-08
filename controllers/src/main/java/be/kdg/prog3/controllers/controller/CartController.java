package be.kdg.prog3.controllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @GetMapping("/addToCart")
    public String addToCart(HttpSession session) {
        session.setAttribute("items", session.getAttribute("items") == null ? 1 : Integer.parseInt(session.getAttribute("items").toString()) + 1);
        return "showItems";
    }

    @GetMapping("/checkout")
    public ModelAndView balance(@SessionAttribute int items) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showCheckout");
        modelAndView.getModel().put("totalPrice", items * 50);
        return modelAndView;
    }
}
