/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorDeArchivos;


import Usuario.Usuario;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Aleee
 */
public class GestorDeArchivos {
    private boolean EstadoCarpeta =false;
    private String RutaCarpeta;
    private String NombreDirectorioRutaMusica;
    private String NombreDirectorioRutaCarpetaUsuario;
    
    public GestorDeArchivos (){
    this.RutaCarpeta = System.getProperty("user.dir") + "/..";
    this.NombreDirectorioRutaMusica = "MUSICA";
    this.NombreDirectorioRutaCarpetaUsuario = "USUARIOS";
        }
    
    
    public boolean Comprobarcarpetas(){
        File carpetaMusica = new File(RutaCarpeta + "/" + NombreDirectorioRutaMusica);
        File carpetaUsuarios = new File(RutaCarpeta + "/" + NombreDirectorioRutaCarpetaUsuario);

        if(carpetaMusica.exists() && carpetaUsuarios.exists()){
            EstadoCarpeta = true;
        } else {
            Crearcarpetas();
            EstadoCarpeta = false;
        }

        return EstadoCarpeta;
        }
    
    
     public void Crearcarpetas(){
        File carpetaMusica = new File(RutaCarpeta + "/MUSICA");
        File carpetaUsuarios = new File(RutaCarpeta + "/USUARIOS");

        carpetaMusica.mkdirs();
        carpetaUsuarios.mkdirs();
        }
    
     
     public void GuardarUsuario(Usuario u) throws Exception{
         // Crea la carpeta del usuario con su nombre
         File carpetaUsuario = new File(RutaCarpeta + "/Usuarios/" + u.getUsuario());
         carpetaUsuario.mkdirs();
         
         //esto creara en si el .txt dentro de la carpeta q hemos creado arriba con su usuario
         
         File Archivo = new File(carpetaUsuario , "DatosUsuario.txt");
         
         
         //esto es para poder escribir o modificar en el archivo .txt
         
          PrintWriter escribir = new PrintWriter(Archivo);
          
          escribir.println("Nombre: " + u.getNombre());
          escribir.println("Apellido: " + u.getApellido());
          escribir.println("Usuario: " + u.getUsuario());
          escribir.println("Contraseña: " + u.getContraseña());
          
          escribir.close();
     }
   
     
    public boolean existeUsuario(String nombreUsuario){
        File carpetaUsuario = new File(RutaCarpeta + "/USUARIOS/" + nombreUsuario);
        return carpetaUsuario.exists();
    }
    
    
    
     
     
     
     
}
