// paquete: informatica.servicio.mock
package informatica.servicio.mock;

// Importa de los nuevos paquetes
import informatica.modelo.Curso;
import informatica.modelo.Actividad;
import informatica.modelo.DocumentoActividad;
import informatica.modelo.VideoActividad;
import informatica.servicio.ICursoService;
import java.util.ArrayList;
import java.util.List;

// Implementamos la interfaz del contrato
public class CursoServiceMock implements ICursoService {

    // En CursoServiceMock.java
    @Override
    public List<Curso> getCursosPorUsuario(int idUsuario) {
        List<Curso> cursosFalsos = new ArrayList<>();

        if (idUsuario == 1) {
            // 1. Crear las actividades mock (usando lógica del paso anterior)
            List<Actividad> actividadesCurso1 = crearActividadesMock(101); // Método auxiliar

            // 2. Pasar la lista de actividades al constructor (int, String, List<Actividad>)
            cursosFalsos.add(new Curso(101, "INSTALADOR DE FIBERHOME E DESPLEGADOR DE FIBRA...", actividadesCurso1));

            // Para los otros cursos, puedes pasar una lista vacía temporalmente:
            cursosFalsos.add(new Curso(102, "Redes y Telecomunicaciones I", new ArrayList<>()));
            cursosFalsos.add(new Curso(103, "Programación Orientada a Objetos", new ArrayList<>()));
        }

        return cursosFalsos;
    }

    // **Asegúrate de tener un método como este en CursoServiceMock.java:**
    private List<Actividad> crearActividadesMock(int idCurso) {
        List<Actividad> actividades = new ArrayList<>();

        // Ejemplo de instancias polimórficas
        if (idCurso == 101) {
            actividades.add(new VideoActividad(201, "Instalación Básica", "Video de 30 min", 1800, "url/video"));
            actividades.add(new DocumentoActividad(202, "Manual Seguridad", "PDF de 10 páginas", 10, "PDF"));
        }

        return actividades;
    }

    @Override
    public List<Actividad> getActividadesPorCurso(int idCurso) {
        // En tu CursoServiceMock.java
        List<Actividad> actividadesFalsas = new ArrayList<>();

        if (idCurso == 101) {
            // CLASE 1 es una sección o un documento? Usemos DocumentoActividad.java (5 argumentos)
            actividadesFalsas.add(new DocumentoActividad(201, "CLASE 1", "Sección Introductoria", 20, "PDF"));

            // CLASE 1 INSTALADOR es un documento? Usemos DocumentoActividad.java
            actividadesFalsas.add(new DocumentoActividad(202, "ACTIVIDAD 1 INSTALADOR", "Guía práctica", 10, "DOCX"));

            // DESPLEGADOR es una sección o un video? Usemos VideoActividad.java (5 argumentos)
            actividadesFalsas.add(new VideoActividad(203, "DESPLEGADOR", "Video sobre técnicas de desplegado", 1800, "url/desp"));

            // Arquitectura FTTH es un recurso, quizás un documento
            actividadesFalsas.add(new DocumentoActividad(206, "Arquitectura FTTH", "Documento de recurso", 50, "PDF"));

            // Video instalador es un video
            actividadesFalsas.add(new VideoActividad(207, "Video instalador", "Video de pasos finales", 1200, "url/inst"));
        }

        return actividadesFalsas;
    }
}