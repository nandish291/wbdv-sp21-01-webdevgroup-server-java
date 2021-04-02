package com.webdevgroup.sp2101webdevegroupserverjava.feignclients;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "stubHubClient",url = "https://api.stubhub.com/sellers")
public interface StubHubClient {

    @GetMapping("search/bulk/events/v3")
    Events getAllEvents();

    @GetMapping("/search/events/v3")
    Events searchEventsById(@RequestParam(value = "id") Integer id);

    @GetMapping("/search/events/v3")
    Events searchEventsByCity(@RequestParam(value = "city") String city);

    @GetMapping("/search/events/v3")
    Events searchEventsByArtist(@RequestParam(value = "performerName") String name);

    @GetMapping("/search/events/v3")
    Events searchEventsByEventName(@RequestParam(value = "name") String name);
}
