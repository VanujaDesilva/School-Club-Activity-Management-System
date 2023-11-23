package com.example.ood_cw;

import java.time.LocalDate;

public class Event extends Events{
    private String eventName;

    public Event() {
    }



    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

}
