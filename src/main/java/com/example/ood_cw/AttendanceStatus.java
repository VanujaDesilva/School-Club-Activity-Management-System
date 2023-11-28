package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.ood_cw.HelloController.*;

public class AttendanceStatus implements Initializable {

    public ChoiceBox studentClubSelector;
    public ChoiceBox studentEventSelector;
    public Label attendanceStatusCheck;
    public Button checkButton;
    public Label heldLocation;
    public Label heldDate;
    public Label description;
    public Button backButton;
    public AnchorPane attendanceStudent;
    private List<Object> clubsNames = new ArrayList<>();
    private List<Object> eventNames = new ArrayList<>();
    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        for(List<Object> reg: registration){
            if(reg.get(0).equals(studentID.get(0))){
                for(List<Object> club: clubs){
                    if(club.get(0).equals(reg.get(1))){
                        clubsNames.add(club.get(1));
                    }
                }
            }
        }
        studentClubSelector.getItems().addAll(clubsNames);
        if(studentClubSelector.getValue()!= null){
        for (List<Object> event : allEvents) {
            if(event.get(8).equals(studentClubSelector.getValue())) {
                String eName = String.valueOf(event.get(1));
                if (Objects.equals(eName, " - ")) {
                    eName = String.valueOf(event.get(0));
                }
                    eventNames.add(eName);
                }
            }
        }
        studentEventSelector.getItems().addAll(eventNames);
    }
    public void onAttendanceBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdvisorMenu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.show();
        Stage preStage = (Stage) attendanceStudent.getScene().getWindow();
        preStage.close();
    }

    public void onCheckButtonClick(ActionEvent actionEvent) {
        if(studentClubSelector != null && studentEventSelector != null){
          for(List<Object> event: allEvents){
              if(event.get(1).equals(studentEventSelector.getValue())){
                  heldLocation.setText(String.valueOf(event.get(2)));
                  heldDate.setText(String.valueOf(event.get(5)));
                  description.setText(String.valueOf(event.get(4)));
                  for(List<Object> atten: attendance){
                      if(atten.get(1).equals(event.get(0))){
                          if(String.valueOf(atten.get(2)).equals("Present")){
                              attendanceStatusCheck.setText("Present");
                          } else if (String.valueOf(atten.get(2)).equals("Absent")) {
                              attendanceStatusCheck.setText("Absent");
                          }else {
                              attendanceStatusCheck.setText("Not Marked Yet");
                          }
                      }
                  }
              }
          }

        }
    }
}
