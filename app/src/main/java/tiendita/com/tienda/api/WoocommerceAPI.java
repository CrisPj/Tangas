package tiendita.com.tienda.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import tiendita.com.tienda.pojo.Coupons;


public interface WoocommerceAPI {

    @GET("/wp-json/wc/v1/coupons")
    Call<Coupons[]> listCoupons();

    @POST("/wp-json/wc/v1/coupons")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Coupons> addCoupon(@Body Coupons data);

    @GET("/wp-json/wc/v1/coupons")
    Call<Coupons[]> listCoupons(@QueryMap Map<String, String> params);
}
