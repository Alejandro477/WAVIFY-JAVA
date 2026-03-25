
package Reproductor;

import Cancion.Cancion;
import java.util.ArrayList;
import javafx.scene.media.MediaPlayer;



public class Reproductor {
    private ArrayList <Cancion> Listacanciones;
    private int Indiceactual; 
    private String dirUsuarios="";
    private MediaPlayer mediaplayer;

    public Reproductor(ArrayList<Cancion> Listacanciones, int Indiceactual, MediaPlayer mediaplayer) {
        this.Listacanciones = Listacanciones;
        this.Indiceactual = Indiceactual;
        this.mediaplayer = mediaplayer;
    }

    public ArrayList<Cancion> getListacanciones() {
        return Listacanciones;
    }

    public void setListacanciones(ArrayList<Cancion> Listacanciones) {
        this.Listacanciones = Listacanciones;
    }

    public int getIndiceactual() {
        return Indiceactual;
    }

    public void setIndiceactual(int Indiceactual) {
        this.Indiceactual = Indiceactual;
    }

    public String getDirUsuarios() {
        return dirUsuarios;
    }

    public void setDirUsuarios(String dirUsuarios) {
        this.dirUsuarios = dirUsuarios;
    }

    public MediaPlayer getMediaplayer() {
        return mediaplayer;
    }

    public void setMediaplayer(MediaPlayer mediaplayer) {
        this.mediaplayer = mediaplayer;
    }

    
}


