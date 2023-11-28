package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentMenu  {
    @FXML
    private AnchorPane StudentMenuAnchor;

    @FXML
    private Button StudentMenuBackButtonID;

    @FXML
    private Button StudentMenuJoinClubButtonID;

    @FXML
    private Button StudentMenuViewEventButtonID;

    @FXML
    private Button StudentMenuViewlubButtonID;


    public void StudentMenuViewClubButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showClub.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) StudentMenuViewlubButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void StudentMenuJoinClubButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoinClub.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) StudentMenuJoinClubButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void StudentMenuViewEventButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowEventScheduleForStudent.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) StudentMenuJoinClubButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void StudentMenuBackButtonClick(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) StudentMenuBackButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }





}
