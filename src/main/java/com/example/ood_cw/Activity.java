package com.example.ood_cw;

import java.time.LocalDate;

public class Activity extends Event{
    private LocalDate endDate;

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
