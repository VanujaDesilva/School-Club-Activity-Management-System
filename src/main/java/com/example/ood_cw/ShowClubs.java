package com.example.ood_cw;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ShowClubs implements Initializable {

    public AnchorPane showClubPane;
    public Button backShowClubs;
    @FXML
    private TableColumn<Club, String> showClubAdvisorID;

    @FXML
    private TableColumn<Club, String> showClubContactNo;

    @FXML
    private TableColumn<Club, String> showClubDate;

    @FXML
    private TableColumn<Club, String> showClubDescription;

    @FXML
    private TableColumn<Club, String> showClubEmail;

    @FXML
    private TableColumn<Club, String> showClubID;

    @FXML
    private TableColumn<Club, ImageView> showClubIcon;

    @FXML
    private TableColumn<Club, String> showClubMission;

    @FXML
    private TableColumn<Club, String> showClubName;
    @FXML
    private TableColumn<Club, String> showClubPresidentName;

    @FXML
    private TableView<Club> showClubTable;

    public void onBackShowClubClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        showClubPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showClubID.setCellValueFactory(new PropertyValueFactory<Club,String>("id"));
        showClubName.setCellValueFactory(new PropertyValueFactory<Club,String>("name"));
        showClubDate.setCellValueFactory(new PropertyValueFactory<Club,String>("stringDate"));
        showClubMission.setCellValueFactory(new PropertyValueFactory<Club,String>("mission"));
        showClubDescription.setCellValueFactory(new PropertyValueFactory<Club,String>("description"));
        showClubPresidentName.setCellValueFactory(new PropertyValueFactory<Club,String>("clubPresidentName"));
        showClubAdvisorID.setCellValueFactory(new PropertyValueFactory<Club,String>("clubAdvisorId"));
        showClubEmail.setCellValueFactory(new PropertyValueFactory<Club,String>("email"));
        showClubContactNo.setCellValueFactory(new PropertyValueFactory<Club,String>("contactNo"));
        showClubIcon.setCellValueFactory(column->{
            ImageView image = new ImageView();
            image.setFitWidth(80);
            image.setFitHeight(80);
            Club club = column.getValue();
            String path = club.getIcon();
            if(path != null){
                File file = new File(path);
                if(file.exists()){
                    image.setImage(new Image(path));

                }
            }
            return new ReadOnlyObjectWrapper<>(image);
        });
        ObservableList<Club> clubs = FXCollections.observableArrayList();
        List<List<Object>> clubView = HelloController.clubs;
        for (List<Object> i : clubView){
            Club viewClubs = new Club(
                    (String)i.get(0),
                    (String)i.get(1),
                    (String) i.get(2),
                    (String)i.get(3),
                    (String)i.get(4),
                    (String)i.get(5),
                    (String)i.get(6),
                    (String)i.get(7),
                    (String)i.get(8),
                    (String)i.get(9)
            );
            clubs.add(viewClubs);
        }
        showClubTable.setItems(clubs);
    }
}
