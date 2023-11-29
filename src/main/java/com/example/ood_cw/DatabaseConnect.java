package com.example.ood_cw;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.ood_cw.HelloController.*;


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
    public static void clearTableOfClubs(){
        try (Connection connection = getConnection()) {
            String deleteQuery = "DELETE FROM club";

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
    public static void getDetailsOfClubs(){
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM club";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                // Clear existing data in the events list
                clubs.clear();
                // Iterate through the result set and populate the events list
                while (resultSet.next()) {
                    List<Object> club = new ArrayList<>();
                    club.add(resultSet.getString("clubId"));
                    club.add(resultSet.getString("clubName"));
                    club.add(resultSet.getString("foundingDate"));
                    club.add(resultSet.getString("mission"));
                    club.add(resultSet.getString("description"));
                    club.add(resultSet.getString("presidentName"));
                    club.add(resultSet.getString("advisorId"));
                    club.add(resultSet.getString("email"));
                    club.add(resultSet.getString("telNo"));
                    club.add(resultSet.getString("clubIcon"));
                    clubs.add(club);
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
    public static void insertDetailsOfClubs(String clubId, String clubName, String foundingDate, String mission, String description,
                                                   String presidentName, String advisorId, String email, String telNo, String clubIcon) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO club (clubId , clubName, foundingDate, mission, description, presidentName, advisorId, email, telNo, clubIcon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, clubId);
                stmt.setString(2, clubName);
                stmt.setString(3, foundingDate);
                stmt.setString(4, mission);
                stmt.setString(5, description);
                stmt.setString(6, presidentName);
                stmt.setString(7, advisorId);
                stmt.setString(8, email);
                stmt.setString(9, telNo);
                stmt.setString(10, clubIcon);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearTableOfAttendance(){
        try (Connection connection = getConnection()) {
            String deleteQuery = "DELETE FROM attendance";

            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                int rowsDeleted = deleteStmt.executeUpdate();
                System.out.println("Deleted " + rowsDeleted + " rows from the event_schedule table.");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getAttendance(){
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM attendance";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                // Clear existing data in the events list
                attendance.clear();
                // Iterate through the result set and populate the events list
                while (resultSet.next()) {
                    List<Object> event = new ArrayList<>();
                    event.add(resultSet.getString("studentId"));
                    event.add(resultSet.getString("sessionId"));
                    event.add(resultSet.getString("studentstatus"));
                    attendance.add(event);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertAttendance(String studentId, String sessionId, String studentStatus) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO attendance (studentId ,sessionId,studentStatus) VALUES (?, ?, ?)";
            try (PreparedStatement attend = connection.prepareStatement(query)) {
                attend.setString(1, studentId);
                attend.setString(2, sessionId);
                attend.setString(3, studentStatus);
                attend.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clearTableOfStudent(){
        try (Connection connection = getConnection()) {
            String deleteQuery = "DELETE FROM student";
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                int rowsDeleted = deleteStmt.executeUpdate();
                System.out.println("Deleted " + rowsDeleted + " rows from the event_schedule table.");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getStudentDetails(){
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM student";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                // Clear existing data in the events list
                studentDetails.clear();
                // Iterate through the result set and populate the events list
                while (resultSet.next()) {
                    List<Object> event = new ArrayList<>();
                    event.add(resultSet.getString("studentID"));
                    event.add(resultSet.getString("firstName"));
                    event.add(resultSet.getString("lastName"));
                    event.add(resultSet.getString("DOB"));
                    event.add(resultSet.getString("telNo"));
                    event.add(resultSet.getString("email"));
                    event.add(resultSet.getString("password"));
                    studentDetails.add(event);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertStudentDetails(String studentID, String firstName, String lastName, String DOB, String telNo,String email,String password) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO student (studentID ,firstName,lastName, DOB,telNo,email,password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement attend = connection.prepareStatement(query)) {
                attend.setString(1, studentID);
                attend.setString(2, firstName);
                attend.setString(3, lastName);
                attend.setString(4, DOB);
                attend.setString(5, telNo);
                attend.setString(6, email);
                attend.setString(7, password);
                attend.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getAdvisorDetails(){
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM clubadvisor";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                // Clear existing data in the events list
                advisorDetails.clear();
                // Iterate through the result set and populate the events list
                while (resultSet.next()) {
                    List<Object> event = new ArrayList<>();
                    event.add(resultSet.getString("advisorId"));
                    event.add(resultSet.getString("firstName"));
                    event.add(resultSet.getString("lastName"));
                    event.add(resultSet.getString("DOB"));
                    event.add(resultSet.getString("telNo"));
                    event.add(resultSet.getString("email"));
                    event.add(resultSet.getString("password"));
                    advisorDetails.add(event);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertAdvisorDetails(String advisorId , String firstName, String lastName, String DOB, String telNo,String email,String password) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO clubadvisor (advisorId  ,firstName,lastName, DOB,telNo,email,password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement attend = connection.prepareStatement(query)) {
                attend.setString(1, advisorId );
                attend.setString(2, firstName);
                attend.setString(3, lastName);
                attend.setString(4, DOB);
                attend.setString(5, telNo);
                attend.setString(6, email);
                attend.setString(7, password);
                attend.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getRegistrationDetails(){
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM registration";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                // Clear existing data in the events list
                registration.clear();
                // Iterate through the result set and populate the events list
                while (resultSet.next()) {
                    List<Object> event = new ArrayList<>();
                    event.add(resultSet.getString("studentId"));
                    event.add(resultSet.getString("clubId"));
                    event.add(resultSet.getString("joinDate"));
                    registration.add(event);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertRegistrationDetails(String studentId, String clubId, String joinDate) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO registration (studentId,clubId,joinDate) VALUES (?, ?, ?)";
            try (PreparedStatement attend = connection.prepareStatement(query)) {
                attend.setString(1, studentId);
                attend.setString(2,clubId);
                attend.setString(3, joinDate);
                attend.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteRowOfSessionTable(String sessionId) {
        String sessionIdToDelete = sessionId;

        // SQL query to delete a row based on sessionId
        String deleteQuery = "DELETE FROM clubsession WHERE sessionId = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            // Set the sessionId parameter
            preparedStatement.setString(1, sessionIdToDelete);

            // Execute the delete query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Row with sessionId " + sessionIdToDelete + " deleted successfully.");
            } else {
                System.out.println("No rows deleted. Row with sessionId " + sessionIdToDelete + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdateClubTableField(String cId,String cName, String fDate, String cMission, String cDescription, String cPresidentName, String cEmail, String cTelNo, String iconPath) throws SQLException {
        try (Connection connection = getConnection()) {
            String query = "UPDATE club " +
                    "SET clubName = ?,foundingDate = ?,mission = ?, description = ?, presidentName = ?,email = ?, telNo = ?, clubIcon = ?" +
                    "WHERE clubId = ?; ";
            try (PreparedStatement attend = connection.prepareStatement(query)) {
                attend.setString(1, cName);
                attend.setString(2, fDate);
                attend.setString(3, cMission);
                attend.setString(4, cDescription);
                attend.setString(5, cPresidentName);
                attend.setString(6, cEmail);
                attend.setString(7, cTelNo);
                attend.setString(8, iconPath);
                attend.setString(9, cId);
                attend.executeUpdate();
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            clearTableOfClubSession();
            insertScheduleOfClubSession("E001", "Spandana", "Viharamahadevi", "08:30", "musical event",
                    "2023-12-23", " - ", " - ", "C001", "AD01");
            insertScheduleOfClubSession("M001", " - ", "Hilton", "08:30", "Batch meeting",
                    "2023-12-23", " - ", "2-hours", "C001", "AD01");
            insertScheduleOfClubSession("A001", "Game Fiesta", "Club Fusion", "08:30", "A game event",
                    "2023-11-23", "2023-12-25", " - ", "C001", "AD01");

            getScheduleOfClubSesion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

