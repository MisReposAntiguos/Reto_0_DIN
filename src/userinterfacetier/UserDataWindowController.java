package userinterfacetier;

import dataaccesstier.UserManagerFactory;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.User;

/**
 * Controlador de la ventana de datos del usuario. Esta clase gestiona la
 * visualización de la información de un usuario en la interfaz gráfica. Se
 * encarga de obtener los datos desde la capa de acceso a datos y de actualizar
 * los elementos de la interfaz correspondientes.
 *
 * @author 2dam
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
     * Maneja la acción del botón. Este método se invoca cuando el usuario hace
     * clic en el botón correspondiente. Obtiene los datos del usuario a través
     * de la capa de acceso a datos y actualiza las etiquetas en la interfaz
     * gráfica con la información del usuario.
     *
     * @param event El evento de acción que desencadena este método. Se espera
     * que sea del tipo ActionEvent.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {

            User usuario = UserManagerFactory.crearAcceso().leerDatos();;

            if (usuario != null) {
                dataID.setText(usuario.getId().toString());
                dataNombre.setText(usuario.getNombre());
                dataEdad.setText(usuario.getEdad().toString());
                dataTelefono.setText(usuario.getTelefono().toString());
                dataEmail.setText(usuario.getEmail());
            } else {
                // Manejo del caso donde el usuario es nulo
                dataID.setText("No encontrado");
                dataNombre.setText("No encontrado");
                dataEdad.setText("No encontrado");
                dataTelefono.setText("No encontrado");
                dataEmail.setText("No encontrado");
            }
            
        } catch (Exception e) {
            Logger.getLogger("hellotiersworld.ui").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage(), ButtonType.OK).showAndWait();
        } 
    }
}
