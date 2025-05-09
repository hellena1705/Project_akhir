module org.week11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens org.week11 to javafx.fxml;
    exports org.week11;
}

