package be.kdg.prog3.cycling.controller;

import be.kdg.prog3.cycling.model.Team;
import be.kdg.prog3.cycling.model.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping({"/", "/teams"})
    public ModelAndView showAllTeams() {
        Iterable<Team> teams = teamRepository.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all_teams");
        modelAndView.getModel().put("teams", teams);
        return modelAndView;
    }

    @GetMapping("/team/{uciCode}")
    public ModelAndView showTeam(@PathVariable String uciCode) {
        Team team = teamRepository.findByUciCode(uciCode);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");
        modelAndView.getModel().put("team", team);
        return modelAndView;
    }
}
