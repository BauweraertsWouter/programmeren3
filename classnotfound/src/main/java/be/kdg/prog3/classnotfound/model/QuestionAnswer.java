package be.kdg.prog3.classnotfound.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "QUESTION_ANSWER")
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QA_ID")
    private long id;

    @Column(name = "QA_SUBJECT", length=100, updatable = false)
    private String subject;

    @Column(name = "QA_BODY", length=1000, nullable = false)
    private String body;

    @Column(name = "QA_SCORE", nullable = false)
    private int score;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "QA_TIMESTAMP", nullable = false)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "QA_USE_ID", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "QA_PARENT_QA_ID", updatable = false)
    private QuestionAnswer parent;

    protected QuestionAnswer() {
    }

    public QuestionAnswer(String body, User user, QuestionAnswer parent) {
        this(body, user);
        this.parent = parent;
    }

    public QuestionAnswer(String subject, String body, User user) {
        this(body, user);
        this.subject = subject;
    }

    private QuestionAnswer(String body, User user) {
        this.body = body;
        this.user = user;
        this.score = 0;
        this.timestamp = new Date();
    }

    public long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public int getScore() {
        return score;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }
}
