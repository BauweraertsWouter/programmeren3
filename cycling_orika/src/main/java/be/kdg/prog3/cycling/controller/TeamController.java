package be.kdg.prog3.cycling.controller;

import be.kdg.prog3.cycling.controller.dto.DtoAssembler;
import be.kdg.prog3.cycling.controller.dto.TeamDto;
import be.kdg.prog3.cycling.model.Team;
import be.kdg.prog3.cycling.model.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeamController {
    private final TeamRepository teamRepository;
    private final DtoAssembler dtoAssembler;

    @Autowired
    public TeamController(TeamRepository teamRepository, DtoAssembler dtoAssembler) {
        this.teamRepository = teamRepository;
        this.dtoAssembler = dtoAssembler;
    }

    @GetMapping({"/", "/teams"})
    public ModelAndView showAllTeams() {
        final Iterable<Team> teams = teamRepository.findAll();
        final List<TeamDto> teamDtos = this.dtoAssembler.toTeamResources(teams);

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all_teams");
        modelAndView.getModel().put("teams", teamDtos);
        return modelAndView;
    }

    @GetMapping("/team/{uciCode}")
    public ModelAndView showTeam(@PathVariable String uciCode) {
        final Team team = teamRepository.findByUciCode(uciCode);
        final TeamDto teamDto = this.dtoAssembler.toResource(team);

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");
        modelAndView.getModel().put("team", teamDto);
        return modelAndView;
    }
}
