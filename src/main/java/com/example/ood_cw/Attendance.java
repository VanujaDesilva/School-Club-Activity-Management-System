package com.example.ood_cw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static com.example.ood_cw.HelloController.events;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Attendance implements Initializable {
    public ChoiceBox eventSelector;
    public ChoiceBox clubSelector;
    public Button showButton;
    @FXML
    private TableView<Student> attendanceTable;
    @FXML
    private Button saveButton;


    private ObservableList<Student> data;

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
                new Student("S002", "Emma", "Johnson", "0712345678", "2002-05-15"));
        List<String> events = Arrays.asList("Event1", "Event2", "Event3");
        eventSelector.getItems().addAll(events);
        List<String> clubs = Arrays.asList("Club 1", "Club 2", "Club 3");
        clubSelector.getItems().addAll(clubs);
        stdIdCol.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telNoCol.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        attendanceStatusCol.setCellValueFactory(new PropertyValueFactory<Student,String>("status"));

    }


    @FXML
    private void handleSaveButtonAction() {
        List<Student> savedAttendanceList = new ArrayList<>(attendanceTable.getItems());
        for (Student student : savedAttendanceList) {
            String attendance;
            if (student.isStatus().isSelected()) {
                attendance = "Present";
            } else {
                attendance = "Absent";
            }
            System.out.println("Student ID: " + student.getStdId() + ", Attendance Status: " + attendance);
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
}
