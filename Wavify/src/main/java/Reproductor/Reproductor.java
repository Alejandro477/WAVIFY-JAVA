
package Reproductor;

import Cancion.Cancion;
import java.util.ArrayList;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



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
    
    public void reproducir(){
        if (this.mediaplayer!=null){
            this.mediaplayer.play();
            
        }else{
            System.out.println("error al reproducir");
        }
    }
    
    public void pausar(){
          if (this.mediaplayer!=null){
            this.mediaplayer.pause();
          }
    }
    public void detener(){
          if (this.mediaplayer!=null){
            this.mediaplayer.stop();
          }
    }

    public void adelantar(){
        if (this.mediaplayer != null) {
            Duration tiempoDestino = this.mediaplayer.getCurrentTime().add(Duration.seconds(10));
            this.mediaplayer.seek(tiempoDestino);
    }
    }
    public void atrasar(){
        if (this.mediaplayer != null) {
            Duration tiempoDestino = this.mediaplayer.getCurrentTime().subtract(Duration.seconds(10));
            this.mediaplayer.seek(tiempoDestino);
    }
    
        
    }
    public void ajustarVolumen(int nivel){
        if (this.mediaplayer != null) {
            if (nivel < 0) nivel = 0;
            if (nivel > 100) nivel = 100;
            
            double volumennormalizado = nivel / 100.0;
            this.mediaplayer.setVolume(volumennormalizado);
       
    }
      
            
    }
}
    


