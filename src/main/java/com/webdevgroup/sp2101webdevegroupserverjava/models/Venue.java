package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venue{
    private int id;
    private String name;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int venueConfigId;
    private String venueConfigName;
}
