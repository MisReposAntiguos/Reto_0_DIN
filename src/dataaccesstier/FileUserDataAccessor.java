package dataaccesstier;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import model.User;

/**
 * Acceso a datos de usuario desde un archivo. Esta clase implementa la interfaz
 * {@link DataAccessible} y proporciona la lógica necesaria para leer la
 * información de un usuario desde un archivo de configuración utilizando
 * {@link ResourceBundle}.
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
     * @return Un objeto {@link User} que contiene la información del usuario.
     * Nunca devuelve null.
     * @throws java.lang.Exception
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
