package be.kdg.webapp.model;

/**
 * Created by Wouter on 6/02/2017.
 */
public class User {
    private String naam, specialisatie, jaar;

    public User(String naam, String specialisatie, String jaar) {
        this.naam = naam;
        this.specialisatie = specialisatie;
        this.jaar = jaar;
    }

    public String getNaam() {
        return naam;
    }

    public String getSpecialisatie() {
        return specialisatie;
    }

    public String getJaar() {
        return jaar;
    }
}
