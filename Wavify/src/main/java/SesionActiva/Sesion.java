/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SesionActiva;

/**
 *
 * @author Aleee
 */
public class Sesion {

    private static String usuarioActual;

    public static String getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(String usuarioActual) {
        Sesion.usuarioActual = usuarioActual;
    }
    
    public static void cerrarSesion(){
        usuarioActual = null;
    }
}