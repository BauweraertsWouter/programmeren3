package be.kdg.prog3.classnotfound.controller;

import be.kdg.prog3.classnotfound.model.QuestionAnswer;
import be.kdg.prog3.classnotfound.model.QuestionAnswerRepository;
import be.kdg.prog3.classnotfound.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionAnswerController {
    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public QuestionAnswerController(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @GetMapping("/q/{questionId}")
    public ModelAndView showQuestion(@PathVariable long questionId) throws HttpServerErrorException {
        QuestionAnswer question = questionAnswerRepository.findOne(questionId);
        if (question != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("show_question");
            modelAndView.getModel().put("question", question);
            return modelAndView;
        }
        else {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "QuestionAnswer with ID '" + questionId + "' not found.");
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
    public String addQuestion(@RequestParam String subject, @RequestParam String body,
                              @AuthenticationPrincipal UserDetails userDetails) {
        QuestionAnswer questionAnswer = new QuestionAnswer(subject, body, userDetails.getUser());
        questionAnswer = questionAnswerRepository.save(questionAnswer);

        return "redirect:/q/" + questionAnswer.getId();
    }
}
