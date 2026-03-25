module com.ejerciciofx.wavify {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.ejerciciofx.wavify to javafx.fxml;
    exports com.ejerciciofx.wavify;
}
