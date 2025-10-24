// paquete: informatica.modelo
package informatica.modelo;

import java.util.List;

public class Curso {
    private int idCurso;
    private String nombre;
    private List<Actividad> actividades; // Lista que contendrá distintos tipos de actividades (Polimorfismo en lista)

    // Constructor
    public Curso(int idCurso, String nombre, List<Actividad> actividades) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.actividades = actividades;
    }

    // Getters (Encapsulamiento)
    public int getIdCurso() { return idCurso; }
    public String getNombre() { return nombre; }
    public List<Actividad> getActividades() { return actividades; }

    // ******* Algoritmo de Búsqueda (Opcional) *******
    // Busca una actividad por título
    public Actividad buscarActividadPorTitulo(String titulo) {
        for (Actividad act : actividades) { // Estructura repetitiva
            if (act.getTitulo().equalsIgnoreCase(titulo)) { // Estructura condicional
                return act;
            }
        }
        return null; // Si no se encuentra
    }
}