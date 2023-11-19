package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class EventScheduling {
    public AnchorPane eventSchedulingAnchor;
    public TextField eventNameText;
    public TextField eventLocationText;
    public TextField eventTimeText;
    public TextArea eventDescriptionText;
    public Label nameError;
    public Label locationError;
    public Label timeError;
    public Label dateError;
    public DatePicker eventDateText;
    public AnchorPane scheduleEventAnchor;
    public Label eventNameTick;
    public Label eventLocTick;
    public Label eventTimeTick;
    public Label eventDateTick;


    public void onScheduleButtonClick() throws IOException {
        while (true){
            int errors = 0;
            int year = 0;
            int month = 0;
            int day = 0;
            LocalDate givenDate = null;
            Event obj = new Event();
            obj.setEventName(eventNameText.getText());
            obj.setEventLocation(eventLocationText.getText());
            obj.setEventTime(eventTimeText.getText());
            obj.setEventDescription(eventDescriptionText.getText());
            String enteredDate = String.valueOf(eventDateText.getValue());
            if (obj.getEventName().isEmpty()){
                nameError.setText("This field must be filled!");
                eventNameText.setStyle("-fx-border-color: red;");
                eventNameTick.setText("");
                errors++;
            } else {
                nameError.setText("");
                eventNameTick.setText("\u2713");
                eventNameText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventLocation().isEmpty()){
                locationError.setText("This field must be filled!");
                eventLocationText.setStyle("-fx-border-color: red;");
                eventLocTick.setText("");
                errors++;
            } else {
                locationError.setText("");
                eventLocTick.setText("\u2713");
                eventLocationText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventTime().isEmpty()){
                timeError.setText("This field must be filled!");
                eventTimeText.setStyle("-fx-border-color: red;");
                eventTimeTick.setText("");
                errors++;
            } else {
                timeError.setText("");
                eventTimeTick.setText("\u2713");
                eventTimeText.setStyle("-fx-border-color: #13e57d;");
            }
            if (enteredDate.equals("null")){
                dateError.setText("This field must be filled!");
                eventDateText.setStyle("-fx-border-color: red;");
                eventDateTick.setText("");
                errors++;
            } else {
                try {
                    year = Integer.parseInt(enteredDate.substring(0, 4));
                    month = Integer.parseInt(enteredDate.substring(5, 7));
                    day = Integer.parseInt(enteredDate.substring(8, 10));
                    givenDate = LocalDate.of(year, month, day);
                    LocalDate currentDate = LocalDate.now();
                    if (givenDate.isBefore(currentDate)){
                        dateError.setText("Please select a future date!");
                        eventDateText.setStyle("-fx-border-color: red;");
                        eventDateTick.setText("");
                        errors++;
                    } else {
                        dateError.setText("");
                        eventDateText.setStyle("-fx-border-color: #13e57d;");
                        eventDateTick.setText("\u2713");
                        obj.setEventDate(givenDate);
                    }
                } catch (Exception e){
                    dateError.setText("Error in date");
                    eventDateText.setStyle("-fx-border-color: red;");
                    eventDateTick.setText("");
                    errors++;
                }
            }
            if (errors > 0)
                break;
            break;
        }
    }

    public void onScheduleEventButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ScheduleEvents.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  444.0);
        stage.setTitle("Schedule Events");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onScheduleMeetingButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ScheduleMeetings.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  444.0);
        stage.setTitle("Schedule Meetings");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onScheduleActivityButtonClick() throws IOException{

    }


    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) scheduleEventAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onBackEventButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnterClubName.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();
    }
}
