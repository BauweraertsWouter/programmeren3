package be.kdg.prog3.cycling.controller;

import be.kdg.prog3.cycling.model.Team;
import be.kdg.prog3.cycling.model.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/")
    public ModelAndView showAllTeams() {
        Iterable<Team> teams = teamRepository.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all_teams");
        modelAndView.getModel().put("teams", teams);
        return modelAndView;
    }
}
