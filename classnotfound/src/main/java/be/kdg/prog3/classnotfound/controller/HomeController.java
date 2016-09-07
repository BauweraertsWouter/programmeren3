package be.kdg.prog3.classnotfound.controller;

import be.kdg.prog3.classnotfound.model.QuestionAnswer;
import be.kdg.prog3.classnotfound.model.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public HomeController(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @GetMapping("/")
    public ModelAndView showDefaultHomepage() {
        final List<QuestionAnswer> homepageQuestions = questionAnswerRepository.findTop10ByOrderByTimestampDesc();

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.getModel().put("questions", homepageQuestions);
        return modelAndView;
    }
}
