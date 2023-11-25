package com.example.ood_cw;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    public static List<List<Object>> mainList = new ArrayList<>();
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
    public Label nameTick;
    public Label dateTick;
    public Label emailTick;
    public Label contactTick;
    public Label presidentTick;
    public Label advisorTick;


    private String name;
    private DatePicker foundingDate;
    private String mission;
    private String description;
    private String email;
    private String contactNo;
    private Image icon;
    private String presidentName;
    private String clubAdvisorName;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundingDate() {
        return foundingDate.getValue();
    }

    public void setFoundingDate(DatePicker foundingDate) {
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
        Club clubInstance = new Club();

        outer:
        while (true){
            int errorCheck = 0;
            int emptyCheck = 0;

            //setting the club name
            //checking if the club name is empty
            if(!clubName.getText().trim().isEmpty()) {
                //checking if the same club name exists
                for (List<Object> a : mainList) {
                    if (a.get(0).equals(clubInstance.getName())) {
                        clubName.setStyle("-fx-text-fill: red;");
                        clubInstance.nameTick.setText("\u2717");
                    } else {
                        clubInstance.setName(clubName.getText());
                        clubName.setStyle("-fx-text-fill: green;");
                        clubInstance.nameTick.setText("\u2713");
                    }
                }
            }
            else {
                clubName.setStyle("-fx-text-fill: red;");
                clubInstance.nameTick.setText("\u2605");
            }

            //setting the club date
            clubDate.valueProperty().addListener((observable, oldValue, newValue) -> {
                //checking if the founding date is empty
                if (newValue != null) {
                    //checking if the entered date is valid
                    if (isValidDate(newValue)){
                        clubInstance.setFoundingDate(clubDate);
                        clubDate.setStyle("-fx-text-fill: green;");
                        clubInstance.dateTick.setText("\u2713"); //tick
                    }
                    else {
                        clubDate.setStyle("-fx-text-fill: red;");
                        clubInstance.dateTick.setText("\u2717"); //cross
                    }
                }
                else {
                    clubDate.setStyle("-fx-text-fill: red;");
                    clubInstance.dateTick.setText("\u2605");  //star
                }
            });


            //setting the club mission
            clubInstance.setMission(clubMission.getText());

            //setting the club description
            clubInstance.setDescription(clubDescription.getText());

            //setting the club president
            //checking if the club president name is empty
            if(!clubPresident.getText().trim().isEmpty()) {
                //checking if the same club president exists
                for (List<Object> b : mainList) {
                    if (b.get(4).equals(clubInstance.getPresidentName())) {
                        clubPresident.setStyle("-fx-text-fill: red;");
                        clubInstance.presidentTick.setText("\u2717");
                    } else {
                        clubInstance.setPresidentName(clubPresident.getText());
                        clubPresident.setStyle("-fx-text-fill: green;");
                        clubInstance.nameTick.setText("\u2713");
                    }
                }
            }
            else {
                clubPresident.setStyle("-fx-text-fill: red;");
                clubInstance.presidentTick.setText("\u2605");
            }

            //setting the club advisor
            //checking if the club advisor name is empty
            if(!clubAdvisor.getText().trim().isEmpty()) {
                //checking if the same club advisor exists
                for (List<Object> c: mainList){
                    if (c.get(5).equals(clubInstance.getClubAdvisorName())){
                        clubAdvisor.setStyle("-fx-text-fill: red;");
                        clubInstance.advisorTick.setText("\u2717");
                    }
                    else {
                        clubInstance.setClubAdvisorName(clubAdvisor.getText());
                        clubAdvisor.setStyle("-fx-text-fill: green;");
                        clubInstance.advisorTick.setText("\u2713");
                    }
                }
            }
            else {
                clubAdvisor.setStyle("-fx-text-fill: red;");
                clubInstance.advisorTick.setText("\u2605");
            }


            //setting the club email
            //checking if the club email is empty
            if (!clubEmail.getText().trim().isEmpty()) {
                //checking if the entered email is valid
                if (isValidEmail(clubEmail.getText())){
                    clubInstance.setEmail(clubEmail.getText());
                    clubEmail.setStyle("-fx-text-fill: green;");
                    clubInstance.emailTick.setText("\u2713");
                }
                else {
                    clubEmail.setStyle("-fx-text-fill: red;");
                    clubInstance.emailTick.setText("\u2717");
                }
            }
            else {
                clubEmail.setStyle("-fx-text-fill: red;");
                clubInstance.emailTick.setText("\u2605");
            }


            clubContactNo.textProperty().addListener((observable, oldValue, newValue) -> {
                //checking if the founding date is empty
                if (newValue != null) {
                    if (isValidContactNo(newValue)) {
                        String contactNumFull = "+94" + newValue;
                        clubInstance.setContactNo(contactNumFull);
                        clubContactNo.setStyle("-fx-text-fill: green;");
                        clubInstance.contactTick.setText("\u2713");
                    } else {
                        clubContactNo.setStyle("-fx-text-fill: red;");
                        clubInstance.contactTick.setText("\u2717");
                    }
                }
                else {
                    clubContactNo.setStyle("-fx-text-fill: red;");
                    clubInstance.contactTick.setText("\u2605");
                }
            });


            //clubInstance.setIcon();



        }
    }

    private boolean isValidContactNo(String contactNo) {
        return contactNo.matches("\\d{9}");
    }

    private boolean isValidDate(LocalDate date) {
        return !date.isAfter(LocalDate.now());
    }

    private boolean isValidEmail(String email) {
        //using a regular expression for the validation
        String emailRegExpress = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";
        return email.matches(emailRegExpress);
    }

    public void onDeleteButtonClick() throws IOException{
    }

    public void onInsertImageClick() throws IOException{
    }
}
