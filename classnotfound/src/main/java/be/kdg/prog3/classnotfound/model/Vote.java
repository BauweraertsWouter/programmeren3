package be.kdg.prog3.classnotfound.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VOTE")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOT_ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VOT_USE_ID", nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VOT_QA_ID", nullable = false, updatable = false)
    private QuestionAnswer questionAnswer;

    @Column(name = "VOT_IS_UP", nullable = false)
    private boolean isUp;

    protected Vote() {
    }

    public Vote(User user, QuestionAnswer questionAnswer, boolean isUp) {
        this.user = user;
        this.questionAnswer = questionAnswer;
        this.isUp = isUp;
    }

    public long getId() {
        return id;
    }

    public boolean isUp() {
        return isUp;
    }

    public User getUser() {
        return user;
    }
}
