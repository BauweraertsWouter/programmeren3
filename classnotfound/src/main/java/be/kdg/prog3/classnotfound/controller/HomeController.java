package be.kdg.prog3.classnotfound.controller;

import be.kdg.prog3.classnotfound.model.Question;
import be.kdg.prog3.classnotfound.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public ModelAndView showDefaultHomepage() {
        final List<Question> homepageQuestions = questionRepository.findTop10ByOrderByTimestampDesc();

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.getModel().put("questions", homepageQuestions);
        return modelAndView;
    }
}
