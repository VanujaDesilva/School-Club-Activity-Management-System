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

import static com.example.ood_cw.HelloController.clubs;

public class ManageClub {

    //importing lists
    @FXML
    public static List<List<Object>> mainList = HelloController.mainList;

    //variable declarations
    @FXML
    public DatePicker updateClubDate;
    @FXML
    public TextField updateClubMission;
    @FXML
    public TextArea updateClubDescription;
    @FXML
    public TextField updateClubPresident;
    @FXML
    public TextField updateClubEmail;
    @FXML
    public TextField updateClubContactNo;
    @FXML
    public ImageView updateClubIcon;
    @FXML
    public Button showClub;
    @FXML
    public TextField showName;
    @FXML
    public Button updateClub;
    @FXML
    public Label uPresidentTick;
    @FXML
    public Label uEmailTick;
    @FXML
    public Label uContactTick;
    @FXML
    public Label uDateTick;
    @FXML
    public Label showTick;
    @FXML
    public Button uInsertIcon;
    @FXML
    public static int listIndex;
    @FXML
    public File updateFile;

    @FXML
    public Label showPromptUpdate;
    @FXML
    public AnchorPane updatePane;
    @FXML
    public Button backClubManage;
    @FXML
    public AnchorPane clubManagePane;

    String preImage;
    String image;

    //creating object instance
    Club updateClubInstance = new Club();

    //show club  functionality
    public void onShowClubButtonClick() throws IOException {
        updateClubInstance.setName(showName.getText());  //setting the club name input from the textField to the club object
        int count =0;
        //checking if the club name is empty
        try {
            //checking if the same club name exists
            for ( List<Object> d : mainList) {
                if (d.get(1).equals(updateClubInstance.getName())) {
                    count++;
                    listIndex =mainList.indexOf(d);

                    //displays the existing item details
                    showName.setText(String.valueOf(d.get(1)));

//                    LocalDate updateFoundingDate = updateClubDate.getValue();

                    System.out.println(d.get(2));
                    updateClubDate.setValue(LocalDate.parse((String) d.get(2)));
                    updateClubMission.setText(String.valueOf(d.get(3)));
                    updateClubDescription.setText(String.valueOf(d.get(4)));
                    updateClubPresident.setText(String.valueOf(d.get(5)));
                    updateClubEmail.setText(String.valueOf(d.get(7)));
                    String contactShort = d.get(8).toString();
                    String contactNum = contactShort.substring(3,12);
                    updateClubContactNo.setText(contactNum);

                    File Updatefile = new File(String.valueOf(d.get(9)));
                    Image updateImage = new Image(Updatefile.toURI().toString());
                    updateClubIcon.setImage(updateImage);
                    preImage = d.get(9).toString();

                }
            }
            if (count==0){
                showPromptUpdate.setText("");
                showName.setStyle("-fx-border-color: red;");
                showTick.setText("\u2717");
            } else {
                showPromptUpdate.setText("Club found!");
                showName.setStyle("-fx-border-color: green;");
                showTick.setText("\u2713");
            }
        }
        catch (NullPointerException e) {
            showName.setStyle("-fx-border-color: red;");
            showTick.setText("\u2605");
        }
    }


    //update club functionality
    public void onUpdateButtonClick() throws IOException, SQLException {
        updateClubInstance.setIcon(mainList.get(listIndex).get(9).toString());
        String clubID = String.valueOf(mainList.get(listIndex).get(0));
        String advisorId = String.valueOf(mainList.get(listIndex).get(6));
        mainList.remove(listIndex); //removing the old item data from the list

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
                        showPromptUpdate.setText("Club already exists!"); //displaying prompt text
                        showPromptUpdate.setStyle("-fx-text-fill: red;");
                        showName.setStyle("-fx-border-color: red;");
                        showTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                showName.setStyle("-fx-border-color: green;");
                showTick.setText("\u2713");
            } else { //validation when club name is empty
                showPromptUpdate.setText("Please fill out all required inputs!"); //displaying prompt text
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
                    showPromptUpdate.setText("Founding Date cannot be in the future!"); //displaying prompt text
                    showPromptUpdate.setStyle("-fx-text-fill: red;");
                    updateClubDate.setStyle("-fx-border-color: red;");
                    uDateTick.setText("\u2717"); //cross
                    errorCheck++;
                }
            } else { //validation when date is empty
                showPromptUpdate.setText("Please fill out all required inputs!"); //displaying prompt text
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
                        showPromptUpdate.setText("Club President already exists!"); //displaying prompt text
                        showPromptUpdate.setStyle("-fx-text-fill: red;");
                        updateClubPresident.setStyle("-fx-border-color: red;");
                        uPresidentTick.setText("\u2717");
                        errorCheck++;
                    }
                }
                updateClubPresident.setStyle("-fx-border-color: green;");
                uPresidentTick.setText("\u2713");
            } else { //validation when president name is empty
                showPromptUpdate.setText("Please fill out all required inputs!"); //displaying prompt text
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubPresident.setStyle("-fx-border-color: red;");
                uPresidentTick.setText("\u2605");
                emptyCheck++;
            }


            //setting the club email
            updateClubInstance.setEmail(updateClubEmail.getText());
            //checking if the club email is empty
            if (!updateClubInstance.getEmail().isEmpty()) {
                //checking if the entered email is valid
                if (Club.isValidEmail(updateClubInstance.getEmail())) {
                    updateClubEmail.setStyle("-fx-border-color: green;");
                    uEmailTick.setText("\u2713");
                } else {
                    showPromptUpdate.setText("Please enter valid email!"); //displaying prompt text
                    showPromptUpdate.setStyle("-fx-text-fill: red;");
                    updateClubEmail.setStyle("-fx-border-color: red;");
                    uEmailTick.setText("\u2717");
                    errorCheck++;
                }
            } else { //validation when  email is empty
                showPromptUpdate.setText("Please fill out all required inputs!"); //displaying prompt text
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubEmail.setStyle("-fx-border-color: red;");
                uEmailTick.setText("\u2605");
                emptyCheck++;
            }

            //setting the club contact number
//            String contactNumSub = updateClubContactNo.getText();
//            String contactNumReduced = contactNumSub.substring(3);
            updateClubInstance.setContactNo(updateClubContactNo.getText());
            //checking if the contact number is empty
            if (updateClubContactNo.getText() != null) {
                if (Club.isValidContactNo(updateClubContactNo.getText())) {
                    updateClubContactNo.setStyle("-fx-border-color: green;");
                    uContactTick.setText("\u2713");
                } else {
                    showPromptUpdate.setText("Please enter valid contact number!"); //displaying prompt text
                    showPromptUpdate.setStyle("-fx-text-fill: red;");
                    updateClubContactNo.setStyle("-fx-border-color: red;");
                    uContactTick.setText("\u2717");
                    errorCheck++;
                }
            } else {  //validation when contact number is empty
                showPromptUpdate.setText("Please fill out all required inputs!"); //displaying prompt text
                showPromptUpdate.setStyle("-fx-text-fill: red;");
                updateClubContactNo.setStyle("-fx-border-color: red;");
                uContactTick.setText("\u2605");
                emptyCheck++;
            }
            String contactNum = "+94"+updateClubInstance.getContactNo();

            try {
                image = updateFile.getAbsolutePath();
            }
            catch (NullPointerException e){
                image = preImage;
            }
            //checking if image input is empty
            if (image == null) {
                showPromptUpdate.setText("Please add an icon!"); //displaying prompt text
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

            //creating a sublist
            List<Object> subList = new ArrayList<>();
            String date = String.valueOf(updateClubInstance.getFoundingDate());

            //adding the item instances to the sublist
            subList.add(clubID);
            subList.add(updateClubInstance.getName());
            subList.add(date);
            subList.add(updateClubInstance.getMission());
            subList.add(updateClubInstance.getDescription());
            subList.add(updateClubInstance.getClubPresidentName());
            subList.add(advisorId);
            subList.add(updateClubInstance.getEmail());
            subList.add(contactNum);
            System.out.println(updateClubInstance.getContactNo());
            subList.add(image);

            mainList.add(subList); //adding the sublist to the main list
//            clubs.add(subList);
            DatabaseConnect.onUpdateClubTableField((String) subList.get(0), (String) subList.get(1), (String) subList.get(2), (String) subList.get(3), (String) subList.get(4), (String) subList.get(5), (String) subList.get(7), (String) subList.get(8), (String) subList.get(9));
            DatabaseConnect.getDetailsOfClubs();
            System.out.println(mainList);
            showPromptUpdate.setText("Club Successfully Created!"); //displaying prompt text
            showPromptUpdate.setStyle("-fx-text-fill: green;");
            break;
        }
    }

    //update image method
    public void onUpdateIconClick() throws IOException{
        FileChooser filePath = new FileChooser();
        updateFile = filePath.showOpenDialog(null); //assign file path to a File variable
        if (updateFile != null) { //check whether user select image or not
            Image image = new Image(updateFile.getAbsolutePath()); // get image path
            updateClubIcon.setImage(image);
        }
    }

    //back button functionality
    public void onBackClubManageClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        clubManagePane.getChildren().setAll(pane);
    }
}