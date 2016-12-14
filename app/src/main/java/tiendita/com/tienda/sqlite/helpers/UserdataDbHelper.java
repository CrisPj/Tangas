package tiendita.com.tienda.sqlite.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tiendita.com.tienda.entities.UserData;
import tiendita.com.tienda.sqlite.contracts.UserdataContract;

import static tiendita.com.tienda.sqlite.contracts.UserdataContract.*;

/**
 * Created by zero_ on 12/12/2016.
 */

public class UserdataDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "userdata.db";


    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Userdata.TABLE_NAME + " (" +
                    Userdata._ID + " INTEGER PRIMARY KEY," +
                    Userdata.COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                    Userdata.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    Userdata.COLUMN_NAME_ROLES + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "delete from " + Userdata.TABLE_NAME;

    public UserdataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void alv(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
