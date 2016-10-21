package be.kdg.prog3.classnotfound.controller;

import be.kdg.prog3.classnotfound.controller.exception.QuestionNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(QuestionNotFoundException.class)
    public ModelAndView handleQuestionNotFoundException() {
        // The following must be added to application.properties for the error page to work:
        // server.error.whitelabel.enabled=false
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("my_error");
        return modelAndView;
    }
}
