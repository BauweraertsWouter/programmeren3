package be.kdg.prog3.cycling.model;

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
@Table(name = "RIDER")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", length=50, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private Team team;

    protected Rider() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Team getTeam() {
        return team;
    }
}
