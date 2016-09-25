package be.kdg.prog3.blog_jsp.model;

public class BlogPost {
    private final String subject;
    private final String body;

    public BlogPost(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
