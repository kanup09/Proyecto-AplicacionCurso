package informatica.modelo;

// Hereda de Actividad: Herencia
public class VideoActividad extends Actividad {
    private int duracionSegundos;
    private String urlVideo;

    public VideoActividad(int idActividad, String titulo, String descripcion, int duracionSegundos, String urlVideo) {
        super(idActividad, titulo, descripcion); // Llama al constructor de la clase base
        this.duracionSegundos = duracionSegundos;
        this.urlVideo = urlVideo;
    }

    // Implementación polimórfica: Muestra el detalle específico del video
    @Override
    public String obtenerDetalleContenido() {
        return "VIDEO - Duración: " + (duracionSegundos / 60) + " min | URL: " + urlVideo;
    }

    // Getter específico
    public String getUrlVideo() { return urlVideo; }
}
