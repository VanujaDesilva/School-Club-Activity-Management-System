package com.example.ood_cw;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleRole;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.ood_cw.HelloController.*;

public class Attendance implements Initializable {
    public ChoiceBox eventSelector;
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
    private List<String> studentIds = new ArrayList<>();

    private String liveClubId;
    private ObservableList<Student> data;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        System.out.println(advisorID.get(0));
        for(List<Object> club: clubs){
            if(club.get(6).equals(advisorID.get(0))){
                liveClubId = String.valueOf(club.get(0));
            }
        }
        System.out.println(liveClubId);
        for (List<Object> reg : attendance){
            if (reg.get(1).equals(liveClubId)){
                studentIds.add(String.valueOf(reg.get(0)));
            }
        }
        System.out.println(studentIds);
        String eDate;
        int eYear,eMonth,eDay;
        for (List<Object> event : allEvents) {
            if(event.get(8).equals(liveClubId)) {
                String eName = String.valueOf(event.get(1));
                if (Objects.equals(eName, " - ")) {
                    eName = String.valueOf(event.get(0));
                }
                eDate = String.valueOf(event.get(5));
                eYear = Integer.parseInt(eDate.substring(0,4));
                eMonth = Integer.parseInt(eDate.substring(5,7));
                eDay = Integer.parseInt(eDate.substring(8,10));
                LocalDate eventDate = LocalDate.of(eYear,eMonth,eDay);
                LocalDate currentDate = LocalDate.now();
                if(eventDate.isBefore(currentDate) || eventDate.equals(currentDate)){
                    eventNames.add(eName);
                }
            }
        }
        eventSelector.getItems().addAll(eventNames);
        stdIdCol.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telNoCol.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        attendanceStatusCol.setCellValueFactory(new PropertyValueFactory<Student,String>("status"));
    }
    @FXML
    private void handleSaveButtonAction(ActionEvent actionEvent) throws SQLException, Exception {
        List<Student> savedAttendanceList = new ArrayList<>(attendanceTable.getItems());
        String attendance;
        String eventId = null;
        for(List<Object> event : allEvents) { // select event ID by using event name
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
            DatabaseConnect.insertAttendance(std.getStdId(), eventId, attendance);
        }
        DatabaseConnect.getAttendance();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AttendanceSave.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();

        attendanceTable.getItems().clear();
        eventSelector.getItems().clear();
        eventSelector.setStyle("-fx-border-color: none;");
    }

    public void onShowButtonClick() throws IOException {


        System.out.println(studentIds);
        for (int i = 0; i < studentIds.size(); i++) {
            for (List<Object> studentdetail : studentDetails) {
                if (studentdetail.get(0).equals(studentIds.get(i))) {
                    String stdId = String.valueOf(studentdetail.get(0));
                    String firstName = String.valueOf(studentdetail.get(1));
                    String lastName = String.valueOf(studentdetail.get(2));
                    String dob = String.valueOf(studentdetail.get(3));
                    String telNo = String.valueOf(studentdetail.get(4));

                    Student student = new Student(stdId, firstName, lastName, dob, telNo);
                    data.add(student);
                }
            }
        }
        String selectedEvent = (String) eventSelector.getValue();

        if  (selectedEvent != null) {
            this.attendanceTable.setItems(data);
            eventSelector.setStyle("-fx-border-color: green;");
        } else {
            eventSelectionError.setText("Select event");
            eventSelector.setStyle("-fx-border-color: red;");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> {
                eventSelectionError.setText("");
                eventSelector.setStyle("-fx-border-color: none;");
            });
            pause.play();
        }
    }
    public void onAttendanceBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdvisorMenu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Enter club name");
        stage.setScene(scene);
        stage.show();
        Stage preStage = (Stage) attendancePane.getScene().getWindow();
        preStage.close();
    }
}
