package com.ejerciciofx.wavify;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;    
 
public class RegistroController {
    @FXML
    private ImageView fotoLogo;

    @FXML
    public void finalizarRegistro() throws IOException {
        System.out.println("Registro completado. Volviendo al login...");
        App.setRoot("primary");
    }
   
    @FXML
    public void initialize() {
    Image img = new Image(getClass().getResourceAsStream("logo.png"));
    fotoLogo.setImage(img);
    }
    
    
    @FXML
    public void VolverAtras() throws IOException{
        App.setRoot("primary");
    }
    
}
