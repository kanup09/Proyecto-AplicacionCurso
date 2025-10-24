// paquete: informatica.modelo
package informatica.modelo;

// Hereda de Persona: DEMOSTRACIÓN DE HERENCIA
public class Usuario extends Persona {
    private String nombreUsuario; // Campo para el login
    private String contrasena;    // En un sistema real sería un hash
    private String rol;           // Ejemplo: "ALUMNO", "PROFESOR", "ADMIN"

    // Constructor completo: DEMOSTRACIÓN DE CONSTRUCTORES
    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, String rol) {
        super(id, nombre, apellido); // Llama al constructor de la clase base (Persona)
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters: DEMOSTRACIÓN DE ENCAPSULAMIENTO
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    // Implementación del método abstracto de Persona: DEMOSTRACIÓN DE ABSTRACCIÓN
    @Override
    public String getTipoUsuario() {
        return this.rol;
    }
}