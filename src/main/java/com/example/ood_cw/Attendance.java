package com.example.ood_cw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Attendance implements Initializable {

    @FXML
    TableView attendanceTable;

    ObservableList<Person> data;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn stdIdCol = new TableColumn("stdId");
        TableColumn nameCol = new TableColumn("Name");
        TableColumn telNoCol = new TableColumn("telNo");
        TableColumn attendanceStatusCol = new TableColumn("Attendance status");
        this.attendanceTable.getColumns().addAll(new Object[]{stdIdCol, nameCol, telNoCol, attendanceStatusCol});
        stdIdCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        nameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        telNoCol.setCellValueFactory(new PropertyValueFactory("email"));
        attendanceStatusCol.setCellValueFactory(new PropertyValueFactory("remark"));
        this.attendanceTable.setItems(this.data);
    }
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendanceTracking.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), 900,600 );
        stage.setScene(scene);
        stage.show();
    }
}
