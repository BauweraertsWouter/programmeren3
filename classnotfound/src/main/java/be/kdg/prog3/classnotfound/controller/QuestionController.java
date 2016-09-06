package be.kdg.prog3.classnotfound.controller;

import be.kdg.prog3.classnotfound.model.Question;
import be.kdg.prog3.classnotfound.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/q/{questionId}")
    public ModelAndView showQuestion(@PathVariable long questionId) throws HttpServerErrorException {
        Question question = questionRepository.findOne(questionId);
        if (question != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("show_question");
            modelAndView.getModel().put("question", question);
            return modelAndView;
        }
        else {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Question with ID '" + questionId + "' not found.");
        }
    }

    @GetMapping("/q/new")
    public String newQuestion() {
        return "new_question";
    }

    @GetMapping("/q/search")
    public String searchQuestions() {
        return "search_questions";
    }

    @PostMapping("/q")
    public String addQuestion(@RequestParam String subject, @RequestParam String body) {
        Question question = new Question(subject, body);
        question = questionRepository.save(question);

        return "redirect:/q/" + question.getId();
    }
}
