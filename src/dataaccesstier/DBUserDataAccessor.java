package dataaccesstier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import model.User;

/**
 * Acceso a datos de usuario desde una base de datos. Esta clase implementa la
 * interfaz {@link DataAccessible} y proporciona la lógica necesaria para leer
 * la información de un usuario desde una base de datos relacional. Utiliza JDBC
 * para establecer la conexión y ejecutar consultas SQL.
 *
 * @author 2dam
 */
public class DBUserDataAccessor implements DataAccessible {

    private ResourceBundle fichConf; // Archivo de configuración de la base de datos.
    private String URL;               // URL de conexión a la base de datos.
    private String DBROOT;            // Usuario de la base de datos.
    private String DBROOTPASS;        // Contraseña del usuario de la base de datos.
    private Connection conexion;       // Conexión a la base de datos.
    private PreparedStatement declaracion; // Declaración SQL preparada.

    private final String CONSULTA_TODO = "SELECT * FROM USUARIO"; // Consulta para obtener todos los usuarios.

    /**
     * Constructor por defecto. Inicializa la configuración de la base de datos
     * a partir del archivo de propiedades.
     */
    public DBUserDataAccessor() {
        fichConf = ResourceBundle.getBundle("dataaccesstier.dbconfig");
        URL = fichConf.getString("URL");
        DBROOT = fichConf.getString("DBROOT");
        DBROOTPASS = fichConf.getString("DBROOTPASS");
    }

    /**
     * Abre una conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    private void openConnection() throws SQLException {
        conexion = DriverManager.getConnection(URL, DBROOT, DBROOTPASS);
    }

    /**
     * Cierra la conexión a la base de datos y libera los recursos utilizados.
     */
    private void closeConnection() {
        try {
            if (declaracion != null) {
                declaracion.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException evento) {
            evento.printStackTrace();
        }
    }

    /**
     * Lee los datos de un usuario desde la base de datos. Este método ejecuta
     * una consulta SQL para recuperar la información del usuario y crea una
     * instancia de {@link User} con los datos leídos.
     *
     * @return Un objeto {@link User} que contiene la información del usuario, o
     * null si no se encontraron usuarios en la base de datos.
     */
    @Override
    public User leerDatos() {
        User usuario = null;
        ResultSet resultado;

        try {
            openConnection();
            declaracion = conexion.prepareStatement(CONSULTA_TODO);
            resultado = declaracion.executeQuery();
            while (resultado.next()) {
                usuario = new User();
                usuario.setId(resultado.getInt("ID"));
                usuario.setNombre(resultado.getString("NOMBRE"));
                usuario.setEmail(resultado.getString("EMAIL"));
                usuario.setTelefono(resultado.getInt("TELEFONO"));
                usuario.setEdad(resultado.getInt("EDAD"));
            }

        } catch (SQLException evento) {
            evento.printStackTrace();
        } finally {
            closeConnection();
        }

        return usuario;
    }
}
