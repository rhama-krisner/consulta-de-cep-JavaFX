module com.example.mycep {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mycep to javafx.fxml;
    exports com.example.mycep;
}