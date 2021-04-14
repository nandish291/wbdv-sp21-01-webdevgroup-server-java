package com.webdevgroup.sp2101webdevegroupserverjava.feignclients;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "seatGeekClient",url = "https://api.seatgeek.com/2")
public interface SeatGeekClient {

    @GetMapping("/events")
    Events getAllEvents();

    @GetMapping("/events/{id}")
    Event searchEventsById(@PathVariable("id") Integer id);

    @GetMapping("/events")
    Events searchEvents(@RequestParam(value = "q")String query);
}
