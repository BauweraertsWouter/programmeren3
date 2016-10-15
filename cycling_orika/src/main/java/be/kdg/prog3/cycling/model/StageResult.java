package be.kdg.prog3.cycling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STAGE_RESULT")
public class StageResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FINISH_PLACE")
    private short finishPlace;

    @ManyToOne
    @JoinColumn(name = "STAGE_ID", nullable = false)
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "RIDER_ID", nullable = false)
    private Rider rider;

    protected StageResult() {
    }

    public short getFinishPlace() {
        return finishPlace;
    }

    public Stage getStage() {
        return stage;
    }

    public Rider getRider() {
        return rider;
    }
}
