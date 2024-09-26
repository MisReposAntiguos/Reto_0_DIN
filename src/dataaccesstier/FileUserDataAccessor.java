package dataaccesstier;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import model.User;

/**
 * La clase {@code FileUserDataAccessor} implementa la interfaz
 * {@link DataAccessible} y se encarga de acceder a los datos de un usuario
 * desde un archivo de configuración. Utiliza un {@link ResourceBundle} para
 * cargar la información almacenada en el archivo, y proporciona métodos para
 * leer y construir un objeto {@link User}.
 * <p>
 * Esta clase asume que los datos de usuario (como ID, nombre, edad, email y
 * teléfono) están correctamente definidos en el archivo de configuración.
 * </p>
 *
 * <p>
 * Ejemplo del archivo de configuración ({@code Ficheroconfig.properties}):</p>
 * <pre>
 * ID=1
 * NOMBRE=Juan Pérez
 * EDAD=30
 * EMAIL=juan.perez@ejemplo.com
 * TELEFONO=123456789
 * </pre>
 *
 * @author Urko
 */
public class FileUserDataAccessor implements DataAccessible {

    private User usuario; // Objeto que representa al usuario.

    /**
     * Lee los datos de un usuario desde el archivo de configuración. Este
     * método recupera la información del usuario utilizando un
     * {@link ResourceBundle} y crea una instancia de {@link User} con los datos
     * leídos.
     *
     * Este método espera que el archivo de configuración contenga las
     * siguientes claves:
     * <ul>
     * <li>ID: Identificador del usuario</li>
     * <li>NOMBRE: Nombre del usuario</li>
     * <li>EDAD: Edad del usuario</li>
     * <li>EMAIL: Dirección de correo electrónico del usuario</li>
     * <li>TELEFONO: Número de teléfono del usuario</li>
     * </ul>
     *
     * @return Un objeto {@link User} que contiene la información del usuario.
     * Nunca devuelve {@code null}.
     * @throws MissingResourceException si alguna clave está ausente en el
     * archivo de configuración o no se puede cargar.
     * @throws NumberFormatException si algún valor numérico (como la ID, la
     * edad o el teléfono) no puede ser convertido correctamente desde el
     * archivo de configuración.
     */
    @Override
    public User leerDatos() throws MissingResourceException {

        usuario = new User();
        usuario.setId(Integer.parseInt(ResourceBundle.getBundle("dataaccesstier.Ficheroconfig").getString("ID")));
        usuario.setNombre(ResourceBundle.getBundle("dataaccesstier.Ficheroconfig").getString("NOMBRE"));
        usuario.setEdad(Integer.parseInt(ResourceBundle.getBundle("dataaccesstier.Ficheroconfig").getString("EDAD")));
        usuario.setEmail(ResourceBundle.getBundle("dataaccesstier.Ficheroconfig").getString("EMAIL"));
        usuario.setTelefono(Integer.parseInt(ResourceBundle.getBundle("dataaccesstier.Ficheroconfig").getString("TELEFONO")));
        return usuario;
    }
}
