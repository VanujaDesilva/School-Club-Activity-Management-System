package com.example.ood_cw;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ScheduleMeetings {

    public TextField meetingDurationText;
    public TextField meetingLocationText;
    public TextField meetingTimeText;
    public TextArea meetingDescriptionText;
    public Label locationError;
    public Label timeError;
    public Label dateError;
    public DatePicker meetingDateText;
    public AnchorPane scheduleMeetingAnchor;
    public Label meetLocTick;
    public Label meetTimeTick;
    public Label meetDateTick;

    public void onScheduleButtonClick()throws IOException {
        while (true){
            int year = 0;
            int month = 0;
            int day = 0;
            LocalDate givenDate = null;
            int errors = 0;
            Meeting obj = new Meeting();
            obj.setMeetDuration(meetingDurationText.getText());
            obj.setEventLocation(meetingLocationText.getText());
            obj.setEventTime(meetingTimeText.getText());
            obj.setEventDescription(meetingDescriptionText.getText());
            String enteredDate = String.valueOf(meetingDateText.getValue());
            if (obj.getEventLocation().isEmpty()){
                locationError.setText("This field must be filled!");
                meetingLocationText.setStyle("-fx-border-color: red;");
                meetLocTick.setText("");
                errors++;
            } else {
                locationError.setText("");
                meetLocTick.setText("\u2713");
                meetingLocationText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventTime().isEmpty()){
                timeError.setText("This field must be filled!");
                meetingTimeText.setStyle("-fx-border-color: red;");
                meetTimeTick.setText("");
                errors++;
            } else {
                timeError.setText("");
                meetTimeTick.setText("\u2713");
                meetingTimeText.setStyle("-fx-border-color: #13e57d;");
            }
            if (enteredDate.equals("null")){
                dateError.setText("This field must be filled!");
                meetingDateText.setStyle("-fx-border-color: red;");
                meetDateTick.setText("");
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
                        meetingDateText.setStyle("-fx-border-color: red;");
                        meetDateTick.setText("");
                        errors++;
                    } else {
                        dateError.setText("");
                        meetingDateText.setStyle("-fx-border-color: #13e57d;");
                        meetDateTick.setText("\u2713");
                        obj.setEventDate(givenDate);
                    }
                } catch (Exception e){
                    dateError.setText("Error in date");
                    meetingDateText.setStyle("-fx-border-color: red;");
                    meetDateTick.setText("");
                    errors++;
                }
            }
            if (errors > 0)
                break;
            break;
        }
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) scheduleMeetingAnchor.getScene().getWindow();
        previousStage.close();
    }
}
