package com.example.ood_cw;

public class ClubAdvisor {
    private String advisorID;
    private String firstName;
    private String lastName;
    private int telNo;
    private String mail;

    public ClubAdvisor(String advisorID, String firstName, String lastName, int telNo, String mail) {
        this.advisorID = advisorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.mail = mail;
    }

    public String getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(String advisorID) {
        this.advisorID = advisorID;
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

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
