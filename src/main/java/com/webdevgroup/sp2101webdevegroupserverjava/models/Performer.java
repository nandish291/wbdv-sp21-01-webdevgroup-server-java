package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "performers")
public class Performer{
    @Id
    private Long id;
    private String name;
    private String short_name;
    private String image;
    private String type;
    private String slug;
}
