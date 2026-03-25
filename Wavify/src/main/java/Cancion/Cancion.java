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
    private float DuracionCancion; 
    private String Artista;
    private ArrayList <String> Ruta;
    
    public Cancion (String NombreCancionE){
        this.NombreCancion = NombreCancionE;
        this.Ruta = new ArrayList<>();
    }

    public String getNombreCancion() {
        return NombreCancion;
    }

    public void setNombreCancion(String NombreCancion) {
        this.NombreCancion = NombreCancion;
    }

    public float getDuracionCancion() {
        return DuracionCancion;
    }

    public void setDuracionCancion(float DuracionCancion) {
        this.DuracionCancion = DuracionCancion;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public ArrayList<String> getRuta() {
        return Ruta;
    }
    
    
}
