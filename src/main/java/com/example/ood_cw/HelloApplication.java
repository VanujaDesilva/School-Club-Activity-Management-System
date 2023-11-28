package com.example.ood_cw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static com.example.ood_cw.HelloController.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DatabaseConnect.getDetailsOfClubs();
        System.out.println(clubs);
        DatabaseConnect.getScheduleOfClubSesion();
        System.out.println(allEvents);
        DatabaseConnect.getAttendance();
        System.out.println(attendance);
        DatabaseConnect.getScheduleOfClubSesion();
        System.out.println(allEvents);
        DatabaseConnect.getStudentDetails();
        System.out.println(studentDetails);
        DatabaseConnect.getAdvisorDetails();
        System.out.println(advisorDetails);
        DatabaseConnect.getRegistrationDetails();
        System.out.println(registration);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}