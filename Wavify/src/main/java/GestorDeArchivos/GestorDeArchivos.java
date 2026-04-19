/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorDeArchivos;


import Usuario.Usuario;
import Cancion.Cancion;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
         File carpetaUsuario = new File(RutaCarpeta + "/USUARIOS/" + u.getUsuario());
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
    
    public boolean validarLogin(String usuario, String contrasena) throws Exception {
    // ⚠ Cambia esta ruta a la que tienes en tu PC
    

    File carpeta = new File(RutaCarpeta + "/USUARIOS/" + usuario);

    if (!carpeta.exists()) {
        System.out.println("DEBUG: Carpeta de usuario no existe: " + carpeta.getAbsolutePath());
        return false;
    }

    File archivo = new File(carpeta, "DatosUsuario.txt"); // nombre exacto
    if (!archivo.exists()) {
        System.out.println("DEBUG: Archivo DatosUsuario.txt no existe en: " + archivo.getAbsolutePath());
        return false;
    }

    BufferedReader lector = new BufferedReader(new FileReader(archivo));
    String linea;
    String userGuardado = "";
    String passGuardada = "";

    while ((linea = lector.readLine()) != null) {
        linea = linea.trim(); // quita espacios al inicio y fin
        System.out.println("DEBUG: Leyendo linea: '" + linea + "'");

        if (linea.toLowerCase().startsWith("usuario:")) {
            userGuardado = linea.split(":", 2)[1].trim(); // toma lo que viene después de :
            System.out.println("DEBUG: userGuardado='" + userGuardado + "'");
        }

        if (linea.toLowerCase().startsWith("contraseña:") || linea.toLowerCase().startsWith("contrasena:")) {
            passGuardada = linea.split(":", 2)[1].trim();
            System.out.println("DEBUG: passGuardada='" + passGuardada + "'");
        }
    }

    lector.close();

    // Compara ignorando mayúsculas/minúsculas y espacios
    boolean usuarioValido = usuario.trim().equalsIgnoreCase(userGuardado);
    boolean passValida = contrasena.trim().equalsIgnoreCase(passGuardada);

    System.out.println("DEBUG: Comparación final -> usuarioValido=" + usuarioValido + " passValida=" + passValida);

    return usuarioValido && passValida;
}
    public ArrayList<Cancion> cargarMusica(){
        ArrayList<Cancion> lista = new ArrayList<>();
        File carpetaMusica = new File(RutaCarpeta + "/" + NombreDirectorioRutaMusica);
        for (File f : carpetaMusica.listFiles()) {
            if (f.getName().endsWith(".mp3") || f.getName().endsWith(".wav")){
                Cancion c = new Cancion(f.getName(), f.getPath());
                lista.add(c);
            }
        }
        return lista;
    }
}
