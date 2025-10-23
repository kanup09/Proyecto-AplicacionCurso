// paquete: informatica.servicio.mock
package informatica.servicio.mock;

// Importa de los nuevos paquetes
import informatica.modelo.Curso;
import informatica.modelo.Actividad;
import informatica.servicio.ICursoService;
import java.util.ArrayList;
import java.util.List;

// Implementamos la interfaz del contrato
public class CursoServiceMock implements ICursoService {

    @Override
    public List<Curso> getCursosPorUsuario(int idUsuario) {
        List<Curso> cursosFalsos = new ArrayList<>();

        if (idUsuario == 1) {
            cursosFalsos.add(new Curso(101, "INSTALADOR DE FIBERHOME E DESPLEGADOR DE FIBRA...", 49));
            cursosFalsos.add(new Curso(102, "Redes y Telecomunicaciones I", 15));
            cursosFalsos.add(new Curso(103, "Programación Orientada a Objetos", 95));
        }

        return cursosFalsos;
    }

    @Override
    public List<Actividad> getActividadesPorCurso(int idCurso) {
        List<Actividad> actividadesFalsas = new ArrayList<>();

        if (idCurso == 101) {
            actividadesFalsas.add(new Actividad(201, "CLASE 1", "seccion", false));
            actividadesFalsas.add(new Actividad(202, "ACTIVIDAD 1 INSTALADOR", "actividad", true));
            actividadesFalsas.add(new Actividad(203, "CLASE 2", "seccion", false));
            actividadesFalsas.add(new Actividad(204, "DESPLEGADOR", "seccion", false));
            actividadesFalsas.add(new Actividad(205, "Actividad N°2 Desplegador", "actividad", false));
            actividadesFalsas.add(new Actividad(206, "Arquitectura FTTH", "recurso", false));
            actividadesFalsas.add(new Actividad(207, "video instalador", "video", false));
        }

        return actividadesFalsas;
    }
}