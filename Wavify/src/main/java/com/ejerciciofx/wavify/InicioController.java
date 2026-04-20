package com.ejerciciofx.wavify;

import Cancion.Cancion;
import GestorDeArchivos.GestorDeArchivos;
import Reproductor.Reproductor;
import java.util.ArrayList;
import javafx.fxml.FXML;

public class InicioController {

    private Reproductor miReproductor;

    @FXML
    public void initialize() {
        GestorDeArchivos gestor = new GestorDeArchivos();
        ArrayList<Cancion> lista = gestor.cargarMusica();
        miReproductor = new Reproductor(lista, 0, null);
    }
    @FXML
    private void playRockstar(){reproducirPorIndice(0); 
    }

    @FXML
    private void playMamaMeDice(){ reproducirPorIndice(1); 
    }
    @FXML
    private void playParalice(){ 
        reproducirPorIndice(2); 
    }
    @FXML
    private void playAnotherDay(){ 
        reproducirPorIndice(3); 
    }

    @FXML
    private void playStarboy(){ 
        reproducirPorIndice(4); 
    }
    private void reproducirPorIndice(int i) {
        if (miReproductor.getListacanciones().size() > i) {
            miReproductor.setIndiceactual(i);
            miReproductor.cargarCancionActual();
            miReproductor.Reproducircancion();
        }
    }
    @FXML
    private void handlePausar(){
        if (miReproductor.getMediaplayer() != null){
            if (miReproductor.getMediaplayer().getStatus() == javafx.scene.media.MediaPlayer.Status.PLAYING){
                miReproductor.pausar();
            } else {
                miReproductor.Reproducircancion();
            }
        }
    }
    @FXML
    private void handleAdelantar(){
        miReproductor.adelantar();
    }

    @FXML
    private void handleAtrasar(){
        miReproductor.atrasar();
    }

    @FXML
    private void handleVolumen(){
        if (miReproductor.getMediaplayer() != null) {
            double volActual = miReproductor.getMediaplayer().getVolume();
            if (volActual > 0){
                miReproductor.ajustarVolumen(0);
            } else {
                miReproductor.ajustarVolumen(100);
            }
        }
    }
    @FXML
    private void irAFavoritos() throws Exception{
        if (miReproductor.getMediaplayer() != null) miReproductor.detener();
        App.setRoot("pantalla_cancionesguardadas");
    }

    @FXML
    private void cerrarSesion() throws Exception{
        if (miReproductor.getMediaplayer() != null) miReproductor.detener();
        App.setRoot("primary"); 
    }
}
