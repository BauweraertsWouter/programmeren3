package be.kdg.prog3.controllers.model;

import java.time.LocalDate;

public class User {
    private final String name;
    private final String phone;
    private final LocalDate dateOfBirth;

    public User(String name, String phone, LocalDate dateOfBirth) {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
