package tiendita.com.tienda.sqlite.contracts;

import android.provider.BaseColumns;

public class UserdataContract {

    private UserdataContract() {
    }

    public static class Userdata implements BaseColumns {
        public static final String TABLE_NAME = "user_data";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_EMAIL = "email";
    }

}