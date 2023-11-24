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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Attendance implements Initializable {

    public ChoiceBox eventSelector;
    public ChoiceBox clubSelector;
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
                new Student("S002", "Emma", "Johnson", "0712345678", "2002-05-15")
        );

        stdIdCol.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telNoCol.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        attendanceStatusCol.setCellValueFactory(new PropertyValueFactory<Student,String>("status"));
        this.attendanceTable.setItems(this.data);
    }


    @FXML
    private void handleSaveButtonAction() {
        // Process the attendance data when the "Save" button is clicked
        List<Student> savedAttendanceList = new ArrayList<>(attendanceTable.getItems());

        // Print the saved attendance data (you can replace this with your saving logic)
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
}
