package userinterfacetier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is a controler for teh user application window
 *
 * @author 2dam
 */
public class Application extends javafx.application.Application {
    //Escenario Principal
    /**
     * Este metodo inicia el escenario
     *
     * @param stage la ventana principal
     * @throws Exception cuando no encuentra la vista
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Carga el DOM del FXML view
        Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));
        //Creamos una escena con nuestra vista
        Scene scene = new Scene(root);
        //Poner la escena en el escenario
        stage.setScene(scene);
        //Mostramos el escenario
        stage.show();
    }

    /**
     * Main method para ejecutar nuestro programa
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
