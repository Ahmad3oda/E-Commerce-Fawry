module com.example.ecommercesystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ecommercesystem to javafx.fxml;
    exports com.example.ecommercesystem;
}