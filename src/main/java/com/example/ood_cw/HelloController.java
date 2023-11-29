package com.example.ood_cw;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Duration;

public class HelloController{
    public static List<List<Object>> events = new ArrayList<>();
    public static List<List<Object>> allEvents = new ArrayList<>();
    public static List<List<Object>> events1 = new ArrayList<>();
    public static List<List<Object>> meetings = new ArrayList<>();
    public static List<List<Object>> activity = new ArrayList<>();
    public static List<String> advisorID = EnterClubName.advisorID;
    public static List<String> clubID = EnterClubName.clubID;
    public static List<List<Object>> mainList = new ArrayList<>();
    public AnchorPane eventSchedulingAnchor;
    public Label eventAddSuccessfull;
    public Label meetingAddSuccessfull;
    public Label activityAddSuccessfull;
    public TextField clubNameText;
    public Label clubNameError;
    public Button closeButton;
    public AnchorPane notificationPane;
    public AnchorPane clubMenuPane;
    public Button createClubs;
    public Button showClubs;
    public Button manageClubs;
    public Button backClubMenu;
    public Label StudentSignUpEmailAlert;
    public Label AdvisorSignUpContactNoAlert;
    public Label AdvisorSignUpEmailAlert;
    public Label StudentLoginEmailAlert;
    public Label StudentLoginPasswordlAlert;
    public Label AdvisorLoginEmailAlert;
    public Label AdvisorLoginPasswordAlert;
    public Label StudentSignUpContactNoAlert;
    public Label StudentLoginPasswordAlert;
    public Label AdvisorSignUpFirstNameAlertID;
    public Label AdvisorSignUpLastNameAlertID;
    public Label AdvisorSignUpContactNolAlertID;
    public Label AdvisorSignUpDOBlAlertID;
    public Label AdvisorSignUpPasswordlAler;
    public Button StuSignUpID;
    public Label StudentSignUpFirstNameAlertID;
    public Label StudentSignUpLNameID;
    public Label StudentSignUpDOBlAlertID;
    public Label StudentSignUpPasswordlAlertID;
    public Label StudentSignUpLastNameAlertID;
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
    public static List<List<Object>> checkList = new ArrayList<>();
    public static List<List<Object>> studentDetails = new ArrayList<>();
    public static List<List<Object>> advisorDetails = new ArrayList<>();
    public static List<Object> studentID = new ArrayList<>();
    public static List<List<Object>> clubs = new ArrayList<>();
    public static List<List<Object>> attendance = new ArrayList<>();
    public static List<List<Object>> registration = new ArrayList<>();

    public void onYeranButtonClick() throws IOException {
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
        //sample event data
        List<Object> event = new ArrayList<>();
        event.add("E001");
        event.add("Spandana");
        event.add("Viharamahadevi");
        event.add("08:30");
        event.add("musical event");
        event.add("2023-12-23");
        event.add(" - ");
        event.add(" - ");
        event.add("C001");
        event.add("AD01");
        events.add(event);

        List<Object> event1 = new ArrayList<>();
        event1.add("M001");
        event1.add(" - ");
        event1.add("Hilton");
        event1.add("08:30");
        event1.add("Batch meeting");
        event1.add("2023-12-23");
        event1.add(" - ");
        event1.add("2-hours");
        event1.add("C002");
        event1.add("AD01");
        events.add(event1);

        List<Object> event2 = new ArrayList<>();
        event2.add("A001");
        event2.add("Game Fiesta");
        event2.add("Club Fusion");
        event2.add("08:30");
        event2.add("A game event");
        event2.add("2023-12-23");
        event2.add("2023-12-25");
        event2.add(" - ");
        event2.add("C003");
        event2.add("AD01");
        events.add(event2);

        //sample club data
        List<Object> subCheck1 = new ArrayList<>();
        subCheck1.add("C001");
        subCheck1.add("Interact Club");
        subCheck1.add("2023-11-25");
        subCheck1.add("Light from heaven");
        subCheck1.add("Social Service");
        subCheck1.add("Tharusha Fernando");
        subCheck1.add("Uththara Godahenage");
        subCheck1.add("interact@gmail.com");
        subCheck1.add("+94712345672");
        subCheck1.add("C:\\Users\\Tharusha\\Pictures\\abc.jpg");
        checkList.add(subCheck1);

        List<Object> subCheck2 = new ArrayList<>();
        subCheck2.add("C002");
        subCheck2.add("Leo Club");
        subCheck2.add("2023-11-15");
        subCheck2.add("We lead others follow");
        subCheck2.add("Helping others");
        subCheck2.add("Yeran Fernando");
        subCheck2.add("Sarath Bandara");
        subCheck2.add("leo@gmail.com");
        subCheck2.add("+94771231167");
        subCheck2.add("C:\\Users\\Tharusha\\Pictures\\def.jpg");
        checkList.add(subCheck2);

        List<Object> subCheck3 = new ArrayList<>();
        subCheck3.add("C003");
        subCheck3.add("IEEE Club");
        subCheck3.add("2023-11-08");
        subCheck3.add("Experimenting new virtues");
        subCheck3.add("Spreading knowledge");
        subCheck3.add("Vanuja Silva");
        subCheck3.add("Oggy Perera");
        subCheck3.add("ieee@gmail.com");
        subCheck3.add("+94781231167");
        subCheck3.add("C:\\Users\\Tharusha\\Pictures\\ghi.jpg");
        checkList.add(subCheck3);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Attendance.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Attendance");
        stage.setScene(scene);
        stage.show();
        Stage preStage = (Stage) sampleAnchor.getScene().getWindow();
        preStage.close();
    }

    public void onTharushaButtonClick() throws IOException, SQLException {
        mainList.clear();
        List<Object> subCheck1 = new ArrayList<>();
        subCheck1.add("C005");
        subCheck1.add("Interact Club");
        subCheck1.add("2023-11-25");
        subCheck1.add("Light from heaven");
        subCheck1.add("Social Service");
        subCheck1.add("Tharusha Fernando");
        subCheck1.add("AD01");
        subCheck1.add("interact@gmail.com");
        subCheck1.add("+94712345672");
        subCheck1.add("C:\\Users\\Tharusha\\Pictures\\abc.jpg");
        mainList.add(subCheck1);
        List<Object> club = new ArrayList<>();
        club.add("C006");
        club.add("Rotrack");
        club.add("2023-11-25");
        club.add("Dakuna perata");
        club.add("Club description");
        club.add("Mahinda raja");
        club.add("AD01");
        club.add("rotrack@gmail.com");
        club.add("0771234567");
        club.add("path");
        mainList.add(club);
        List<Object> club1 = new ArrayList<>();
        club1.add("C007");
        club1.add("Leo");
        club1.add("2023-11-25");
        club1.add("Dakuna perata");
        club1.add("Club description");
        club1.add("Sumahinda raja");
        club1.add("AD02");
        club1.add("leo@gmail.com");
        club1.add("0771234567");
        club1.add("path");
        mainList.add(club1);
        DatabaseConnect.getDetailsOfClubs();
        System.out.println(clubs);
        for (int i = 0; i<mainList.size();i++){
            DatabaseConnect.insertDetailsOfClubs(String.valueOf(mainList.get(i).get(0)),String.valueOf(mainList.get(i).get(1)),String.valueOf(mainList.get(i).get(2)),String.valueOf(mainList.get(i).get(3)),String.valueOf(mainList.get(i).get(4)),String.valueOf(mainList.get(i).get(5)),String.valueOf(mainList.get(i).get(6)),String.valueOf(mainList.get(i).get(7)),String.valueOf(mainList.get(i).get(8)),String.valueOf(mainList.get(i).get(9)));
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        sampleAnchor.getChildren().setAll(pane);
    }

    public void onAvishkaButtonClick() throws IOException, SQLException {
        DatabaseConnect.getDetailsOfClubs();
        System.out.println(clubs);
//        for (int i = 0; i<mainList.size();i++){
//            DatabaseConnect.insertDetailsOfClubs(String.valueOf(mainList.get(i).get(0)),String.valueOf(mainList.get(i).get(1)),String.valueOf(mainList.get(i).get(2)),String.valueOf(mainList.get(i).get(3)),String.valueOf(mainList.get(i).get(4)),String.valueOf(mainList.get(i).get(5)),String.valueOf(mainList.get(i).get(6)),String.valueOf(mainList.get(i).get(7)),String.valueOf(mainList.get(i).get(8)),String.valueOf(mainList.get(i).get(9)));
//        }
        List<Object> student = new ArrayList<>();
        student.add("S001");
        student.add("Avishka");
        student.add("Shenan");
        student.add("2002-07-07");
        student.add("0771234567");
        student.add("avishkashenan@gmail.com");
        student.add("avishka123");
        studentDetails.add(student);


        List<Object> advisor = new ArrayList<>();
        advisor.add("AD01");
        advisor.add("Avishka");
        advisor.add("Shenan");
        advisor.add("2002-07-07");
        advisor.add("0771234567");
        advisor.add("avishka@gmail.com");
        advisor.add("avishka123");
        advisorDetails.add(advisor);
        System.out.println(studentDetails);
        System.out.println(advisorDetails);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Welcome.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();

//        Stage previousStage = (Stage) sampleAnchor.getScene().getWindow();
//        previousStage.close();
    }

    public AnchorPane enterClubNameAnchor;
    public ListView<String> clubNamesView;



    public void onScheduleEventButtonClick() throws IOException { //load the fxml to schedule events
        events1.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("E")){
                events1.add(events.get(i));
            }
        }
        System.out.println(events1);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ScheduleEvents.fxml"));
        eventSchedulingAnchor.getChildren().setAll(pane);
    }

    public void onScheduleMeetingButtonClick() throws IOException{ //load the fxml to schedule meetings
        meetings.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("M")){
                meetings.add(events.get(i));
            }
        }
        System.out.println(meetings);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ScheduleMeetings.fxml"));
        eventSchedulingAnchor.getChildren().setAll(pane);
    }

    public void onScheduleActivityButtonClick() throws IOException{ //load the fxml to schedule activities
        activity.clear();
        for (int i = 0; i<events.size(); i++){
            String e = (String) events.get(i).get(0);
            e = e.substring(0,1);
            if (e.equals("A")){
                activity.add(events.get(i));
            }
        }
        System.out.println(activity);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("SheduleActivities.fxml"));
        eventSchedulingAnchor.getChildren().setAll(pane);

    }
    public void onBackEventScheduleButtonClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EnterClubName.fxml"));
        eventSchedulingAnchor.getChildren().setAll(pane);
    }


    public void onScheduleEventsButtonClick() throws IOException, SQLException { //when user select the event schedule button
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
            } else { //checking the date
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
            if (errors > 0){
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(event -> {
                    nameError.setText("");
                    locationError.setText("");
                    timeError.setText("");
                    dateError.setText("");
                    eventDateTick.setText("");
                    eventTimeTick.setText("");
                    eventLocTick.setText("");
                    eventNameTick.setText("");
                    eventNameText.setStyle("-fx-border-color: none;");
                    eventLocationText.setStyle("-fx-border-color: none;");
                    eventTimeText.setStyle("-fx-border-color: none;");
                    eventDateText.setStyle("-fx-border-color: none;");
                });
                pause.play();
                break;
            }
            String date = String.valueOf(obj.getEventDate());
            List<List<Object>> allEvents1 = new ArrayList<>();
            for (int j = 0; j<allEvents.size(); j++){
                String e = (String) allEvents.get(j).get(0);
                e = e.substring(0,1);
                if (e.equals("E")){
                    allEvents1.add(allEvents.get(j));
                }
            }
            for (int i = 0; i < allEvents1.size(); i++){ //checking if the user entered event already exist or not
                if (allEvents1.get(i).get(1).equals(obj.getEventName()) && String.valueOf(allEvents1.get(i).get(5)).equals(date)){
                    eventAddSuccessfull.setStyle("-fx-text-fill: #ff0000;");
                    eventAddSuccessfull.setText("Entered Event already exist!");
                    PauseTransition pause = new PauseTransition(Duration.seconds(4));
                    // Set the action to be performed when the pause is finished
                    pause.setOnFinished(event -> {
                        // Remove the text after 5 seconds
                        eventAddSuccessfull.setText("");
                    });
                    // Start the pause transition
                    pause.play();
                    break outerloop;
                }
            }
            int max =0; //getting the id
            for (int i = 0 ; i < allEvents1.size() ; i++){
                String e = (String) allEvents1.get(i).get(0);
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
            event.add(clubID.get(0));
            event.add(advisorID.get(0));
            events.add(event);
            events1.add(event);
            allEvents1.add(event);
            allEvents.add(event);
            DatabaseConnect.insertScheduleOfClubSession(String.valueOf(event.get(0)),String.valueOf(event.get(1)),String.valueOf(event.get(2)),String.valueOf(event.get(3)),String.valueOf(event.get(4)),String.valueOf(event.get(5)),String.valueOf(event.get(6)),String.valueOf(event.get(7)),String.valueOf(event.get(8)),String.valueOf(event.get(9)));
            eventAddSuccessfull.setStyle("-fx-text-fill: #13e57d;");
            eventAddSuccessfull.setText("Event added Successfully");
            PauseTransition pause = new PauseTransition(Duration.seconds(4));
            // Set the action to be performed when the pause is finished
            pause.setOnFinished(event1 -> {
                // Remove the text after 5 seconds
                eventAddSuccessfull.setText("");
            });
            // Start the pause transition
            pause.play();
            break;
        }
    }
    public void onScheduleEventsBackButtonClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EventScheduling.fxml"));
        scheduleEventAnchor.getChildren().setAll(pane);
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
            if (obj.getEventDescription().isEmpty()){
                obj.setEventDescription(" - ");
            }
            if (enteredDate.equals("null")){
                obj.setLabel(meetingDateError,meetingDateText,meetDateTick);
                errors++;
            } else {
                try { // converting the date to local date
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

            List<List<Object>> allMeetings = new ArrayList<>();
            for (int j = 0; j<allEvents.size(); j++){ //getting all the meetings
                String e = (String) allEvents.get(j).get(0);
                e = e.substring(0,1);
                if (e.equals("M")){
                    allMeetings.add(allEvents.get(j));
                }
            }

            for (int i = 0; i < allMeetings.size(); i++){ //checking if the meeting already exists or not
                if (allMeetings.get(i).get(2).equals(obj.getEventLocation()) && String.valueOf(allMeetings.get(i).get(5)).equals(date) && allMeetings.get(i).get(3).equals(obj.getEventTime())){
                    meetingAddSuccessfull.setStyle("-fx-text-fill: #ff0000;");
                    meetingAddSuccessfull.setText("Entered Meeting already exist!");
                    PauseTransition pause = new PauseTransition(Duration.seconds(4));
                    // Set the action to be performed when the pause is finished
                    pause.setOnFinished(event -> {
                        // Remove the text after 5 seconds
                        meetingAddSuccessfull.setText("");
                    });
                    // Start the pause transition
                    pause.play();
                    break outerloop;
                }
            }
            int max =0; //generating the id mor the meeting
            for (int i = 0 ; i < allMeetings.size() ; i++){
                String e = (String) allMeetings.get(i).get(0);
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
            meeting.add(clubID.get(0));
            meeting.add(advisorID.get(0));
            events.add(meeting);
            meetings.add(meeting);
            allEvents.add(meeting);
            DatabaseConnect.insertScheduleOfClubSession(String.valueOf(meeting.get(0)),String.valueOf(meeting.get(1)),String.valueOf(meeting.get(2)),String.valueOf(meeting.get(3)),String.valueOf(meeting.get(4)),String.valueOf(meeting.get(5)),String.valueOf(meeting.get(6)),String.valueOf(meeting.get(7)),String.valueOf(meeting.get(8)),String.valueOf(meeting.get(9)));
            meetingAddSuccessfull.setStyle("-fx-text-fill: #13e57d;");
            meetingAddSuccessfull.setText("Meeting added Successfully");
            PauseTransition pause = new PauseTransition(Duration.seconds(4));
            // Set the action to be performed when the pause is finished
            pause.setOnFinished(event -> {
                // Remove the text after 5 seconds
                meetingAddSuccessfull.setText("");
            });
            // Start the pause transition
            pause.play();
            break;
        }
    }
    public void onSheduleMeetingsBackButtonClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EventScheduling.fxml"));
        scheduleMeetingAnchor.getChildren().setAll(pane);
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


    public void onActivityScheduleButtonClick() throws IOException, SQLException {
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
            if (obj.getEventDescription().isEmpty()){
                obj.setEventDescription(" - ");
            }
            int sYear = 0;
            int sMonth = 0;
            int sDay = 0;
            LocalDate sGivenDate = null;

            if (startDate.equals("null")){
                obj.setLabel(activityStartDateError,activityStartDateText,activityStartDateTick);
                errors++;
            } else { //converting the start date into localDate type
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
            }else { //converting the lastDate to local date type
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

            List<List<Object>> allActivities = new ArrayList<>();
            for (int j = 0; j<allEvents.size(); j++){ //getting all the activities
                String e = (String) allEvents.get(j).get(0);
                e = e.substring(0,1);
                if (e.equals("A")){
                    allActivities.add(allEvents.get(j));
                }
            }

            for (int i = 0; i < allActivities.size(); i++){ //checking if the activity already exists
                if (allActivities.get(i).get(1).equals(obj.getEventName()) && String.valueOf(allActivities.get(i).get(5)).equals(date) && String.valueOf(allActivities.get(i).get(6)).equals(date1)){

                    activityAddSuccessfull.setStyle("-fx-text-fill: #ff0000;");
                    activityAddSuccessfull.setText("Entered Activity already exist!");
                    PauseTransition pause = new PauseTransition(Duration.seconds(4));
                    // Set the action to be performed when the pause is finished
                    pause.setOnFinished(event -> {
                        // Remove the text after 5 seconds
                        activityAddSuccessfull.setText("");
                    });
                    // Start the pause transition
                    pause.play();
                    break outerloop;
                }
            }
            int max =0; //generating the activity id
            for (int i = 0 ; i < allActivities.size() ; i++){
                String e = (String) allActivities.get(i).get(0);
                int curValue = Integer.parseInt(e.substring(1,4));
                if (max < curValue){
                    max = curValue;
                }
            }
            max = max + 1;
            String id = String.format("%03d",max);
            id = "A"+id;
            List<Object> activity1 = new ArrayList<>();
            activity1.add(id);
            activity1.add(obj.getEventName());
            activity1.add(obj.getEventLocation());
            activity1.add(obj.getEventTime());
            activity1.add(obj.getEventDescription());
            activity1.add(obj.getEventDate());
            activity1.add(obj.getEndDate());
            activity1.add(" - ");
            activity1.add(clubID.get(0));
            activity1.add(advisorID.get(0));
            events.add(activity1);
            activity.add(activity1);
            allEvents.add(activity1);
//            DatabaseConnect.clearTableOfClubSession();
//            for (int i=0 ;i<allEvents.size(); i++){
//                DatabaseConnect.insertScheduleOfClubSession(String.valueOf(allEvents.get(i).get(0)),String.valueOf(allEvents.get(i).get(1)),String.valueOf(allEvents.get(i).get(2)),String.valueOf(allEvents.get(i).get(3)),String.valueOf(allEvents.get(i).get(4)),String.valueOf(allEvents.get(i).get(5)),String.valueOf(allEvents.get(i).get(6)),String.valueOf(allEvents.get(i).get(7)),String.valueOf(allEvents.get(i).get(8)),String.valueOf(allEvents.get(i).get(9)));
//            }
            DatabaseConnect.insertScheduleOfClubSession(String.valueOf(activity1.get(0)),String.valueOf(activity1.get(1)),String.valueOf(activity1.get(2)),String.valueOf(activity1.get(3)),String.valueOf(activity1.get(4)),String.valueOf(activity1.get(5)),String.valueOf(activity1.get(6)),String.valueOf(activity1.get(7)),String.valueOf(activity1.get(8)),String.valueOf(activity1.get(9)));
            activityAddSuccessfull.setStyle("-fx-text-fill: #13e57d;");
            activityAddSuccessfull.setText("Activity added Successfully");
            PauseTransition pause = new PauseTransition(Duration.seconds(4));
            // Set the action to be performed when the pause is finished
            pause.setOnFinished(event -> {
                // Remove the text after 5 seconds
                activityAddSuccessfull.setText("");
            });
            // Start the pause transition
            pause.play();
            break;
        }
    }

    public void onActivityScheduleBackButtonClick() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EventScheduling.fxml"));
        scheduleActivityAnchor.getChildren().setAll(pane);
    }

    public static List<List<Object>> eventView = new ArrayList<>();
    public void onEventSchedulingViewOrDeleteButtonClick() throws IOException {
        eventView.clear();
        for (int i=0; i<events.size();i++){ //converting all the data of the events to String
            List<Object> event = new ArrayList<>();
            event.add(String.valueOf(events.get(i).get(0)));
            event.add(String.valueOf(events.get(i).get(1)));
            event.add(String.valueOf(events.get(i).get(2)));
            event.add(String.valueOf(events.get(i).get(3)));
            event.add(String.valueOf(events.get(i).get(4)));
            event.add(String.valueOf(events.get(i).get(5)));
            event.add(String.valueOf(events.get(i).get(6)));
            event.add(String.valueOf(events.get(i).get(7)));
            event.add(String.valueOf(events.get(i).get(8)));
            event.add(String.valueOf(events.get(i).get(9)));
            eventView.add(event);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewOrDeleteEvents.fxml"));
        eventSchedulingAnchor.getChildren().setAll(pane);
    }
    public static List<List<Object>> eventSchedule = new ArrayList<>();
    public void onShowEventScheduleForStudentButtonClick() throws IOException {
        DatabaseConnect.getScheduleOfClubSesion();
        for (int j=0; j<allEvents.size();j++){
            int sYear = Integer.parseInt(String.valueOf(allEvents.get(j).get(5)).substring(0, 4));
            int sMonth = Integer.parseInt(String.valueOf(allEvents.get(j).get(5)).substring(5, 7));
            int sDay = Integer.parseInt(String.valueOf(allEvents.get(j).get(5)).substring(8, 10));
            LocalDate date = LocalDate.of(sYear, sMonth, sDay);
            allEvents.get(j).set(5,date);
        }
        LocalDate currentDate = LocalDate.now();
        for (int j=0;j<allEvents.size();j++){
            if (currentDate.isAfter((LocalDate) allEvents.get(j).get(5))){
                allEvents.remove(j);
            }
        }
        //need to be changed
        List<Object> studentClubs = new ArrayList<>();
        studentClubs.add("C001");
        studentClubs.add("C002");
        eventSchedule.clear();
        for (int i=0;i<studentClubs.size();i++){
            for (int j=0;j<allEvents.size();j++){
                if (allEvents.get(j).get(8).equals(studentClubs.get(i))){
                    eventSchedule.add(allEvents.get(j));
                }
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowEventScheduleForStudent.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Show event Schedule");
        stage.setScene(scene);
        stage.show();
    }


    public void onCloseButtonClick(ActionEvent actionEvent) { //attendance notification close button
        Stage preStage = (Stage) notificationPane.getScene().getWindow();
        preStage.close();
    }

    @FXML
    private Button StartID;
    public void onStartClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) StartID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    @FXML
    private Button StudentButtonID;
    @FXML
    private Button advisorbuttonID;
    @FXML
    private Button SecondBackButtonId;

    public void onStudentClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) StudentButtonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void onAdvisorClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) advisorbuttonID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public void SecondBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) SecondBackButtonId.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public TextField StudentSignUpLastNameID;
    public TextField StudentSignUpFirstNameID;
    public TextField StudentSignUpContactNoID;
    public TextField StudentSignUpEmailID;
    public DatePicker StudentSignUpDOBID;
    public AnchorPane StuSignUpAnchorID;
    public PasswordField StudentSignUpPassword;
    @FXML
    private Button StuSignUpBackID;

    public void StudentSignUpClickID() throws IOException, SQLException {
        Student obj = new Student();
        obj.setFirstName(StudentSignUpFirstNameID.getText());
        obj.setLastName(StudentSignUpLastNameID.getText());
        obj.setDob(String.valueOf(StudentSignUpDOBID.getValue()));
        obj.setTelNo(StudentSignUpContactNoID.getText());
        obj.setEmail(StudentSignUpEmailID.getText());
        String password = StudentSignUpPassword.getText();
        int count =0;
        if (obj.getFirstName().isEmpty()){
            StudentSignUpFirstNameID.setStyle("-fx-border-color: red;");
            StudentSignUpFirstNameAlertID.setText("Fill the Blanks");
            StudentSignUpFirstNameAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            StudentSignUpFirstNameID.setStyle("-fx-border-color: green;");
            StudentSignUpFirstNameAlertID.setText("");
        }

        if (obj.getLastName().isEmpty()){
            StudentSignUpLastNameID.setStyle("-fx-border-color: red;");
            StudentSignUpLastNameAlertID.setText("Fill the Blanks");
            StudentSignUpLastNameAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            StudentSignUpLastNameID.setStyle("-fx-border-color: green;");
            StudentSignUpLastNameAlertID.setText("");
        }
        if (obj.getDob().equals("null")){
            StudentSignUpDOBID.setStyle("-fx-border-color: red;");
            StudentSignUpDOBlAlertID.setText("Fill the Blanks");
            StudentSignUpDOBlAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            StudentSignUpDOBID.setStyle("-fx-border-color: green;");
            StudentSignUpDOBlAlertID.setText("");
        }
        if (obj.getEmail().isEmpty()){
            StudentSignUpEmailID.setStyle("-fx-border-color: red;");
            StudentSignUpEmailAlert.setText("Fill the Blanks");
            StudentSignUpEmailAlert.setStyle("-fx-text-fill: red;");
            count++;
        } else if (Club.isValidEmail(obj.getEmail())) {
            StudentSignUpEmailID.setStyle("-fx-border-color: green;");
            StudentSignUpEmailAlert.setText("");
            for (List<Object> i : studentDetails){
                if(String.valueOf(i.get(5)).equals(obj.getEmail())){
                    count++;
                    StudentSignUpEmailAlert.setStyle("-fx-text-fill: red;");
                    StudentSignUpEmailAlert.setText("Email already exist!");
                    StudentSignUpEmailID.setStyle("-fx-border-color: none;");
                }
            }
        } else {
            StudentSignUpEmailAlert.setStyle("-fx-text-fill: red;");
            StudentSignUpEmailAlert.setText("Please enter valid email!");
            count++;
        }
        if (obj.getTelNo().isEmpty()) {
            StudentSignUpContactNoID.setStyle("-fx-border-color: red;");
            StudentSignUpContactNoAlert.setStyle("-fx-text-fill: red;");
            StudentSignUpContactNoAlert.setText("Fill the Blanks");
            count++;
        } else {
            StudentSignUpContactNoID.setStyle("-fx-border-color: green");
            StudentSignUpContactNoAlert.setText("");
        }

//        if (Club.isValidContactNo("+94"+obj.getTelNo())){
//            StudentSignUpContactNoID.setStyle("-fx-border-color: green");
//        } else {
//            StudentSignUpContactNoAlert.setStyle("-fx-text-fill: red;");
//            StudentSignUpContactNoAlert.setText("Please enter a valid Conatct No");
//            count++;
//        }



        if (password.isEmpty()){
            StudentSignUpPassword.setStyle("-fx-border-color: red;");
            StudentSignUpPasswordlAlertID.setText("Fill the Blanks");
            StudentSignUpPasswordlAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            StudentSignUpPassword.setStyle("-fx-border-color: green;");
            StudentSignUpPasswordlAlertID.setText("");
        }

        if (count>0){
            return;
        }
        int max =0;
        for (int i = 0 ; i < studentDetails.size() ; i++){
            String e = (String) studentDetails.get(i).get(0);
            int curValue = Integer.parseInt(e.substring(1,4));
            if (max < curValue){
                max = curValue;
            }
        }
        max = max + 1;
        String id = String.format("%03d",max);
        id = "S"+id;
        System.out.println(id);
        studentID.clear();
        studentID.add(id);
        List<Object> student = new ArrayList<>();
        student.add(id);
        student.add(obj.getFirstName());
        student.add(obj.getLastName());
        student.add(obj.getDob());
        student.add(obj.getTelNo());
        student.add(obj.getEmail());
        student.add(password);
        studentDetails.add(student);
        DatabaseConnect.insertStudentDetails(String.valueOf(student.get(0)),String.valueOf(student.get(1)),String.valueOf(student.get(2)),String.valueOf(student.get(3)),String.valueOf(student.get(4)),String.valueOf(student.get(5)),String.valueOf(student.get(6)));
        DatabaseConnect.getStudentDetails();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) StuSignUpID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void StuSignUpBackClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) StuSignUpAnchorID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    @FXML
    private AnchorPane AdvisorSignUpAnchorID;

    @FXML
    private Button AdvisorSignUpBackID;

    @FXML
    private TextField AdvisorSignUpContactNoID;

    @FXML
    private DatePicker AdvisorSignUpDOBID;

    @FXML
    private TextField AdvisorSignUpEmailID;

    @FXML
    private TextField AdvisorSignUpFNameID;

    @FXML
    private Button AdvisorSignUpID;

    @FXML
    private TextField AdvisorSignUpLNameID;

    @FXML
    private PasswordField AdvisorSignUpPasswordID;

    public void AdvisorSignUpClick() throws IOException, SQLException {
        System.out.println(advisorDetails);
        Advisor obj = new Advisor();
        obj.setFirstName(AdvisorSignUpFNameID.getText());
        obj.setLastName(AdvisorSignUpLNameID.getText());
        obj.setDob(String.valueOf(AdvisorSignUpDOBID.getValue()));
        obj.setTelNo("+94" + AdvisorSignUpContactNoID.getText());
        obj.setEmail(AdvisorSignUpEmailID.getText());
        String password = AdvisorSignUpPasswordID.getText();
        int count =0;
        if (obj.getFirstName().isEmpty()){
            AdvisorSignUpFNameID.setStyle("-fx-border-color: red;");
            AdvisorSignUpFirstNameAlertID.setText("Fill this field");
            AdvisorSignUpFirstNameAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            AdvisorSignUpFNameID.setStyle("-fx-border-color: green;");
            AdvisorSignUpFirstNameAlertID.setText("");
        }
        if (obj.getLastName().isEmpty()){
            AdvisorSignUpLNameID.setStyle("-fx-border-color: red;");
            AdvisorSignUpLastNameAlertID.setText("Fill this field");
            AdvisorSignUpLastNameAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            AdvisorSignUpLNameID.setStyle("-fx-border-color: green;");
            AdvisorSignUpLastNameAlertID.setText("");
        }
        if (obj.getDob().equals("null")){
            AdvisorSignUpDOBID.setStyle("-fx-border-color: red;");
            AdvisorSignUpDOBlAlertID.setText("Fill the blanks");
            AdvisorSignUpDOBlAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            AdvisorSignUpDOBID.setStyle("-fx-border-color: green;");
            AdvisorSignUpDOBlAlertID.setText("");
        }


        if (obj.getEmail().isEmpty()){
            AdvisorSignUpEmailID.setStyle("-fx-border-color: red;");
            AdvisorSignUpEmailAlert.setText("Fill the blanks");
            AdvisorSignUpEmailAlert.setStyle("-fx-text-fill: red;");
            count++;
        } else if (Club.isValidEmail(obj.getEmail())){
            AdvisorSignUpEmailID.setStyle("-fx-border-color: green;");
            AdvisorSignUpEmailAlert.setText("");
            for (List<Object> i : advisorDetails){
                if(String.valueOf(i.get(5)).equals(obj.getEmail())){
                    count++;
                    AdvisorSignUpEmailAlert.setText("Email already exixts!");
                    AdvisorSignUpEmailID.setStyle("-fx-border-color: none;");
                }
            }
        } else {
            AdvisorSignUpEmailAlert.setText("Please enter valid email!");
            AdvisorSignUpEmailAlert.setStyle("-fx-text-fill: red;");
            count++;
        }
        if (obj.getTelNo().isEmpty()){
            AdvisorSignUpContactNoID.setStyle("-fx-border-color: red;");
            AdvisorSignUpContactNolAlertID.setText("Fill this fields blanks");
            AdvisorSignUpContactNolAlertID.setStyle("-fx-text-fill: red;");
            count++;
        } else if (Club.isValidContactNo(AdvisorSignUpContactNoID.getText())){
            AdvisorSignUpContactNoID.setStyle("-fx-border-color: green;");
            AdvisorSignUpContactNolAlertID.setText("");
        } else {
            AdvisorSignUpContactNolAlertID.setStyle("-fx-text-fill: red;");
            AdvisorSignUpContactNolAlertID.setText("Please enter valid contact number!");
            count++;
        }
        if (password.isEmpty()){
            AdvisorSignUpPasswordID.setStyle("-fx-border-color: red;");
            AdvisorSignUpPasswordlAler.setText("Fill this field");
            AdvisorSignUpPasswordlAler.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            AdvisorSignUpPasswordID.setStyle("-fx-border-color: green;");
            AdvisorSignUpPasswordlAler.setText("");
        }

        if (count>0){
            return;
        }
        int max =0;
        for (int i = 0 ; i < advisorDetails.size() ; i++){
            String e = (String) advisorDetails.get(i).get(0);
            int curValue = Integer.parseInt(e.substring(2,4));
            if (max < curValue){
                max = curValue;
            }
        }
        max = max + 1;
        String id = String.format("%02d",max);
        id = "AD"+id;
        advisorID.clear();
        advisorID.add(id);
        List<Object> advisor = new ArrayList<>();
        advisor.add(id);
        advisor.add(obj.getFirstName());
        advisor.add(obj.getLastName());
        advisor.add(obj.getDob());
        advisor.add(obj.getTelNo());
        advisor.add(obj.getEmail());
        advisor.add(password);
        advisorDetails.add(advisor);
        DatabaseConnect.insertAdvisorDetails(String.valueOf(advisor.get(0)),String.valueOf(advisor.get(1)),String.valueOf(advisor.get(2)),String.valueOf(advisor.get(3)),String.valueOf(advisor.get(4)),String.valueOf(advisor.get(5)),String.valueOf(advisor.get(6)));
        DatabaseConnect.getAdvisorDetails();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        Stage primaryStage = (Stage) AdvisorSignUpID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void AdvisorSignUpBackClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) AdvisorSignUpBackID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private AnchorPane StudentLoginAnchor;

    @FXML
    private Button StudentLoginBackID;

    @FXML
    private Button StudentLoginButtonID;

    @FXML
    private Button StudentLoginPageSignUpId;

    @FXML
    private PasswordField StudentLoginPasswordID;

    @FXML
    private TextField StudentLoginEmailID;

    public void StudentLoginButtonClick(ActionEvent actionEvent) throws IOException {
        Student obj = new Student();
        obj.setEmail(StudentLoginEmailID.getText());
        String password = StudentLoginPasswordID.getText();
        int count =0;
        if (obj.getEmail().isEmpty()){
            StudentLoginEmailID.setStyle("-fx-border-color: red;");
            StudentLoginEmailAlert.setText("Please provide a email");
            StudentLoginEmailAlert.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            if (Club.isValidEmail(obj.getEmail())){
                StudentLoginEmailID.setStyle("-fx-border-color: green;");
                StudentLoginEmailAlert.setText("");
            } else {
                StudentLoginEmailID.setStyle("-fx-border-color: red;");
                StudentLoginEmailAlert.setText("Please provide a valid email");
                StudentLoginEmailAlert.setStyle("-fx-text-fill: red;");
                count++;
            }

        }
        if (password.isEmpty()){
            StudentLoginPasswordID.setStyle("-fx-border-color: red;");
            StudentLoginPasswordAlert.setText("Please provide a password");
            StudentLoginPasswordAlert.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            StudentLoginPasswordAlert.setText("");
            StudentLoginPasswordID.setStyle("-fx-border-color: none;");
        }
        int match =0;
        for (int i = 0; i<studentDetails.size();i++){
            if (studentDetails.get(i).get(5).equals(obj.getEmail()) && studentDetails.get(i).get(6).equals(password)){
                match++;
                studentID.clear();
                studentID.add(String.valueOf(studentDetails.get(i).get(0)));
                System.out.println("Load the menu for students");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentMenu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                Stage primaryStage = (Stage) StudentLoginButtonID.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();

                return;
            }
        }
        if (count>0){
            return;
        }
        if (match==0){
            StudentLoginPasswordAlert.setStyle("-fx-text-fill: red;");
            StudentLoginPasswordAlert.setText("Entered email and password doesn't match");
            StudentLoginEmailID.setStyle("-fx-border-color: none;");
        }
    }

    public void StudentLoginPageSignUpButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentSignUp.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) StudentLoginPageSignUpId.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void StudentLoginBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) StudentLoginBackID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    @FXML
    private AnchorPane AdvisorLoginAnchor;

    @FXML
    private Button AdvisorLoginBackID;

    @FXML
    private Button AdvisorLoginButtonID;

    @FXML
    private PasswordField AdvisorLoginPasswordID;

    @FXML
    private TextField AdvisorLoginEmailID;

    @FXML
    private Button AdvisorLoginPageSignUpId;
    public void AdvisorLoginButtonClick(ActionEvent actionEvent) throws IOException {
        Advisor obj = new Advisor();
        obj.setEmail(AdvisorLoginEmailID.getText());
        String password = AdvisorLoginPasswordID.getText();
        int count =0;
        if (!obj.getEmail().isEmpty()){
            if (Club.isValidEmail(obj.getEmail())) {
                AdvisorLoginEmailID.setStyle("-fx-border-color: green;");
            }
            else {
                AdvisorLoginEmailAlert.setText("Invalid email");
                AdvisorLoginEmailAlert.setStyle("-fx-text-fill: red;");
                count++;
            }
        }else {
            count++;
            AdvisorLoginEmailAlert.setText("Please enter an email");
            AdvisorLoginEmailAlert.setStyle("-fx-text-fill: red;");
        }
        if (password.isEmpty()){
            AdvisorLoginPasswordAlert.setText("Please enter a password!");
            AdvisorLoginPasswordAlert.setStyle("-fx-text-fill: red;");
            count++;
        } else {
            AdvisorLoginPasswordID.setStyle("-fx-border-color: none;");

        }
        int match =0;
        for (int i = 0; i<advisorDetails.size();i++){
            if (advisorDetails.get(i).get(5).equals(obj.getEmail()) && advisorDetails.get(i).get(6).equals(password)){
                match++;
                advisorID.clear();
                advisorID.add(String.valueOf(advisorDetails.get(i).get(0)));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorMenu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);


                Stage primaryStage = (Stage) AdvisorLoginButtonID.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();

                return;
            }
        }
        if (count>0){
            return;
        }
        if (match==0){
            AdvisorLoginEmailAlert.setText("");
            AdvisorLoginPasswordAlert.setText("Entered email and password does not match!");
        }

    }

    public void AdvisorLoginPageSignUpButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdvisorSignUp.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) AdvisorLoginPageSignUpId.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void AdvisorLoginBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage) AdvisorLoginBackID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void onCreateClubClick() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CreateClub.fxml"));
        clubMenuPane.getChildren().setAll(pane);
    }

    public void onManageClubClick() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ManageClub.fxml"));
        clubMenuPane.getChildren().setAll(pane);
    }

    public void onBackClubMenuClick() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdvisorMenu.fxml"));
        clubMenuPane.getChildren().setAll(pane);
    }


    public void onShowClubClick()throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("showClubs.fxml"));
        clubMenuPane.getChildren().setAll(pane);
    }
}