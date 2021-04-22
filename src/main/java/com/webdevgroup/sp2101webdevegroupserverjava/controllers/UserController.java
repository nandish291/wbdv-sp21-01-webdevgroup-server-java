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
import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.services.EventService;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000","https://wbdv-client-react-s1.herokuapp.com/"},allowCredentials = "true")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    EventService eventService;

    @PostMapping("/api/register/{username}")
    public Integer register(
            @RequestBody User user,
            HttpSession session) {

        if (service.findUserByUserName(user.getUserName()) != null) {
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
        if (registeredUser.getUserName() == null) {
            return -1;
        }

        // login successful
        if (registeredUser.getUserName().equals(user.getUsername())
                && registeredUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("currentUser", registeredUser);
            return 1;
        } else {

            // username and password don't match
            return 0;
        }
    }


    // TODO: must be sure that client is storing the same cookie, so maybe enable the credentials and select the specific CORS
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

    @GetMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }

    //chayank
    @GetMapping("/user/{uid}")
    User getEvent(@PathVariable Long uid)
    {
        return service.findUserById(uid);
    }

    @PutMapping("/user/{uid}/update")
    public User updateUser(
            @PathVariable("uid") Long uid,
            @RequestBody User user
    ) {

        return service.updateUser(user);
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
