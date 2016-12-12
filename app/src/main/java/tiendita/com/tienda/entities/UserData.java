package tiendita.com.tienda.entities;

/**
 * Created by Cresh on 09/12/2016.
 */

public final class UserData {

    private final String valido;
    public final long id;
    private final String nombre_completo;
    private final String rol;
    private final User user;

    public UserData(String valido, long id, String nombre_completo, String rol, User user) {
        this.valido = valido;
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.rol = rol;
        this.user = user;
    }

    public String getValido() {
        return valido;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public User getUser() {
        return user;
    }

    public String getRol() {
        return rol;
    }

    public long getId() { return id; }

    public static final class User {
        private final String first_name;
        private final String last_name;
        private final String email;
        private final String[] roles;
        private final String avatar;

        public User(String first_name, String last_name, String email, String[] roles, String avatar) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.roles = roles;
            this.avatar = avatar;
        }

        public String getEmail() {
            return email;
        }

        public String[] getRoles() {
            return roles;
        }

        public String getAvatar() {
            return avatar;
        }
    }
}