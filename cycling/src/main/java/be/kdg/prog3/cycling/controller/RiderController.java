package be.kdg.prog3.cycling.controller;

import be.kdg.prog3.cycling.model.Rider;
import be.kdg.prog3.cycling.model.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RiderController {
    private final RiderRepository riderRepository;

    @Autowired
    public RiderController(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @GetMapping("/rider/{id}")
    public ModelAndView showRider(@PathVariable long id) {
        Rider rider = riderRepository.findOne(id);

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rider");
        modelAndView.getModel().put("rider", rider);
        return modelAndView;
    }
}
