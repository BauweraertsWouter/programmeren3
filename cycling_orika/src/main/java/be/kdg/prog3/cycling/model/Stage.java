package be.kdg.prog3.cycling.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "STAGE")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "SEQ", nullable = false)
    private byte sequence;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", nullable = false)
    private Tour tour;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StageResult> stageResults;

    protected Stage() {
    }

    public byte getSequence() {
        return sequence;
    }

    public Tour getTour() {
        return tour;
    }
}
