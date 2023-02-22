module com.example.mycep {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.mycep to javafx.fxml;
    opens com.example.mycep.util to com.google.gson;

    exports com.example.mycep;
}