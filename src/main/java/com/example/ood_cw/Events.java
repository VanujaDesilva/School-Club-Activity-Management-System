package com.example.ood_cw;

import java.time.LocalDate;

public abstract class Events {
    private String eventLocation;
    private String eventTime;
    private String eventDescription;
    private LocalDate eventDate;

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }
}
