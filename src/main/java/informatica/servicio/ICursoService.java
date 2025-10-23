// paquete: informatica.servicio
package informatica.servicio;

// Importa del nuevo paquete
import informatica.modelo.Curso;
import informatica.modelo.Actividad;
import java.util.List;

public interface ICursoService {

    /**
     * Obtiene la lista de cursos en los que está inscrito un usuario.
     * @param idUsuario El ID del usuario logueado.
     * @return Una lista de objetos Curso.
     */
    List<Curso> getCursosPorUsuario(int idUsuario);

    /**
     * Obtiene el detalle (clases, actividades) de un curso específico.
     * @param idCurso El ID del curso seleccionado.
     * @return Una lista de objetos Actividad de ese curso.
     */
    List<Actividad> getActividadesPorCurso(int idCurso);
}