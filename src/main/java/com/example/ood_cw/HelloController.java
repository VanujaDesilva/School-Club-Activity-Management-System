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
        List<Object> event1 = new ArrayList<>();
        event1.add("E01");
        event1.add("Spandana");
        event1.add("Viharamahadevi");
        event1.add("18:00");
        event1.add("Musical event");
        event1.add("2023-12-16");
        event1.add("C01");
        event1.add("AD01");
        events.add(event1);

        List<Object> event2 = new ArrayList<>();
        event2.add("M01");
        event2.add("Hilton");
        event2.add("18:00");
        event2.add("The monthly meeting");
        event2.add("2023-12-18");
        event2.add("2 hours");
        event2.add("C01");
        event2.add("AD01");
        events.add(event2);

        List<Object> event3 = new ArrayList<>();
        event3.add("A01");
        event3.add("Game Fiesta");
        event3.add("Hilton");
        event3.add("18:00");
        event3.add("Game event");
        event3.add("2023-12-18");
        event3.add("2023-12-20");
        event3.add("C01");
        event3.add("AD01");
        events.add(event3);
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
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) sampleAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onVanujaButtonClick(ActionEvent actionEvent) {
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
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) eventSchedulingAnchor.getScene().getWindow();
        previousStage.close();
    }


    public void onScheduleEventsButtonClick() throws IOException {
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
            String date = String.valueOf(obj.getEventDate());
            for (int i = 0; i < events1.size(); i++){
                if (events1.get(i).get(1).equals(obj.getEventName()) && events1.get(i).get(5).equals(date)){
                    System.out.println("Event already exists");
                    break outerloop;
                }
            }
            System.out.println("Event should be added to the list");
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

    public void onScheduleMeetingsButtonClick()throws IOException {
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
                meetingLocationError.setText("This field must be filled!");
                meetingLocationText.setStyle("-fx-border-color: red;");
                meetLocTick.setText("");
                errors++;
            } else {
                meetingLocationError.setText("");
                meetLocTick.setText("\u2713");
                meetingLocationText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventTime().isEmpty()){
                meetingTimeError.setText("This field must be filled!");
                meetingTimeText.setStyle("-fx-border-color: red;");
                meetTimeTick.setText("");
                errors++;
            } else {
                meetingTimeError.setText("");
                meetTimeTick.setText("\u2713");
                meetingTimeText.setStyle("-fx-border-color: #13e57d;");
            }
            if (enteredDate.equals("null")){
                meetingDateError.setText("This field must be filled!");
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
                        meetingDateError.setText("Please select a future date!");
                        meetingDateText.setStyle("-fx-border-color: red;");
                        meetDateTick.setText("");
                        errors++;
                    } else {
                        meetingDateError.setText("");
                        meetingDateText.setStyle("-fx-border-color: #13e57d;");
                        meetDateTick.setText("\u2713");
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
                if (meetings.get(i).get(1).equals(obj.getEventLocation()) && meetings.get(i).get(4).equals(date)){
                    System.out.println("Meeting already exists");
                    break outerloop;
                }
            }
            System.out.println("Meeting should be added to the list");
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
                activityNameError.setText("This field must be filled!");
                activityNameText.setStyle("-fx-border-color: red;");
                activityNameTick.setText("");
                errors++;
            } else {
                activityNameError.setText("");
                activityNameTick.setText("\u2713");
                activityNameText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventLocation().isEmpty()){
                activityLocationError.setText("This field must be filled!");
                activityLocationText.setStyle("-fx-border-color: red;");
                activityLocTick.setText("");
                errors++;
            } else {
                activityLocationError.setText("");
                activityLocTick.setText("\u2713");
                activityLocationText.setStyle("-fx-border-color: #13e57d;");
            }
            if (obj.getEventTime().isEmpty()){
                activityTimeError.setText("This field must be filled!");
                activityTimeText.setStyle("-fx-border-color: red;");
                activityTimeTick.setText("");
                errors++;
            } else {
                activityTimeError.setText("");
                activityTimeTick.setText("\u2713");
                activityTimeText.setStyle("-fx-border-color: #13e57d;");
            }
            int sYear = 0;
            int sMonth = 0;
            int sDay = 0;
            LocalDate sGivenDate = null;

            if (startDate.equals("null")){
                activityStartDateError.setText("This field must be filled!");
                activityStartDateText.setStyle("-fx-border-color: red;");
                activityStartDateTick.setText("");
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
                        activityStartDateError.setText("");
                        activityStartDateText.setStyle("-fx-border-color: #13e57d;");
                        activityStartDateTick.setText("\u2713");
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
                activityEndDateError.setText("This field must be filled!");
                activityEndDateText.setStyle("-fx-border-color: red;");
                activityEndDateTick.setText("");
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
                        activityEndDateError.setText("");
                        activityEndDateText.setStyle("-fx-border-color: #13e57d;");
                        activityEndDateTick.setText("\u2713");
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

    @FXML
    private AnchorPane viewOrDeleteEventsAnchor;


}