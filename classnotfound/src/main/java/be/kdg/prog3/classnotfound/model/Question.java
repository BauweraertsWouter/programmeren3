package be.kdg.prog3.classnotfound.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUE_ID")
    private long id;

    @Column(name = "QUE_SUBJECT", length=100, nullable = false)
    private String subject;

    @Column(name = "QUE_BODY", length=1000, nullable = false)
    private String body;

    @Column(name = "QUE_SCORE", nullable = false)
    private int score;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "QUE_TIMESTAMP", nullable = false)
    private Date timestamp;

    protected Question() {
    }

    public Question(String subject, String body) {
        this.subject = subject;
        this.body = body;
        this.score = 0;
        this.timestamp = new Date();
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
}
