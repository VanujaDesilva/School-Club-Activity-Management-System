package com.example.ood_cw;

import javafx.scene.control.CheckBox;

public class Advisor {
    private String AdId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String dob;
    private String email;
    Advisor(){

    }

    public static void setStyle(String s) {
    }

    public void setAdId(String adId) {
        AdId = adId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdId() {
        return AdId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelNo() {
        return telNo;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public Advisor(String adId, String firstName, String lastName, String telNo, String dob, String email) {
        AdId = adId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.dob = dob;
        this.email = email;
    }
}
