package informatica.modelo;

// Clase abstracta: DEMOSTRACIÓN DE ABSTRACCIÓN Y HERENCIA
public abstract class Persona {
    private int id;                 // Encapsulamiento
    private String nombre;
    private String apellido;

    // Constructor para inicializar la clase base
    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters: Encapsulamiento
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    // Método abstracto: Obliga a las subclases a implementarlo (Abstracción)
    public abstract String getTipoUsuario();
}
