package com.webdevgroup.sp2101webdevegroupserverjava.models;


import lombok.Getter;
import lombok.Setter;

public class EventBasic {
    public Long[] eventIds;
    public String[] eventNames;

    public EventBasic() {
        this.eventIds = new Long[2];
        this.eventNames = new String[2];
    }
}
