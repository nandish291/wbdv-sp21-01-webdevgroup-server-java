package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ancestors{
    public List<Category> categories;
    public List<Grouping> groupings;
}
