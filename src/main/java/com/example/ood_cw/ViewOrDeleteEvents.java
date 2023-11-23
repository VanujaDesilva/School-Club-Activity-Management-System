package com.example.ood_cw;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewOrDeleteEvents implements Initializable {
    public AnchorPane viewOrDeleteEventsAnchor;
    public TextField eventIdDelete;
    public Label deleteIdError;
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

    public void onViewOrDeleteEventsBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EventScheduling.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) viewOrDeleteEventsAnchor.getScene().getWindow();
        previousStage.close();
    }

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
        List<List<Object>> eventView = HelloController.eventView;
        for (List<Object> i : eventView){
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

    public void onViewOrDeleteEventsDeleteButtonClick() throws IOException {
        List<List<Object>> events = HelloController.events;
        String deleteId = eventIdDelete.getText();
        int count =0;
        for (int i = 0; i < events.size();i++){
            if (String.valueOf(events.get(i).get(0)).equalsIgnoreCase(deleteId)){
                events.remove(i);
                count++;
                break;
            }
        }
        if (count==0){
            deleteIdError.setStyle("-fx-text-fill: #ff0000;");
            deleteIdError.setText("Entered Event ID doesn't exist!");
            PauseTransition pause = new PauseTransition(Duration.seconds(4));
            // Set the action to be performed when the pause is finished
            pause.setOnFinished(event -> {
                // Remove the text after 5 seconds
                deleteIdError.setText("");
            });
            // Start the pause transition
            pause.play();
        } else {
            List<List<Object>> eventView = HelloController.eventView;
            for (int i = 0; i <eventView.size();i++){
                if (String.valueOf(eventView.get(i).get(0)).equalsIgnoreCase(deleteId)){
                    eventView.remove(i);
                    break;
                }
            }
            List<List<Object>> events1 = HelloController.events1;
            for (int i =0 ; i < events1.size();i++){
                if (String.valueOf(events1.get(i).get(0)).equalsIgnoreCase(deleteId)){
                    events1.remove(i);
                    break;
                }
            }
            List<List<Object>> meetings = HelloController.meetings;
            for (int i =0 ; i < meetings.size();i++){
                if (String.valueOf(meetings.get(i).get(0)).equalsIgnoreCase(deleteId)){
                    meetings.remove(i);
                    break;
                }
            }
            List<List<Object>> activity = HelloController.activity;
            for (int i =0 ; i < activity.size();i++){
                if (String.valueOf(activity.get(i).get(0)).equalsIgnoreCase(deleteId)){
                    activity.remove(i);
                    break;
                }
            }
            deleteIdError.setStyle("-fx-text-fill: #13e57d;");
            deleteIdError.setText("Event has been deleted!");
            PauseTransition pause = new PauseTransition(Duration.seconds(4));
            pause.setOnFinished(event -> {
                deleteIdError.setText("");
            });
            pause.play();
        }
    }
}
