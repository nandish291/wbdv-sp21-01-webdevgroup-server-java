package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.EventDetails;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import com.webdevgroup.sp2101webdevegroupserverjava.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000","http://wbdv-client-react-s1.herokuapp.com","https://wbdv-client-react-s1.herokuapp.com"}, allowCredentials = "true")
public class EventController {

    private final EventService service;

    @GetMapping("/events")
    Events getAllEvents(){
        return service.getAllEvents();
    }

    @GetMapping("/events/trending")
    Events getTrendingEvents(){
        return service.getTrendingEvents();
    }

    @GetMapping("/events/venue/{venue}")
    Events getEventsAroundVenue(@PathVariable String venue){
        return service.getEventsAroundVenue(venue);
    }

    @GetMapping("/search")
    Events searchEvents(@RequestParam String name){
        return service.searchEvents(name);
    }

    @GetMapping("/event/{id}")
    EventDetails getEvent(@PathVariable Long id)
    {
       return service.getEventById(id);
    }

    @PostMapping("/event")
    boolean createEvent(@RequestBody Event event)
    {
        return service.createEvent(event);
    }

    @PutMapping("/event")
    boolean updateEvent(@RequestBody Event event)
    {
        return service.createEvent(event);
    }

    @GetMapping("/events/recommendations/{userId}")
    Set<Event> getRecommendationsForUser(@PathVariable Long userId)
    {
        return service.getRecommendationsForUser(userId);
    }
}
