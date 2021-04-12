package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event{
    public String title;
    public String url;
    public Date datetime_local;
    public List<Performer> performers;
    public Venue venue;
    public String short_title;
    public Date datetime_utc;
    public double score;
    public String type;
    public int id;
}
