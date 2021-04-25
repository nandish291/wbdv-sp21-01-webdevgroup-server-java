package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Builder
public class EventDetails {
    Event event;
    Set<Comment> comment;
    Set<Media> media;
}
