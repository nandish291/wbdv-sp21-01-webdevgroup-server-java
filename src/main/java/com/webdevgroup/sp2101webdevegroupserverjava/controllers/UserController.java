package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.mapper.UserUserBasicMapper;
import com.webdevgroup.sp2101webdevegroupserverjava.models.*;
import com.webdevgroup.sp2101webdevegroupserverjava.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import com.webdevgroup.sp2101webdevegroupserverjava.services.EventService;

import java.util.List;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000","http://wbdv-client-react-s1.herokuapp.com","https://wbdv-client-react-s1.herokuapp.com"},allowCredentials = "true")
public class UserController {

    private final UserService service;
    private final EventService eventService;
    private final UserUserBasicMapper mapper;

    @GetMapping("/users")
    public List<UserBasic> getAllUsers()
    {
        return service.findAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(
            @RequestBody User user,
            HttpSession session) {
        if (service.findUserByUserName(user.getUserName()) != null
        || service.findByEmail(user.getEmail())) {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
        service.createUser(user);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @PostMapping("/login")
    public UserBasic login(
            @RequestBody UserLogin user,
            HttpSession session) {

        User registeredUser;
        if(user.getUsername().matches("(.*)@(.*)\\.(.*)"))
        {
            registeredUser=service.findUserByEmail(user.getUsername());
        }
        else
        {
            registeredUser=service.findUserByUserName(user.getUsername());
        }


        if (registeredUser!=null && registeredUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("currentUser", registeredUser);
            return mapper.UserToUserBasic(registeredUser);
        }
            // username and password don't match
            return new UserBasic();
    }

    @GetMapping("/currentuser")
    public UserBasic currentUser(HttpSession session) {
        User obj=(User)session.getAttribute("currentUser");
        if(obj==null)
            return new UserBasic();
        return mapper.UserToUserBasic(obj);
    }

    @GetMapping("/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
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

    @PutMapping("/user/update")
    public User updateUser(
            @RequestBody User user
    ) {

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

    @GetMapping("/username/{username}")
    public ResponseEntity<Boolean> checkUserName(@PathVariable("username")String userName)
    {
        User user= service.findUserByUserName(userName);
        if(user!=null)
            return new ResponseEntity<>(true,HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(false,HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Boolean> checkEmail(@PathVariable("email")String email)
    {
        if(service.findByEmail(email))
            return new ResponseEntity<>(true,HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(false,HttpStatus.OK);
    }

    @GetMapping("/user/events/{id}")
    public EventBasic findEventsForUser(@PathVariable Long id)
    {
       return service.findEventsForUser(id);
    }

    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable Long id)
    {
        service.deleteUser(id);
        return true;
    }

    @PostMapping("/user/follow/{userId}/{targetId}")
    public Set<User> addFollow(@PathVariable Long userId,@PathVariable Long targetId)
    {
        return service.addFollow(userId,targetId);
    }

    @PostMapping("/user/unfollow/{userId}/{targetId}")
    public Set<User> deleteFollow(@PathVariable Long userId, @PathVariable Long targetId)
    {
        return service.deleteFollow(userId,targetId);
    }

    @GetMapping("/user/details/{userId}")
    public UserDetails getUserDetails(@PathVariable Long userId)
    {
        return service.getUserDetails(userId);
    }
}
