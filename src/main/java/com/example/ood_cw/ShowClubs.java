package com.example.ood_cw;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.List;
import java.util.ResourceBundle;

public class ShowClubs implements Initializable {

    //variable declarations
    @FXML
    public AnchorPane showClubPane;
    @FXML
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //importing clubs list from the controller
        List<List<Object>> clubView = HelloController.mainList;

        ObservableList<Club> clubViewMain = FXCollections.observableArrayList();

        for (List<Object> i : clubView){
            //creating sub list
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
            //adding sublist to the main list
            clubViewMain.add(viewClubs);

            //setting the club details to the table columns
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
                Club clubImageTable = column.getValue();
                String path = clubImageTable.getIcon();
                if(path != null && !path.isEmpty()){
                    try {
                        image.setImage(new Image(new File(path).toURI().toString()));

                    }
                    catch (Exception e){
                        System.out.println("error");
                    }
                }
                return new ReadOnlyObjectWrapper<>(image);
            });

            //displaying values in the table
            showClubTable.setItems(clubViewMain);
        }
    }

    //back button functionality
    public void onBackShowClubClick() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("clubMenu.fxml"));
        showClubPane.getChildren().setAll(pane);
    }
}
