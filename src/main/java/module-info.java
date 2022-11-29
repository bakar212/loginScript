module com.example.loginscript {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginscript to javafx.fxml;
    exports com.example.loginscript;
}