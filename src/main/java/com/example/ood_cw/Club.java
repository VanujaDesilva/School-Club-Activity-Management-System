package com.example.ood_cw;

import java.time.LocalDate;

public class Club {

    //variable declarations
    private String id;
    private String name;
    private LocalDate foundingDate;
    private String mission;
    private String description;
    private String email;
    private String contactNo;
    private String icon;
    private String clubPresidentName;
    private String clubAdvisorId;
    private String stringDate;

    //default constructor
    public Club(){}

    //parameterized constructors
    public Club(String name, LocalDate foundingDate, String mission, String description, String presidentName, String email, String contactNo, String icon){
        this.name = name;
        this.foundingDate = foundingDate;
        this.mission = mission;
        this.description = description;
        this.clubPresidentName = presidentName;
        this.email = email;
        this.contactNo = contactNo;
        this.icon = icon;
    }

    public Club(String id, String name, String stringDate, String mission, String description, String presidentName, String clubAdvisorId, String email, String contactNo, String icon){
        this.id = id;
        this.name = name;
        this.stringDate = stringDate;
        this.mission = mission;
        this.description = description;
        this.clubPresidentName = presidentName;
        this.clubAdvisorId = clubAdvisorId;
        this.email = email;
        this.contactNo = contactNo;
        this.icon = icon;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        this.foundingDate = foundingDate;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getClubPresidentName() {
        return clubPresidentName;
    }

    public void setClubPresidentName(String clubPresidentName) {
        this.clubPresidentName = clubPresidentName;
    }

    public String getAdvisorId() {
        return clubAdvisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.clubAdvisorId = clubAdvisorId;
    }
    public void setClubAdvisorId(String clubAdvisorId) {
        this.clubAdvisorId = clubAdvisorId;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

    public String getClubAdvisorId() {
        return clubAdvisorId;
    }

    public String getStringDate() {
        return stringDate;
    }

    //validation for the contact number input
    public static boolean isValidContactNo(String contactNumber) {
        return contactNumber.matches("\\d{9}");
    }

    //validation for the date input
    public static boolean isValidDate(LocalDate date) {
        return !date.isAfter(LocalDate.now());
    }

    //validation for the email input
    public static boolean isValidEmail(String email) {
        //using a regular expression for the validation
        String emailRegExpress = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";
        return email.matches(emailRegExpress);
    }
}