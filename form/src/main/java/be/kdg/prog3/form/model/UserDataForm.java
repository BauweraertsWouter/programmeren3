package be.kdg.prog3.form.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class UserDataForm {
    @Size(min = 2, max = 50, message = "{form.invalid.size}")
    private String firstName;

    @Size(min = 2, max = 50, message = "{form.invalid.size}")
    private String lastName;

    @Email(message = "{form.invalid.email}")
    @NotBlank(message = "{form.invalid.empty}")
    private String email;

    @Size(min = 8, max = 20, message = "{form.invalid.size}")
    private String password;

    @Size(min = 8, max = 20, message = "{form.invalid.size}")
    private String passwordConfirmation;

    public UserDataForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
