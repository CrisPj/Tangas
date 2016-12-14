package tiendita.com.tienda.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import tiendita.com.tienda.pojo.Category;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public interface ProductsAPI {

    @GET("wp-json/wc/v1/products")
    Call<Product[]> listProducts();

    @GET("/wp-json/wc/v1/products/categories")
    Call<Category[]> listCategories();

    @GET("/wp-json/wc/v1/products/categories")
    Call<Category[]> listCategories(@QueryMap Map<String, String> params);

    @GET("wp-json/wc/v1/products/{id}")
    Call<Product> getProduct(@Path("id") String id);

}
