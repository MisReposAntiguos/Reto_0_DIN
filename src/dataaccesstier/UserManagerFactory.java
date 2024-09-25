package dataaccesstier;

import java.util.ResourceBundle;

/**
 * Fábrica para la gestión del acceso a datos de usuario. Esta clase proporciona
 * un método estático para crear instancias de {@link DataAccessible} según la
 * configuración especificada en un archivo de propiedades.
 *
 * La clase determina el tipo de acceso a los datos (base de datos o archivo)
 * utilizando una propiedad llamada "ACCESS" en el archivo de propiedades. Según
 * el valor de esta propiedad, se retornará una instancia de
 * {@link DBUserDataAccessor} o {@link FileUserDataAccessor}.
 *
 * Si el tipo de acceso no es reconocido, se lanza una excepción
 * {@link IllegalArgumentException}.
 *
 *
 * @author Sergio
 */
public class UserManagerFactory {

    // Obtiene la configuración del tipo de acceso desde el archivo de propiedades.
    private static final String propiedades = ResourceBundle.getBundle("dataaccesstier.newproperties").getString("ACCESS");

    /**
     * Crea una instancia de {@link DataAccessible} basada en la configuración
     * del archivo de propiedades.
     *
     * Este método lee la propiedad "ACCESS" para determinar si el acceso a los
     * datos debe realizarse a través de una base de datos o de un archivo.
     *
     *
     * @return Una implementación de {@link DataAccessible}, ya sea de tipo
     * {@link DBUserDataAccessor} si el valor de la propiedad es "DB", o
     * {@link FileUserDataAccessor} si el valor es "FICHERO".
     *
     * @throws IllegalArgumentException si el tipo de acceso especificado en la
     * propiedad "ACCESS" no es válido.
     */
    public static DataAccessible crearAcceso() {
        switch (propiedades) {
            case "DB":
                return new DBUserDataAccessor();
            case "FICHERO":
                return new FileUserDataAccessor();
            default:
                throw new IllegalArgumentException("Tipo de acceso no reconocido: " + propiedades);
        }
    }
}
