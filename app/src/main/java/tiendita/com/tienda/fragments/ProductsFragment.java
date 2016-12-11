package tiendita.com.tienda.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tiendita.com.tienda.R;
import tiendita.com.tienda.adapters.ProductoRecyclerViewAdapter;
import tiendita.com.tienda.contents.ProductContent;
import tiendita.com.tienda.contents.ProductsContent;

/**
 * Created by zero_ on 11/12/2016.
 */

public class ProductsFragment extends Fragment {

    private ProductsContent content;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProductosFragment.OnListFragmentInteractionListener mListener;

    public ProductsFragment() {
    }

    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(mLayoutManager);
            //adapter = new ProductoRecyclerViewAdapter(content.products, mListener, context);
            //recyclerView.setAdapter(adapter);
            //recyclerView.addOnScrollListener(createInfiniteScrollListener());
        }
        return view;
    }
}
