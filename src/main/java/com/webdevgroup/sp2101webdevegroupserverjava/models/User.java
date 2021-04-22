package com.webdevgroup.sp2101webdevegroupserverjava.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    @NotBlank
    private String gender;
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String type;
    @ManyToMany
    private Set<Event> interested;
    @ManyToMany
    private Set<Event> attending;
}
