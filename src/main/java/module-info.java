module com.example.mmf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.mmf to javafx.fxml;
    exports com.example.mmf;
}