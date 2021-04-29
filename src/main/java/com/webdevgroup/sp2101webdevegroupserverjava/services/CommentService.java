package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Comment;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.CommentRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventRepository    eventRepository;
    private final EventService eventService;

    public Set<Comment> addComment(Comment comment)
    {
        Event event=eventRepository.findById(comment.getEvent().getId()).orElse(null);
        if(event==null)
            eventService.createEvent(comment.getEvent());
        Comment comment1=commentRepository.save(comment);
        return commentRepository.findCommentsForEvent(comment.getEvent().getId());
    }

    public Set<Comment> findCommentsForEvent(Long eid) {
        return commentRepository.findCommentsForEvent(eid);
    }

    public boolean updateComment(Comment comment)
    {
        //hardcode like update
        Comment comment1=commentRepository.findById(comment.getId()).get();
        comment1.setLikes(comment1.getLikes()+1);
        commentRepository.save(comment1);
        return true;
    }
}
