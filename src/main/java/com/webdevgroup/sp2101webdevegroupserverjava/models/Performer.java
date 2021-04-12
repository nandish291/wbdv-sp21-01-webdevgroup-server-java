package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Performer{
    public String name;
    public String short_name;
    public String url;
    public String image;
    public Images images;
    public boolean primary;
    public int id;
    public int score;
    public String type;
    public String slug;
}
