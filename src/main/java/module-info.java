module com.example.ood_cw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ood_cw to javafx.fxml;
    exports com.example.ood_cw;
}