package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageClub {
    public TextField updateClubName;
    public DatePicker updateClubDate;
    public TextField updateClubMission;
    public TextArea updateClubDescription;
    public TextField updateClubPresident;
    public TextField updateClubAdvisor;
    public TextField updateClubEmail;
    public TextField updateClubContactNo;
    public ImageView updateClubIcon;
    public Button showClub;

    public TextField showName;
    public Button updateClub;
    public Label uNameTick;
    public Label uPresidentTick;
    public Label uAdvisorTick;
    public Label uEmailTick;
    public Label uContactTick;
    public Label uDateTick;
    public Label showTick;
    public Button uInsertIcon;
    public static int listIndex;
    public File updateFile;

    public static List<List<Object>> mainList = CreateClub.mainList;

    Club updateClubInstance = new Club();

    public void onShowClubButtonClick() throws IOException {
        updateClubInstance.setName(updateClubName.getText());  //setting the club name input from the textField to the club object

        //checking if the club name is empty
        if (!updateClubInstance.getName().isEmpty()) {
            //checking if the same club name exists
            for (List<Object> d : mainList) {
                if (d.get(0).equals(updateClubInstance.getName())) {
                    listIndex =mainList.indexOf(d);
                    updateClubName.setStyle("-fx-text-fill: green;");
                    showTick.setText("\u2713");

                    //displays the existing item details
                    showName.setText(String.valueOf(d.get(0)));

                    LocalDate updateFoundingDate = updateClubDate.getValue();
                    updateClubDate.setValue(updateFoundingDate);

                    updateClubMission.setText(String.valueOf(d.get(2)));
                    updateClubDescription.setText(String.valueOf(d.get(3)));
                    updateClubPresident.setText(String.valueOf(d.get(4)));
                    updateClubAdvisor.setText(String.valueOf(d.get(5)));
                    updateClubEmail.setText(String.valueOf(d.get(6)));
                    updateClubContactNo.setText(String.valueOf(d.get(7)));

                    File Updatefile = new File(String.valueOf(d.get(8)));
                    Image updateImage = new Image(Updatefile.toURI().toString());
                    updateClubIcon.setImage(updateImage);

                } else {
                    updateClubName.setStyle("-fx-text-fill: red;");
                    uNameTick.setText("\u2717");
                }
            }

        }
        else {
            updateClubName.setStyle("-fx-text-fill: red;");
            uNameTick.setText("\u2605");
        }
    }



    public void onUpdateButtonClick() throws IOException{
        updateClubInstance.setIcon(mainList.get(listIndex).get(7).toString());
        mainList.remove(listIndex); //removing the old item data from the list

        //setting the club name
        //checking if the club name is empty
        if (!updateClubName.getText().trim().isEmpty()) {
            //checking if the same club name exists
            for (List<Object> e : mainList) {
                if (e.get(0).equals(updateClubInstance.getName())) {
                    updateClubName.setStyle("-fx-text-fill: red;");
                    uNameTick.setText("\u2717");
                } else {
                    updateClubInstance.setName(updateClubName.getText());
                    updateClubName.setStyle("-fx-text-fill: green;");
                    uNameTick.setText("\u2713");
                }
            }
        }
        else {
            updateClubName.setStyle("-fx-text-fill: red;");
            uNameTick.setText("\u2605");
        }

        //setting the club date
        updateClubDate.valueProperty().addListener((observable, oldValue, newValue) -> {
            //checking if the founding date is empty
            if (newValue != null) {
                //checking if the entered date is valid
                if (Club.isValidDate(newValue)) {
                    LocalDate foundingDate = updateClubDate.getValue();
                    updateClubInstance.setFoundingDate(foundingDate);
                    updateClubDate.setStyle("-fx-text-fill: green;");
                    uDateTick.setText("\u2713"); //tick
                } else {
                    updateClubDate.setStyle("-fx-text-fill: red;");
                    uDateTick.setText("\u2717"); //cross
                }
            } else {
                updateClubDate.setStyle("-fx-text-fill: red;");
                uNameTick.setText("\u2605");  //star
            }
        });


        //setting the club mission
        updateClubInstance.setMission(updateClubMission.getText());

        //setting the club description
        updateClubInstance.setDescription(updateClubDescription.getText());

        //setting the club president
        //checking if the club president name is empty
        if (!updateClubPresident.getText().trim().isEmpty()) {
            //checking if the same club president exists
            for (List<Object> f : mainList) {
                if (f.get(4).equals(updateClubInstance.getClubPresidentName())) {
                    updateClubPresident.setStyle("-fx-text-fill: red;");
                    uPresidentTick.setText("\u2717");
                } else {
                    updateClubInstance.setClubPresidentName(updateClubPresident.getText());
                    updateClubPresident.setStyle("-fx-text-fill: green;");
                    uPresidentTick.setText("\u2713");
                }
            }
        } else {
            updateClubPresident.setStyle("-fx-text-fill: red;");
            uPresidentTick.setText("\u2605");
        }

        //setting the club advisor
        //checking if the club advisor name is empty
        if (!updateClubAdvisor.getText().trim().isEmpty()) {
            //checking if the same club advisor exists
            for (List<Object> g : mainList) {
                if (g.get(5).equals(updateClubInstance.getClubAdvisorName())) {
                    updateClubAdvisor.setStyle("-fx-text-fill: red;");
                    uAdvisorTick.setText("\u2717");
                } else {
                    updateClubInstance.setClubAdvisorName(updateClubAdvisor.getText());
                    updateClubAdvisor.setStyle("-fx-text-fill: green;");
                    uAdvisorTick.setText("\u2713");
                }
            }
        } else {
            updateClubAdvisor.setStyle("-fx-text-fill: red;");
            uAdvisorTick.setText("\u2605");
        }


        //setting the club email
        //checking if the club email is empty
        if (!updateClubEmail.getText().trim().isEmpty()) {
            //checking if the entered email is valid
            if (Club.isValidEmail(updateClubEmail.getText())) {
                updateClubInstance.setEmail(updateClubEmail.getText());
                updateClubEmail.setStyle("-fx-text-fill: green;");
                uEmailTick.setText("\u2713");
            } else {
                updateClubEmail.setStyle("-fx-text-fill: red;");
                uEmailTick.setText("\u2717");
            }
        } else {
            updateClubEmail.setStyle("-fx-text-fill: red;");
            uEmailTick.setText("\u2605");
        }


        updateClubContactNo.textProperty().addListener((observable, oldValue, newValue) -> {
            //checking if the contact number is empty
            if (newValue != null) {
                if (Club.isValidContactNo(newValue)) {
                    String contactNumFull = "+94" + newValue;
                    updateClubInstance.setContactNo(contactNumFull);
                    updateClubContactNo.setStyle("-fx-text-fill: green;");
                    uContactTick.setText("\u2713");
                } else {
                    updateClubContactNo.setStyle("-fx-text-fill: red;");
                    uContactTick.setText("\u2717");
                }
            } else {
                updateClubContactNo.setStyle("-fx-text-fill: red;");
                uContactTick.setText("\u2605");
            }
        });



        if (updateFile == null){
//            Stage emptyImageInput = new Stage(); //loading the error window
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("errorImage.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
//            emptyImageInput.setTitle("ERROR!");
//            emptyImageInput.setScene(scene);
//            emptyImageInput.show();
            //break;
        }
        else {
            updateClubInstance.setIcon(updateFile.getAbsolutePath());
        }

        //creating a sublist
        List<Object> subList = new ArrayList<>();

        //adding the item instances to the sublist
        subList.add(updateClubInstance.getName());
        subList.add(updateClubInstance.getFoundingDate());
        subList.add(updateClubInstance.getMission());
        subList.add(updateClubInstance.getDescription());
        subList.add(updateClubInstance.getClubPresidentName());
        subList.add(updateClubInstance.getClubAdvisorName());
        subList.add(updateClubInstance.getEmail());
        subList.add(updateClubInstance.getContactNo());
        subList.add(updateClubInstance.getIcon());

        mainList.add(subList); //adding the sublist to the main list
        //break;
    }


    public void onUpdateIconClick() throws IOException{
        FileChooser filePath = new FileChooser();
        updateFile = filePath.showOpenDialog(null); //assign file path to a File variable
        if (updateFile != null) { //check whether user select image or not
            Image image = new Image(updateFile.getAbsolutePath()); // get image path
            updateClubIcon.setImage(image);
        }
    }
}
