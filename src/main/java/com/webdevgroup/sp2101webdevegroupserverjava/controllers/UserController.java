package com.webdevgroup.sp2101webdevegroupserverjava.controllers;
import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.services.EventService;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    EventService eventService;

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



    //chayank
    @GetMapping("/user/{uid}")
    User getEvent(@PathVariable Long uid)
    {
        return service.findUserById(uid);
    }

    @PutMapping("/user/{uid}/add_interested_event")
    public User addEventToInterestedForUser(
            @PathVariable("uid") Long uid,
            @RequestBody Event event
    ) {

        User user=service.findUserById(uid);

        eventService.createEvent(event);

        user.getInterested().add(event);

        return service.updateUser(user);
    }

    @DeleteMapping("/user/{uid}/delete_interested_event/{eid}")
    public User deleteEventFromInterestedForUser(
            @PathVariable("uid") Long uid,
            @PathVariable("eid") Long eid) {


        Event event=eventService.getEventById(eid).getEvent();
        User user=service.findUserById(uid);
        user.getInterested().remove(event);

        return service.updateUser(user);
    }

    @PutMapping("/user/{uid}/add_attended_event")
    public User AddEventToAttendingForUser(
            @PathVariable("uid") Long uid,
            @RequestBody Event event
    ) {

        User user=service.findUserById(uid);

        eventService.createEvent(event);

        user.getAttending().add(event);

        return service.updateUser(user);
    }

    @DeleteMapping("/user/{uid}/delete_attended_event/{eid}")
    public User DeleteEventFromAttendingForUser(
            @PathVariable("uid") Long uid,
            @PathVariable("eid") Long eid) {


        Event event=eventService.getEventById(eid).getEvent();
        User user=service.findUserById(uid);
        user.getAttending().remove(event);

        return service.updateUser(user);
    }
}
