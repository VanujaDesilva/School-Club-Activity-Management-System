package com.example.ood_cw;

import java.time.LocalDate;

public class Activity extends Events{
    private LocalDate endDate;
    private String eventName;

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
