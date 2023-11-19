package com.example.ood_cw;

import java.time.LocalDate;

public class Event {
    private String eventName;
    private String eventLocation;
    private String eventTime;
    private String eventDescription;
    private LocalDate eventDate;

    public Event() {
    }

    public Event(String eventName, String eventLocation, String eventTime, String eventDescription, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
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

}
