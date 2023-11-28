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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.ood_cw.HelloController.*;

public class StudentMenu  {
    public Button viewAttendanceButton;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showClubs.fxml"));
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
            DatabaseConnect.getScheduleOfClubSesion();
        System.out.println(allEvents);
            for (int j=0; j<allEvents.size();j++){
                int sYear = Integer.parseInt(String.valueOf(allEvents.get(j).get(5)).substring(0, 4));
                int sMonth = Integer.parseInt(String.valueOf(allEvents.get(j).get(5)).substring(5, 7));
                int sDay = Integer.parseInt(String.valueOf(allEvents.get(j).get(5)).substring(8, 10));
                LocalDate date = LocalDate.of(sYear, sMonth, sDay);
                allEvents.get(j).set(5,date);
            }
            LocalDate currentDate = LocalDate.now();
            List<List<Object>> dateValidEvents = new ArrayList<>();
            for (int j=0;j<allEvents.size();j++){
                if (currentDate.isBefore((LocalDate) allEvents.get(j).get(5))){
                    dateValidEvents.add(allEvents.get(j));
                }
            }
        System.out.println(dateValidEvents);
            //need to be changed
            List<Object> studentClubs = new ArrayList<>();
            DatabaseConnect.getRegistrationDetails();
            for (List<Object> i : registration){
                if (String.valueOf(i.get(0)).equals(String.valueOf(studentID.get(0)))){
                    studentClubs.add(i.get(1));
                }
            }
            eventSchedule.clear();
        System.out.println(studentClubs);
            for (int i=0;i<studentClubs.size();i++){
                for (int j=0;j<dateValidEvents.size();j++){
                    String date = String.valueOf(dateValidEvents.get(j).get(5));
                    dateValidEvents.get(j).set(5,date);
                    if (dateValidEvents.get(j).get(8).equals(studentClubs.get(i))){
                        eventSchedule.add(dateValidEvents.get(j));
                    }
                }
            }
        System.out.println(eventSchedule);

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowEventScheduleForStudent.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 900,  600);
            stage.setTitle("Show event Schedule");
            stage.setScene(scene);
            stage.show();
        Stage preStage = (Stage) StudentMenuAnchor.getScene().getWindow();
        preStage.close();

    }



    public void StudentMenuBackButtonClick(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) StudentMenuBackButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public void onViewAttendanceButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AttendanceStudent.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) viewAttendanceButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
