module com.ejerciciofx.wavify {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ejerciciofx.wavify to javafx.fxml;
    exports com.ejerciciofx.wavify;
}
