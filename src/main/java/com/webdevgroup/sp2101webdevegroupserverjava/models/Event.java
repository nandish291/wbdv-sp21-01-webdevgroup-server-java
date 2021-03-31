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
    private int id;
    private String name;
    private String status;
    private String webURI;
    private Date eventDateLocal;
    private Date eventDateUTC;
    private Date createdDate;
    private Date lastUpdatedDate;
    private boolean hideEventDate;
    private boolean hideEventTime;
    private Venue venue;
    private String timezone;
    private Ancestors ancestors;
}
