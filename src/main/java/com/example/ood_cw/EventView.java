package com.example.ood_cw;

public class EventView {
    String eventId;
    String name;
    String location;
    String time;
    String description;
    String startDate;
    String endDate;
    String duration;
    String clubId;
    String advisorId;

    public EventView(String eventId, String name, String location, String time, String description, String startDate, String endDate, String duration, String clubId, String advisorId) {
        this.eventId = eventId;
        this.name = name;
        this.location = location;
        this.time = time;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.clubId = clubId;
        this.advisorId = advisorId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getClubId() {
        return clubId;
    }

    public String getAdvisorId() {
        return advisorId;
    }
}
