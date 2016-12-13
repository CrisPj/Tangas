package tiendita.com.tienda.contents;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Product;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductsContent {

    public Product[] products;

    public ProductsContent(Context context) {
        // Create service
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, context);
        api.listProducts().enqueue(new Callback<Product[]>() {
            @Override
            public void onResponse(Call<Product[]> call, Response<Product[]> response) {
                products = response.body();
            }

            @Override
            public void onFailure(Call<Product[]> call, Throwable t) {

            }
        });
    }

}
