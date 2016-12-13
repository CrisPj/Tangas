package tiendita.com.tienda.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import tiendita.com.tienda.pojo.Coupons;
import tiendita.com.tienda.pojo.Customer;
import tiendita.com.tienda.pojo.Customers;

/**
 * Created by zero_ on 11/12/2016.
 */

public interface CustomersAPI {

    @GET("/wp-json/wc/v1/customers")
    Call<Customer[]> listCustomers();

    @GET("/wp-json/wc/v1/customers")
    Call<Customer[]> listCustomers(@QueryMap Map<String, String> params);

    @POST("/wp-json/wc/v1/customers/{id}")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Customer> updateCustomer(@Path("id") int id, @Body Customer data);
}
