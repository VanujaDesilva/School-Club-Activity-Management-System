package com.example.ood_cw;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.time.LocalDate;

public class Club {
    public TextField clubName;
    public DatePicker clubDate;
    public TextField clubMission;
    public TextArea clubDescription;
    public TextField clubPresident;
    public TextField clubAdvisor;
    public TextField clubEmail;
    public TextField clubContactNo;
    public ImageView clubIcon;
    public Button clubCreate;
    public Button clubDelete;
    public Button imageInsert;


    private String name;
    private LocalDate foundingDate;
    private String mission;
    private String description;
    private String email;
    private String contactNo;
    private Image icon;
    private String presidentName;
    private String clubAdvisorName;

    Club clubInstance = new Club();


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

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getClubAdvisorName() {
        return clubAdvisorName;
    }

    public void setClubAdvisorName(String clubAdvisorName) {
        this.clubAdvisorName = clubAdvisorName;
    }

    public void onCreateButtonClick() throws IOException {
    }

    public void onDeleteButtonClick() throws IOException{
    }

    public void onInsertImageClick() throws IOException{
    }
}
