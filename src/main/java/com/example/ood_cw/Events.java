package com.example.ood_cw;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public abstract class Events {
    private String eventLocation;
    private String eventTime;
    private String eventDescription;
    private LocalDate eventDate;
    public void setLabel(Label l1, TextField l2, Label l3){
        l1.setText("This field must be filled!");
        l2.setStyle("-fx-border-color: red;");
        l3.setText("");
    }
    public void setLabel(Label l1, DatePicker l2, Label l3){
        l1.setText("This field must be filled!");
        l2.setStyle("-fx-border-color: red;");
        l3.setText("");
    }

    public void setLabelCorrect(Label l1,Label l2, TextField l3){
        l1.setText("");
        l2.setText("\u2713");
        l3.setStyle("-fx-border-color: #13e57d;");
    }

    public void setLabelCorrect(Label l1,Label l2, DatePicker l3){
        l1.setText("");
        l2.setText("\u2713");
        l3.setStyle("-fx-border-color: #13e57d;");
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
