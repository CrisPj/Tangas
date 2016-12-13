package tiendita.com.tienda.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tiendita.com.tienda.pojo.Coupons;
import tiendita.com.tienda.pojo.Product;


public interface WoocommerceAPI {

    @GET("/wp-json/wc/v1/coupons")
    Call<Coupons[]> listCoupons();

    @POST(" /wp-json/wc/v1/coupons")
    @FormUrlEncoded
    Call<Coupons> addCoupon(@FieldMap HashMap<String, String> authData);

}
