package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.models.UserLogin;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/api/register/{username}")
    public Integer register(
            @RequestBody User user,
            HttpSession session) {

        if (service.findUserByUserName(user.getUsername()) != null) {
            return -1;
        }
        service.createUser(user);
        return 1;
    }

    @PostMapping("/api/login")
    public Integer login(
            @RequestBody UserLogin user,
            HttpSession session) {

        // user does not exist
        User registeredUser = service.findUserByUserName(user.getUsername());
        if (registeredUser.getUsername() == null) {
            return -1;
        }

        // login successful
        if (registeredUser.getUsername().equals(user.getUsername())
                && registeredUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("currentUser", registeredUser);
            return 1;
        } else {

            // username and password don't match
            return 0;
        }
    }

    @GetMapping("/currentUser")
    public User currentUser(HttpSession session) {
        return (User) session.getAttribute("currentUser");
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }
}
