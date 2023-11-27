package com.example.ood_cw;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.ood_cw.HelloController.events;
import static com.example.ood_cw.CreateClub.checkList;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import java.sql.*;

public class Attendance implements Initializable {
    public ChoiceBox eventSelector;
    public ChoiceBox<String> clubSelector;
    public Button showButton;
    public TableColumn stdIdCol;
    public TableColumn firstNameCol;
    public TableColumn lastNameCol;
    public TableColumn telNoCol;
    public TableColumn dobCol;
    public TableColumn attendanceStatusCol;
    public Label clubSelectionError;
    public Label eventSelectionError;
    public Button closeButton;
    public AnchorPane notificationPane;
    public Button atendanceBackButton;
    public AnchorPane attendancePane;
    @FXML
    private TableView<Student> attendanceTable;
    @FXML
    private Button saveButton;
    private final List<Object> eventNames = new ArrayList<>();

    private final List<Object> clubNames = new ArrayList<>();
    private ObservableList<Student> data;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String selectedClubId = null;
        System.out.println(checkList);
        this.data = FXCollections.observableArrayList(
                new Student("S001", "Jacob", "Smith", "0704594151", "2003-01-23"),
                new Student("S002", "Emma", "Johnson", "0712345678", "2002-05-15"),
                new Student("S003", "Velma", "Johnson", "0713345678", "2004-05-15"));
        System.out.println(events);
        eventSelector.getItems().addAll(eventNames);
        for(List<Object> club: checkList){
            String cName = String.valueOf(club.get(1));
            System.out.println(cName);
            clubNames.add(cName);
        }
        clubSelector.getItems().addAll(String.valueOf(clubNames));


        for (List<Object> clubs : checkList) {
            if(clubSelector.getValue() == clubs.get(1)){
                selectedClubId = String.valueOf(clubs.get(0));
            }
        }
        for (List<Object> event : events) {
            if(event.get(8) == selectedClubId) {
                String eName = String.valueOf(event.get(1));
                if (Objects.equals(eName, " - ")) {
                    eName = String.valueOf(event.get(0));
                }
                System.out.println(eName);
                eventNames.add(eName);
            }
        }

        stdIdCol.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telNoCol.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        attendanceStatusCol.setCellValueFactory(new PropertyValueFactory<Student,String>("status"));
    }
    public static void insertAttendance(String studentId, String sessionId, String studentStatus) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO attendance (studentId ,sessionId,studentStatus) VALUES (?, ?, ?)";
            try (PreparedStatement attend = connection.prepareStatement(query)) {
                attend.setString(1, studentId);
                attend.setString(2, sessionId);
                attend.setString(3, studentStatus);
                attend.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleSaveButtonAction(ActionEvent actionEvent) throws SQLException, Exception {
        List<Student> savedAttendanceList = new ArrayList<>(attendanceTable.getItems());
        String attendance;
        String eventId = null;
        for(List<Object> event : events) { // select event ID by using event name
            if (eventSelector.getValue() == event.get(1)) {
                eventId = String.valueOf(event.get(0));
            }
        }
        for (Student std : savedAttendanceList) {
            if (std.getStatus().isSelected()) {
                attendance = "Present";
            } else {
                attendance = "Absent";
            }
            System.out.println("Student ID: " + std.getStdId() + ", Attendance Status: " + attendance);
            insertAttendance(std.getStdId(), eventId, attendance);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AttendanceSave.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();

        attendanceTable.getItems().clear();
        eventSelector.getItems().clear();
        clubSelector.getItems().clear();
        clubSelector.setStyle("-fx-border-color: none;");
        eventSelector.setStyle("-fx-border-color: none;");
    }

    public void onShowButtonClick() throws IOException {
        String selectedClub = clubSelector.getValue();
        String selectedEvent = (String) eventSelector.getValue();

        // Check if both club and event are selected
        if (selectedClub != null && selectedEvent != null) {
            this.attendanceTable.setItems(this.data);
            eventSelector.setStyle("-fx-border-color: green;");
            clubSelector.setStyle("-fx-border-color: green;");
        } else if (selectedClub == null) {
            clubSelectionError.setText("Select club first");
            eventSelectionError.setText("Select event");
            clubSelector.setStyle("-fx-border-color: red;");
            eventSelector.setStyle("-fx-border-color: red;");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> {
                clubSelectionError.setText("");
                eventSelectionError.setText("");
                clubSelector.setStyle("-fx-border-color: none;");
                eventSelector.setStyle("-fx-border-color: none;");
            });
            pause.play();
        } else {
            eventSelectionError.setText("Select event");
            eventSelector.setStyle("-fx-border-color: red;");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> {
                clubSelectionError.setText("");
                eventSelectionError.setText("");
                clubSelector.setStyle("-fx-border-color: none;");
                eventSelector.setStyle("-fx-border-color: none;");
            });
            pause.play();

        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/scams", "root", "");
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
            e.printStackTrace();
        }

        System.out.println("Driver class registered");
        Connection sample = null;

        try {
            sample = DriverManager.getConnection("jdbc:mysql://localhost:3306/scams", "root", "");
        }catch (SQLException e2) {
            System.out.println("sql exception found");
            e2.printStackTrace();
            return;
        }

        if (sample != null){
            System.out.println("success");
        }else {
            System.out.println("failed to connect");
        }
    }

    public void onAttendanceBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();
        Stage preStage = (Stage) attendancePane.getScene().getWindow();
        preStage.close();
    }
}
