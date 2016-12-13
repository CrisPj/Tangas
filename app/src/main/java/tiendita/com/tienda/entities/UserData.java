package tiendita.com.tienda.entities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import tiendita.com.tienda.sqlite.helpers.UserdataDbHelper;

import static tiendita.com.tienda.sqlite.contracts.UserdataContract.Userdata;

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

    public long getId() {
        return id;
    }

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

        public static boolean isAuthenticated(Context context) {
            UserdataDbHelper helper = new UserdataDbHelper(context);
            SQLiteDatabase userDatabase = helper.getReadableDatabase();
            String[] projection = {
                    Userdata._ID,
                    Userdata.COLUMN_NAME_USERNAME,
                    Userdata.COLUMN_NAME_EMAIL
            };
            Cursor query = userDatabase.query(
                    Userdata.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            return query.getCount() >= 1;
        }

        public static UserData fetchUserdata(Context context) {
            UserdataDbHelper helper = new UserdataDbHelper(context);
            SQLiteDatabase userDatabase = helper.getReadableDatabase();
            String[] projection = {
                    Userdata._ID,
                    Userdata.COLUMN_NAME_USERNAME,
                    Userdata.COLUMN_NAME_EMAIL
            };
            Cursor query = userDatabase.query(
                    Userdata.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );
            String user_id = query.getString(0);
            String username = query.getString(1);
            String email = query.getString(2);
            UserData userData = new UserData("true", Long.valueOf(user_id), username, "", null);
            return userData;
        }
    }
}