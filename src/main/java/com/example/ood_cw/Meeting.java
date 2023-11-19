package com.example.ood_cw;

public class Meeting extends Event{
    private String meetDuration;

    public Meeting() {
    }

    public void setMeetDuration(String meetDuration) {
        this.meetDuration = meetDuration;
    }

    public String getMeetDuration() {
        return meetDuration;
    }


}
