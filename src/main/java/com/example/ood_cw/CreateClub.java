package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

    public File createFile;
    public Label dateTick;
    public Label emailTick;
    public Label contactTick;
    public Label presidentTick;
    public Label advisorTick;
    public Label nameTick;
    public AnchorPane imagePane;
    public Label promptLabelCreate;

    public static List<List<Object>> checkList = new ArrayList<>();

    public void initialize() {

        List<Object> subCheck1 = new ArrayList<>();
        subCheck1.add("C001");
        subCheck1.add("Interact Club");
        subCheck1.add("2023-11-25");
        subCheck1.add("Light from heaven");
        subCheck1.add("Social Service");
        subCheck1.add("Tharusha Fernando");
        subCheck1.add("Uththara Godahenage");
        subCheck1.add("interact@gmail.com");
        subCheck1.add("+94712345672");
        subCheck1.add("C:\\Users\\Tharusha\\Pictures\\abc.jpg");
        checkList.add(subCheck1);

        List<Object> subCheck2 = new ArrayList<>();
        subCheck2.add("C002");
        subCheck2.add("Leo Club");
        subCheck2.add("2023-11-15");
        subCheck2.add("We lead others follow");
        subCheck2.add("Helping others");
        subCheck2.add("Yeran Fernando");
        subCheck2.add("Sarath Bandara");
        subCheck2.add("leo@gmail.com");
        subCheck2.add("+94771231167");
        subCheck2.add("C:\\Users\\Tharusha\\Pictures\\def.jpg");
        checkList.add(subCheck2);

        List<Object> subCheck3 = new ArrayList<>();
        subCheck3.add("C003");
        subCheck3.add("IEEE Club");
        subCheck3.add("2023-11-08");
        subCheck3.add("Experimenting new virtues");
        subCheck3.add("Spreading knowledge");
        subCheck3.add("Vanuja Silva");
        subCheck3.add("Oggy Perera");
        subCheck3.add("ieee@gmail.com");
        subCheck3.add("+94781231167");
        subCheck3.add("C:\\Users\\Tharusha\\Pictures\\ghi.jpg");
        checkList.add(subCheck3);

    }


    public void onCreateButtonClick() throws IOException {
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
                    if (a.get(0).equals(createClubInstance.getName())) {
                        promptLabelCreate.setText("Club already exists!");
                        promptLabelCreate.setStyle("-fx-text-fill: red;");
                        clubName.setStyle("-fx-border-color: red;");
                        nameTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                clubName.setStyle("-fx-border-color: green;");
                nameTick.setText("\u2713");
            } else {
                promptLabelCreate.setText("Please fill out all required inputs!");
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
                    promptLabelCreate.setText("Founding Date cannot be in the future!");
                    promptLabelCreate.setStyle("-fx-text-fill: red;");
                    clubDate.setStyle("-fx-border-color: red;");
                    dateTick.setText("\u2717"); //cross
                    errorCheck++;
                }
            } else {
                promptLabelCreate.setText("Please fill out all required inputs!");
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
                    if (b.get(4).equals(createClubInstance.getClubPresidentName())) {
                        promptLabelCreate.setText("Club President already exists!");
                        promptLabelCreate.setStyle("-fx-text-fill: red;");
                        clubPresident.setStyle("-fx-border-color: red;");
                        presidentTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                clubPresident.setStyle("-fx-border-color: green;");
                presidentTick.setText("\u2713");
            } else {
                promptLabelCreate.setText("Please fill out all required inputs!");
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubPresident.setStyle("-fx-border-color: red;");
                presidentTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club advisor
            createClubInstance.setClubAdvisorName(clubAdvisor.getText());
            //checking if the club advisor name is empty
            if (!createClubInstance.getClubAdvisorName().isEmpty()) {
                //checking if the same club advisor exists
                for (List<Object> c : mainList) {
                    if (c.get(5).equals(createClubInstance.getClubAdvisorName())) {
                        promptLabelCreate.setText("Club Advisor already exists!");
                        promptLabelCreate.setStyle("-fx-text-fill: red;");
                        clubAdvisor.setStyle("-fx-border-color: red;");
                        advisorTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                clubAdvisor.setStyle("-fx-border-color: green;");
                advisorTick.setText("\u2713");
            } else {
                promptLabelCreate.setText("Please fill out all required inputs!");
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubAdvisor.setStyle("-fx-border-color: red;");
                advisorTick.setText("\u2605");
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
                    promptLabelCreate.setText("Please enter valid email!");
                    promptLabelCreate.setStyle("-fx-text-fill: red;");
                    clubEmail.setStyle("-fx-border-color: red;");
                    emailTick.setText("\u2717");
                    errorCheck++;
                }
            } else {
                promptLabelCreate.setText("Please fill out all required inputs!");
                promptLabelCreate.setStyle("-fx-text-fill: red;");
                clubEmail.setStyle("-fx-border-color: red;");
                emailTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club contact number
            //String contactNumFull = "+94" + clubContactNo.getText();
            createClubInstance.setContactNo("+94" + clubContactNo.getText());
            //checking if the contact number is empty
            if (clubContactNo.getText() != null) {
                if (Club.isValidContactNo(clubContactNo.getText())) {
                    clubContactNo.setStyle("-fx-border-color: green;");
                    contactTick.setText("\u2713");
                } else {
                    promptLabelCreate.setText("Please enter valid contact number!");
                    promptLabelCreate.setStyle("-fx-text-fill: red;");
                    clubContactNo.setStyle("-fx-border-color: red;");
                    contactTick.setText("\u2717");
                    errorCheck++;
                }
            } else {
                promptLabelCreate.setText("Please fill out all required inputs!");
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
//            Stage emptyImageInput = new Stage(); //loading the error window
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("errorImage.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
//            emptyImageInput.setTitle("ERROR!");
//            emptyImageInput.setScene(scene);
//            emptyImageInput.show();
                errorCheck++;
            } else {
                imagePane.setStyle("-fx-border-color: green; -fx-border-width: 3;");
                createClubInstance.setIcon(createFile.getAbsolutePath());
            }

            if (emptyCheck != 0) { //checking for any empty inputs
                break;
            }
            if(errorCheck != 0){ //checking for any errors
                break;
            }

            //creating a sublist
            List<Object> subList = new ArrayList<>();

            //adding the item instances to the sublist
            subList.add(createClubInstance.getName());
            subList.add(createClubInstance.getFoundingDate());
            subList.add(createClubInstance.getMission());
            subList.add(createClubInstance.getDescription());
            subList.add(createClubInstance.getClubPresidentName());
            subList.add(createClubInstance.getClubAdvisorName());
            subList.add(createClubInstance.getEmail());
            subList.add(createClubInstance.getContactNo());
            subList.add(createClubInstance.getIcon());

            mainList.add(subList); //adding the sublist to the main list

            System.out.println(subList);
            System.out.println(mainList);
            promptLabelCreate.setText("Club Successfully Created!");
            promptLabelCreate.setStyle("-fx-text-fill: green;");
            break;
        }
    }

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
}
