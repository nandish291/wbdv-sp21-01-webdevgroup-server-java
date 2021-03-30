package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.feignclients.StubHubClient;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
        Events byEvenetName=client.searchEventsByEventName(name);
        events.getEvents().addAll(byArtists.getEvents());
        events.getEvents().addAll(byCity.getEvents());
        events.getEvents().addAll(byEvenetName.getEvents());
        events.setNumFound(byCity.getNumFound()+byArtists.getNumFound()+byEvenetName.getNumFound());
        return events;
    }
}
