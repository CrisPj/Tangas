package tiendita.com.tienda.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tiendita.com.tienda.R;
import tiendita.com.tienda.activities.OneProductActivity;
import tiendita.com.tienda.adapters.ProductRecyclerViewAdapter;
import tiendita.com.tienda.api.ProductsAPI;
import tiendita.com.tienda.api.ProductsOffsetAPI;
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
    private int offset = 0;
    private Product[] products;

    public ProductsFragment() {
    }

    public static void replaceFragment(final FragmentTransaction ft, final Context context, final ProgressBar requestProgress) {
        requestProgress.setVisibility(View.VISIBLE);
        // Retrieve products
        ProductsAPI api = ServiceGenerator.createAuthenticatedService(ProductsAPI.class, context);
        api.listProducts().enqueue(new Callback<Product[]>() {
            @Override
            public void onResponse(Call<Product[]> call, Response<Product[]> response) {
                requestProgress.setVisibility(View.GONE);
                ProductsFragment pf = new ProductsFragment();
                pf.setProducts(response.body());
                ft.replace(R.id.fragment_container, pf);
                ft.commit();
            }

            @Override
            public void onFailure(Call<Product[]> call, Throwable t) {
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
            recyclerView.addOnScrollListener(createInfiniteScrollListener());
        }
        return view;
    }

    @NonNull
    private InfiniteScrollListener createInfiniteScrollListener() {
            return new InfiniteScrollListener(9, mLayoutManager) {
                @Override public void onScrolledToEnd(final int firstVisibleItemPosition) {
                     ProductsOffsetAPI api = ServiceGenerator.createAuthenticatedService(ProductsOffsetAPI.class, getContext());
                    Map<String, String> params = new HashMap<>();
                    params.put("offset",""+(offset+=10));
                    api.listProductsOffset(params).enqueue(new Callback<Product[]>() {
                        @Override
                        public void onResponse(Call<Product[]> call, Response<Product[]> response) {
                            products = (concat(response.body()));
                            refreshView(recyclerView, new ProductRecyclerViewAdapter(products, mListener, getContext()), firstVisibleItemPosition);
                        }

                        @Override
                        public void onFailure(Call<Product[]> call, Throwable t) {
                            Toast.makeText(getContext(),"No hay mas products",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            };
        }


    private Product[] concat(Product[] b) {
                int bLen = b.length;
                int aLen = products.length;
                Product[] c= new Product[aLen+bLen];
                System.arraycopy(products, 0, c, 0, aLen);
                System.arraycopy(b, 0, c, aLen, bLen);
                return c;
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
