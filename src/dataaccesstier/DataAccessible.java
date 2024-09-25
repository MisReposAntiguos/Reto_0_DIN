package dataaccesstier;

import model.User;

/**
 * Interfaz para la capa de acceso a datos de usuario. Esta interfaz define los
 * métodos necesarios para acceder y manipular datos de usuarios en el sistema.
 *
 * @author 2dam Equipo
 */
public interface DataAccessible {

    /**
     * Lee los datos de un usuario. Este método debe ser implementado para
     * proporcionar la lógica necesaria para recuperar la información de un
     * usuario.
     *
     * @return Un objeto {@link User} que contiene la información del usuario.
     * Si no se encuentra ningún usuario, puede devolver null.
     * @throws Exception
     */
    public User leerDatos() throws Exception;
}
