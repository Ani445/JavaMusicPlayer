module com.example.buttonmanipulation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jetbrains.annotations;
    requires javafx.media;


    opens com.example.buttonmanipulation to javafx.fxml;
    exports com.example.buttonmanipulation;
}