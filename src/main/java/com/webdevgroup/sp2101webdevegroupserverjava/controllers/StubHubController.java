package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import com.webdevgroup.sp2101webdevegroupserverjava.services.StubHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StubHubController {

    private final StubHubService service;

    @GetMapping("/events")
    Events getAllEvents(){
        return service.getAllEvents();
    }

    @GetMapping("/search")
    Events searchEvents(@RequestParam String name){
        return service.searchEvents(name);
    }
}
