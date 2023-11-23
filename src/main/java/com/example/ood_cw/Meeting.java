package com.example.ood_cw;

public class Meeting extends Events{
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
