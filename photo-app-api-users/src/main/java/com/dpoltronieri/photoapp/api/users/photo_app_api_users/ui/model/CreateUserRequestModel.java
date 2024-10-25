package com.dpoltronieri.photoapp.api.users.photo_app_api_users.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequestModel {

    @NotNull(message = "Fist name cannot be null")
    @Size(min = 2, max = 128, message = "Fist name cannot be less than 2 or more tha 128")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, max = 128, message = "Last name cannot be less than 2 or more tha 128")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password cannot be less than 8 or more tha 16")
    private String password;

    @NotNull(message = "Email name cannot be null")
    @Email
    private String email;


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
