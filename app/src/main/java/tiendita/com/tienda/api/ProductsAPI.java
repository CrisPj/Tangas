package tiendita.com.tienda.api;

import retrofit2.Call;
import retrofit2.http.GET;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public interface ProductsAPI {

    @GET("/wc-api/v3/products")
    Call<Products> listProducts();



}
