package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentMenu {
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


    public void StudentMenuViewClubButtonClick(ActionEvent actionEvent) {
    }

    public void StudentMenuJoinClubButtonClick(ActionEvent actionEvent) {
    }

    public void StudentMenuViewEventButtonClick(ActionEvent actionEvent) {
    }



    public void StudentMenuBackButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Load the menu for advisor");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) StudentMenuBackButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
