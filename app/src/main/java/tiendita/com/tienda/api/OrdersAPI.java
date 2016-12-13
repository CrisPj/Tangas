package tiendita.com.tienda.api;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import tiendita.com.tienda.entities.UserData;
import tiendita.com.tienda.pojo.Coupons;
import tiendita.com.tienda.pojo.Order;

/**
 * Created by Cresh on 11/12/2016.
 */

public interface OrdersAPI {
    @GET("/wp-json/wc/v1/orders")
    Call<Order[]> listOrders();

    @GET("/wp-json/wc/v1/orders")
    Call<Order[]> listOrders(@QueryMap Map<String, String> params);

    @POST("/wp-json/wc/v1/orders")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Order> addOrder(@Body Order data);
}
