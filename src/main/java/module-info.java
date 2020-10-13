module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires json;
    requires javafx.web;

    opens org.example to javafx.fxml;
    exports org.example;
}