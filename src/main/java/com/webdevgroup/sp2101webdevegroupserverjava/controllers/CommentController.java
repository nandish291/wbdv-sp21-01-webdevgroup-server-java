package com.webdevgroup.sp2101webdevegroupserverjava.controllers;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Comment;
import com.webdevgroup.sp2101webdevegroupserverjava.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService service;

    @PostMapping("/event/comment")
    public boolean addComment(@RequestBody Comment comment)
    {
        return service.addComment(comment);
    }
}
