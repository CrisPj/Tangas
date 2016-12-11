package tiendita.com.tienda.contents;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductsContent {

    public Products products;

    public ProductsContent(Context context) {
        // Create service
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, context);
        api.listProducts().enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                products = response.body();
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {

            }
        });
    }

}
