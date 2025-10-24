package informatica;
import informatica.modelo.Actividad;
import informatica.modelo.Curso;
import informatica.dao.CursoDAO;
import informatica.dao.UsuarioDAO;
import informatica.modelo.Usuario;
import java.util.Scanner;
import java.util.List;

public class Principal {

    // Declaración del objeto DAO
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void main(String[] args) {
        // Creación del objeto Scanner para entrada (Constructor)
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        // Estructura de control repetitiva (bucle del menú)
        while (opcion != 0) {
            mostrarMenu();
            try {
                // Manejo de Excepciones: Para evitar errores si el usuario ingresa texto en lugar de número
                opcion = Integer.parseInt(scanner.nextLine());

                // Estructura de control condicional (switch)
                switch (opcion) {
                    case 1:
                        realizarLogin(scanner);
                        break;
                    case 2:
                        mostrarUsuarios();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un número para seleccionar la opción.");
                opcion = -1;
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Acceder (Login)");
        System.out.println("2. Mostrar todos los Usuarios (Solo Demo)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void realizarLogin(Scanner scanner) {
        System.out.print("Usuario: ");
        String user = scanner.nextLine();
        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        try {
            // Uso de la clase DAO (objeto) y llamada al método login
            Usuario usuarioLogeado = usuarioDAO.login(user, pass);
            System.out.println("\n*** ACCESO EXITOSO ***");
            System.out.println("Bienvenido, " + usuarioLogeado.getNombre() + ". Rol: " + usuarioLogeado.getRol());

            // DEMOSTRACIÓN DE POLIMORFISMO
            System.out.println("El método polimórfico devuelve: " + usuarioLogeado.getTipoUsuario());

        } catch (Exception e) {
            // Manejo de Excepciones (captura el error lanzado por el DAO)
            System.err.println("Error de Login: " + e.getMessage());
        }
    }

    private static void mostrarUsuarios() {
        System.out.println("\n--- LISTA DE USUARIOS (MOCK) ---");
        // Estructura de control repetitiva (iteración sobre la lista)
        for (Usuario u : usuarioDAO.obtenerTodos()) {
            System.out.printf("ID: %d | Nombre: %s %s | Rol: %s%n",
                    u.getId(), u.getNombre(), u.getApellido(), u.getRol());
        }
    }
    private static void mostrarCursos(CursoDAO cursoDAO) {
        System.out.println("\n--- LISTA DE CURSOS (ORDENADOS) ---");
        List<Curso> cursos = cursoDAO.obtenerTodosOrdenadosPorNombre(); // Uso de algoritmo de ordenación

        for (Curso curso : cursos) {
            System.out.println("------------------------------------");
            System.out.println("CURSO: " + curso.getNombre() + " (ID: " + curso.getIdCurso() + ")");
            System.out.println("ACTIVIDADES:");

            // Bucle para demostrar el Polimorfismo
            for (Actividad actividad : curso.getActividades()) {
                // Se llama al método común, pero el resultado es distinto según el tipo de objeto (Video o Documento)
                System.out.println("  - " + actividad.getResumen());
                System.out.println("    [DETALLE POLIMÓRFICO]: " + actividad.obtenerDetalleContenido());
            }

            // Uso de Algoritmo de Búsqueda
            Actividad buscada = curso.buscarActividadPorTitulo("Manual de Seguridad");
            if (buscada != null) {
                System.out.println("\n[BUSCADA]: Encontrada: " + buscada.getTitulo());
            }
        }
    }
}
