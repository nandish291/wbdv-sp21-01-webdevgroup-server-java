package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venue{
    public int id;
    public String name;
    public String city;
    public String state;
    public String postalCode;
    public String country;
    public int venueConfigId;
    public String venueConfigName;
}
