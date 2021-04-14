package com.webdevgroup.sp2101webdevegroupserverjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "venues")
public class Venue{
    @Id
    private Long id;
    private String city;
    private String name;
    private String country;
    private String state;
}
