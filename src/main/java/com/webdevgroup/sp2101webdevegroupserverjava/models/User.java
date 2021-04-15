package com.webdevgroup.sp2101webdevegroupserverjava.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String dob;
    @NotBlank
    private String gender;
    @Column(unique = true)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Column(unique = true)
    @NotBlank
    private String email;

    public User(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String dob, @NotBlank String gender, @NotBlank String username, @NotBlank String password, @NotBlank String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.dob = "";
        this.gender = "";
        this.username = "";
        this.password = "";
        this.email = "";

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
