/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cancion;

import java.util.ArrayList;

/**
 *
 * @author Aleee
 */
public class Cancion {
    private String NombreCancion;
    private ArrayList <String> Ruta;
    
    public Cancion (String NombreCancionE){
        this.NombreCancion = NombreCancionE;
    }

    public String getNombreCancion() {
        return NombreCancion;
    }

    public void setNombreCancion(String NombreCancion) {
        this.NombreCancion = NombreCancion;
    }
    
    
}
