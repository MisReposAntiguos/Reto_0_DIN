package model;

/**
 * Representa un usuario en el sistema. Esta clase contiene la información
 * básica de un usuario, incluyendo su ID, nombre, correo electrónico, teléfono
 * y edad. Proporciona métodos para obtener y establecer estos atributos.
 *
 * @author 2dam
 */
public class User {

    private Integer id;        // ID del usuario.
    private String nombre;     // Nombre del usuario.
    private String email;      // Correo electrónico del usuario.
    private Integer telefono;   // Número de teléfono del usuario.
    private Integer edad;      // Edad del usuario.

    /**
     * Constructor por defecto. Crea una instancia de la clase User sin
     * inicializar los atributos.
     */
    public User() {
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El nuevo ID del usuario.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return El número de teléfono del usuario.
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono El nuevo número de teléfono del usuario.
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la edad del usuario.
     *
     * @return La edad del usuario.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Establece la edad del usuario.
     *
     * @param edad La nueva edad del usuario.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
