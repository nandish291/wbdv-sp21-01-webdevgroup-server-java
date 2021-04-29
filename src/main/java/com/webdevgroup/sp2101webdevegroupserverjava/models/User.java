package com.webdevgroup.sp2101webdevegroupserverjava.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
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
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private Date dob;
    @NotNull
    private String gender;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String type;
    @ManyToMany
    private List<Event> attending;
    @OneToMany(cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;
    @ManyToMany
    @JsonIgnore
    private List<User> followers;
    @ManyToMany
    @JsonIgnore
    private List<User> following;
}
