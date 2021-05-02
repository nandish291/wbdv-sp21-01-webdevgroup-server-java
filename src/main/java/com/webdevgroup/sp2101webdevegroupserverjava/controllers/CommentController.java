package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Comment;
import com.webdevgroup.sp2101webdevegroupserverjava.models.Events;
import com.webdevgroup.sp2101webdevegroupserverjava.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://event-tracker-nm.herokuapp.com","http://wbdv-client-react-s1.herokuapp.com","https://wbdv-client-react-s1.herokuapp.com"})
public class CommentController {

    private final CommentService service;


    @GetMapping("/event/{eid}/comments")
    public Set<Comment>  getAllEvents(
            @PathVariable("eid") Long eid){
        return service.findCommentsForEvent(eid);
    }


    @PostMapping("/event/comment")
    public Comment addComment(@RequestBody Comment comment)
    {

        return service.addComment(comment);
    }

    @PutMapping("/event/comment")
    public boolean UpdateComment(@RequestBody Comment comment)
    {

        return service.updateComment(comment);
    }
}
