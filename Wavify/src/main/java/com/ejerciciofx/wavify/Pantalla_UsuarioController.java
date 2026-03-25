package com.ejerciciofx.wavify;

import java.io.IOException;
import javafx.fxml.FXML;

public class Pantalla_UsuarioController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}