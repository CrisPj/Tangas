package tiendita.com.tienda.api;

import retrofit2.Call;
import retrofit2.http.GET;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public interface ProductsAPI {

    @GET("wp-json/wc/v1/products")
    Call<Product[]> listProducts();

}
