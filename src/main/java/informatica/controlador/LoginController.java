// paquete: informatica.controlador
package informatica.controlador;

// Importa de los nuevos paquetes
import informatica.modelo.Usuario;
import informatica.servicio.IUsuarioService;
import informatica.servicio.mock.UsuarioServiceMock; // ¡Importa el Mock!

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
// ... otros imports de JavaFX

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private TextField txtPassword;
    @FXML private Label lblError;

    // El controlador USA la interfaz como tipo
    private IUsuarioService usuarioService;

    public LoginController() {
        // Por ahora, usa la implementación "falsa"
        this.usuarioService = new UsuarioServiceMock();

        // Cuando el Rol 2 termine, la ÚNICA línea que cambiará será esta:
        // this.usuarioService = new UsuarioServiceReal();
    }

    @FXML
    private void handleAccederButton() {
        String user = txtUsuario.getText();
        String pass = txtPassword.getText();

        Usuario usuarioValidado = usuarioService.validarLogin(user, pass);

        if (usuarioValidado != null) {
            lblError.setText("¡Bienvenido " + usuarioValidado.getNombreCompleto() + "!");
            // Lógica para cambiar a la escena del Dashboard
        } else {
            lblError.setText("Usuario o contraseña incorrectos.");
        }
    }
}
