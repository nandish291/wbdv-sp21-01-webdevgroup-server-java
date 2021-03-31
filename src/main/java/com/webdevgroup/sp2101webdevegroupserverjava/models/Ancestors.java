package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ancestors{
    private List<Category> categories;
    private List<Grouping> groupings;
    private List<Performer> performers;
}
