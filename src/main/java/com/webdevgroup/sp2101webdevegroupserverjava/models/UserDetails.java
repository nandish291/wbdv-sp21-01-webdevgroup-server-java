package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private User user;
    private Set<User> followers;
    private Set<User> following;
}
