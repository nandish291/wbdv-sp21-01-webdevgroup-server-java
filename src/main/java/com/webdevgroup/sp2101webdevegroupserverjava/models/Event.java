package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event{
    public int id;
    public String name;
    public String status;
    public String webURI;
    public Date eventDateLocal;
    public Date eventDateUTC;
    public Date createdDate;
    public Date lastUpdatedDate;
    public boolean hideEventDate;
    public boolean hideEventTime;
    public Venue venue;
    public String timezone;
    public Ancestors ancestors;
}
