package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.pojo.Product;
import tiendita.com.tienda.pojo.Products;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductsFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProductInteractionListener mListener;
    private ProductRecyclerViewAdapter adapter;
    private int mColumnCount;
    private Products products;

    public ProductsFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft, final Context context, final ProgressBar requestProgress) {
        requestProgress.setVisibility(View.VISIBLE);
        // Retrieve products
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, context);
        api.listProducts().enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                requestProgress.setVisibility(View.GONE);
                ProductsFragment pf = new ProductsFragment();
                pf.setProducts(response.body());
                ft.replace(R.id.fragment_container, pf);
                ft.commit();
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                requestProgress.setVisibility(View.GONE);
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static ProductsFragment newInstance(int itemCount) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            adapter = new ProductRecyclerViewAdapter(products, mListener, context);
            recyclerView.setAdapter(adapter);
            //recyclerView.addOnScrollListener(createInfiniteScrollListener());
        }
        return view;
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

    public void setProducts(Products products) {
        this.products = products;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
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
