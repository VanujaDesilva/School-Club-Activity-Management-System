package com.example.ood_cw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class HelloController{
    public static List<List<Object>> events = new ArrayList<>();
    public static List<List<Object>> events1 = new ArrayList<>();
    public static List<List<Object>> meetings = new ArrayList<>();
    public static List<List<Object>> activity = new ArrayList<>();
    public AnchorPane eventSchedulingAnchor;
    @FXML
    private AnchorPane sampleAnchor;
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

    public void onYeranButtonClick() throws IOException {
        events1.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("E")){
                events1.add(events.get(i));
            }
        }

        meetings.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("M")){
                meetings.add(events.get(i));
            }
        }
        activity.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("A")){
                activity.add(events.get(i));
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnterClubName.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) sampleAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onVanujaButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Attendance.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Attendance");
        stage.setScene(scene);
        stage.show();
    }

    public void onTharushaButtonClick(ActionEvent actionEvent) {
    }

    public void onAvishkaButtonClick(ActionEvent actionEvent) {
    }

    public AnchorPane enterClubNameAnchor;
    public void onEnterClubNameNextClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) enterClubNameAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onScheduleEventButtonClick() throws IOException {
        events1.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("E")){
                events1.add(events.get(i));
            }
        }
        System.out.println(events1);
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
        meetings.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("M")){
                meetings.add(events.get(i));
            }
        }
        System.out.println(meetings);
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
        activity.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("A")){
                activity.add(events.get(i));
            }
        }
        System.out.println(activity);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SheduleActivities.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  500.0);
        stage.setTitle("Schedule Meetings");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();

    }
    public void onBackEventScheduleButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnterClubName.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();
    }


    public void onScheduleEventsButtonClick() throws IOException, SQLException {
        outerloop:
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
                obj.setLabel(nameError,eventNameText,eventNameTick);
                errors++;
            } else {
                obj.setLabelCorrect(nameError,eventNameTick,eventNameText);
            }
            if (obj.getEventLocation().isEmpty()){
                obj.setLabel(locationError,eventLocationText,eventLocTick);
                errors++;
            } else {
                obj.setLabelCorrect(locationError,eventLocTick,eventLocationText);
            }
            if (obj.getEventTime().isEmpty()){
                obj.setLabel(timeError,eventTimeText,eventTimeTick);
                errors++;
            } else {
                obj.setLabelCorrect(timeError,eventTimeTick,eventTimeText);
            }
            if (obj.getEventDescription().isEmpty()){
                obj.setEventDescription(" - ");
            }
            if (enteredDate.equals("null")){
                obj.setLabel(dateError,eventDateText,eventDateTick);
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
                        obj.setLabelCorrect(dateError,eventDateTick,eventDateText);
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
            String date = String.valueOf(obj.getEventDate());
            System.out.println(events1);
            for (int i = 0; i < events1.size(); i++){
                if (events1.get(i).get(1).equals(obj.getEventName()) && String.valueOf(events1.get(i).get(5)).equals(date)){
                    System.out.println("Event already exists");
                    break outerloop;
                }
            }
            int max =0;
            for (int i = 0 ; i < events1.size() ; i++){
                String e = (String) events1.get(i).get(0);
                int curValue = Integer.parseInt(e.substring(1,4));
                if (max < curValue){
                    max = curValue;
                }
            }
            max = max + 1;
            String id = String.format("%03d",max);
            id = "E"+id;
            List<Object> event = new ArrayList<>();
            event.add(id);
            event.add(obj.getEventName());
            event.add(obj.getEventLocation());
            event.add(obj.getEventTime());
            event.add(obj.getEventDescription());
            event.add(obj.getEventDate());
            event.add(" - ");
            event.add(" - ");
            event.add("C001");
            event.add("AD01");
            events.add(event);
            events1.add(event);
            DatabaseConnect.clearTable();
            for (int i=0 ;i<events.size(); i++){
                DatabaseConnect.insertSchedule(String.valueOf(events.get(i).get(0)),String.valueOf(events.get(i).get(1)),String.valueOf(events.get(i).get(2)),String.valueOf(events.get(i).get(3)),String.valueOf(events.get(i).get(4)),String.valueOf(events.get(i).get(5)),String.valueOf(events.get(i).get(6)),String.valueOf(events.get(i).get(7)),String.valueOf(events.get(i).get(8)),String.valueOf(events.get(i).get(9)));
            }
            break;
        }
    }

    public void onScheduleEventsBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) scheduleEventAnchor.getScene().getWindow();
        previousStage.close();
    }

    public TextField meetingDurationText; //Schedule meetings
    public TextField meetingLocationText;
    public TextField meetingTimeText;
    public TextArea meetingDescriptionText;
    public Label meetingLocationError;
    public Label meetingTimeError;
    public Label meetingDateError;
    public DatePicker meetingDateText;
    public AnchorPane scheduleMeetingAnchor;
    public Label meetLocTick;
    public Label meetTimeTick;
    public Label meetDateTick;

    public void onScheduleMeetingsButtonClick() throws IOException, SQLException {
        outerloop:
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
                obj.setLabel(meetingLocationError,meetingLocationText,meetLocTick);
                errors++;
            } else {
                obj.setLabelCorrect(meetingLocationError,meetLocTick,meetingLocationText);
            }
            if (obj.getEventTime().isEmpty()){
                obj.setLabel(meetingTimeError,meetingTimeText,meetTimeTick);
                errors++;
            } else {
                obj.setLabelCorrect(meetingTimeError,meetTimeTick,meetingTimeText);
            }
            if (enteredDate.equals("null")){
                obj.setLabel(meetingDateError,meetingDateText,meetDateTick);
                errors++;
            } else {
                try {
                    year = Integer.parseInt(enteredDate.substring(0, 4));
                    month = Integer.parseInt(enteredDate.substring(5, 7));
                    day = Integer.parseInt(enteredDate.substring(8, 10));
                    givenDate = LocalDate.of(year, month, day);
                    LocalDate currentDate = LocalDate.now();
                    if (givenDate.isBefore(currentDate)){
                        meetingDateError.setText("Please select a future date!");
                        meetingDateText.setStyle("-fx-border-color: red;");
                        meetDateTick.setText("");
                        errors++;
                    } else {
                        obj.setLabelCorrect(meetingDateError,meetDateTick,meetingDateText);
                        obj.setEventDate(givenDate);
                    }
                } catch (Exception e){
                    meetingDateError.setText("Error in date");
                    meetingDateText.setStyle("-fx-border-color: red;");
                    meetDateTick.setText("");
                    errors++;
                }
            }
            if (errors > 0)
                break;
            String date = String.valueOf(obj.getEventDate());
            for (int i = 0; i < meetings.size(); i++){
                if (meetings.get(i).get(2).equals(obj.getEventLocation()) && String.valueOf(meetings.get(i).get(5)).equals(date) && meetings.get(i).get(3).equals(obj.getEventTime())){
                    System.out.println("Meeting already exists");
                    break outerloop;
                }
            }
            int max =0;
            for (int i = 0 ; i < meetings.size() ; i++){
                String e = (String) meetings.get(i).get(0);
                int curValue = Integer.parseInt(e.substring(1,4));
                if (max < curValue){
                    max = curValue;
                }
            }
            max = max + 1;
            String id = String.format("%03d",max);
            id = "M"+id;
            List<Object> meeting = new ArrayList<>();
            meeting.add(id);
            meeting.add(" - ");
            meeting.add(obj.getEventLocation());
            meeting.add(obj.getEventTime());
            meeting.add(obj.getEventDescription());
            meeting.add(obj.getEventDate());
            meeting.add(" - ");
            meeting.add(obj.getMeetDuration());
            meeting.add("C001");
            meeting.add("AD01");
            events.add(meeting);
            meetings.add(meeting);
            DatabaseConnect.clearTable();
            for (int i=0 ;i<events.size(); i++){
                DatabaseConnect.insertSchedule(String.valueOf(events.get(i).get(0)),String.valueOf(events.get(i).get(1)),String.valueOf(events.get(i).get(2)),String.valueOf(events.get(i).get(3)),String.valueOf(events.get(i).get(4)),String.valueOf(events.get(i).get(5)),String.valueOf(events.get(i).get(6)),String.valueOf(events.get(i).get(7)),String.valueOf(events.get(i).get(8)),String.valueOf(events.get(i).get(9)));
            }
            break;
        }
    }

    public void onSheduleMeetingsBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) scheduleMeetingAnchor.getScene().getWindow();
        previousStage.close();
    }

    public AnchorPane scheduleActivityAnchor; //schedule Acivities
    public TextField activityNameText;
    public TextField activityLocationText;
    public TextField activityTimeText;
    public TextArea activityDescriptionText;
    public Label activityNameError;
    public Label activityLocationError;
    public Label activityTimeError;
    public Label activityStartDateError;
    public DatePicker activityStartDateText;
    public Label activityNameTick;
    public Label activityLocTick;
    public Label activityTimeTick;
    public Label activityStartDateTick;
    public Label activityEndDateError;
    public DatePicker activityEndDateText;
    public Label activityEndDateTick;


    public void onActivityScheduleButtonClick() throws IOException {
        outerloop:
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
                obj.setLabel(activityNameError,activityNameText,activityNameTick);
                errors++;
            } else {
                obj.setLabelCorrect(activityNameError,activityNameTick,activityNameText);
            }
            if (obj.getEventLocation().isEmpty()){
                obj.setLabel(activityLocationError,activityLocationText,activityLocTick);
                errors++;
            } else {
                obj.setLabelCorrect(activityLocationError,activityLocTick,activityLocationText);
            }
            if (obj.getEventTime().isEmpty()){
                obj.setLabel(activityTimeError,activityTimeText,activityTimeTick);
                errors++;
            } else {
                obj.setLabelCorrect(activityTimeError,activityTimeTick,activityTimeText);
            }
            int sYear = 0;
            int sMonth = 0;
            int sDay = 0;
            LocalDate sGivenDate = null;

            if (startDate.equals("null")){
                obj.setLabel(activityStartDateError,activityStartDateText,activityStartDateTick);
                errors++;
            } else {
                try {
                    sYear = Integer.parseInt(startDate.substring(0, 4));
                    sMonth = Integer.parseInt(startDate.substring(5, 7));
                    sDay = Integer.parseInt(startDate.substring(8, 10));
                    sGivenDate = LocalDate.of(sYear, sMonth, sDay);
                    LocalDate currentDate = LocalDate.now();
                    if (sGivenDate.isBefore(currentDate)){
                        activityStartDateError.setText("Please select a future date!");
                        activityStartDateText.setStyle("-fx-border-color: red;");
                        activityStartDateTick.setText("");
                        errors++;
                    } else {
                        obj.setLabelCorrect(activityStartDateError,activityStartDateTick,activityStartDateText);
                        obj.setEventDate(sGivenDate);
                    }
                } catch (Exception e){
                    activityStartDateError.setText("Error in date!");
                    activityStartDateText.setStyle("-fx-border-color: red;");
                    activityStartDateTick.setText("");
                    errors++;
                }
            }
            int eYear = 0;
            int eMonth = 0;
            int eDay = 0;
            LocalDate eGivenDate = null;
            if (endDate.equals("null")){
                obj.setLabel(activityEndDateError,activityEndDateText,activityEndDateTick);
                errors++;
            }else {
                try {
                    eYear = Integer.parseInt(endDate.substring(0, 4));
                    eMonth = Integer.parseInt(endDate.substring(5, 7));
                    eDay = Integer.parseInt(endDate.substring(8, 10));
                    eGivenDate = LocalDate.of(eYear, eMonth, eDay);
                    LocalDate currentDate = LocalDate.now();
                    if (eGivenDate.isBefore(currentDate)) {
                        activityEndDateError.setText("Please select a future date!");
                        activityEndDateText.setStyle("-fx-border-color: red;");
                        activityEndDateTick.setText("");
                        errors++;
                    } else {
                        obj.setLabelCorrect(activityEndDateError,activityEndDateTick,activityEndDateText);
                        obj.setEndDate(eGivenDate);
                    }
                } catch (Exception e) {
                    activityEndDateError.setText("Error in date!");
                    activityEndDateText.setStyle("-fx-border-color: red;");
                    activityEndDateTick.setText("");
                    errors++;
                }
            }
            if (errors > 0)
                break;
            String date = String.valueOf(obj.getEventDate());
            String date1 = String.valueOf(obj.getEndDate());
            for (int i = 0; i < activity.size(); i++){
                if (activity.get(i).get(1).equals(obj.getEventName()) && activity.get(i).get(5).equals(date) && activity.get(i).get(6).equals(date1)){
                    System.out.println("Activity already exists");
                    break outerloop;
                }
            }
            System.out.println("Activity should be added to the list");
            int max =0;
            for (int i = 0 ; i < meetings.size() ; i++){
                String e = (String) meetings.get(i).get(0);
                int curValue = Integer.parseInt(e.substring(1,4));
                if (max < curValue){
                    max = curValue;
                }
            }
            max = max + 1;
            String id = String.format("%03d",max);
            id = "M"+id;
            break;
        }
    }

    public void onActivityScheduleBackButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) scheduleActivityAnchor.getScene().getWindow();
        previousStage.close();
    }

    public static List<List<Object>> eventView = new ArrayList<>();
    public void onEventSchedulingViewOrDeleteButtonClick() throws IOException {
        eventView.clear();
        for (int i=0; i<events1.size();i++){
            List<Object> event = new ArrayList<>();
            event.add(String.valueOf(events1.get(i).get(0)));
            event.add(String.valueOf(events1.get(i).get(1)));
            event.add(String.valueOf(events1.get(i).get(2)));
            event.add(String.valueOf(events1.get(i).get(3)));
            event.add(String.valueOf(events1.get(i).get(4)));
            event.add(String.valueOf(events1.get(i).get(5)));
            event.add(String.valueOf(events1.get(i).get(6)));
            event.add(String.valueOf(events1.get(i).get(7)));
            event.add(String.valueOf(events1.get(i).get(8)));
            event.add(String.valueOf(events1.get(i).get(9)));
            eventView.add(event);
        }

        for (int i = 0; i<meetings.size() ; i++){
            List<Object> meeting = new ArrayList<>();
            meeting.add(String.valueOf(meetings.get(i).get(0)));
            meeting.add(String.valueOf(meetings.get(i).get(1)));
            meeting.add(String.valueOf(meetings.get(i).get(2)));
            meeting.add(String.valueOf(meetings.get(i).get(3)));
            meeting.add(String.valueOf(meetings.get(i).get(4)));
            meeting.add(String.valueOf(meetings.get(i).get(5)));
            meeting.add(String.valueOf(meetings.get(i).get(6)));
            meeting.add(String.valueOf(meetings.get(i).get(7)));
            meeting.add(String.valueOf(meetings.get(i).get(8)));
            meeting.add(String.valueOf(meetings.get(i).get(9)));
            eventView.add(meeting);
        }

        for (int i = 0; i<activity.size();i++){
            List<Object> activity1 = new ArrayList<>();
            activity1.add(String.valueOf(activity.get(i).get(0)));
            activity1.add(String.valueOf(activity.get(i).get(1)));
            activity1.add(String.valueOf(activity.get(i).get(2)));
            activity1.add(String.valueOf(activity.get(i).get(3)));
            activity1.add(String.valueOf(activity.get(i).get(4)));
            activity1.add(String.valueOf(activity.get(i).get(5)));
            activity1.add(String.valueOf(activity.get(i).get(6)));
            activity1.add(String.valueOf(activity.get(i).get(7)));
            activity1.add(String.valueOf(activity.get(i).get(8)));
            activity1.add(String.valueOf(activity.get(i).get(9)));
            eventView.add(activity1);
        }

        System.out.println(eventView);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewOrDeleteEvents.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("View or Delete Events");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();
    }
    public static List<List<Object>> eventSchedule = new ArrayList<>();
    public void onShowEventScheduleForStudentButtonClick() throws IOException {
        events1.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("E")){
                events1.add(events.get(i));
            }
        }

        meetings.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("M")){
                meetings.add(events.get(i));
            }
        }

        activity.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("A")){
                activity.add(events.get(i));
            }
        }
        eventView.clear();
        for (int i=0; i<events1.size();i++){
            List<Object> event = new ArrayList<>();
            event.add(String.valueOf(events1.get(i).get(0)));
            event.add(String.valueOf(events1.get(i).get(1)));
            event.add(String.valueOf(events1.get(i).get(2)));
            event.add(String.valueOf(events1.get(i).get(3)));
            event.add(String.valueOf(events1.get(i).get(4)));
            event.add(String.valueOf(events1.get(i).get(5)));
            event.add(" - ");
            event.add(" - ");
            event.add(String.valueOf(events1.get(i).get(6)));
            event.add(String.valueOf(events1.get(i).get(7)));
            eventView.add(event);
        }

        for (int i = 0; i<meetings.size() ; i++){
            List<Object> meeting = new ArrayList<>();
            meeting.add(String.valueOf(meetings.get(i).get(0)));
            meeting.add(" - ");
            meeting.add(String.valueOf(meetings.get(i).get(1)));
            meeting.add(String.valueOf(meetings.get(i).get(2)));
            meeting.add(String.valueOf(meetings.get(i).get(3)));
            meeting.add(String.valueOf(meetings.get(i).get(4)));
            meeting.add(" - ");
            meeting.add(String.valueOf(meetings.get(i).get(5)));
            meeting.add(String.valueOf(meetings.get(i).get(6)));
            meeting.add(String.valueOf(meetings.get(i).get(7)));
            eventView.add(meeting);
        }

        for (int i = 0; i<activity.size();i++){
            List<Object> activity1 = new ArrayList<>();
            activity1.add(String.valueOf(activity.get(i).get(0)));
            activity1.add(String.valueOf(activity.get(i).get(1)));
            activity1.add(String.valueOf(activity.get(i).get(2)));
            activity1.add(String.valueOf(activity.get(i).get(3)));
            activity1.add(String.valueOf(activity.get(i).get(4)));
            activity1.add(String.valueOf(activity.get(i).get(5)));
            activity1.add(String.valueOf(activity.get(i).get(6)));
            activity1.add(" - ");
            activity1.add(String.valueOf(activity.get(i).get(7)));
            activity1.add(String.valueOf(activity.get(i).get(8)));
            eventView.add(activity1);
        }
        String clubId = "C01";
        for (int i = 0; i < eventView.size(); i++){
            if (String.valueOf(eventView.get(i).get(7)).equalsIgnoreCase(clubId)){
                eventSchedule.add(eventView.get(i));
            }
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowEventScheduleForStudent.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Show event Schedule");
        stage.setScene(scene);
        stage.show();
    }


}