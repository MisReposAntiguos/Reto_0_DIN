package userinterfacetier;

import dataaccesstier.UserManagerFactory;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.User;

/**
 * Controlador de la ventana de datos del usuario. Esta clase se encarga de
 * gestionar la visualización de la información del usuario en la interfaz
 * gráfica. Obtiene los datos del usuario desde la capa de acceso a datos
 * utilizando la fábrica {@link UserManagerFactory}, y los muestra en las
 * etiquetas correspondientes de la interfaz.
 *
 * Además, maneja posibles excepciones que pueden surgir durante la obtención de
 * datos, como errores en la base de datos, en la configuración o en el acceso a
 * los archivos de recursos.
 *
 * @author Urko
 */
public class UserDataWindowController {

    @FXML
    private Label dataID;       // Etiqueta para mostrar el ID del usuario.

    @FXML
    private Label dataNombre;   // Etiqueta para mostrar el nombre del usuario.

    @FXML
    private Label dataEdad;     // Etiqueta para mostrar la edad del usuario.

    @FXML
    private Label dataTelefono;  // Etiqueta para mostrar el teléfono del usuario.

    @FXML
    private Label dataEmail;    // Etiqueta para mostrar el correo electrónico del usuario.

    /**
     * Maneja la acción del botón de la interfaz. Este método es invocado cuando
     * el usuario hace clic en el botón para mostrar los datos del usuario. El
     * método obtiene los datos del usuario desde la capa de acceso a datos a
     * través de la fábrica {@link UserManagerFactory} y los muestra en las
     * etiquetas de la interfaz gráfica.
     *
     * Si ocurre alguna excepción durante la obtención de datos, como problemas
     * con la base de datos, archivos de propiedades o datos de usuario
     * faltantes, se mostrará una alerta con el mensaje de error
     * correspondiente.
     *
     *
     * @param event El evento de acción que desencadena este método.
     * Generalmente es un clic en el botón de la interfaz.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Obtener los datos del usuario utilizando la fábrica UserManagerFactory
            User usuario = UserManagerFactory.crearAcceso().leerDatos();

            // Actualizar las etiquetas de la interfaz con los datos del usuario
            if (usuario != null) {
                dataID.setText(usuario.getId().toString());
                dataNombre.setText(usuario.getNombre());
                dataEdad.setText(usuario.getEdad().toString());
                dataTelefono.setText(usuario.getTelefono().toString());
                dataEmail.setText(usuario.getEmail());
            } else {
                // Manejar el caso donde los datos del usuario no se encuentran
                mostrarDatosNoEncontrados();
            }

        } catch (Exception e) {
            // Registrar el error en el log
            Logger.getLogger("userinterfacetier.ui").severe(e.getLocalizedMessage());

            // Manejar las excepciones específicas
            if (e instanceof SQLException) {
                mostrarAlertaError("Error en la base de datos: " + e.getLocalizedMessage());
            } else if (e instanceof IllegalArgumentException) {
                mostrarAlertaError("Error en el fichero de propiedades: " + e.getLocalizedMessage());
            } else if (e instanceof MissingResourceException) {
                mostrarAlertaError("Error en el fichero de datos: " + e.getLocalizedMessage());
            } else {
                mostrarAlertaError("Error fatal, contacta con el servicio técnico: " + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Muestra una alerta con un mensaje de error.
     *
     * @param mensaje El mensaje de error que se mostrará en la alerta.
     */
    private void mostrarAlertaError(String mensaje) {
        new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK).showAndWait();
    }

    /**
     * Actualiza las etiquetas de la interfaz para mostrar que los datos del
     * usuario no se encontraron.
     */
    private void mostrarDatosNoEncontrados() {
        dataID.setText("No encontrado");
        dataNombre.setText("No encontrado");
        dataEdad.setText("No encontrado");
        dataTelefono.setText("No encontrado");
        dataEmail.setText("No encontrado");
    }
}
