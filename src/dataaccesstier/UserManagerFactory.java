package dataaccesstier;

import java.util.ResourceBundle;

/**
 * Fabrica para la gestión de acceso a datos de usuario. Esta clase proporciona
 * un método estático para crear instancias de {@link DataAccessible} según la
 * configuración especificada en el archivo de propiedades.
 *
 * La clase determina el tipo de acceso (base de datos o archivo) a través de
 * una propiedad llamada "ACCESS".
 *
 * @author 2dam
 */
public class UserManagerFactory {

    private static final String propiedades = ResourceBundle.getBundle("dataaccesstier.newproperties").getString("ACCESS");

    /**
     * Crea una instancia de {@link DataAccessible} según la configuración
     * especificada.
     *
     * @return Una implementación de {@link DataAccessible} que puede ser de
     * tipo {@link DBUserDataAccessor} o {@link FileUserDataAccessor}. Devuelve
     * null si el tipo de acceso no es reconocido.
     */
    public static DataAccessible crearAcceso() {
        switch (propiedades) {
            case "DB":
                return new DBUserDataAccessor();
            case "FICHERO":
                return new FileUserDataAccessor();
            default:
                // ERROR
                return null;
        }
    }
}
