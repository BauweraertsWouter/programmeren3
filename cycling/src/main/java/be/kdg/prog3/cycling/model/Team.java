package be.kdg.prog3.cycling.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", length=50, nullable = false)
    private String name;

    @Column(name = "UCI_CODE", length=3, nullable = false, columnDefinition="char(3)")
    private String uciCode;

    @Column(name = "YEAR_FOUNDED", nullable = false)
    private short founded;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rider> riders;

    protected Team() {
    }

    public String getName() {
        return name;
    }

    public String getUciCode() {
        return uciCode;
    }

    public short getFounded() {
        return founded;
    }

    public List<Rider> getRiders() {
        return riders;
    }
}
