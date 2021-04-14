package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.feignclients.SeatGeekClient;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Performer;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Venue;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.EventRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.PerformerRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EventService{
    private final SeatGeekClient client;
    private final EventRepository repository;
    private final PerformerRepository performerRepository;
    private final VenueRepository venueRepository;

    public Events getAllEvents(){
        return client.getAllEvents();
    }

    public Events searchEvents(String name){
        return client.searchEvents(name);

    }
    public Event getEventById(Integer id)
    {
        Event event=client.searchEventsById(id);
        if(event.getId()!=0)
            return event;
        return null;
    }

    public boolean createEvent(Event event)
    {
        for(Performer performer:event.getPerformers())
        {
            Performer performer1=performerRepository.findById(performer.getId()).orElse(null);
            if(performer1==null)
                performerRepository.save(performer);
        }
        Venue venue=venueRepository.findById(event.getVenue().getId()).orElse(null);
        if(venue==null)
            venueRepository.save(event.getVenue());
        repository.save(event);
        return true;
    }

    public boolean updateEvent(Event event)
    {
        return true;
    }
}
