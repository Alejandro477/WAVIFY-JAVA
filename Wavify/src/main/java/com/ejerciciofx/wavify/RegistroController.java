package com.ejerciciofx.wavify;

import GestorDeArchivos.GestorDeArchivos;
import Usuario.Usuario;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;    
 
public class RegistroController {
    @FXML
    private ImageView fotoLogo;
    @FXML
    private TextField Nombre;

    @FXML
    private TextField Apellido;

    @FXML
    private TextField Usuario;

    @FXML
    private TextField Contraseña;

    @FXML
    public void finalizarRegistro() throws IOException {
        System.out.println("Registro completado. Volviendo al login");
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
    
    private boolean validarCampos(String nombre, String apellido, String usuario, String contraseña){

        if(nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || contraseña.isEmpty()){
            System.out.println("Hay campos vacíos");
            mostrarAlerta("alerta ","Hay campos vacíos");
            return false;
            }

        return true;
        }
    
    
    public void registrarUsuario(){

        String nombre = Nombre.getText();
        String apellido = Apellido.getText();
        String usuario = Usuario.getText();
        String contraseña = Contraseña.getText();

    
        if(!validarCampos(nombre, apellido, usuario, contraseña)){
        return;
        }

        GestorDeArchivos gestor = new GestorDeArchivos();
        gestor.Comprobarcarpetas();

    
        if(gestor.existeUsuario(usuario)){
        System.out.println("El usuario ya existe");
        mostrarAlerta("error","Este Usuario ya existe");
        return; 
        }

    
        Usuario u = new Usuario(nombre, apellido, usuario, contraseña);

        try {
            gestor.GuardarUsuario(u);
            System.out.println("Usuario creado correctamente");
            finalizarRegistro();
        } catch (Exception e) {
            System.out.println("error al guardar usuario");
            mostrarAlerta("error ","Al intentar guardar usuario");
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }   
}
