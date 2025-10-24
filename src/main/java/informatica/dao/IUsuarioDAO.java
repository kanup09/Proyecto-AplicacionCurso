package informatica.dao;

import informatica.modelo.Usuario;
import java.util.List;

// Interfaz para el contrato del DAO
public interface IUsuarioDAO {
    Usuario login(String nombreUsuario, String contrasena) throws Exception;
    Usuario obtenerPorId(int id) throws Exception;
    List<Usuario> obtenerTodos();
    // ... otros métodos CRUD
}