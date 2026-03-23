/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Cancion.Cancion;
import java.util.ArrayList;

/**
 *
 * @author Aleee
 */
public class Usuario {
    private String Nombre;
    private String Apellido;
    private String Usuario;
    private String Contraseña;
    private ArrayList<Cancion> Playlist;
    
    public Usuario (String NombreE, String ApellidoE, String UsuarioE, String ContraseñaE){
        this.Nombre = NombreE;
        this.Apellido = ApellidoE;
        this.Usuario = UsuarioE;
        this.Contraseña = ContraseñaE;
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
    
    
}
