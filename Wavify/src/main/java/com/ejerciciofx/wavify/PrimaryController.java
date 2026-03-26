package com.ejerciciofx.wavify;

import GestorDeArchivos.GestorDeArchivos;
import Usuario.Usuario;
import java.io.*;
import java.nio.file.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML private TextField usuarioField;
    @FXML private TextField contrasenaField;
    @FXML private Button btnLogin;

    @FXML
    

     private boolean verificarUsuario(String usuario, String contrasena) {
        GestorDeArchivos gestor = new GestorDeArchivos();
        gestor.Comprobarcarpetas(); // asegura que existan las carpetas

        try {
            return gestor.validarLogin(usuario, contrasena);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @FXML
    public void IrRegistro() throws IOException{
        App.setRoot("registro");
    }
    
    
    @FXML
    public void iniciarSesion(){
        System.out.println("CLICK LOGIN");

        String usuario = usuarioField.getText();
        String contrasena = contrasenaField.getText();

    
        if(usuario.isEmpty() || contrasena.isEmpty()){
            System.out.println("Campos vacíos");
            mostrarAlerta("ALERTA ","CAMPOS VACIOS");
            return;
        }

        GestorDeArchivos gestor = new GestorDeArchivos();
        gestor.Comprobarcarpetas();

        try {
            if(gestor.validarLogin(usuario, contrasena)){
                System.out.println("Login correcto");

            
                App.setRoot("pantalla_usuario");

            } else {
                System.out.println("Usuario o contraseña incorrectos");
                mostrarAlerta("ALERTA ","USUARIO O CONTRASEÑA INCORRECTOS");
            }

        } catch (Exception e) {
            System.out.println("Error en login");
            mostrarAlerta("ERROR ","NO SE HA PODIDO INICIAR SESION");
        }
    }
}
