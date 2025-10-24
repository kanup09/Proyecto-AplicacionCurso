package informatica.modelo;

// Hereda de Actividad: Herencia
public class DocumentoActividad extends Actividad {
    private int paginas;
    private String formato; // PDF, DOCX

    public DocumentoActividad(int idActividad, String titulo, String descripcion, int paginas, String formato) {
        super(idActividad, titulo, descripcion); // Llama al constructor de la clase base
        this.paginas = paginas;
        this.formato = formato;
    }

    // Implementación polimórfica: Muestra el detalle específico del documento
    @Override
    public String obtenerDetalleContenido() {
        return "DOCUMENTO - Páginas: " + paginas + " | Formato: " + formato;
    }

    // Getter específico
    public int getPaginas() { return paginas; }
}
