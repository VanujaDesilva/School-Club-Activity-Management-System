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

public class AdvisorMenu {
    @FXML
    private AnchorPane AdvisorMenuAnchorID;

    @FXML
    private Button AdvisorMenuAttendanceTrackingButtonID;

    @FXML
    private Button AdvisorMenuClubCreationbuttonID;

    @FXML
    private Button AdvisorMenuReportingButtonID;

    @FXML
    private Button AdvisorMenuScheduleEventButtonID;
    @FXML
    private Button AdvisorMenuBackButtonID;

    public void AdvisorMenuScheduleEventButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Load the menu for advisor");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EnterClubName.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) AdvisorMenuScheduleEventButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void AdvisorMenuReportingButtonClcik(ActionEvent actionEvent) {
    }

    public void AdvisorMenuClubCreationButtonClick(ActionEvent actionEvent) {
    }

    public void AdvisorMenuAttendanceTrackingButtonClick(ActionEvent actionEvent) {
    }

    public void AdvisorMenuBackButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Load the menu for advisor");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) AdvisorMenuScheduleEventButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
