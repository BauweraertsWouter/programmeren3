package be.kdg.prog3.controllers.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SuperUser {
    private String name;
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public SuperUser() {
    }

    // Getters
    // Setter

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
