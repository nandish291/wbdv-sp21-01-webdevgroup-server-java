package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.EventDetails;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import com.webdevgroup.sp2101webdevegroupserverjava.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class EventController {

    private final EventService service;

    @GetMapping("/events")
    Events getAllEvents(){
        return service.getAllEvents();
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
}
