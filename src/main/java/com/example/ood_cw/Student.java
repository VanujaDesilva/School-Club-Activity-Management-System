package com.example.ood_cw;

import javafx.scene.control.CheckBox;

public class Student {
    private String stdId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String dob;
    private CheckBox status;
    private String email;

    public Student(String stdId, String firstName, String lastName, String telNo, String dob, CheckBox status, String email) {
        this.stdId = stdId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.dob = dob;
        this.status = status;
        this.email = email;
    }
    Student(){

    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Student(String stdId, String firstName, String lastName, String telNo, String dob) {
        this.stdId = stdId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.dob = dob;
        this.status = new CheckBox();
    }

    public String getStdId() {

        return stdId;
    }

    public void setStdId(String stdId) {

        this.stdId = stdId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getTelNo() {

        return telNo;
    }

    public void setTelNo(String telNo) {

        this.telNo = telNo;
    }

    public String getDob() {

        return dob;
    }

    public void setDob(String dob) {

        this.dob = dob;
    }

    public CheckBox getStatus() {
        return status;
    }

    public void setStatus(CheckBox status) {
        this.status = status;
    }
}

