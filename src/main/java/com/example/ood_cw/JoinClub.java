package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.ood_cw.HelloController.*;

public class JoinClub implements Initializable {
    public ImageView clubImageView;
    public File file;
    LocalDate localDate;
    public ChoiceBox clubSelectBox;
    public Label clubName;
    public Label clubFoundingDate;
    public Label clubMission;
    public Label clubFounder;
    public Label clubEmail;
    public Label clubTelNo;
    public Label confirmationLabel;
    List<Object> cNameList = new ArrayList<>();
    public Button viewButton;
    public Button joinButton;
    @FXML
    private Button JoinClubBackButtonID;

    @FXML
    public void JoinClubBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) JoinClubBackButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(List<Object>list: clubs){
            cNameList.add(list.get(1));
        }
        for(List<Object> reg: registration){
            if(reg.get(0).equals(studentID.get(0))){
                for(List<Object> club: clubs){
                    if(club.get(0).equals(reg.get(1))){
                        cNameList.removeIf(i -> club.get(1).equals(i));
                    }
                }
            }

        }clubSelectBox.getItems().addAll(cNameList);
    }


    public void onViewButtonClick(ActionEvent actionEvent) throws IOException {
        if(clubSelectBox.getValue()!= null){
            for (List<Object>club: clubs){
                if(club.get(1).equals(clubSelectBox.getValue())){
                    clubName.setText(String.valueOf(club.get(1)));
                    clubFoundingDate.setText(String.valueOf(club.get(2)));
                    clubMission.setText(String.valueOf(club.get(3)));
                    clubFounder.setText(String.valueOf(club.get(4)));
                    clubEmail.setText(String.valueOf(club.get(7)));
                    clubTelNo.setText(String.valueOf(club.get(8)));
                    File Updatefile = new File(String.valueOf(club.get(9)));
                    Image image = new Image(Updatefile.toURI().toString());
                    clubImageView.setImage(image);
                    confirmationLabel.setText("Are you wish to join to this club?");
                }
            }

        }    }

    public void onJoinButtonClick(ActionEvent actionEvent) throws IOException, SQLException {
        String clubId= null;
        String id = String.valueOf(studentID.get(0));
        for (List<Object> club: clubs){
            if(club.get(1).equals(clubSelectBox.getValue())){
                 clubId = (String) club.get(0);
                confirmationLabel.setStyle("-fx-text-fill: Green");
                confirmationLabel.setText("Club join successfully!");
            }
        }
        String date = String.valueOf(LocalDate.now());
        DatabaseConnect.insertRegistrationDetails(id,clubId,date);
        DatabaseConnect.getRegistrationDetails();

    }

}
