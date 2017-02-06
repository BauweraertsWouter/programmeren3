package be.kdg.webapp.model;

/**
 * Created by Wouter on 6/02/2017.
 */
public class Post {
    private int id;
    private String jaar, name, omschrijving, specialisatie, url;

    public Post(int id, String jaar, String name, String omschrijving, String specialisatie, String url) {
        this.id = id;
        this.jaar = jaar;
        this.name = name;
        this.omschrijving = omschrijving;
        this.specialisatie = specialisatie;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getJaar() {
        return jaar;
    }

    public String getName() {
        return name;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public String getUrl() {
        return url;
    }
}
