package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Comment;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.CommentRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventRepository    eventRepository;
    private final EventService eventService;

    public boolean addComment(Comment comment)
    {
        Event event=eventRepository.findById(comment.getEvent().getId()).orElse(null);
        if(event==null)
            eventService.createEvent(comment.getEvent());
        Comment comment1=commentRepository.save(comment);
        if(comment1!=null)
            return true;
        return false;
    }
}
