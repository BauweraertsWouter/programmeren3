package be.kdg.prog3.classnotfound.controller.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String msg) {
        super(msg);
    }
}
