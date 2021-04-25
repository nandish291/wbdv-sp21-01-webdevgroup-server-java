package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.feignclients.SeatGeekClient;
import com.webdevgroup.sp2101webdevegroupserverjava.models.*;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.CommentRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.EventRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.PerformerRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    public Events getRecommendationsByPerformer(Long id)
    {
        Event event=repository.findById(id).orElse(null);
        Long pid=event.getPerformers().get(0).getId();
        Root root=client.getEventsLikeByPerformer(pid.toString());
        List<Recommendation> recommendations=root.recommendations;
        Events events=new Events();
        events.setEvents(new HashSet<>());
        for(Recommendation recommendation:recommendations)
            events.getEvents().add(recommendation.event);
        return events;
    }

    public Events getRecommendationsByEvent(Long id)
    {
        Root root=client.getEventsLikeByEvent(id.toString());
        List<Recommendation> recommendations=root.recommendations;
        Events events=new Events();
        events.setEvents(new HashSet<>());
        for(Recommendation recommendation:recommendations)
            events.getEvents().add(recommendation.event);
        return events;
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
        Set<Comment> comments=commentRepository.findCommentsForEvent(event.getId());
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
