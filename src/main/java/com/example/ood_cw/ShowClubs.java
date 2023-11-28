package com.example.ood_cw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ShowClubs {

    public AnchorPane showClubPane;
    public TableView showClubTable;
    public Button backShowClubs;
    public TableColumn showClubID;
    public TableColumn showClubName;
    public TableColumn showClubDate;
    public TableColumn showClubMission;
    public TableColumn showClubDescription;
    public TableColumn showClubPresidentName;
    public TableColumn showClubAdvisorID;
    public TableColumn showClubEmail;
    public TableColumn showClubContactNo;
    public TableColumn showClubIcon;

    public void onBackShowClubClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        showClubPane.getChildren().setAll(pane);
    }

    //@Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        showClubID.setCellValueFactory(new PropertyValueFactory<Club,String>("Club ID"));
//        showClubName.setCellValueFactory(new PropertyValueFactory<Club,String>("Club Name"));
//        showClubDate.setCellValueFactory(new PropertyValueFactory<Club,LocalDate>("Founding Date"));
//        showClubMission.setCellValueFactory(new PropertyValueFactory<Club,String>("Mission"));
//        showClubDescription.setCellValueFactory(new PropertyValueFactory<Club,String>("Description"));
//        showClubPresidentName.setCellValueFactory(new PropertyValueFactory<Club,String>("President Name"));
//        showClubAdvisorID.setCellValueFactory(new PropertyValueFactory<Club,String>("Advisor ID"));
//        showClubEmail.setCellValueFactory(new PropertyValueFactory<Club,String>("Email"));
//        showClubContactNo.setCellValueFactory(new PropertyValueFactory<Club,String>("Contact No"));
//        showClubIcon.setCellValueFactory(new PropertyValueFactory<Club,String>("Club Icon"));
//        ObservableList<Club> clubs = FXCollections.observableArrayList();
//        List<List<Object>> clubView = HelloController.clubs;
//        for (List<Object> i : clubView){
//            Club viewClubs = new Club(
//                    (String)i.get(0),
//                    (String)i.get(1),
//                    (LocalDate) i.get(2),
//                    (String)i.get(3),
//                    (String)i.get(4),
//                    (String)i.get(5),
//                    (String)i.get(6),
//                    (String)i.get(7),
//                    (String)i.get(8),
//                    (String)i.get(9)
//            );
//            clubs.add(viewClubs);
//        }
//        showClubTable.setItems(clubs);
//    }
}
