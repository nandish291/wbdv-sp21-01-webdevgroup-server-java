package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Events {
    int numFound;
    Set<Event> events;
}
