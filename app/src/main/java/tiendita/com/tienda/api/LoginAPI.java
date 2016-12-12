package tiendita.com.tienda.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tiendita.com.tienda.entities.UserData;

/**
 * Created by Cresh on 11/12/2016.
 */

public interface LoginAPI {
    @FormUrlEncoded
    @POST("/auth_users.php")
    Call<UserData> login(@FieldMap HashMap<String, String> authData);

}
