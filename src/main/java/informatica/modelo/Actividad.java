// paquete: informatica.modelo
package informatica.modelo;

// Clase abstracta para definir la estructura común de las actividades.
public abstract class Actividad {
    private int idActividad;
    private String titulo;
    private String descripcion;

    // Constructor
    public Actividad(int idActividad, String titulo, String descripcion) {
        this.idActividad = idActividad;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Getters y Setters (Encapsulamiento)
    public int getIdActividad() { return idActividad; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }

    // Método abstracto para Polimorfismo: Cada tipo de actividad mostrará su contenido de forma diferente.
    public abstract String obtenerDetalleContenido();

    // Método común para todas las actividades
    public String getResumen() {
        return "Actividad: " + titulo + " (ID: " + idActividad + ")";
    }
}