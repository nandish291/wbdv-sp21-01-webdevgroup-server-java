package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/user/register/")
    public User register(@RequestBody User user,
            HttpSession session) {
        service.createUser(user);
        return user;
    }

    // TODO: must be sure that client is storing the same cookie, so maybe enable the credentials and select the specific CORS
    @GetMapping("/currentUser")
    public User currentUser(HttpSession session) {
        return (User)session.getAttribute("currentUser");
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @GetMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }

    //    //    TODO: This should actually use Post, not Get
    @GetMapping("/api/login/{username}/{password}")
    public boolean login(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            HttpSession session) {
        User user = service.findUserByUserName(username);
        System.out.println(username);
        System.out.println(password);
        System.out.println(user.getPassword().equals(password));
        if (user.getUserName().equals(username)
                && user.getPassword().equals(password)) {
            session.setAttribute("currentUser", user);
            return true;
        }
        return false;
    }

}
