package tiendita.com.tienda.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 13/12/2016.
 */

public class ReportsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reports, container, false);
        final View progressContainer = (View) view.findViewById(R.id.progressContainer);
        // Test
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, getContext());
        api.getProduct("1").enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                progressContainer.setVisibility(View.GONE);
                Toast.makeText(getContext(), "OK!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
        return view;
    }
}
