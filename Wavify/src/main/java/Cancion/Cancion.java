package Cancion;


public class Cancion {
    private String NombreCancion;
    private float DuracionCancion; 
    private String Artista;
    private String Ruta; 
    
    
    public Cancion(String NombreCancionE, String RutaE) {
        this.NombreCancion = NombreCancionE;
        this.Ruta = RutaE;
        this.Artista = "Desconocido";
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

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }
}