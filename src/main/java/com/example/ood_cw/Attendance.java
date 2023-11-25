package com.example.ood_cw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static com.example.ood_cw.HelloController.events;
import java.net.URL;
import java.util.*;

import java.sql.*;
import java.io.*;

public class Attendance implements Initializable {
    public ChoiceBox eventSelector;
    public ChoiceBox clubSelector;
    public Button showButton;
    @FXML
    private TableView<Student> attendanceTable;
    @FXML
    private Button saveButton;

    private List<Object> eventNames = new ArrayList<>();
    private List<Object> eNames = new ArrayList<>();
    private ObservableList<Student> data;

    public Attendance() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn<Student, String> stdIdCol = new TableColumn<>("Student ID");
        TableColumn<Student, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<Student, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<Student, String> telNoCol = new TableColumn<>("Telephone Number");
        TableColumn<Student, String> dobCol = new TableColumn<>("Date of Birth");
        TableColumn<Student, String> attendanceStatusCol = new TableColumn<>("Attendance Status");
        this.attendanceTable.getColumns().addAll(stdIdCol, firstNameCol, lastNameCol, telNoCol, dobCol, attendanceStatusCol);
        this.data = FXCollections.observableArrayList(
                new Student("S001", "Jacob", "Smith", "0704594151", "2003-01-23"),
                new Student("S002", "Emma", "Johnson", "0712345678", "2002-05-15"),
                new Student("S003", "Velma", "Johnson", "0713345678", "2004-05-15"));
        System.out.println(events);
        for (int i = 0; i < events.size(); i++) {
            String eName =  String.valueOf(events.get(i).get(1));
            if(eName == " - "){
                eName =  String.valueOf(events.get(i).get(0));
            }
            System.out.println(eName);
            eNames.add(eName);
        }

        eventSelector.getItems().addAll(eNames);
        List<String> clubs = Arrays.asList("Club 1", "Club 2", "Club 3");
        clubSelector.getItems().addAll(clubs);
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
            try (PreparedStatement atten = connection.prepareStatement(query)) {
                atten.setString(1, studentId);
                atten.setString(2, sessionId);
                atten.setString(3, studentStatus);
                atten.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSaveButtonAction() throws SQLException {
        List<Student> savedAttendanceList = new ArrayList<>(attendanceTable.getItems());
        for (Student student : savedAttendanceList) {
            String attendance;
            if (student.isStatus().isSelected()) {
                attendance = "Present";
            } else {
                attendance = "Absent";
            }
            System.out.println("Student ID: " + student.getStdId() + ", Attendance Status: " + attendance);
            String eventId = null;
            for (int i = 0; i < events.size(); i++) {
                if (eventSelector.getValue() == events.get(i).get(1)) {
                    eventId = String.valueOf(events.get(i).get(0));
                }
            }
            insertAttendance(student.getStdId(), eventId, attendance);
        }
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("attendanceTracking.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void onShowButtonClick() {
        String selectedClub = (String) clubSelector.getValue();
        String selectedEvent = (String) eventSelector.getValue();

        // Check if both club and event are selected
        if (selectedClub != null && selectedEvent != null) {
            this.attendanceTable.setItems(this.data);
        } else {
            System.out.println("Please select both club and event");
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

}
