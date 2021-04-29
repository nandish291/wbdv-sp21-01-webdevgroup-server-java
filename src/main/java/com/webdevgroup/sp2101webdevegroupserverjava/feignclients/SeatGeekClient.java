package com.webdevgroup.sp2101webdevegroupserverjava.feignclients;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Recommendation;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "seatGeekClient",url = "https://api.seatgeek.com/2")
public interface SeatGeekClient {

    @GetMapping("/events?per_page=5")
    Events getAllEvents();

    @GetMapping("/events?per_page=5&sort=score.desc")
    Events getTrendingEvents();

    @GetMapping("/events/{id}")
    Event searchEventsById(@PathVariable("id") Long id);

    @GetMapping("/events?sort=score.desc&per_page=50")
    Events searchEvents(@RequestParam(value = "q")String query);

    @GetMapping("/events?per_page=5")
    Events getEventsAroundVenue(@RequestParam(value = "venue.city")String venue);

    @GetMapping("/recommendations?per_page=5")
    Root getEventsLikeByPerformer(@RequestParam(value = "performers.id")String id);

    @GetMapping("/recommendations?per_page=5&postal_code=10014")
    Root getEventsLikeByEvent(@RequestParam(value = "events.id")String id);
}
