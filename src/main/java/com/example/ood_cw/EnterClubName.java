package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.ood_cw.HelloController.clubs;

public class EnterClubName implements Initializable {
    public AnchorPane enterClubNameAnchor;
    public TextField clubNameText;
    public Label clubNameError;
    public ListView<String> clubNamesView;
    public static List<String> clubID = new ArrayList<>();
    public static List<String> advisorID = new ArrayList<>();
    public static List<List<Object>> allEvents = HelloController.allEvents;
    public static List<List<Object>> events = HelloController.events;
    public static List<List<Object>> events1 = HelloController.events1;
    public static List<List<Object>> meetings = HelloController.meetings;
    public static List<List<Object>> activity = HelloController.activity;

    public static List<List<Object>> advisorClubs = new ArrayList<>();
    public Button nextButton;

    public void onEnterClubNameNextClick() throws IOException {
        String clubName = clubNameText.getText();
        int count =0;
        if (clubName.isEmpty()){
            clubNameError.setText("Please enter a club name!");
            return;
        } else {
            System.out.println(advisorClubs);
            for (int i=0; i<advisorClubs.size();i++){
                if (clubName.equalsIgnoreCase((String) advisorClubs.get(i).get(1))){
                    count++;
                    DatabaseConnect.getScheduleOfClubSesion();
                    String clubId = String.valueOf(advisorClubs.get(i).get(0));
                    String advisorId = String.valueOf(advisorID.get(0));
                    System.out.println(clubId);
                    clubID.clear();
                    clubID.add(clubId);
                    System.out.println(allEvents);
//                    advisorID.clear();
//                    advisorID.add(advisorId);
                    for (int j=0; j<allEvents.size();j++){ //getting the events according to the clubID and advisorID
                        if (allEvents.get(j).get(8).equals(clubId) && allEvents.get(j).get(9).equals(advisorId)){
                            events.add(allEvents.get(j));
                        }
                    }
                    System.out.println(events);
                    events1.clear();
                    for (int j = 0; j<events.size(); j++){
                        String e = (String) events.get(j).get(0);
                        e = e.substring(0,1);
                        if (e.equals("E")){
                            events1.add(events.get(j));
                        }
                    }

                    meetings.clear();
                    for (int j = 0; j<events.size(); j++){
                        String e = (String) events.get(j).get(0);
                        e = e.substring(0,1);
                        if (e.equals("M")){
                            meetings.add(events.get(j));
                        }
                    }
                    activity.clear();
                    for (int j = 0; j<events.size(); j++){
                        String e = (String) events.get(j).get(0);
                        e = e.substring(0,1);
                        if (e.equals("A")){
                            activity.add(events.get(j));
                        }
                    }
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("EventScheduling.fxml"));
                    enterClubNameAnchor.getChildren().setAll(pane);
                    return;
                }
            }
        }
        if (count==0){
            clubNameError.setText("Entered Club name doesn't exists!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


//        enterClubNameAnchor.getChildren().remove(nextButton);


        List<String> clubNames = new ArrayList<>();
        for (int i=0; i<clubs.size();i++){ //getting the clubs relevant for that particular  club advisor
            if (clubs.get(i).get(6).equals(advisorID.get(0))) {
                clubNames.add(String.valueOf(clubs.get(i).get(1)));
                advisorClubs.add(clubs.get(i));
            }
        }
        clubNamesView.getItems().addAll(clubNames);

    }

    public void onEnterClubNameBackButtonClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdvisorMenu.fxml"));
        enterClubNameAnchor.getChildren().setAll(pane);
    }
}
