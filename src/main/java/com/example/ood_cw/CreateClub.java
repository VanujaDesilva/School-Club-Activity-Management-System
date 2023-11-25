package com.example.ood_cw;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateClub {
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
    public Button imageInsert;

    public File fileAID;
    public Label dateTick;
    public Label emailTick;
    public Label contactTick;
    public Label presidentTick;
    public Label advisorTick;
    public Label nameTick;


    public void onCreateButtonClick() throws IOException {
        Club clubInstance = new Club();

//        outer:
        //while (true){
//            int errorCheck = 0;
//            int emptyCheck = 0;

        //setting the club name
        //checking if the club name is empty
        if (!clubName.getText().trim().isEmpty()) {
            //checking if the same club name exists
            for (List<Object> a : mainList) {
                if (a.get(0).equals(clubInstance.getName())) {
                    clubName.setStyle("-fx-text-fill: red;");
                    nameTick.setText("\u2717");
                } else {
                    clubInstance.setName(clubName.getText());
                    clubName.setStyle("-fx-text-fill: green;");
                    nameTick.setText("\u2713");
                }
            }
        } else {
            clubName.setStyle("-fx-text-fill: red;");
            nameTick.setText("\u2605");
        }

        //setting the club date
        clubDate.valueProperty().addListener((observable, oldValue, newValue) -> {
            //checking if the founding date is empty
            if (newValue != null) {
                //checking if the entered date is valid
                if (Club.isValidDate(newValue)) {
                    clubInstance.setFoundingDate(clubDate);
                    clubDate.setStyle("-fx-text-fill: green;");
                    dateTick.setText("\u2713"); //tick
                } else {
                    clubDate.setStyle("-fx-text-fill: red;");
                    dateTick.setText("\u2717"); //cross
                }
            } else {
                clubDate.setStyle("-fx-text-fill: red;");
                dateTick.setText("\u2605");  //star
            }
        });


        //setting the club mission
        clubInstance.setMission(clubMission.getText());

        //setting the club description
        clubInstance.setDescription(clubDescription.getText());

        //setting the club president
        //checking if the club president name is empty
        if (!clubPresident.getText().trim().isEmpty()) {
            //checking if the same club president exists
            for (List<Object> b : mainList) {
                if (b.get(4).equals(clubInstance.getClubPresidentName())) {
                    clubPresident.setStyle("-fx-text-fill: red;");
                    presidentTick.setText("\u2717");
                } else {
                    clubInstance.setClubPresidentName(clubPresident.getText());
                    clubPresident.setStyle("-fx-text-fill: green;");
                    nameTick.setText("\u2713");
                }
            }
        } else {
            clubPresident.setStyle("-fx-text-fill: red;");
            presidentTick.setText("\u2605");
        }

        //setting the club advisor
        //checking if the club advisor name is empty
        if (!clubAdvisor.getText().trim().isEmpty()) {
            //checking if the same club advisor exists
            for (List<Object> c : mainList) {
                if (c.get(5).equals(clubInstance.getClubAdvisorName())) {
                    clubAdvisor.setStyle("-fx-text-fill: red;");
                    advisorTick.setText("\u2717");
                } else {
                    clubInstance.setClubAdvisorName(clubAdvisor.getText());
                    clubAdvisor.setStyle("-fx-text-fill: green;");
                    advisorTick.setText("\u2713");
                }
            }
        } else {
            clubAdvisor.setStyle("-fx-text-fill: red;");
            advisorTick.setText("\u2605");
        }


        //setting the club email
        //checking if the club email is empty
        if (!clubEmail.getText().trim().isEmpty()) {
            //checking if the entered email is valid
            if (Club.isValidEmail(clubEmail.getText())) {
                clubInstance.setEmail(clubEmail.getText());
                clubEmail.setStyle("-fx-text-fill: green;");
                emailTick.setText("\u2713");
            } else {
                clubEmail.setStyle("-fx-text-fill: red;");
                emailTick.setText("\u2717");
            }
        } else {
            clubEmail.setStyle("-fx-text-fill: red;");
            emailTick.setText("\u2605");
        }


        clubContactNo.textProperty().addListener((observable, oldValue, newValue) -> {
            //checking if the founding date is empty
            if (newValue != null) {
                if (Club.isValidContactNo(newValue)) {
                    String contactNumFull = "+94" + newValue;
                    clubInstance.setContactNo(contactNumFull);
                    clubContactNo.setStyle("-fx-text-fill: green;");
                    contactTick.setText("\u2713");
                } else {
                    clubContactNo.setStyle("-fx-text-fill: red;");
                    contactTick.setText("\u2717");
                }
            } else {
                clubContactNo.setStyle("-fx-text-fill: red;");
                contactTick.setText("\u2605");
            }
        });


        //clubInstance.setIcon();
        if (fileAID == null){
//            Stage emptyImageInput = new Stage(); //loading the error window
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("errorImage.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
//            emptyImageInput.setTitle("ERROR!");
//            emptyImageInput.setScene(scene);
//            emptyImageInput.show();
            //break;
        }
        else {
            clubInstance.setIcon(fileAID.getAbsolutePath());
        }

        //creating a sublist
        List<Object> subList = new ArrayList<>();

        //adding the item instances to the sublist
        subList.add(clubInstance.getName());
        subList.add(clubInstance.getFoundingDate());
        subList.add(clubInstance.getMission());
        subList.add(clubInstance.getDescription());
        subList.add(clubInstance.getClubPresidentName());
        subList.add(clubInstance.getClubAdvisorName());
        subList.add(clubInstance.getEmail());
        subList.add(clubInstance.getContactNo());
        subList.add(clubInstance.getIcon());

        mainList.add(subList); //adding the sublist to the main list
        //break;


        //}
    }

    public void onInsertImageClick() throws IOException {
        FileChooser filePath = new FileChooser();
        filePath.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.webp"));
        fileAID = filePath.showOpenDialog(null); //assign file path to a File variable
        if (fileAID != null) { //check whether user select image or not
            Image image = new Image(fileAID.getAbsolutePath()); // get image path
            clubIcon.setImage(image);
        }
    }
}
