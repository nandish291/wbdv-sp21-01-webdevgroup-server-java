package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class EventDetails {
    Event event;
    List<Comment> comment;
    List<Media> media;
}
