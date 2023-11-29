package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.ood_cw.HelloController.*;

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
    List<List<Object>> reporting = new ArrayList<>();
    public void AdvisorMenuReportingButtonClcik() throws IOException {
        String clubName = "";
        String clubId = "";
        for (List<Object> club : clubs){
            if (club.get(6).equals(advisorID.get(0))){
                clubName = String.valueOf(club.get(1));
                clubId = String.valueOf(club.get(0));
            }
        }
        int registeredCount = 0;
        for (List<Object> i: registration){
            if (i.get(1).equals(clubId)){
                registeredCount++;
            }
        }
        System.out.println(registeredCount);
        List<Object> eventIds = new ArrayList<>();
        List<Object> eventNames = new ArrayList<>();
        List<Object> scheduleDates = new ArrayList<>();
        for (List<Object> event : allEvents){
            if (event.get(8).equals(clubId)){
                eventIds.add(event.get(0));
                eventNames.add(event.get(1));
                scheduleDates.add(event.get(5));
            }
        }
        List<List<Object>> eventAttendance = new ArrayList<>();
        for (int i =0 ; i < eventIds.size() ;i++){
            int attendCount=0;
            List<Object> eventAttend = new ArrayList<>();
            for (List<Object> attend : attendance){
                if (attend.get(1).equals(eventIds.get(i)) && attend.get(2).equals("Present")){
                    attendCount++;
                }
            }
            eventAttend.add(eventNames.get(i));
            eventAttend.add(eventIds.get(i));
            eventAttend.add(scheduleDates.get(i));
            eventAttend.add(attendCount);
            eventAttendance.add(eventAttend);
        }
        System.out.println(eventAttendance);
        if (clubId==""){
            clubId="NoClub";
        }
        String fileName =clubId+".html";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("<html><body>");
            writer.write("<center><p style=\"font-size: 20px;\"><strong>Advisor ID:</strong> " + advisorID.get(0) + "</p></center>");
            writer.write("<center><p style=\"font-size: 20px;\"><strong>Club name:</strong> " + clubName + "</p></center>");
            writer.write("<center><p style=\"font-size: 20px;\"><strong>Club ID:</strong> " + clubId + "</p></center>");
            writer.write("<center><p style=\"font-size: 20px;\"><strong>Members count:</strong> " + registeredCount + "</p></center>");
            writer.write("<br>");
            writer.write("<br>");
            for(List<Object> i : eventAttendance){
                writer.write("<p style=\"font-size: 16px;\"><strong>Event name:</strong> " + i.get(0)+ "</p>");
                writer.write("<p style=\"font-size: 16px;\"><strong>Event ID:</strong> " + i.get(1)+ "</p>");
                writer.write("<p style=\"font-size: 16px;\"><strong>Event Date:</strong> " + i.get(2)+ "</p>");
                writer.write("<p style=\"font-size: 16px;\"><strong>Event Attendance:</strong> " + i.get(3)+ "</p>");
                writer.write("<br>");
            }
            writer.write("</body></html>");
//            writer.write("Advisor id: "+advisorID.get(0)+"\n");
//            writer.write("Club name: "+clubName+"\n");
//            writer.write("Members count: "+registeredCount+"\n");
//            writer.write("\n");
//            writer.write("\n");
//            writer.write("\n");
//            for(List<Object> i : eventAttendance){
//                writer.write("Event name: "+i.get(0)+"\n");
//                writer.write("Event id: "+i.get(1)+"\n");
//                writer.write("Date: "+i.get(2)+"\n");
//                writer.write("Event attendance: "+i.get(3)+"\n");
//                writer.write("\n");
//            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void AdvisorMenuClubCreationButtonClick() throws IOException {
        for (int i =0; i < clubs.size();i++){
            mainList.add(clubs.get(i));
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("clubMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) AdvisorMenuClubCreationbuttonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void AdvisorMenuAttendanceTrackingButtonClick(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
        AdvisorMenuAnchorID.getChildren().setAll(pane);
    }

    public void AdvisorMenuBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) AdvisorMenuScheduleEventButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
