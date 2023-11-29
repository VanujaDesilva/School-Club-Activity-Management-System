//package com.example.ood_cw;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class GenerateExcelFile {
//    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/sacms";
//    private static final String username = "root";
//    private static final String password = "";
//
//    private static final String excelFilePath = "path/to/output/excel/file.xlsx";
//
//    public static void main(String[] args) {
//        // Create an instance of DatabaseConnect
//        DatabaseConnect databaseConnect = new DatabaseConnect();
//
//        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
//            // Specify the tables you want to export
//            String[] tables = {"student", "clubadvisor", "club", "registration", "attendance", "clubsession"};
//
//            // Create a new workbook
//            Workbook workbook = new XSSFWorkbook();
//
//            for (String table : tables) {
//                // Fetch data from the database using DatabaseConnect methods
//                ResultSet resultSet = databaseConnect.fetchDataFromTable(connection, table);
//
//                // Create a new sheet for each table
//                Sheet sheet = workbook.createSheet(table);
//
//                // Create header row
//                Row headerRow = sheet.createRow(0);
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                int columnCount = metaData.getColumnCount();
//                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
//                    Cell cell = headerRow.createCell(colIndex - 1);
//                    cell.setCellValue(metaData.getColumnName(colIndex));
//                }
//
//                // Populate data rows
//                int rowIndex = 1;
//                while (resultSet.next()) {
//                    Row dataRow = sheet.createRow(rowIndex++);
//                    for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
//                        Cell cell = dataRow.createCell(colIndex - 1);
//                        cell.setCellValue(resultSet.getString(colIndex));
//                    }
//                }
//            }
//
//            // Write the workbook to an Excel file
//            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
//                workbook.write(outputStream);
//                System.out.println("Excel file created successfully.");
//            }
//
//        } catch (SQLException | java.io.IOException e) {
//            e.printStackTrace();
//        }
//    }
//}