package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.feignclients.SeatGeekClient;
import com.webdevgroup.sp2101webdevegroupserverjava.models.*;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.CommentRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.EventRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.PerformerRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EventService{
    private final SeatGeekClient client;
    private final EventRepository repository;
    private final PerformerRepository performerRepository;
    private final VenueRepository venueRepository;
    private final CommentRepository  commentRepository;

    public Events getAllEvents(){
        return client.getAllEvents();
    }

    public Events getTrendingEvents(){
        return client.getTrendingEvents();
    }

    public Events searchEvents(String name){
        return client.searchEvents(name);

    }
    public EventDetails getEventById(Long id)
    {
        Event event;
        event=repository.findById(id).orElse(null);
        if(event==null)
            event=client.searchEventsById(id);
        List<Comment> comments=commentRepository.findCommentByEvent_Id(event.getId());
        EventDetails eventDetails=EventDetails.builder().event(event).comment(comments).build();
        if(event.getId()!=0)
            return eventDetails;
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

    public Events getEventsAroundVenue(String venue) {
        return client.getEventsAroundVenue(venue);
    }
}
