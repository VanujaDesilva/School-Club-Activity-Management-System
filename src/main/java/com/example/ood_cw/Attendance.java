package com.example.ood_cw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.CheckBoxTableCell;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class Attendance implements Initializable {

    @FXML
    private ChoiceBox<Club> clubSelector;

    @FXML
    private ChoiceBox<Event> eventSelector;

    @FXML
    private TableColumn<Student,String> name;

    @FXML
    private TableColumn<Student, Boolean> status;

    @FXML
    private TableColumn<?, ?> stdId;

    @FXML
    private TableColumn<?, ?> telNo;

    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendanceTracking.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), 900,600 );
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        status.setCellFactory(CheckBoxTableCell.forTableColumn(status));

    }
}
