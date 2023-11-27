package com.example.ood_cw;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnect {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sacms", "root", "");
    }

    public static void clearTableOfClubSession(){
        try (Connection connection = getConnection()) {
            String deleteQuery = "DELETE FROM clubsession";

            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                int rowsDeleted = deleteStmt.executeUpdate();
                System.out.println("Deleted " + rowsDeleted + " rows from the event_schedule table.");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<List<Object>> allEvents = HelloController.allEvents;
    public static List<List<Object>> events = HelloController.events;

    public static void getScheduleOfClubSesion(){
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM clubsession";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                // Clear existing data in the events list
                allEvents.clear();
                events.clear();
                // Iterate through the result set and populate the events list
                while (resultSet.next()) {
                    List<Object> event = new ArrayList<>();
                    event.add(resultSet.getString("sessionId"));
                    event.add(resultSet.getString("name"));
                    event.add(resultSet.getString("location"));
                    event.add(resultSet.getString("time"));
                    event.add(resultSet.getString("description"));
                    event.add(resultSet.getString("startDate"));
                    event.add(resultSet.getString("endDate"));
                    event.add(resultSet.getString("duration"));
                    event.add(resultSet.getString("clubId"));
                    event.add(resultSet.getString("advisorId"));

                    allEvents.add(event);
                }
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    public static void insertScheduleOfClubSession(String scheduleId, String name, String location, String time, String description,
                                      String startDate, String endDate, String duration, String clubId, String advisorId) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO clubsession (sessionId , name, location, time, description, startDate, endDate, duration, clubId, advisorId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, scheduleId);
                stmt.setString(2, name);
                stmt.setString(3, location);
                stmt.setString(4, time);
                stmt.setString(5, description);
                stmt.setString(6, startDate);
                stmt.setString(7, endDate);
                stmt.setString(8, duration);
                stmt.setString(9, clubId);
                stmt.setString(10, advisorId);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            clearTableOfClubSession();
            insertScheduleOfClubSession("E001", "Spandana", "Viharamahadevi", "08:30", "musical event",
                    "2023-12-23", " - ", " - ", "C001", "AD01");
            insertScheduleOfClubSession("E002", " - ", "Hilton", "08:30", "Batch meeting",
                    "2023-12-23", " - ", "2-hours", "C001", "AD01");
            insertScheduleOfClubSession("A001", "Game Fiesta", "Club Fusion", "08:30", "A game event",
                    "2023-11-23", "2023-12-25", " - ", "C001", "AD01");

            getScheduleOfClubSesion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

