package com.ejerciciofx.wavify;

import java.io.*;
import java.nio.file.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML private TextField usuarioField;
    @FXML private TextField contrasenaField;
    @FXML private Button btnLogin;

    @FXML
    private void handleLogin() {
        String usuario = usuarioField.getText().trim();
        String contrasena = contrasenaField.getText().trim();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Por favor rellena todos los campos.");
            return;
        }

        if (verificarUsuario(usuario, contrasena)) {
            mostrarAlerta("Bienvenido", "Inicio de sesión correcto, hola " + usuario + "!");
           
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
        }
    }

    private boolean verificarUsuario(String usuario, String contrasena) {
        File archivo = new File(System.getProperty("user.home") + "/wavify_usuarios.txt");
        if (!archivo.exists()) return false;

        try {
            for (String linea : Files.readAllLines(archivo.toPath())) {
                String[] partes = linea.split(",");
                if (partes.length == 2 &&
                    partes[0].equals(usuario) &&
                    partes[1].equals(contrasena)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
