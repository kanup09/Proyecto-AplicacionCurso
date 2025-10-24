package informatica.dao;

import informatica.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

// Implementa la interfaz: DEMOSTRACIÓN DE POLIMORFISMO
public class UsuarioDAO implements IUsuarioDAO {

    // Lista de objetos mockeados (simulando registros de la BD)
    private final List<Usuario> usuariosMock = new ArrayList<>();

    public UsuarioDAO() {
        // Inicialización de datos de prueba
        Usuario admin = new Usuario(1, "Ana", "García", "admin", "admin123", "ADMIN");
        Usuario alumno1 = new Usuario(2, "Juan", "Pérez", "alumno33", "contrasena", "ALUMNO");
        Usuario profesor = new Usuario(3, "Carlos", "López", "profesor", "profe123", "PROFESOR");

        usuariosMock.add(admin);
        usuariosMock.add(alumno1);
        usuariosMock.add(profesor);
    }

    // Método Login
    @Override
    public Usuario login(String nombreUsuario, String contrasena) throws Exception {
        // Uso de Estructuras Condicionales y Repetitivas (búsqueda)
        for (Usuario user : usuariosMock) {
            if (user.getNombreUsuario().equals(nombreUsuario)) {
                if (user.getContrasena().equals(contrasena)) {
                    return user;
                } else {
                    // Manejo de Excepciones: Simulación de error de contraseña (BD no alcanzada)
                    throw new Exception("Contraseña incorrecta para el usuario: " + nombreUsuario);
                }
            }
        }
        // Manejo de Excepciones: Simulación de usuario no encontrado (BD no alcanzó el registro)
        throw new Exception("El usuario " + nombreUsuario + " no existe.");
    }

    // Método para el Prototipo del Menú
    @Override
    public List<Usuario> obtenerTodos() {
        // Retorna la lista de usuarios. Tu compañero podría usar esto en un menú de administración.
        return new ArrayList<>(usuariosMock);
    }

    // El resto de métodos del CRUD pueden quedarse con implementaciones básicas o lanzar una excepción "no implementado"
    @Override
    public Usuario obtenerPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
