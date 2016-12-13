package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.EndlessRecyclerViewScrollListener;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ProductsOffsetAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Product;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductsFragment extends CustomFragment
{

    private Product[] products;
    private ProductsFragment.ProductInteractionListener mListener;
    private ProductRecyclerViewAdapter adapter;

    public ProductsFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft) {
        ProductsFragment pf = new ProductsFragment();
        ft.replace(R.id.fragment_container, pf);
        ft.commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, getContext());
        api.listProducts().enqueue(new Callback<Product[]>() {
            @Override
            public void onResponse(Call<Product[]> call, Response<Product[]> response) {
                products = response.body();
                adapter = new ProductRecyclerViewAdapter(products, mListener, getContext());
                recyclerView.setAdapter(adapter);
                EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                        loadNextDataFromApi(page);
                    }
                };
                recyclerView.addOnScrollListener(scrollListener);
                progressContainer.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Product[]> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        progressContainer = view.findViewById(R.id.progressContainer);
        final Context context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    void loadNextDataFromApi(int page) {
        ProductsOffsetAPI api = ServiceGenerator.createAuthenticatedService(ProductsOffsetAPI.class, getContext());
        Map<String, String> params = new HashMap<>();
        params.put("offset", "" + (offset += 10));
        api.listProductsOffset(params).enqueue(new Callback<Product[]>() {
            @Override
            public void onResponse(Call<Product[]> call, Response<Product[]> response) {
                products = (concat(products,response.body()));
                adapter.setProducts(products);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Product[]> call, Throwable t) {
                Toast.makeText(getContext(), "No hay mas products", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new ProductInteractionListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Product item);
    }
    public class ProductInteractionListener implements OnListFragmentInteractionListener {
        @Override
        public void onListFragmentInteraction(Product item) {
            Gson gson = new Gson();
            String resultado = gson.toJson(item);
            Intent i = new Intent(getActivity(), OneProductActivity.class);
            i.putExtra("producto", resultado);
            startActivity(i);
        }
    }

}
