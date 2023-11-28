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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageClub {
    public DatePicker updateClubDate;
    public TextField updateClubMission;
    public TextArea updateClubDescription;
    public TextField updateClubPresident;
    //public TextField updateClubAdvisor;
    public TextField updateClubEmail;
    public TextField updateClubContactNo;
    public ImageView updateClubIcon;
    public Button showClub;

    public TextField showName;
    public Button updateClub;
    public Label uPresidentTick;
    //public Label uAdvisorTick;
    public Label uEmailTick;
    public Label uContactTick;
    public Label uDateTick;
    public Label showTick;
    public Button uInsertIcon;
    public static int listIndex;
    public File updateFile;

    public static List<List<Object>> mainList = HelloController.mainList;
    public Label showPromptUpdate;
    public AnchorPane updatePane;
    public Button backClubManage;
    public AnchorPane clubManagePane;

    String preImage;
    String image;

    Club updateClubInstance = new Club();

    public void onShowClubButtonClick() throws IOException {
        updateClubInstance.setName(showName.getText());  //setting the club name input from the textField to the club object

        //checking if the club name is empty
        try {
            //checking if the same club name exists
            for ( List<Object> d : mainList) {
                if (d.get(1).equals(updateClubInstance.getName())) {
                    listIndex =mainList.indexOf(d);
                    showPromptUpdate.setText("Club found!");
                    showName.setStyle("-fx-border-color: green;");
                    showTick.setText("\u2713");

                    //displays the existing item details
                    showName.setText(String.valueOf(d.get(1)));

//                    LocalDate updateFoundingDate = updateClubDate.getValue();
                    updateClubDate.setValue((LocalDate) d.get(2));

                    updateClubMission.setText(String.valueOf(d.get(3)));
                    updateClubDescription.setText(String.valueOf(d.get(4)));
                    updateClubPresident.setText(String.valueOf(d.get(5)));
                    //updateClubAdvisor.setText(String.valueOf(d.get(6)));
                    updateClubEmail.setText(String.valueOf(d.get(7)));
                    String contactShort = d.get(8).toString();
                    String contactNum = contactShort.substring(3,12);
                    updateClubContactNo.setText(contactNum);

                    File Updatefile = new File(String.valueOf(d.get(9)));
                    Image updateImage = new Image(Updatefile.toURI().toString());
                    updateClubIcon.setImage(updateImage);

                    preImage = d.get(9).toString();


                } else {
                    showName.setStyle("-fx-border-color: red;");
                    showTick.setText("\u2717");
                }
            }
        }
        catch (NullPointerException e) {
            showName.setStyle("-fx-border-color: red;");
            showTick.setText("\u2605");
        }
    }



    public void onUpdateButtonClick() throws IOException{
        updateClubInstance.setIcon(mainList.get(listIndex).get(9).toString());
        //mainList.remove(listIndex); //removing the old item data from the list

        outer:
        while (true) {
            int errorCheck = 0;
            int emptyCheck = 0;

            //setting the club name
            updateClubInstance.setName(showName.getText());
            //checking if the club name is empty
            if (!updateClubInstance.getName().isEmpty()) {
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
                    if (a.get(1).equals(updateClubInstance.getName())) {
                        showPromptUpdate.setText("Club already exists!");
                        showPromptUpdate.setStyle("-fx-text-fill: red;");
                        showName.setStyle("-fx-border-color: red;");
                        showTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                showName.setStyle("-fx-border-color: green;");
                showTick.setText("\u2713");
            } else {
                showPromptUpdate.setText("Please fill out all required inputs!");
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                showName.setStyle("-fx-border-color: red;");
                showTick.setText("\u2605");
                emptyCheck++;
            }


            //setting the club date
            LocalDate foundingDate = updateClubDate.getValue();
            updateClubInstance.setFoundingDate(foundingDate);
            //checking if the founding date is empty
            if (updateClubInstance.getFoundingDate() != null) {
                //checking if the entered date is valid
                if (Club.isValidDate(updateClubInstance.getFoundingDate())) {
                    updateClubDate.setStyle("-fx-border-color: green;");
                    uDateTick.setText("\u2713"); //tick
                } else {
                    showPromptUpdate.setText("Founding Date cannot be in the future!");
                    showPromptUpdate.setStyle("-fx-text-fill: red;");
                    updateClubDate.setStyle("-fx-border-color: red;");
                    uDateTick.setText("\u2717"); //cross
                    errorCheck++;
                }
            } else {
                showPromptUpdate.setText("Please fill out all required inputs!");
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubDate.setStyle("-fx-border-color: red;");
                uDateTick.setText("\u2605");  //star
                emptyCheck++;
            }


            //setting the club mission
            updateClubInstance.setMission(updateClubMission.getText());

            //setting the club description
            updateClubInstance.setDescription(updateClubDescription.getText());

            //setting the club president
            updateClubInstance.setClubPresidentName(updateClubPresident.getText());
            //checking if the club president name is empty
            if (!updateClubInstance.getClubPresidentName().isEmpty()) {
                //checking if the same club president exists
                for (List<Object> b : mainList) {
                    if (b.get(5).equals(updateClubInstance.getClubPresidentName())) {
                        showPromptUpdate.setText("Club President already exists!");
                        showPromptUpdate.setStyle("-fx-text-fill: red;");
                        updateClubPresident.setStyle("-fx-border-color: red;");
                        uPresidentTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                updateClubPresident.setStyle("-fx-border-color: green;");
                uPresidentTick.setText("\u2713");
            } else {
                showPromptUpdate.setText("Please fill out all required inputs!");
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubPresident.setStyle("-fx-border-color: red;");
                uPresidentTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club advisor
//            updateClubInstance.setClubAdvisorName(updateClubAdvisor.getText());
//            //checking if the club advisor name is empty
//            if (!updateClubInstance.getClubAdvisorName().isEmpty()) {
//                //checking if the same club advisor exists
//                for (List<Object> c : mainList) {
//                    if (c.get(6).equals(updateClubInstance.getClubAdvisorName())) {
//                        showPromptUpdate.setText("Club Advisor already exists!");
//                        showPromptUpdate.setStyle("-fx-text-fill: red;");
//                        updateClubAdvisor.setStyle("-fx-border-color: red;");
//                        uAdvisorTick.setText("\u2717");
//                        errorCheck++;
//                    }
//                }
//                updateClubAdvisor.setStyle("-fx-border-color: green;");
//                uAdvisorTick.setText("\u2713");
//            } else {
//                showPromptUpdate.setText("Please fill out all required inputs!");
//                showPromptUpdate.setStyle("-fx-text-fill: red;");
//                updateClubAdvisor.setStyle("-fx-border-color: red;");
//                uAdvisorTick.setText("\u2605");
//                emptyCheck++;
//            }


            //setting the club email
            updateClubInstance.setEmail(updateClubEmail.getText());
            //checking if the club email is empty
            if (!updateClubInstance.getEmail().isEmpty()) {
                //checking if the entered email is valid
                if (Club.isValidEmail(updateClubInstance.getEmail())) {
                    updateClubEmail.setStyle("-fx-border-color: green;");
                    uEmailTick.setText("\u2713");
                } else {
                    showPromptUpdate.setText("Please enter valid email!");
                    showPromptUpdate.setStyle("-fx-text-fill: red;");
                    updateClubEmail.setStyle("-fx-border-color: red;");
                    uEmailTick.setText("\u2717");
                    errorCheck++;
                }
            } else {
                showPromptUpdate.setText("Please fill out all required inputs!");
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubEmail.setStyle("-fx-border-color: red;");
                uEmailTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club contact number
            String contactNumSub = updateClubContactNo.getText();
            String contactNumReduced = contactNumSub.substring(3);
            updateClubInstance.setContactNo(contactNumReduced);
            //checking if the contact number is empty
            if (updateClubContactNo.getText() != null) {
                if (Club.isValidContactNo(updateClubContactNo.getText())) {
                    updateClubContactNo.setStyle("-fx-border-color: green;");
                    uContactTick.setText("\u2713");
                } else {
                    showPromptUpdate.setText("Please enter valid contact number!");
                    showPromptUpdate.setStyle("-fx-text-fill: red;");
                    updateClubContactNo.setStyle("-fx-border-color: red;");
                    uContactTick.setText("\u2717");
                    errorCheck++;
                }
            } else {
                showPromptUpdate.setText("Please fill out all required inputs!");
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubContactNo.setStyle("-fx-border-color: red;");
                uContactTick.setText("\u2605");
                emptyCheck++;
            }

            try {
                image = updateFile.getAbsolutePath();
            }
            catch (NullPointerException e){
                image = preImage;
            }
            //checking if image input is empty
            if (image == null) {
                showPromptUpdate.setText("Please add an icon!");
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updatePane.setStyle("-fx-border-color: red; -fx-border-width: 3;");
                errorCheck++;
            } else {
                updatePane.setStyle("-fx-border-color: green; -fx-border-width: 3;");
                updateClubInstance.setIcon(image);
            }

            if (emptyCheck != 0) { //checking for any empty inputs
                break;
            }
            if(errorCheck != 0){ //checking for any errors
                break;
            }

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


            //creating a sublist
            List<Object> subList = new ArrayList<>();

            //adding the item instances to the sublist
            subList.add(clubID);
            subList.add(updateClubInstance.getName());
            subList.add(updateClubInstance.getFoundingDate());
            subList.add(updateClubInstance.getMission());
            subList.add(updateClubInstance.getDescription());
            subList.add(updateClubInstance.getClubPresidentName());
            //subList.add(updateClubInstance.getClubAdvisorName());
            subList.add(updateClubInstance.getEmail());
            subList.add(updateClubInstance.getContactNo());
            subList.add(image);

            mainList.add(subList); //adding the sublist to the main list

            System.out.println(subList);
            System.out.println(mainList);
            showPromptUpdate.setText("Club Successfully Created!");
            showPromptUpdate.setStyle("-fx-text-fill: green;");
            break;
        }
    }

    public void onUpdateIconClick() throws IOException{
        FileChooser filePath = new FileChooser();
        updateFile = filePath.showOpenDialog(null); //assign file path to a File variable
        if (updateFile != null) { //check whether user select image or not
            Image image = new Image(updateFile.getAbsolutePath()); // get image path
            updateClubIcon.setImage(image);
        }
    }

    public void onBackClubManageClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        clubManagePane.getChildren().setAll(pane);
    }
}
