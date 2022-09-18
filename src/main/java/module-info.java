module com.vassilyev.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.vassilyev.gameoflife to javafx.fxml;
    exports com.vassilyev.gameoflife;
}