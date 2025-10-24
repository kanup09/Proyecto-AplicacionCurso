package informatica.dao;

import informatica.modelo.Curso;
import informatica.modelo.Actividad;
import informatica.modelo.VideoActividad;
import informatica.modelo.DocumentoActividad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CursoDAO {

    private final List<Curso> cursosMock = new ArrayList<>();

    public CursoDAO() {
        // Creación de objetos polimórficos para el Curso
        List<Actividad> actividades1 = new ArrayList<>();
        // Demostración de objetos polimórficos: La lista contiene instancias de diferentes subclases
        actividades1.add(new VideoActividad(101, "Instalación de Fibra", "Video guía", 1800, "url/video1"));
        actividades1.add(new DocumentoActividad(102, "Manual de Seguridad", "Protocolos de FTTH", 35, "PDF"));
        actividades1.add(new VideoActividad(103, "Corte y Empalme", "Técnica avanzada", 1200, "url/video2"));

        cursosMock.add(new Curso(1, "Instalador de FiberHome", actividades1));
        cursosMock.add(new Curso(2, "Desplegador de Fibra Optica", new ArrayList<>()));
    }

    public List<Curso> obtenerTodosOrdenadosPorNombre() {
        // ******* Algoritmo de Ordenación (Opcional) *******
        List<Curso> listaOrdenada = new ArrayList<>(cursosMock);

        // Uso de Comparator para ordenar la lista (Java Collection Framework)
        listaOrdenada.sort(Comparator.comparing(Curso::getNombre));

        return listaOrdenada;
    }

    // ... otros métodos CRUD (Create, Read, Update, Delete)
}
