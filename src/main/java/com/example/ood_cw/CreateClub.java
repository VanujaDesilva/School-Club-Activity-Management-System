package com.example.ood_cw;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateClub {

    //importing lists from controller
    @FXML
    public static List<List<Object>> mainList = HelloController.mainList;
    @FXML
    public static List<String> advisorList = HelloController.advisorID;

    //variable declarations
    @FXML
    public TextField clubName;
    @FXML
    public DatePicker clubDate;
    @FXML
    public TextField clubMission;
    @FXML
    public TextArea clubDescription;
    @FXML
    public TextField clubPresident;
    @FXML
    public TextField clubEmail;
    @FXML
    public TextField clubContactNo;
    @FXML
    public ImageView clubIcon;
    @FXML
    public Button clubCreate;
    @FXML
    public Button imageInsert;
    @FXML
    public File createFile;
    @FXML
    public Label dateTick;
    @FXML
    public Label emailTick;
    @FXML
    public Label contactTick;
    @FXML
    public Label presidentTick;
    @FXML
    public Label nameTick;
    @FXML
    public AnchorPane imagePane;
    @FXML
    public Label promptLabelCreate;
    @FXML
    public AnchorPane clubCreationPane;
    @FXML
    public Button backClubCreate;


    //create club functionality
    public void onCreateButtonClick() throws SQLException {
        //creating an instance of the club object
        Club createClubInstance = new Club();

        outer:
        while (true) {
            int errorCheck = 0;
            int emptyCheck = 0;

            //setting the club name
            createClubInstance.setName(clubName.getText());
            //checking if the club name is empty
            if (!createClubInstance.getName().isEmpty()) {
                //checking if the club name is only alphabetical
//                if (!newValue.matches("[a-zA-Z]*")){
//                    clubName.setText(oldValue); //if not reverts back the text
//                    clubName.setStyle("-fx-text-fill: red;");
//                    nameTick.setText("\u2717");
//                }
//                else {

//                }
                //checking if the same club name exists
                for (List<Object> a : mainList) {
                    if (a.get(1).equals(createClubInstance.getName())) {
                        promptLabelCreate.setText("Club already exists!"); //displaying prompt text
                        promptLabelCreate.setStyle("-fx-text-fill: red;");
                        clubName.setStyle("-fx-border-color: red;");
                        nameTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                clubName.setStyle("-fx-border-color: green;");
                nameTick.setText("\u2713");
            } else {  //validation when club name is empty
                promptLabelCreate.setText("Please fill out all required inputs!");//displaying prompt text
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubName.setStyle("-fx-border-color: red;");
                nameTick.setText("\u2605");
                emptyCheck++;
            }


            //setting the club date
            LocalDate foundingDate = clubDate.getValue();
            createClubInstance.setFoundingDate(foundingDate);
            //checking if the founding date is empty
            if (createClubInstance.getFoundingDate() != null) {
                //checking if the entered date is valid
                if (Club.isValidDate(createClubInstance.getFoundingDate())) {
                    clubDate.setStyle("-fx-border-color: green;");
                    dateTick.setText("\u2713"); //tick
                } else {
                    promptLabelCreate.setText("Founding Date cannot be in the future!"); //displaying prompt text
                    promptLabelCreate.setStyle("-fx-text-fill: red;");
                    clubDate.setStyle("-fx-border-color: red;");
                    dateTick.setText("\u2717"); //cross
                    errorCheck++;
                }
            } else { //validation when date is empty
                promptLabelCreate.setText("Please fill out all required inputs!"); //displaying prompt text
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubDate.setStyle("-fx-border-color: red;");
                dateTick.setText("\u2605");  //star
                emptyCheck++;
            }


            //setting the club mission
            createClubInstance.setMission(clubMission.getText());

            //setting the club description
            createClubInstance.setDescription(clubDescription.getText());

            //setting the club president
            createClubInstance.setClubPresidentName(clubPresident.getText());
            //checking if the club president name is empty
            if (!createClubInstance.getClubPresidentName().isEmpty()) {
                //checking if the same club president exists
                for (List<Object> b : mainList) {
                    if (b.get(5).equals(createClubInstance.getClubPresidentName())) {
                        promptLabelCreate.setText("Club President already exists!"); //displaying prompt text
                        promptLabelCreate.setStyle("-fx-text-fill: red;");
                        clubPresident.setStyle("-fx-border-color: red;");
                        presidentTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                clubPresident.setStyle("-fx-border-color: green;");
                presidentTick.setText("\u2713");
            } else {  //validation when president name is empty
                promptLabelCreate.setText("Please fill out all required inputs!"); //displaying prompt text
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubPresident.setStyle("-fx-border-color: red;");
                presidentTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club email
            createClubInstance.setEmail(clubEmail.getText());
            //checking if the club email is empty
            if (!createClubInstance.getEmail().isEmpty()) {
                //checking if the entered email is valid
                if (Club.isValidEmail(createClubInstance.getEmail())) {
                    clubEmail.setStyle("-fx-border-color: green;");
                    emailTick.setText("\u2713");
                } else {
                    promptLabelCreate.setText("Please enter valid email!"); //displaying prompt text
                    promptLabelCreate.setStyle("-fx-text-fill: red;");
                    clubEmail.setStyle("-fx-border-color: red;");
                    emailTick.setText("\u2717");
                    errorCheck++;
                }
            } else {  //validation when email is empty
                promptLabelCreate.setText("Please fill out all required inputs!"); //displaying prompt text
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubEmail.setStyle("-fx-border-color: red;");
                emailTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club contact number
            createClubInstance.setContactNo("+94" + clubContactNo.getText());
            //checking if the contact number is empty
            if (clubContactNo.getText() != null) {
                if (Club.isValidContactNo(clubContactNo.getText())) {
                    clubContactNo.setStyle("-fx-border-color: green;");
                    contactTick.setText("\u2713");
                } else {
                    promptLabelCreate.setText("Please enter valid contact number!"); //displaying prompt text
                    promptLabelCreate.setStyle("-fx-text-fill: red;");
                    clubContactNo.setStyle("-fx-border-color: red;");
                    contactTick.setText("\u2717");
                    errorCheck++;
                }
            } else {  //validation when contact number is empty
                promptLabelCreate.setText("Please fill out all required inputs!"); //displaying prompt text
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubContactNo.setStyle("-fx-border-color: red;");
                contactTick.setText("\u2605");
                emptyCheck++;
            }

            //checking if image input is empty
            if (createFile == null) {
                promptLabelCreate.setText("Please add an icon!");
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                imagePane.setStyle("-fx-border-color: red; -fx-border-width: 3;");
                errorCheck++;
            } else {
                imagePane.setStyle("-fx-border-color: green; -fx-border-width: 3;");
                createClubInstance.setIcon(createFile.getAbsolutePath());
            }
            //checking empty inputs
            if (createClubInstance.getName().isEmpty() && createClubInstance.getFoundingDate()==null && createClubInstance.getClubPresidentName().isEmpty() && createClubInstance.getEmail().isEmpty() && clubContactNo.getText().isEmpty() && createFile==null){
                promptLabelCreate.setText("Please fill out all required inputs!"); //displaying prompt text
            }

            if (emptyCheck != 0) { //checking for any empty inputs
                break;
            }
            if(errorCheck != 0){ //checking for any errors
                break;
            }

            //generating clubID
            int max =0;
            for (int i = 0 ; i < mainList.size() ; i++){
                String c = (String) mainList.get(i).get(0);
                int currentValue = Integer.parseInt(c.substring(1,4));
                if (max < currentValue){
                    max = currentValue;
                }
            }
            max++;
            String clubID = String.format("%03d",max);
            clubID="C"+clubID;

            //importing advisorID
            String advisorID = advisorList.get(0);


            //creating a sublist
            List<Object> subList = new ArrayList<>();

            //adding the item instances to the sublist
            subList.add(clubID);
            subList.add(createClubInstance.getName());
            subList.add(createClubInstance.getFoundingDate());
            subList.add(createClubInstance.getMission());
            subList.add(createClubInstance.getDescription());
            subList.add(createClubInstance.getClubPresidentName());
            subList.add(advisorID);
            subList.add(createClubInstance.getEmail());
            subList.add(createClubInstance.getContactNo());
            subList.add(createClubInstance.getIcon());

            mainList.add(subList); //adding the sublist to the main list
            HelloController.clubs.add(subList);

            System.out.println(mainList);
            System.out.println(HelloController.clubs);
            promptLabelCreate.setText("Club Successfully Created!"); //displaying prompt text
            DatabaseConnect.insertDetailsOfClubs(String.valueOf(clubID),String.valueOf(createClubInstance.getName()), String.valueOf(createClubInstance.getFoundingDate()), String.valueOf(createClubInstance.getMission()), String.valueOf(createClubInstance.getDescription()), String.valueOf(createClubInstance.getClubPresidentName()), String.valueOf(advisorID), String.valueOf(createClubInstance.getEmail()), String.valueOf(createClubInstance.getContactNo()), String.valueOf(createClubInstance.getIcon()));
            promptLabelCreate.setStyle("-fx-text-fill: green;");
            break;
        }
    }

    //image insertion method
    public void onInsertImageClick() {
        imagePane.setStyle("-fx-border-color: black; -fx-border-width: 3;");
        FileChooser filePath = new FileChooser();
        filePath.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.webp"));
        createFile = filePath.showOpenDialog(null); //assign file path to a File variable
        if (createFile != null) { //check whether user select image or not
            Image image = new Image(createFile.getAbsolutePath()); // get image path
            clubIcon.setImage(image);
        }
    }

    //back button functionality
    public void onBackClubCreateClick() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        clubCreationPane.getChildren().setAll(pane);
    }
}
