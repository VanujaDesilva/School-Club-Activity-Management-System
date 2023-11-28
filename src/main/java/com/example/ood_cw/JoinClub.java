package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JoinClub implements Initializable {
    @FXML
    private Button JoinClubBackButtonID;

    @FXML
    private ComboBox<String> JoinClubComboBoxID;
    private String[] Clubs = {"Leo","Rotract","IEE"};





    @FXML
    public void JoinClubComboBoxClick(ActionEvent actionEvent) {

    }
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
        JoinClubComboBoxID.getItems().addAll(Clubs);

    }
}
