package tiendita.com.tienda.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import tiendita.com.tienda.pojo.Product;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public interface ProductsOffsetAPI {

    @GET("wp-json/wc/v1/products")
    Call<Product[]> listProductsOffset(@QueryMap Map<String, String> params);

}
