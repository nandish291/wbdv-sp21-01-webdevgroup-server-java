package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.models.UserLogin;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.services.EventService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    EventService eventService;

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

    //chayank
//    @GetMapping("/user/{uid}")
//    User getEvent(@PathVariable Long uid)
//    {
//        return service.findUserById(uid);
//    }
//
//    @PutMapping("/user/{uid}/add_interested_event")
//    public User addEventToInterestedForUser(
//            @PathVariable("uid") Long uid,
//            @RequestBody Event event
//    ) {
//
//        User user=service.findUserById(uid);
//
//        eventService.createEvent(event);
//
//        user.getInterested().add(event);
//
//        return service.updateUser(user);
//    }
//
//    @DeleteMapping("/user/{uid}/delete_interested_event/{eid}")
//    public User deleteEventFromInterestedForUser(
//            @PathVariable("uid") Long uid,
//            @PathVariable("eid") Long eid) {
//
//
//        Event event=eventService.getEventById(eid).getEvent();
//        User user=service.findUserById(uid);
//        user.getInterested().remove(event);
//
//        return service.updateUser(user);
//    }
//
//    @PutMapping("/user/{uid}/add_attended_event")
//    public User AddEventToAttendingForUser(
//            @PathVariable("uid") Long uid,
//            @RequestBody Event event
//    ) {
//
//        User user=service.findUserById(uid);
//
//        eventService.createEvent(event);
//
//        user.getAttending().add(event);
//
//        return service.updateUser(user);
//    }
//
//    @DeleteMapping("/user/{uid}/delete_attended_event/{eid}")
//    public User DeleteEventFromAttendingForUser(
//            @PathVariable("uid") Long uid,
//            @PathVariable("eid") Long eid) {
//
//
//        Event event=eventService.getEventById(eid).getEvent();
//        User user=service.findUserById(uid);
//        user.getAttending().remove(event);
//
//        return service.updateUser(user);
//    }
}
