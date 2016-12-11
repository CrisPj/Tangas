package tiendita.com.tienda.api;

import retrofit2.Call;
import retrofit2.http.GET;
import tiendita.com.tienda.pojo.Customers;

/**
 * Created by zero_ on 11/12/2016.
 */

public interface CustomersAPI {

    @GET("/wc-api/v3/customers")
    Call<Customers> listCustomers();

}
