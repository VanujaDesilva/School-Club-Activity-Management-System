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

public class SheduleActivities {
    public AnchorPane scheduleActivityAnchor;
    public TextField activityNameText;
    public TextField activityLocationText;
    public TextField activityTimeText;
    public TextArea activityDescriptionText;
    public Label nameError;
    public Label locationError;
    public Label timeError;
    public Label startDateError;
    public DatePicker activityStartDateText;
    public Label eventNameTick;
    public Label eventLocTick;
    public Label eventTimeTick;
    public Label eventStartDateTick;
    public Label endDateError;
    public DatePicker activityEndDateText;
    public Label eventEndDateTick;

    public void onScheduleButtonClick() throws IOException {
        while (true){
            int errors = 0;
            Activity obj = new Activity();
            obj.setEventName(activityNameText.getText());
            obj.setEventLocation(activityLocationText.getText());
            obj.setEventTime(activityTimeText.getText());
            obj.setEventDescription(activityDescriptionText.getText());
            String startDate = String.valueOf(activityStartDateText.getValue());
            String endDate = String.valueOf(activityEndDateText.getValue());
            if (obj.getEventName().isEmpty()){
                nameError.setText("This field must be filled!");
                activityNameText.setStyle("-fx-border-color: red;");
                eventNameTick.setText("");
                errors++;
            } else {
                nameError.setText("");
                eventNameTick.setText("\u2713");
                activityNameText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventLocation().isEmpty()){
                locationError.setText("This field must be filled!");
                activityLocationText.setStyle("-fx-border-color: red;");
                eventLocTick.setText("");
                errors++;
            } else {
                locationError.setText("");
                eventLocTick.setText("\u2713");
                activityLocationText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventTime().isEmpty()){
                timeError.setText("This field must be filled!");
                activityTimeText.setStyle("-fx-border-color: red;");
                eventTimeTick.setText("");
                errors++;
            } else {
                timeError.setText("");
                eventTimeTick.setText("\u2713");
                activityTimeText.setStyle("-fx-border-color: #13e57d;");
            }
            int sYear = 0;
            int sMonth = 0;
            int sDay = 0;
            LocalDate sGivenDate = null;

            if (startDate.equals("null")){
                startDateError.setText("This field must be filled!");
                activityStartDateText.setStyle("-fx-border-color: red;");
                eventStartDateTick.setText("");
                errors++;
            } else {
                try {
                    sYear = Integer.parseInt(startDate.substring(0, 4));
                    sMonth = Integer.parseInt(startDate.substring(5, 7));
                    sDay = Integer.parseInt(startDate.substring(8, 10));
                    sGivenDate = LocalDate.of(sYear, sMonth, sDay);
                    LocalDate currentDate = LocalDate.now();
                    if (sGivenDate.isBefore(currentDate)){
                        startDateError.setText("Please select a future date!");
                        activityStartDateText.setStyle("-fx-border-color: red;");
                        eventStartDateTick.setText("");
                        errors++;
                    } else {
                        startDateError.setText("");
                        activityStartDateText.setStyle("-fx-border-color: #13e57d;");
                        eventStartDateTick.setText("\u2713");
                        obj.setEventDate(sGivenDate);
                    }
                } catch (Exception e){
                    startDateError.setText("Error in date!");
                    activityStartDateText.setStyle("-fx-border-color: red;");
                    eventStartDateTick.setText("");
                    errors++;
                }
            }
            int eYear = 0;
            int eMonth = 0;
            int eDay = 0;
            LocalDate eGivenDate = null;
            if (endDate.equals("null")){
                endDateError.setText("This field must be filled!");
                activityEndDateText.setStyle("-fx-border-color: red;");
                eventEndDateTick.setText("");
                errors++;
            }else {
                try {
                    eYear = Integer.parseInt(endDate.substring(0, 4));
                    eMonth = Integer.parseInt(endDate.substring(5, 7));
                    eDay = Integer.parseInt(endDate.substring(8, 10));
                    eGivenDate = LocalDate.of(eYear, eMonth, eDay);
                    LocalDate currentDate = LocalDate.now();
                    if (eGivenDate.isBefore(currentDate)) {
                        endDateError.setText("Please select a future date!");
                        activityEndDateText.setStyle("-fx-border-color: red;");
                        eventEndDateTick.setText("");
                        errors++;
                    } else {
                        endDateError.setText("");
                        activityEndDateText.setStyle("-fx-border-color: #13e57d;");
                        eventEndDateTick.setText("\u2713");
                        obj.setEndDate(eGivenDate);
                    }
                } catch (Exception e) {
                    endDateError.setText("Error in date!");
                    activityEndDateText.setStyle("-fx-border-color: red;");
                    eventEndDateTick.setText("");
                    errors++;
                }
            }
            if (errors > 0)
                break;
            break;
        }
    }

    public void onBackButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) scheduleActivityAnchor.getScene().getWindow();
        previousStage.close();
    }
}
