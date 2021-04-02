package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.feignclients.StubHubClient;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class StubHubService {
    private final StubHubClient client;

    public Events getAllEvents(){
        return client.getAllEvents();
    }

    public Events searchEvents(String name){
        Events events=new Events();
        events.setEvents(new HashSet<>());
        Events byCity=client.searchEventsByCity(name);
        Events byArtists=client.searchEventsByArtist(name);
        Events byEventName=client.searchEventsByEventName(name);
        events.getEvents().addAll(byArtists.getEvents());
        events.getEvents().addAll(byCity.getEvents());
        events.getEvents().addAll(byEventName.getEvents());
        events.setNumFound(byCity.getNumFound()+byArtists.getNumFound()+byEventName.getNumFound());
        return events;
    }

    public Event getEventById(Integer id)
    {
        Events events=client.searchEventsById(id);
        if(events.getNumFound()!=0)
            return (Event)events.getEvents().toArray()[0];
        return null;
    }
}
