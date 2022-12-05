module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires org.junit.jupiter.api;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.Controllers;
    opens com.example.demo.Controllers to javafx.fxml;
    exports com.example.demo.gameElements;
    opens com.example.demo.gameElements to javafx.fxml;
    exports com.example.demo.gameElements.Utilities;
    opens com.example.demo.gameElements.Utilities to javafx.fxml;
    exports com.example.demo.endGameElements;
    opens com.example.demo.endGameElements to javafx.fxml;
}