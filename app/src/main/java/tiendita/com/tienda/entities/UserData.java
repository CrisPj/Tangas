package tiendita.com.tienda.entities;

/**
 * Created by Cresh on 09/12/2016.
 */

public final class UserData {

    private final String valido;
    public final long id;
    private final String nombre_completo;
    private final String rol;

    public UserData(String valido, long id, String nombre_completo, String rol) {
        this.valido = valido;
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.rol = rol;
    }

    public String getValido() {
        return valido;
    }
    public String getNombre_completo() {
        return nombre_completo;
    }
    public String getRol() {
        return rol;
    }
    public long getId() { return id; }

}