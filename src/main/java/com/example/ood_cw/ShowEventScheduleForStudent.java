package com.example.ood_cw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowEventScheduleForStudent implements Initializable {
    public AnchorPane showEventScheduleForStudentAnchor;
    @FXML
    private TableView<EventView> eventTableView;

    @FXML
    private TableColumn<EventView, String> showAdvisorId;

    @FXML
    private TableColumn<EventView, String> showClubId;

    @FXML
    private TableColumn<EventView, String> showDes;

    @FXML
    private TableColumn<EventView, String> showDuration;

    @FXML
    private TableColumn<EventView, String> showEndDate;

    @FXML
    private TableColumn<EventView, String> showId;

    @FXML
    private TableColumn<EventView, String> showLoc;

    @FXML
    private TableColumn<EventView, String> showName;

    @FXML
    private TableColumn<EventView, String> showStartDate;

    @FXML
    private TableColumn<EventView, String> showTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showId.setCellValueFactory(new PropertyValueFactory<EventView,String>("eventId"));
        showName.setCellValueFactory(new PropertyValueFactory<EventView,String>("name"));
        showLoc.setCellValueFactory(new PropertyValueFactory<EventView,String>("location"));
        showTime.setCellValueFactory(new PropertyValueFactory<EventView,String>("time"));
        showDes.setCellValueFactory(new PropertyValueFactory<EventView,String>("description"));
        showStartDate.setCellValueFactory(new PropertyValueFactory<EventView,String>("startDate"));
        showEndDate.setCellValueFactory(new PropertyValueFactory<EventView,String>("endDate"));
        showDuration.setCellValueFactory(new PropertyValueFactory<EventView,String>("duration"));
        showClubId.setCellValueFactory(new PropertyValueFactory<EventView,String>("clubId"));
        showAdvisorId.setCellValueFactory(new PropertyValueFactory<EventView,String>("advisorId"));
        ObservableList<EventView> stringEvents = FXCollections.observableArrayList();
        List<List<Object>> eventSchedule = HelloController.eventSchedule;
        for (List<Object> i : eventSchedule){
            EventView newEventView = new EventView(
                    (String)i.get(0),
                    (String)i.get(1),
                    (String)i.get(2),
                    (String)i.get(3),
                    (String)i.get(4),
                    (String)i.get(5),
                    (String)i.get(6),
                    (String)i.get(7),
                    (String)i.get(8),
                    (String)i.get(9)
            );
            stringEvents.add(newEventView);
        }
        eventTableView.setItems(stringEvents);
    }

    public void onShowEventsForStudentsBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentMenu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 900,  600);
        stage.setTitle("Show event Schedule");
        stage.setScene(scene);
        stage.show();
        Stage preStage = (Stage) showEventScheduleForStudentAnchor.getScene().getWindow();
        preStage.close();
    }
}
